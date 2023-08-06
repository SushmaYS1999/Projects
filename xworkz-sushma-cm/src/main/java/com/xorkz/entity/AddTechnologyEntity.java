package com.xorkz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "technologys")
@NamedQuery(name = "list", query = "select entity from AddTechnologyEntity entity where entity.signupId=:bysignupId")
public class AddTechnologyEntity {

	@Id
	@Column(name="id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="signupId")
	private int signupId;
	@Column(name = "techName")
	private String techName;
	@Column(name = "language")
	private String language;
	@Column(name = "version")
	private String version;
	@Column(name = "owner")
	private String owner;
	@Column(name = "supportFrom")
	private String supportFrom;
	@Column(name = "supportTo")
	private String supportTo;
	@Column(name = "license")
	private String license;
	@Column(name = "openSource")
	private Boolean openSource;
	@Column(name = "osType")
	private String osType;
}
