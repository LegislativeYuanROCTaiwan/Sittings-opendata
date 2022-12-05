package API.obj;

public class ID221Obj {

	private String smeetingDate;
	private String meetingRoom;
	private String meetingTypeName;
	private String meetingName;
	private String meetingContent;
	private String speechKindName;
	private String legislatorNameList;
	private String speechType;

	public String getSmeetingDate() {
		return smeetingDate;
	}

	public String getMeetingRoom() {
		return meetingRoom;
	}

	public String getMeetingTypeName() {
		return meetingTypeName;
	}

	public String getMeetingName() {
		return meetingName;
	}

	public String getMeetingContent() {
		return meetingContent;
	}

	public String getSpeechKindName() {
		return speechKindName;
	}

	public String getLegislatorNameList() {
		return legislatorNameList;
	}

	public String getSpeechType() {
		return speechType;
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

	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}

	public void setMeetingContent(String meetingContent) {
		this.meetingContent = meetingContent;
	}

	public void setSpeechKindName(String speechKindName) {
		this.speechKindName = speechKindName;
	}

	public void setLegislatorNameList(String legislatorNameList) {
		this.legislatorNameList = legislatorNameList;
	}

	public void setSpeechType(String speechType) {
		this.speechType = speechType;
	}

	public ID221Obj() {
		super();
	}

	public ID221Obj(Object smeetingDate, Object meetingRoom, Object meetingTypeName, Object meetingName,
		Object meetingContent, Object speechKindName, Object legislatorNameList, Object speechType) {
		setSmeetingDate(String.valueOf(smeetingDate));
		setMeetingRoom(String.valueOf(meetingRoom));
		setMeetingTypeName(String.valueOf(meetingTypeName));
		setMeetingName(String.valueOf(meetingName));
		setMeetingContent(String.valueOf(meetingContent));
		setSpeechKindName(String.valueOf(speechKindName));
		setLegislatorNameList(String.valueOf(legislatorNameList));
		setSpeechType(String.valueOf(speechType));
	}
}
