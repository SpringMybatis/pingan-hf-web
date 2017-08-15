package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pingan.hf.web.dto.EmailDTO;
import com.pingan.hf.web.service.MailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class MailTest {

	@Autowired
	private MailService mailService;

	@Test
	public void sendmail() {
		EmailDTO dto = new EmailDTO();
		dto.setFromAss("1065127135@qq.com");
		dto.setToAss(new String[] { "1065127135@qq.com", "zhongjun100@126.com" });
		dto.setBccAss(new String[] { "1065127135@qq.com" });
		dto.setCcAss(new String[] { "1065127135@qq.com" });
		dto.setSubject("MailTest");
		dto.setContent("this is a test email, if you have problem, ask me for help!");
		
		mailService.sendMail(dto);

	}

}
