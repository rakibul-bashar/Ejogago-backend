package com.ejogajog.setup.service.setup.service.impl;

import java.lang.reflect.Type;
import java.util.List;

import com.ejogajog.setup.service.setup.domain.Trip;
import com.ejogajog.setup.service.setup.dto.tripDto.GeListTripDto;
import com.ejogajog.setup.service.setup.dto.tripDto.TripDto;
import com.ejogajog.setup.service.setup.repository.TripRepository;
import com.ejogajog.setup.service.setup.service.ITripService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl implements ITripService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TripServiceImpl.class);
	private static final Type TRIP_LIST = new TypeToken<List<GeListTripDto>>() {
	}.getType();

	@Autowired
	TripRepository tripRepository;


	@Autowired
	ModelMapper modelMapper;

	@Override
	public boolean saveTrip(TripDto tripDto) {
		boolean isTripCreated = false;

		try {
			LOGGER.info("*********Start trip save********");
            Trip tripEntity = modelMapper.map(tripDto, Trip.class);
			tripRepository.save(tripEntity);
			isTripCreated = true;
			LOGGER.info("*********Done********");

		} catch (Exception ex) {
			LOGGER.error("An error occurred while saving Trip data" + ex.getMessage());
		}
		return isTripCreated;
	}



	@Override
	public List<GeListTripDto> getAllTripList() {
		try {

			LOGGER.info("*************Start retrieve the process Trip list *****************") ;
			Iterable<Trip> trip = tripRepository.findAll();
			LOGGER.info("*************Process completed*****************") ;

			List<GeListTripDto> tripListDto = modelMapper.map(trip, TRIP_LIST);
			return tripListDto;
		} catch (Exception ex) {
			LOGGER.error("error occurd while retrive Trip data::" + ex);
		}
		return null;
	}



}
