package API.obj;

public class ID223Obj {

	private String smeetingDate;
	private String meetingRoom;
	private String meetingTypeName;
	private String jointCommittee;
	private String meetingName;
	private String meetingContent;
	private String legislatorNameList;

	public String getSmeetingDate() {
		return smeetingDate;
	}

	public String getMeetingRoom() {
		return meetingRoom;
	}

	public String getMeetingTypeName() {
		return meetingTypeName;
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

	public String getLegislatorNameList() {
		return legislatorNameList;
	}

	public void setSmeetingDate(String smeetingDate) {
		this.smeetingDate = smeetingDate;
	}

	public void setMeetingRoom(String meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

	public void setMeetingTypeName(String meetingTypeName) {
		this.meetingTypeName = meetingTypeName;
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

	public void setLegislatorNameList(String legislatorNameList) {
		this.legislatorNameList = legislatorNameList;
	}

	public ID223Obj() {
		super();
	}

	public ID223Obj(Object smeetingDate, Object meetingRoom, Object meetingTypeName, Object jointCommittee,
		Object meetingName, Object meetingContent, Object legislatorNameList) {
		setSmeetingDate(String.valueOf(smeetingDate));
		setMeetingRoom(String.valueOf(meetingRoom));
		setMeetingTypeName(String.valueOf(meetingTypeName));
		setJointCommittee(String.valueOf(jointCommittee));
		setMeetingName(String.valueOf(meetingName));
		setMeetingContent(String.valueOf(meetingContent));
		setLegislatorNameList(String.valueOf(legislatorNameList));
	}
}
