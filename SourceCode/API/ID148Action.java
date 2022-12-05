package API;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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

import API.obj.ID148Obj;
import API.obj.ID148ObjList;
//
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;

//委員發言片段相關影片資訊
public class ID148Action extends ActionSupport {

	private static final long serialVersionUID = -6756806711022425967L;
	private final Logger log = Logger.getLogger(this.getClass());
	private static final HashSet<String> availableFileType = new HashSet<String>(
		Arrays.asList("csv", "json", "xml", "xls", "txt"));

	private String term;
	private String sessionPeriod;
	private String meetingDateS;
	private String meetingDateE;
	private String meetingTime;
	private String legislatorName;

	private String importFilePath = "/lyodw/odwsys/ODM_FT/148_CSV/148_CSV.csv";
	private String exportFilePath = "/lyodw/tomcat7/webapps/odw/source/";
	private String exportFileName = String.valueOf(System.currentTimeMillis());

	private String fileType;

	public String execute() throws Exception {
		System.out.println("ID148Action start!!");
		HttpServletRequest request;
		 request = ServletActionContext.getRequest();

		if (StringUtils.isBlank(fileType) || !availableFileType.contains(fileType.toLowerCase())
			|| (StringUtils.isBlank(meetingDateS) && getCDate(meetingDateS) == null)
			|| (StringUtils.isBlank(meetingDateE) && getCDate(meetingDateE) == null)) {
			return SUCCESS;
		}

		try {
			List<ID148Obj> resultList = new ArrayList<>();
			ID148Obj iD148Obj = new ID148Obj();
			ID148ObjList iD148ObjList = new ID148ObjList();
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
				// term,sessionPeriod,meetingDate,meetingTime,meetingTypeName,meetingName,meetingContent,legislatorName,areaName,speechStartTime,speechEndTime,speechRecordUrl,videoLength,videoUrl,selectTerm
				String[] detail = ((String) readLine).split(",", -1);

				iD148Obj = new ID148Obj(detail[0], detail[1], detail[2], detail[3], detail[4], detail[5], detail[6],
					detail[7], detail[8], detail[9], detail[10], detail[11], detail[12], detail[13], detail[14]);
				// generate query result
				if ((StringUtils.isBlank(term) || term.equals(iD148Obj.getTerm())) &&
					(StringUtils.isBlank(sessionPeriod) || sessionPeriod.equals(iD148Obj.getSessionPeriod())) &&
					(StringUtils.isBlank(meetingDateS) || !changeDate(iD148Obj.getMeetingDate().replace("-", "")).before(getCDate(meetingDateS))) && 
					(StringUtils.isBlank(meetingDateE) || !changeDate(iD148Obj.getMeetingDate().replace("-", "")).after(getCDate(meetingDateE))) &&
					(StringUtils.isBlank(meetingTime) || meetingTime.equals(iD148Obj.getMeetingTime())) &&
					(StringUtils.isBlank(legislatorName) || legislatorName.equals(iD148Obj.getLegislatorName()))) {
					resultList.add(iD148Obj);
					iD148ObjList.getId148ObjLst().addAll(resultList);
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
				JAXBContext jaxbContext = JAXBContext.newInstance(ID148ObjList.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

				// Marshal the employees list in file
				jaxbMarshaller.marshal(iD148ObjList, new File(exportFilePath + exportFileName + ".xml"));
			}
			request.setAttribute("exportFilePath",exportFilePath);
			request.setAttribute("exportFileName",exportFileName);
			request.setAttribute("fileType",fileType);
		} catch (Exception e) {
			e.printStackTrace();
			// errorMsg = e.getMessage();
			return "exception";
		}
		System.out.println("ID148Action SUCCESS!!");
		return SUCCESS;
	}

	public static String generateCsv(String fileLocation, String fileName, String fileSubName,
		List<ID148Obj> resultList)
		throws Exception {
		String csvFilePath = fileLocation + fileName + fileSubName;
		try {

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				    new FileOutputStream((csvFilePath)), "UTF-8"));
			bw.write('\ufeff');
			bw.write(
				"term,sessionPeriod,meetingDate,meetingTime,meetingTypeName,meetingName,meetingContent,legislatorName,areaName,speechStartTime,speechEndTime,speechRecordUrl,videoLength,videoUrl,selectTerm");

			for (ID148Obj result : resultList) {
				bw.newLine();
				bw.write(result.getTerm() + "," + result.getSessionPeriod() + "," + result.getMeetingDate() + ","
					+ result.getMeetingTime() + "," + result.getMeetingTypeName() + "," + result.getMeetingName() + ","
					+ result.getMeetingContent() + "," + result.getLegislatorName() + "," + result.getAreaName() + ","
					+ result.getSpeechStartTime() + "," + result.getSpeechEndTime() + "," + result.getSpeechRecordUrl()
					+ "," + result.getVideoLength() + "," + result.getVideoUrl() + "," + result.getSelectTerm());
			}

			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return csvFilePath;
	}

	public static Date getCDate(String origDate) {
		try {
			if (origDate.length() != 7) {
				return null;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

			return sdf.parse(Integer.parseInt(origDate.substring(0, 3)) + 1911 + origDate.substring(3));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Date changeDate(String origDate) {
		try {
			if (origDate.length() != 8) {
				return null;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			return sdf.parse(origDate);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getTerm() {
		return term;
	}

	public String getSessionPeriod() {
		return sessionPeriod;
	}

	public String getMeetingDateS() {
		return meetingDateS;
	}

	public String getMeetingDateE() {
		return meetingDateE;
	}
	
	public void setMeetingDateS(String meetingDateS) {
		this.meetingDateS = meetingDateS;
	}
	
	public void setMeetingDateE(String meetingDateE) {
		this.meetingDateE = meetingDateE;
	}

	public String getMeetingTime() {
		return meetingTime;
	}

	public String getLegislatorName() {
		return legislatorName;
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

	public void setMeetingTime(String meetingTime) {
		this.meetingTime = meetingTime;
	}

	public void setLegislatorName(String legislatorName) {
		this.legislatorName = legislatorName;
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

}
