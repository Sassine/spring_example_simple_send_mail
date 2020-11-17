package com.sassine.mail;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MailController {

	@Autowired
	private MailService mailService;

	@GetMapping("/")
	public String home() {
		return "redirect:sendMail";
	}

	@GetMapping("/sendMail")
	public String sendEmailForm(Model model) {
		Mail mail = new Mail();
		model.addAttribute("sendMailForm", mail);
		return "sendMail";
	}

	@PostMapping("/sendMail")
	public String sendMail(Model model, @RequestParam("collage") List<MultipartFile> files, Mail mail) {
		try {
			mailService.sendMail(mail, files);
		} catch (MailException | MessagingException me) {
			System.out.println(me.getMessage());
			return "redirect:error";
		}
		return "redirect:sent";
	}

	@GetMapping("/error")
	public String error() {
		return "error";
	}

	@GetMapping("/sent")
	public String sent() {
		return "sent";
	}

}
