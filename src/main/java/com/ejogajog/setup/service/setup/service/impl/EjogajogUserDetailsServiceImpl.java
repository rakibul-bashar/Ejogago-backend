package com.ejogajog.setup.service.setup.service.impl;

import javax.transaction.Transactional;

import com.ejogajog.setup.service.setup.domain.User;
import com.ejogajog.setup.service.setup.repository.UserRepository;
import com.ejogajog.setup.service.setup.service.IEjogajogUserDetailsService;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EjogajogUserDetailsServiceImpl implements IEjogajogUserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TripServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;


	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));
		return UserDetailsImpl.build(user);
	}        


}

