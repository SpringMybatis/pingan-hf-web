package com.pingan.hf.web.service.impl;

import java.util.Date;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.pingan.hf.web.dto.EmailDTO;
import com.pingan.hf.web.service.MailService;

@Service
public class MailServiceImpl implements MailService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private ConfigServiceImpl configService;


	private JavaMailSenderImpl mailSender;


	private Properties javaMailProperties;


	@PostConstruct
	public void initSendMail() {
		mailSender = new JavaMailSenderImpl();
		mailSender.setHost(configService.getHost());
		mailSender.setPort(configService.getPort());
		if(StringUtils.isNotBlank(configService.getProtocol())){
			mailSender.setProtocol(configService.getProtocol());
		}
		mailSender.setUsername(configService.getUsername());
		mailSender.setPassword(configService.getPassword());
		mailSender.setDefaultEncoding("UTF-8");  


		javaMailProperties = new Properties();
		javaMailProperties.put("mail.debug", configService.isDebug());
		javaMailProperties.put("mail.smtp.timeout", configService.getTimeout());
		// javaMailProperties.put("mail.smtp.localhost", configService.getLocalhost());
		javaMailProperties.put("mail.smtp.auth", configService.isAuth());
		javaMailProperties.put("mail.smtp.starttls.enable", configService.isStarttls());
		javaMailProperties.put("mail.smtp.socketFactory.class", configService.getSocketFactory());
		mailSender.setJavaMailProperties(javaMailProperties);
	}


	@Override
	public void sendMail(EmailDTO email) {
		try {
			logger.info("--- MailService sendMail start [{}]---", email.toString());
			MimeMessage message = mailSender.createMimeMessage();
			mailSender.getSession().setDebug(configService.isDebug());
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			// 主题
			messageHelper.setSubject(email.getSubject());
			// 发件人
			messageHelper.setFrom(email.getFromAss());
			// 收件人
			messageHelper.setTo(email.getToAss());
			// 抄送
			if (null != email.getCcAss() && email.getCcAss().length > 0) {
				messageHelper.setCc(email.getCcAss());
			}
			// 密抄送
			if (null != email.getBccAss() && email.getBccAss().length > 0) {
				messageHelper.setBcc(email.getBccAss());
			}
			// 附件
			/*if (null != email.getAttachments() && !email.getAttachments().isEmpty()) {
				for (File file : email.getAttachments()) {
					messageHelper.addAttachment(file.getName(), file);
				}
			}*/
			// 发送时间
			messageHelper.setSentDate(new Date());
			// 内容
			messageHelper.setText("<font color='blue'>邮件图片测试</font><br><img src='cid:myImg'>",true);
			// 内嵌图片
			ClassPathResource img = new ClassPathResource("image/windows.jpg");  
			messageHelper.addInline("myImg", img);  
			// 附件
			messageHelper.addAttachment(img.getFilename(), img);
			// 发送
			mailSender.send(message);
			logger.info("--- MailService sendMail success ---");
		} catch (Exception e) {
			logger.error("--- MailService sendMail error ---");
			logger.error("MailService sendMail Exception : \n" + e);
		}
	}
	
}
