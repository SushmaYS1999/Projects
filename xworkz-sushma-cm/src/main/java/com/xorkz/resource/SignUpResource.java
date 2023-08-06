package com.xorkz.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.xorkz.dto.SgroupDTO;
import com.xorkz.service.SgroupService;

@RequestMapping("/")
@EnableWebMvc
@RestController
public class SignUpResource {

	@Autowired
	private SgroupService service;
	
	public SignUpResource() {
		System.out.println("created" +this.getClass().getSimpleName());
		
	}
	
	@GetMapping(value = "/email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onEmail(@PathVariable String email) {
		System.out.println("running on email" +email);
		Long dbEmail = this.service.findByEmail(email);
		System.out.println(dbEmail);
		if(dbEmail == 0) {
			System.out.println("Running in equals conditions");
			return "";
		}
		else {
				return "email exists";
			}
		}
	
	@GetMapping(value = "/userName/{user}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onUserName(@PathVariable String user) {
		Long dbUser = this.service.findByUser(user);
		System.out.println(dbUser);
		if(dbUser == 0) {
			System.out.println("Running in equals conditions");
			return "";
		}
		else {
				return "UserId exists";
			}
		}
	
	@GetMapping(value = "/mobile/{mobile}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onMobile(@PathVariable Long mobile) {
		Long dbNumber = this.service.findByMobile(mobile);
		System.out.println(dbNumber);
		if(dbNumber == 0) {
			System.out.println("Running in equals conditions");
			return "";
		}
		else {
				return "mobile number exists";
			}
		}
	
	@GetMapping(value = "/reemail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String reEmail(@PathVariable String email) {
		Long dbEmail = this.service.findByEmail(email);
		System.out.println(dbEmail);
		if(dbEmail == 0) {
			System.out.println("Running in equals conditions");
			return "please enter existing email";
		}
		else {
				return " ";
			}
		}
		
	}
	

