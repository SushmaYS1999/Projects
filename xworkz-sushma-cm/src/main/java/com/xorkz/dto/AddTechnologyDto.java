package com.xorkz.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddTechnologyDto {

	private Long id;
	private int signupId;
	
	@NotNull(message = "name techName can't be null")
	private String techName;
	@NotNull(message = "language can't be null")
	private String language;
	@NotNull(message = "version can't be null")
	private String version;
	@NotNull(message = "owner can't be null")
	private String owner;
	@NotNull(message = "supportFromuage can't be null")
	private String supportFrom;
	@NotNull(message = "supportTo can't be null")
	private String supportTo;
	@NotNull(message = "license can't be null")
	private String license;
	@NotNull(message = "openSource can't be null")
	private boolean openSource;
	@NotNull(message = "osType can't be null")
	private String osType;
	
}
