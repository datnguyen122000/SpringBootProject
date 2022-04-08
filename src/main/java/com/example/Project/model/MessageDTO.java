package com.example.Project.model;

public class MessageDTO {
	private String from;// là email gửi đi
	private String to;// email gửi đến
	private String toName;// tên người mình cần gửi đến
	private String subject;
	private String content;

	public MessageDTO() {
		super();
	}

	public MessageDTO(String from, String to, String toName, String subject, String content) {
		super();
		this.from = from;
		this.to = to;
		this.toName = toName;
		this.subject = subject;
		this.content = content;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "MessageDTO [from=" + from + ", to=" + to + ", toName=" + toName + ", subject=" + subject + ", content="
				+ content + "]";
	}

}
