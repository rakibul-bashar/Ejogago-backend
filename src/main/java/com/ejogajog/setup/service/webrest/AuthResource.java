package com.ejogajog.setup.service.webrest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.ejogajog.setup.service.constant.AppConstant;
import com.ejogajog.setup.service.constant.RoleType;
import com.ejogajog.setup.service.security.JwtUtils;
import com.ejogajog.setup.service.setup.domain.Role;
import com.ejogajog.setup.service.setup.domain.User;
import com.ejogajog.setup.service.setup.dto.authDto.AuhenticationRequestDto;
import com.ejogajog.setup.service.setup.dto.authDto.AuthenticationResponseDto;
import com.ejogajog.setup.service.setup.dto.authDto.MessageResponse;
import com.ejogajog.setup.service.setup.dto.userDto.UserDto;
import com.ejogajog.setup.service.setup.repository.RoleRepository;
import com.ejogajog.setup.service.setup.repository.UserRepository;
import com.ejogajog.setup.service.setup.service.impl.UserDetailsImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api" + AppConstant.API_VERSION + "/users", produces = { "application/json" })
public class AuthResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthResource.class);
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;



	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody AuhenticationRequestDto loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new AuthenticationResponseDto(jwt, 
												 userDetails.getId(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserDto signUpRequest) {

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(RoleType.ROLE_CUSTOMER);
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(RoleType.ROLE_ADMIN);
					roles.add(adminRole);

					break;

				default:
					Role userRole = roleRepository.findByName(RoleType.ROLE_CUSTOMER);
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}


