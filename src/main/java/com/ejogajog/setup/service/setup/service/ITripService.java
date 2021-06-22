package com.ejogajog.setup.service.setup.service;

import java.util.List;

import com.ejogajog.setup.service.setup.dto.tripDto.GeListTripDto;
import com.ejogajog.setup.service.setup.dto.tripDto.TripDto;

public interface ITripService {

    boolean saveTrip(TripDto tripDto);

    List<GeListTripDto> getAllTripList();

}
