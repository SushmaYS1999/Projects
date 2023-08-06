package com.xorkz.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xorkz.dto.AddTechnologyDto;
import com.xorkz.dto.SgroupDTO;
import com.xorkz.service.SgroupService;


@Controller
@RequestMapping("/")
public class SgroupController {

	@Autowired
	private SgroupService service;
	
	public SgroupController() {
		System.out.println("created" + this.getClass().getSimpleName());
		
	}
	
	@PostMapping("/display")
	public String onFam(SgroupDTO dto, Model model) {
	
			Set<ConstraintViolation<SgroupDTO>> violation = this.service.validateAndSave(dto);
			if (violation!=null && violation.isEmpty()) {
				
				System.out.println("running in no violations condition ");
				System.out.println("" +dto);
				model.addAttribute("signup", "data saved successful");
				
				return "SignUp";
				
			}	
			
			model.addAttribute("error", violation);
			model.addAttribute("message", " data not saved");
			//model.addAttribute("dto",dto);
			System.err.println("violation in controll");
			return "SignUp";
		} 	
	@PostMapping("/signin")
	public String userSignIn(String  userId, String password, Model model, HttpServletRequest request) {
		System.out.println("running in userSignIn condition");
		try {
			SgroupDTO dto=this.service.userSignIn(userId, password);
			System.out.println("Login count" +dto.getLoginCount());
			if(dto.getLoginCount() >= 3) {
				model.addAttribute("msg","Account locked Reset password");
				System.out.println("account locked dto to wrong password entering 3 times");
				return "SignIn";
			}
			if(dto!=null) {
				if(dto.getResetPassword() == true) {
					System.out.println("running in resetpassword true condition");
					if(!dto.getPasswordChangedTime().isAfter(LocalTime.now())) {
						System.out.println("running in time varifying condition");
						model.addAttribute("msgs","time out plz try again");
						return "SignIn";
					}
					model.addAttribute("userId", dto.getUserId());
					System.out.println("running in reset condition");
					System.out.println("resetPassword" +dto.getResetPassword());
					System.out.println("Timer---" +dto.getPasswordChangedTime().isBefore(LocalTime.now()));
					return "updatePassword";
				}
				//System.currentTimeMillis();
				System.out.println("userId and password is matched");
				HttpSession httpSession = request.getSession(true);
				httpSession.setAttribute("userId", dto.getUserId());
				httpSession.setAttribute("dtoPic", dto.getPicName());
				httpSession.setAttribute("dto", dto);
				httpSession.setAttribute("signupId", dto.getSignupId());
				
				return "LoginSucess";
			}
				
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("userId or Password is not matching");
		model.addAttribute("match", "userId or Password is not matching");
		return "SignIn";
	}
	
	@PostMapping("/reset")
	public String reSetPassword(String email, Model model) {
		try {
		SgroupDTO dto = this.service.reSetPassword(email);
		if(dto.getResetPassword()==true) {
			model.addAttribute("msg", "PAssword reset successful plz login");
			return "resetPassword";
		}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return "resetPassword";
	}
	@PostMapping("/passwordUpdate")
	public String upDatePassword(String userId, String password, String confirmPassword) {
		System.out.println("Running in upDatePassword method");
		this.service.updatePassword(userId, password, confirmPassword);
		return "sucess";
		
	}
	
	@PostMapping("/upload")
	public String onUpload(@RequestParam("sushma") MultipartFile multipartFile, String userId, String email,
			Long mobile, Model model) throws IOException {
		System.out.println("multipartFile" + multipartFile);
		System.out.println(multipartFile.getOriginalFilename());
		System.out.println(multipartFile.getContentType());
		System.out.println("Size of file" + multipartFile.getSize());
		System.out.println("Size of bite" + multipartFile.getBytes());
		if (multipartFile.isEmpty()) {
			System.out.println("file not uploaded");
			model.addAttribute("error", "please select file");
			return "profileUpdate";
		}
		model.addAttribute("sucess", "image uploaded sucessfully");
		byte[] bytes = multipartFile.getBytes();
		Path path = Paths.get("D:\\highway\\" + userId + System.currentTimeMillis() + ".jpg");
		Files.write(path, bytes);
		String imageName = path.getFileName().toString();
		System.out.println("Image name--" + imageName);
		System.out.println("Image name in tostring--" + path.toString());
		System.out.println("Image file name--" + path.getFileName());
		this.service.updateProfile(userId, email, mobile, imageName);
		return "profileUpdate";
	}

	@GetMapping("/download")
	public void onDownload(HttpServletResponse response, @RequestParam String fileName,  SgroupDTO dto)
			throws IOException {
		Path path = Paths.get("D:\\highway\\" + dto.getPicName());
		path.toFile();
		response.setContentType("image/jpeg");
		File file = new File("D:\\highway\\" + fileName);
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		ServletOutputStream out = response.getOutputStream();
		IOUtils.copy(in, out);
		response.flushBuffer();
	}
	
	@GetMapping("/addtechnology")
	public String addList( Integer signupId, Model model)
	{
		System.out.println("@getMapping addtechnology, signupId " +signupId);
		SgroupDTO dto=this.service.findBySignupId(signupId);
		System.out.println("dto: "+dto);
		model.addAttribute("getUserId", dto.getUserId());
		model.addAttribute("signupId", signupId);
		return "AddTechnology";
		
	}
	
	@PostMapping("/addtechnology")
	public String addTechnology(AddTechnologyDto tdto, Integer signupId, Model model)
	{
		System.out.println("@PoatMapping(/addtechnology)  AddTechnologyDto tdto = "+ tdto + "signupId= " +signupId);
		tdto.setSignupId(signupId);
		System.out.println("tdto: "+tdto);
		model.addAttribute("signupId", signupId);
		Set<ConstraintViolation<AddTechnologyDto>> violations = this.service.validateAndSave(tdto);
		if(violations.isEmpty())
		{
			System.out.println("there is no vioations can add a technology");
			model.addAttribute("addTechSuccess", "Technology added successfully:" +tdto.getTechName());
			return "AddTechnology";
		}
		
		System.out.println("violoations in the technology, can't add it");
		model.addAttribute("errors", violations);
		return "TechnologiesList";
	}
	
	@GetMapping("/listtechnology")
	public String listTechnology(Integer signupId, Model model)
	{
		System.out.println("listTechnology " +signupId);
		SgroupDTO dto=(SgroupDTO) this.service.findBySignupId(signupId);
		System.out.println("dto: "+dto);
		model.addAttribute("signupId", signupId);
		List<AddTechnologyDto> dtos = this.service.listBySignupId(signupId);
		if(dtos.isEmpty())
		{
			System.out.println("there is no technology added");
			model.addAttribute("emptyTechnologies", "there is no technologies added");
			return "LoginSucess";
		}
		System.out.println("dtos.size()"+dtos.size());
		model.addAttribute("dtos", dtos);
		return "TechnologiesList";
		
	}
}

		
