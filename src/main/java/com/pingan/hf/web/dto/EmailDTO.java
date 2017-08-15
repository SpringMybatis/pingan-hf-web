package com.pingan.hf.web.dto;

import java.io.File;
import java.util.List;

public class EmailDTO {

	private String subject;

	private String content;

	private String[] toAss;

	private String fromAss;

	private String[] ccAss;

	private String[] bccAss;

	private List<File> attachements;

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

	public String[] getToAss() {
		return toAss;
	}

	public void setToAss(String[] toAss) {
		this.toAss = toAss;
	}

	public String getFromAss() {
		return fromAss;
	}

	public void setFromAss(String fromAss) {
		this.fromAss = fromAss;
	}

	public String[] getCcAss() {
		return ccAss;
	}

	public void setCcAss(String[] ccAss) {
		this.ccAss = ccAss;
	}

	public String[] getBccAss() {
		return bccAss;
	}

	public void setBccAss(String[] bccAss) {
		this.bccAss = bccAss;
	}

	public List<File> getAttachements() {
		return attachements;
	}

	public void setAttachements(List<File> attachements) {
		this.attachements = attachements;
	}

}
