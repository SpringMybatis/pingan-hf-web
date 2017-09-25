package com.pingan.hf.web.dwr;

import org.directwebremoting.annotations.DataTransferObject;

@DataTransferObject
public class UserMessage {

	private String name;

	private String hello;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}

}
