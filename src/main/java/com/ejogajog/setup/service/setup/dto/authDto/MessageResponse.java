package com.ejogajog.setup.service.setup.dto.authDto;
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
public class MessageResponse {
	private String message;

	public MessageResponse(String message) {
	    this.message = message;
	  }

}
