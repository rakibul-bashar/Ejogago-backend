package com.ejogajog.setup.service.setup.dto.authDto;

import java.util.List;

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
public class AuthenticationResponseDto {
    private String token;
	private String type = "Bearer";
	private Long id;
	private String email;
	private List<String> roles;

    public AuthenticationResponseDto(String accessToken, Long id, String email, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.email = email;
		this.roles = roles;
	}

}
