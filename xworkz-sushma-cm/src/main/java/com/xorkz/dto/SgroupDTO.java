package com.xorkz.dto;



import java.time.LocalTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SgroupDTO {

	@NotNull
	private int signupId;
	@NotBlank
	@Size(min = 4, max = 100, message = " userId should between 5 to 20 letters")
	private String userId;
	@NotBlank
	@Size(min = 5, max = 30, message = " email should between 5 to 20 letters")
	private String email;
	@NotNull
	private Long mobile;
	@NotBlank
	@Size(min = 5, max = 15, message = " password should between 5 to 15 letters")
	private String password;
	@NotNull
	@NotBlank
	private String confirmPassword;
//	@Size(min = 5, max = 15, message = " acceptAgreement should between 5 to 15 letters")
	@NotNull
	private Boolean acceptAgreement;
	private int loginCount;
	private Boolean resetPassword;
	private LocalTime passwordChangedTime;
	public String picName;
}
