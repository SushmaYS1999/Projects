package com.xorkz.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xorkz.dto.AddTechnologyDto;
import com.xorkz.dto.SgroupDTO;
import com.xorkz.entity.AddTechnologyEntity;
import com.xorkz.entity.SgroupEntity;
import com.xorkz.repo.SgroupRepo;


@Service
public class SgroupServiceImpl implements SgroupService {

	@Autowired
	private SgroupRepo  repo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	
	
	public SgroupServiceImpl() {
		System.out.println("created" +this.getClass().getSimpleName());
	}
	
	private Set<ConstraintViolation<SgroupDTO>> validate(SgroupDTO dto) {
		ValidatorFactory factory=Validation.buildDefaultValidatorFactory();
		Validator validator=factory.getValidator();
		Set<ConstraintViolation<SgroupDTO>> violations=validator.validate(dto);
		return violations;
	}
	
	@Override
	public Set<ConstraintViolation<SgroupDTO>> validateAndSave(SgroupDTO dto) {
		Long emailCount = this.repo.findByEmail(dto.getEmail());
		Long userCount = this.repo.findByUser(dto.getUserId());
		Long mobileCount = this.repo.findByMobile(dto.getMobile());
		System.err.println("emailCount-" +emailCount);
		System.err.println("userCount-" +userCount);
		System.err.println("mobileCount-" +mobileCount);
		
		Set<ConstraintViolation<SgroupDTO>> violations = validate(dto);
			if(violations!=null && !violations.isEmpty())
			{
				System.out.println("violation in dto");
				return violations;
			}
			if(!dto.getPassword().equals(dto.getConfirmPassword()))
			{
				System.out.println("password is not matching");
				return null;
			}
			if(emailCount == 0 && userCount == 0 && mobileCount == 0) {
				
					System.out.println("no violation processing to save");

					SgroupEntity entity = new SgroupEntity();
					entity.setCreateBy(dto.getUserId());
					entity.setCreateDate(LocalDateTime.now());
					//BeanUtils.copyProperties(dto, entity);
					entity.setPassword(passwordEncoder.encode(dto.getPassword()));
					entity.setUserId(dto.getUserId());
					entity.setEmail(dto.getEmail());
					entity.setAcceptAgreement(dto.getAcceptAgreement());
					entity.setMobile(dto.getMobile());
					entity.setResetPassword(false);
					entity.setPasswordChangedTime(LocalTime.of(0, 0, 0));
					boolean saved=this.repo.save(entity);
					
					System.out.println("entity is saved" + saved);
					
					if(saved) {
						boolean sent = this.sendMail(dto.getEmail(), "Thanks for registration");
						System.out.println("email sent successfully " +sent);
					}
					
			}
			return Collections.emptySet();
		}
		
	@Override
	public SgroupDTO userSignIn(String userId, String password) {
		SgroupEntity entity = this.repo.userSignIn(userId);
		SgroupDTO dto = new SgroupDTO();
		BeanUtils.copyProperties(entity, dto);
		
		System.out.println("matching" + passwordEncoder.matches(password, entity.getPassword()));
		System.out.println("Time matching--" +entity.getPasswordChangedTime().isBefore(LocalTime.now()));
		System.out.println("Now Present time--" +LocalTime.now());
		System.out.println("PasswordChangedTime--" +entity.getPasswordChangedTime());
		System.out.println("Time--" + LocalTime.now().isBefore(entity.getPasswordChangedTime()));
		
		if (entity.getLoginCount() >= 3) {
			System.out.println("running in login count condition");
			return dto;
		}
		//dto.setUserId(entity.getUserId());
		//dto.setPassword(entity.getPassword());
		if(dto.getUserId().equals(userId) && passwordEncoder.matches(password, entity.getPassword())) {
			System.out.println("running userId matching and password matching");
			return dto;
		}
		else {
			this.repo.logincount(userId, entity.getLoginCount() + 1);
			//System.out.println("count of login "+ entity.getLoginCount() + 1);
			return null;
		}
		
	}
	
	@Override
	public List<SgroupDTO> findAll() {
		List<SgroupEntity> sEntity = this.repo.findAll();
		List<SgroupDTO> lists = new ArrayList<SgroupDTO>();
		for(SgroupEntity entity : sEntity) {
			SgroupDTO dto =new SgroupDTO();
			BeanUtils.copyProperties(entity, dto);
			lists.add(dto);
		}
		return lists;
	}
	
	@Override
	public Long findByEmail(String email) {
		Long emailcount = this.repo.findByEmail(email);
		System.err.println("Find by Email");
		return emailcount;
	}
	
	@Override
	public Long findByMobile(Long mobile) {
		Long mobilecount = this.repo.findByMobile(mobile);
		return mobilecount;
		
	}
	
	@Override
	public Long findByUser(String user) {
		Long usercount = this.repo.findByUser(user);
		return usercount;
	}
	
	@Override
	public SgroupDTO reSetPassword(String email) {
		System.out.println("running in reset password--");
		String reSetPassword = DefaultPasswordGenerator.generate(6);
		System.out.println("Reset password--" +reSetPassword);
		SgroupEntity entity = this.repo.reSetPassword(email);
		if(entity != null)
		{
			System.out.println("entity found for email--" +email);
			entity.setPassword(passwordEncoder.encode(reSetPassword));
			entity.setUpdateBy("System");
			entity.setUpdateDate(LocalDateTime.now());
			entity.setLoginCount(0);
			entity.setResetPassword(true);
			entity.setPasswordChangedTime(LocalTime.now().plusSeconds(120));
			boolean update = this.repo.update(entity);
			if(update) {
				sendMail(entity.getEmail(),"your reset password is --> " +reSetPassword + "plz login again with in 2 min with this password");
			}
			System.out.println("updated--" + update);
			SgroupDTO dto = new SgroupDTO();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}
		System.out.println("entity not found for email--" +email);
		return SgroupService.super.reSetPassword(email);
	}
	
	@Override
	public SgroupDTO updatePassword(String userId, String password, String confirmPassword) {
		SgroupEntity entity = new SgroupEntity();
		if(password.equals(confirmPassword)) {
			boolean passwordUpdated = this.repo.updatePassword(userId, passwordEncoder.encode(password), false, LocalTime.of(0, 0, 0));
			System.out.println("password updated--" +passwordUpdated);
		}
		return SgroupService.super.updatePassword(userId, password, confirmPassword);
		
	}
	
	@Override
	public SgroupDTO updateProfile(String userId, String email, Long mobile, String path) {
		SgroupEntity upEntity = this.repo.reSetPassword(email);
		System.out.println("userId: "+userId +"email: "+email+"mobile: "+mobile+"image name: "+path);

		upEntity.setUserId(userId);
		upEntity.setMobile(mobile);
		upEntity.setPicName(path);
		boolean updated=this.repo.update(upEntity);
		System.out.println("updated--"+updated);
		return SgroupService.super.updateProfile(userId, email, mobile, path);
	}
	
	@Override
	public boolean sendMail(String email, String text) {
		String reSetPassword =DefaultPasswordGenerator.generate(6);
		String portNumber="587";
		String hostName="smtp.office365.com";
		String fromEmail="sushmagowda1999@outlook.com";
		String password="sys*1999";
		String to=email;
		
		Properties prop=new Properties();
		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.debug", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.transport.protocal", "smtp");
		
		Session session = Session.getInstance(prop, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail,password);
			}
			
		});
		
		MimeMessage message= new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(fromEmail));
			//message.setSubject("Registration completed");
			message.setText("thanks for reseting password" + reSetPassword);
			message.setText(text);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(message);
			System.out.println("--mail send succussfully--");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return true;	
	}
	
	public final static class DefaultPasswordGenerator {
		private static final String[] charCategories = new String[] { "abcdefghijklmnopqrstuvwxyz",
				"ABCDEFGHIJKLMNOPQRSTUVWXYZ", "0123456789" };
		 
		public static String generate(int length) {
			StringBuilder password = new StringBuilder(length);
			Random random = new Random(System.nanoTime());
			
			for(int i=0; i<length; i++) {
				String charCategory = charCategories[random.nextInt(charCategories.length)];
				int position = random.nextInt(charCategory.length());
				password.append(charCategory.charAt(position));
			}
			return new String(password);	
		}
		//String password =DefaultPasswordGenerator.generate(6);
	}

	@Override
	public Set<ConstraintViolation<AddTechnologyDto>> validateAndSave(AddTechnologyDto tdto) {
		System.out.println("validate and add in serviceImpl");
		ValidatorFactory factory=Validation.buildDefaultValidatorFactory();
		Validator validator=factory.getValidator();
		Set<ConstraintViolation<AddTechnologyDto>> violations=validator.validate(tdto);
		if(violations != null && !violations.isEmpty()) {
			System.out.println("violations in dto" +tdto);
			return violations;
		}
		
		AddTechnologyEntity entity = new AddTechnologyEntity();
		BeanUtils.copyProperties(tdto, entity);
		boolean add=this.repo.add(entity);
		if(add) {
			System.out.println("technology added successfully");
		}
		return Collections.emptySet();
	}
	
	@Override
	public SgroupDTO findBySignupId(Integer id) {
		System.out.println("findBySignupId" +id);
		SgroupEntity entity=repo.findById(id);
		System.out.println("entity in service:" +entity);
		if(entity!=null) {
			SgroupDTO dto=new SgroupDTO();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}
		return SgroupService.super.findBySignupId(id);
	}
	
	@Override
	public List<AddTechnologyDto> listBySignupId(Integer signupId) {
		System.out.println("findBySignupId" +signupId);
		List<AddTechnologyEntity> entities = this.repo.listBysignupId(signupId);
		System.out.println("entities.size(): " +entities.size());
		List<AddTechnologyDto> dtos = new ArrayList<>();
		if(!entities.isEmpty()) {
			for (AddTechnologyEntity entity : entities) {
				AddTechnologyDto dto = new AddTechnologyDto();
				BeanUtils.copyProperties(entity, dto);
				dtos.add(dto);
				
			}
			System.out.println("dtos.size():" +dtos.size());
			return dtos;
		}
		return Collections.emptyList();
	}
}