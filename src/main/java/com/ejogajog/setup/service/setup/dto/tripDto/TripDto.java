package com.ejogajog.setup.service.setup.dto.tripDto;

import javax.validation.constraints.NotNull;

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
public class TripDto {
    
	@NotNull
	private Double fromLatitude;

	@NotNull
	private Double fromLongitude;

	@NotNull
	private Double toLatitude;

	@NotNull
	private Double toLongitude;
}