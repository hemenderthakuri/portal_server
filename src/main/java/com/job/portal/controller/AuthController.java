package com.job.portal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.portal.core.ResponseStatus;
import com.job.portal.core.ResponseView;
import com.job.portal.dao.UsersRepository;
import com.job.portal.model.Users;
import com.job.portal.payload.ApiResponse;
import com.job.portal.payload.LoginRequest;
import com.job.portal.payload.SignUpRequest;
import com.job.portal.security.CurrentUser;
import com.job.portal.security.JwtTokenProvider;
import com.job.portal.security.UserPrincipal;
import com.job.portal.view.JwtAuthenticationResponse;
import com.job.portal.view.UserView;

@RestController
@RequestMapping("/api/auth")
public class AuthController extends AbstractController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UsersRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtTokenProvider tokenProvider;

	@PostMapping("/signin")
	public ResponseView authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		ResponseView responseView;
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(authentication);
		JwtAuthenticationResponse view = new JwtAuthenticationResponse(jwt);
		responseView = getResponseView(HttpStatus.OK.value(), ResponseStatus.SUCCESS, "Login Successfull", view);
		return responseView;
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"), HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		Users user = new Users(signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getEmail(),
				signUpRequest.getPassword(), signUpRequest.getType());

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		Users result = userRepository.save(user);

		return ResponseEntity.ok().body(new ApiResponse(true, "User registered successfully"));
	}

	@GetMapping("/me")
	@PreAuthorize("isAuthenticated()")
	public ResponseView getCurrentUser(@CurrentUser UserPrincipal currentUser) {
		ResponseView responseView;
		UserView view = new UserView();
		view.setUser(userRepository.findById(currentUser.getId()).get());
		responseView = getResponseView(HttpStatus.OK.value(), ResponseStatus.SUCCESS, "", view);
		return responseView;
	}

}