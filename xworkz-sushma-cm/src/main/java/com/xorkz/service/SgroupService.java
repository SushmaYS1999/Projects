package com.xorkz.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xorkz.dto.AddTechnologyDto;
import com.xorkz.dto.SgroupDTO;
import com.xorkz.entity.SgroupEntity;

public interface SgroupService {

	Set<ConstraintViolation<SgroupDTO>> validateAndSave(SgroupDTO dto);

	default SgroupDTO userSignIn(String userId, String password) {
		return null;
	}

	default List<SgroupDTO> findAll() {
		return Collections.emptyList();

	}

	default Long findByUser(String user) {
		return null;

	}

	default Long findByEmail(String email) {
		return null;

	}

	default Long findByMobile(Long mobile) {
		return null;
	}

	default SgroupDTO findBySignupId(Integer id) {
		return null;
	}
	
	default SgroupDTO updatePassword(String userId, String password, String confirmPassword) {
		return null;
	}

	default SgroupDTO reSetPassword(String email) {
		return null;
	}

	boolean sendMail(String email, String text);

	default SgroupDTO updateProfile(String userId, String email, Long mobile, String path) {
		return null;
	}


	Set<ConstraintViolation<AddTechnologyDto>> validateAndSave(AddTechnologyDto tdto);

	default List<AddTechnologyDto> listBySignupId(Integer signupId) {
		return Collections.emptyList();
	}

}
