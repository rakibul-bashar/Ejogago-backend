package com.ejogajog.setup.service.setup.dto.userDto;

import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author rakibul
 */

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    
	@NotBlank
	private String email;

	private Set<String> role;

	@NotBlank
	private String password;
}