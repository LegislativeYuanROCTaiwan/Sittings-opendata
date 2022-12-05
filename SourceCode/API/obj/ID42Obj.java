package API.obj;

public class ID42Obj {

	private String term;
	private String sessionPeriod;
	private String sessionTimes;
	private String meetingTimes;
	private String meetingNo;
	private String meetingDateDesc;
	private String meetingRoom;
	private String meetingUnit;
	private String jointCommittee;
	private String meetingName;
	private String meetingContent;
	private String coChairman;
	private String attendLegislator;
	private String selectTerm;

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

	public String getMeetingNo() {
		return meetingNo;
	}

	public String getMeetingDateDesc() {
		return meetingDateDesc;
	}

	public String getMeetingRoom() {
		return meetingRoom;
	}

	public String getMeetingUnit() {
		return meetingUnit;
	}

	public String getJointCommittee() {
		return jointCommittee;
	}

	public String getMeetingName() {
		return meetingName;
	}

	public String getMeetingContent() {
		return meetingContent;
	}

	public String getCoChairman() {
		return coChairman;
	}

	public String getAttendLegislator() {
		return attendLegislator;
	}

	public String getSelectTerm() {
		return selectTerm;
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

	public void setMeetingNo(String meetingNo) {
		this.meetingNo = meetingNo;
	}

	public void setMeetingDateDesc(String meetingDateDesc) {
		this.meetingDateDesc = meetingDateDesc;
	}

	public void setMeetingRoom(String meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

	public void setMeetingUnit(String meetingUnit) {
		this.meetingUnit = meetingUnit;
	}

	public void setJointCommittee(String jointCommittee) {
		this.jointCommittee = jointCommittee;
	}

	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}

	public void setMeetingContent(String meetingContent) {
		this.meetingContent = meetingContent;
	}

	public void setCoChairman(String coChairman) {
		this.coChairman = coChairman;
	}

	public void setAttendLegislator(String attendLegislator) {
		this.attendLegislator = attendLegislator;
	}

	public void setSelectTerm(String selectTerm) {
		this.selectTerm = selectTerm;
	}

	public ID42Obj() {
		super();
	}

	public ID42Obj(Object term, Object sessionPeriod, Object sessionTimes, Object meetingTimes, Object meetingNo,
		Object meetingDateDesc, Object meetingRoom, Object meetingUnit, Object jointCommittee, Object meetingName,
		Object meetingContent, Object coChairman, Object attendLegislator, Object selectTerm) {
		setTerm(String.valueOf(term));
		setSessionPeriod(String.valueOf(sessionPeriod));
		setSessionTimes(String.valueOf(sessionTimes));
		setMeetingTimes(String.valueOf(meetingTimes));
		setMeetingNo(String.valueOf(meetingNo));
		setMeetingDateDesc(String.valueOf(meetingDateDesc));
		setMeetingRoom(String.valueOf(meetingRoom));
		setMeetingUnit(String.valueOf(meetingUnit));
		setJointCommittee(String.valueOf(jointCommittee));
		setMeetingName(String.valueOf(meetingName));
		setMeetingContent(String.valueOf(meetingContent));
		setCoChairman(String.valueOf(coChairman));
		setAttendLegislator(String.valueOf(attendLegislator));
		setSelectTerm(String.valueOf(selectTerm));
	}
}
