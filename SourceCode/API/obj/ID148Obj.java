package API.obj;

public class ID148Obj {

	private String term;
	private String sessionPeriod;
	private String meetingDate;
	private String meetingTime;
	private String meetingTypeName;
	private String meetingName;
	private String meetingContent;
	private String legislatorName;
	private String areaName;
	private String speechStartTime;
	private String speechEndTime;
	private String speechRecordUrl;
	private String videoLength;
	private String videoUrl;
	private String selectTerm;

	public String getTerm() {
		return term;
	}

	public String getSessionPeriod() {
		return sessionPeriod;
	}

	public String getMeetingDate() {
		return meetingDate;
	}

	public String getMeetingTime() {
		return meetingTime;
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

	public String getLegislatorName() {
		return legislatorName;
	}

	public String getAreaName() {
		return areaName;
	}

	public String getSpeechStartTime() {
		return speechStartTime;
	}

	public String getSpeechEndTime() {
		return speechEndTime;
	}

	public String getSpeechRecordUrl() {
		return speechRecordUrl;
	}

	public String getVideoLength() {
		return videoLength;
	}

	public String getVideoUrl() {
		return videoUrl;
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

	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}

	public void setMeetingTime(String meetingTime) {
		this.meetingTime = meetingTime;
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

	public void setLegislatorName(String legislatorName) {
		this.legislatorName = legislatorName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public void setSpeechStartTime(String speechStartTime) {
		this.speechStartTime = speechStartTime;
	}

	public void setSpeechEndTime(String speechEndTime) {
		this.speechEndTime = speechEndTime;
	}

	public void setSpeechRecordUrl(String speechRecordUrl) {
		this.speechRecordUrl = speechRecordUrl;
	}

	public void setVideoLength(String videoLength) {
		this.videoLength = videoLength;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public void setSelectTerm(String selectTerm) {
		this.selectTerm = selectTerm;
	}

	public ID148Obj() {
		super();
	}

	public ID148Obj(Object term, Object sessionPeriod, Object meetingDate, Object meetingTime, Object meetingTypeName,
		Object meetingName, Object meetingContent, Object legislatorName, Object areaName, Object speechStartTime,
		Object speechEndTime, Object speechRecordUrl, Object videoLength, Object videoUrl, Object selectTerm) {
		setTerm(String.valueOf(term));
		setSessionPeriod(String.valueOf(sessionPeriod));
		setMeetingDate(String.valueOf(meetingDate));
		setMeetingTime(String.valueOf(meetingTime));
		setMeetingTypeName(String.valueOf(meetingTypeName));
		setMeetingName(String.valueOf(meetingName));
		setMeetingContent(String.valueOf(meetingContent));
		setLegislatorName(String.valueOf(legislatorName));
		setAreaName(String.valueOf(areaName));
		setSpeechStartTime(String.valueOf(speechStartTime));
		setSpeechEndTime(String.valueOf(speechEndTime));
		setSpeechRecordUrl(String.valueOf(speechRecordUrl));
		setVideoLength(String.valueOf(videoLength));
		setVideoUrl(String.valueOf(videoUrl));
		setSelectTerm(String.valueOf(selectTerm));
	}
}
