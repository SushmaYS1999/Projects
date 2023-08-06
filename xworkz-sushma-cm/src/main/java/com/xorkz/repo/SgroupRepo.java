package com.xorkz.repo;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import com.xorkz.entity.AddTechnologyEntity;
import com.xorkz.entity.SgroupEntity;

public interface SgroupRepo {

	boolean save(SgroupEntity entity);

	default List<SgroupEntity> findAll() {
		return Collections.emptyList();

	}

	default SgroupEntity userSignIn(String userId) {
		return null;
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
	
	default SgroupEntity findById(Integer Id) {
		return null;
	}

	boolean update(SgroupEntity entity);
	
	boolean logincount(String userId, int count);

	default SgroupEntity reSetPassword(String email) {
		return null;
	}

	boolean updatePassword(String userId, String password, Boolean resetPassword, LocalTime passwordChangedTime);

	boolean add(AddTechnologyEntity entity);

	default List<AddTechnologyEntity> listBysignupId(Integer signupId) {
		return Collections.emptyList();	
	}

}
