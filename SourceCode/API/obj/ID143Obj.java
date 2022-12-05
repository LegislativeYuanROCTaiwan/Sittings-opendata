package API.obj;

public class ID143Obj {

	private String term;
	private String sessionPeriod;
	private String meetingDate;
	private String meetingTime;
	private String meetingTypeName;
	private String meetingName;
	private String meetingContent;
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

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public void setSelectTerm(String selectTerm) {
		this.selectTerm = selectTerm;
	}

	public ID143Obj() {
		super();
	}

	public ID143Obj(Object term, Object sessionPeriod, Object meetingDate, Object meetingTime, Object meetingTypeName,
		Object meetingName, Object meetingContent, Object videoUrl, Object selectTerm) {
		setTerm(String.valueOf(term));
		setSessionPeriod(String.valueOf(sessionPeriod));
		setMeetingDate(String.valueOf(meetingDate));
		setMeetingTime(String.valueOf(meetingTime));
		setMeetingTypeName(String.valueOf(meetingTypeName));
		setMeetingName(String.valueOf(meetingName));
		setMeetingContent(String.valueOf(meetingContent));
		setVideoUrl(String.valueOf(videoUrl));
		setSelectTerm(String.valueOf(selectTerm));
	}
}
