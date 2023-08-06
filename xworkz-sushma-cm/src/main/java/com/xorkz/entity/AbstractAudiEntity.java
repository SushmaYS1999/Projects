package com.xorkz.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public class AbstractAudiEntity implements Serializable{

	@Column(name="s_createBy")
	private String createBy;
	@Column(name="s_createDate")
	private LocalDateTime createDate;
	@Column(name="s_updateBy")
	private String updateBy;
	@Column(name="s_updateDate")
	private LocalDateTime updateDate;
}
