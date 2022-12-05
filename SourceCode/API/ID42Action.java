package API;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import com.google.gson.Gson;

import API.obj.ID42Obj;
import API.obj.ID42ObjList;
import au.com.bytecode.opencsv.CSVReader;
//
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;

//會議資訊
public class ID42Action extends ActionSupport {

	private static final long serialVersionUID = -6756806711022425967L;
	private final Logger log = Logger.getLogger(this.getClass());
	private static final HashSet<String> availableFileType = new HashSet<String>(
		Arrays.asList("csv", "json", "xml", "xls", "txt"));

	private String term;
	private String sessionPeriod;
	private String sessionTimes;
	private String meetingTimes;
	private String coChairman;
	private String attendLegislator;

	private String importFilePath = "/lyodw/odwsys/ODM_FT/42_CSV/42_CSV.csv";
	private String exportFilePath = "/lyodw/tomcat7/webapps/odw/source/";
	private String exportFileName = String.valueOf(System.currentTimeMillis());

	private String fileType;

	public String execute() throws Exception {
		System.out.println("ID42Action start!!");
		HttpServletRequest request;
		 request = ServletActionContext.getRequest();

		if (StringUtils.isBlank(fileType) || !availableFileType.contains(fileType.toLowerCase())) {
			return SUCCESS;
		}

		try {
			List<ID42Obj> resultList = new ArrayList<>();
			ID42Obj iD42Obj = new ID42Obj();
			ID42ObjList iD42ObjList = new ID42ObjList();
			Path path = Paths.get(importFilePath);
			InputStreamReader isr = new InputStreamReader(new FileInputStream(path.toFile()),
				StandardCharsets.UTF_8);
			BufferedReader br = new BufferedReader(isr);
			
			int row = 1;
			String readLine;
			while ((readLine = br.readLine()) != null) {
				if (row == 1) {
					row++;
					continue;
				}
				// ======== CSV file column
				// term,sessionPeriod,sessionTimes,meetingTimes,meetingNo,meetingDateDesc,meetingRoom,meetingUnit,jointCommittee,meetingName,meetingContent,coChairman,attendLegislator,selectTerm
				String[] detail = ((String) readLine).split(",", -1);
				if(detail.length<14)
						continue;
				iD42Obj = new ID42Obj(detail[0], detail[1], detail[2], detail[3], detail[4], detail[5], detail[6],
					detail[7], detail[8], detail[9], detail[10], detail[11], detail[12], detail[13]);

				// generate query result
				if ((StringUtils.isBlank(term) || term.equals(iD42Obj.getTerm())) &&
					(StringUtils.isBlank(sessionPeriod) || sessionPeriod.equals(iD42Obj.getSessionPeriod())) &&
					(StringUtils.isBlank(sessionTimes) || sessionTimes.equals(iD42Obj.getSessionTimes())) &&
					(StringUtils.isBlank(meetingTimes) || meetingTimes.equals(iD42Obj.getMeetingTimes())) &&
					(StringUtils.isBlank(coChairman) || coChairman.equals(iD42Obj.getCoChairman())) &&
					(StringUtils.isBlank(attendLegislator) || attendLegislator.equals(iD42Obj.getAttendLegislator()))) {
					resultList.add(iD42Obj);
					iD42ObjList.getId42ObjLst().addAll(resultList);
				}

			}
			
			br.close();
			isr.close();

			if (fileType.equalsIgnoreCase("csv")) {
				generateCsv(exportFilePath, exportFileName, ".csv", resultList);
			} else if (fileType.equalsIgnoreCase("txt")) {
				generateCsv(exportFilePath, exportFileName, ".txt", resultList);
			} else if (fileType.equalsIgnoreCase("xls")) {
				String csvFilePath = generateCsv(exportFilePath, exportFileName, ".csv", resultList);

				// Opening CSV Files
				Workbook wb = new HSSFWorkbook();
				CreationHelper helper = wb.getCreationHelper();
				Sheet sheet = wb.createSheet("new sheet");

				Path path_xls = Paths.get(csvFilePath);
				InputStreamReader isr_xls = new InputStreamReader(new FileInputStream(path_xls.toFile()),
					StandardCharsets.UTF_8);
				BufferedReader br_xls = new BufferedReader(isr_xls);
				
				String readLine_xls;
				int r = 0;
				while ((readLine_xls = br_xls.readLine()) != null) {
					Row rows = sheet.createRow((short) r++);
					
					String[] line = ((String) readLine_xls).split(",", -1);

					for (int i = 0; i < line.length; i++)
						rows.createCell(i).setCellValue(helper.createRichTextString(line[i]));

				}

				// Write the output to a file
				FileOutputStream fileOut = new FileOutputStream(exportFilePath + exportFileName + ".xls");
				wb.write(fileOut);
				fileOut.close();
				br_xls.close();

			} else if (fileType.equalsIgnoreCase("json")) {
				String finalResult = "{\"dataList\":" + new Gson().toJson(resultList) + "}";
				FileWriter fw = new FileWriter(exportFilePath + exportFileName + ".txt");
				fw.write(finalResult);
				fw.close();
				request.setAttribute("json",finalResult);
			} else if (fileType.equalsIgnoreCase("xml")) {
				// xml
				StringWriter sw = new StringWriter();
				JAXBContext jaxbContext = JAXBContext.newInstance(ID42ObjList.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

				// Marshal the employees list in file
				jaxbMarshaller.marshal(iD42ObjList, new File(exportFilePath + exportFileName + ".xml"));
			}
			request.setAttribute("exportFilePath",exportFilePath);
			request.setAttribute("exportFileName",exportFileName);
			request.setAttribute("fileType",fileType);
		} catch (Exception e) {
			e.printStackTrace();
			// errorMsg = e.getMessage();
			return "exception";
		}
		System.out.println("ID42Action SUCCESS!!");
		return SUCCESS;
	}

	public static String generateCsv(String fileLocation, String fileName, String fileSubName, List<ID42Obj> resultList)
		throws Exception {
		String csvFilePath = fileLocation + fileName + fileSubName;
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				    new FileOutputStream((csvFilePath)), "UTF-8"));
			bw.write('\ufeff');
			bw.write(
				"term,sessionPeriod,sessionTimes,meetingTimes,meetingNo,meetingDateDesc,meetingRoom,meetingUnit,jointCommittee,meetingName,meetingContent,coChairman,attendLegislator,selectTerm");// �g��s�ɮפ�

			for (ID42Obj result : resultList) {
				bw.newLine();// �s�_�@��
				bw.write(result.getTerm() + "," + result.getSessionPeriod() + "," + result.getSessionTimes() + ","
					+ result.getMeetingTimes() + "," + result.getMeetingNo() + "," + result.getMeetingDateDesc() + ","
					+ result.getMeetingRoom() + "," + result.getMeetingUnit() + "," + result.getJointCommittee() + ","
					+ result.getMeetingName() + "," + result.getMeetingContent() + "," + result.getCoChairman() + ","
					+ result.getAttendLegislator() + "," + result.getSelectTerm());// �g��s�ɮפ�
			}

			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return csvFilePath;
	}

	public String getTerm() {
		return term;
	}

	public String getSessionPeriod() {
		return sessionPeriod;
	}

	public String getSessionTimes() {
		return sessionTimes;
	}

	public String getMeetingTimes() {
		return meetingTimes;
	}

	public String getImportFilePath() {
		return importFilePath;
	}

	public String getExportFilePath() {
		return exportFilePath;
	}

	public String getExportFileName() {
		return exportFileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public void setSessionPeriod(String sessionPeriod) {
		this.sessionPeriod = sessionPeriod;
	}

	public void setSessionTimes(String sessionTimes) {
		this.sessionTimes = sessionTimes;
	}

	public void setMeetingTimes(String meetingTimes) {
		this.meetingTimes = meetingTimes;
	}

	public void setImportFilePath(String importFilePath) {
		this.importFilePath = importFilePath;
	}

	public void setExportFilePath(String exportFilePath) {
		this.exportFilePath = exportFilePath;
	}

	public void setExportFileName(String exportFileName) {
		this.exportFileName = exportFileName;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getCoChairman() {
		return coChairman;
	}

	public String getAttendLegislator() {
		return attendLegislator;
	}

	public void setCoChairman(String coChairman) {
		this.coChairman = coChairman;
	}

	public void setAttendLegislator(String attendLegislator) {
		this.attendLegislator = attendLegislator;
	}

}
