package com.pingan.hf.web.service;

import com.pingan.hf.web.dto.EmailDTO;

public interface MailService {

	void sendMail(EmailDTO email);

}
