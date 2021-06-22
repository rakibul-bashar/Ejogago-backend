package com.ejogajog.setup.service.webrest;

import java.util.LinkedHashMap;
import java.util.List;

import com.ejogajog.setup.service.constant.AppConstant;
import com.ejogajog.setup.service.setup.dto.tripDto.GeListTripDto;
import com.ejogajog.setup.service.setup.dto.tripDto.TripDto;
import com.ejogajog.setup.service.setup.service.ITripService;
import com.ejogajog.setup.service.utility.AppResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by rakibul
 */

@RestController
@RequestMapping(path = "/api" + AppConstant.API_VERSION + "/trips", produces = { "application/json" })
public class TripResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(TripResource.class);
    private LinkedHashMap<String, Object> apiResponse;
    
    @Autowired
    ITripService tripService;

    @PostMapping()
    @PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
    ResponseEntity<?> saveTrip(@RequestBody TripDto TripDto) {

        try {
            if (TripDto == null) {
                return new ResponseEntity<Object>(AppResponse.isBadRequest(), new HttpHeaders(),
                        HttpStatus.BAD_REQUEST);
            }
            boolean isTrip = tripService.saveTrip(TripDto);
            if (isTrip) {
                return new ResponseEntity<Object>(AppResponse.isCreated("Trip"), new HttpHeaders(),
                        HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Object>(AppResponse.isNotSaved("Trip"), new HttpHeaders(),
                        HttpStatus.OK);
            }

        } catch (Exception ex) {
            LOGGER.error("An error occurred during retrieved data ::" + ex.getMessage());
            return new ResponseEntity<Object>(AppResponse.isInternalServerError(), new HttpHeaders(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN')")
	ResponseEntity<?> getAllTripList() {
		apiResponse = new LinkedHashMap<String, Object>();
		try {
			List<GeListTripDto> list = tripService.getAllTripList();
			return new ResponseEntity<Object>(list, new HttpHeaders(), HttpStatus.OK);

		} catch (Exception e) {
			LOGGER.info("An error occurred during retrieved data ::" + e);
			apiResponse.put("status", Boolean.FALSE);
			apiResponse.put("httpStatusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
			apiResponse.put("message", "Sorry, unable to retrieved data !!");
			return new ResponseEntity<Object>(apiResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}


