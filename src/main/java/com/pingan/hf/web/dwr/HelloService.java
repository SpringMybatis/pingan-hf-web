package com.pingan.hf.web.dwr;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;

@RemoteProxy(name="helloService")
public class HelloService {

	@RemoteMethod
	public UserMessage getUser() throws Exception {
		UserMessage user = new UserMessage();
		user.setHello("Hello");
		user.setName("Dwr");
		return user;
	}

	@RemoteMethod
	public void printUser() {
		System.out.println("Hello Dwr");
	}

}
