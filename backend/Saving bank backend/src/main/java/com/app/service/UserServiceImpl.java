package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.LoginRequestDTO;
import com.app.dto.UserDTO;

import com.app.dto.UserPostDTO;
import com.app.entities.UserEntity;
import com.app.repository.UserEntityRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserEntityRepository userEntityRepository;
	@Autowired
	private ModelMapper modelMapper;
//	@Autowired
//	private PasswordEncoder encoder;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public ResponseEntity<?> authenticateUser(LoginRequestDTO loginRequest) {
	    UserEntity user = userEntityRepository.findByEmail(loginRequest.getEmail())
	        .orElseThrow(() -> new ResourceNotFoundException("User not found"));
	    
	    if(passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
	        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
	        return ResponseEntity.ok(userDTO);
	    }
	    throw new RuntimeException("Invalid credentials");
	}
	@Override
	public UserDTO getUserById(Long userId) {
		UserEntity user =userEntityRepository.findById(userId).orElseThrow(()-> new RuntimeException("user not found"));
		
		return modelMapper.map(user, UserDTO.class); 
	}

	@Override
	public String addUser (UserPostDTO userPostDTO) {
	    if (userEntityRepository.existsByEmail(userPostDTO.getEmail())) {
	        throw new RuntimeException("Email already exists!");
	    }
	    if (userEntityRepository.existsByPhone(userPostDTO.getPhone())) {
	        throw new RuntimeException("Phone number already exists!");
	    }
	    UserEntity user = modelMapper.map(userPostDTO, UserEntity.class);
	    user.setPassword(passwordEncoder.encode(userPostDTO.getPassword())); // Ensure password is encoded
	    userEntityRepository.save(user);
	    return "User  is saved";
	}
	
	

	@Override
	public List<UserDTO> alluser() {
		
//		
		
		return userEntityRepository.findAll().stream()
	            .map(userEntity -> modelMapper.map(userEntity, UserDTO.class))
	            .collect(Collectors.toList());
	}
	
	

//	@Override
//	public UserDTO signupUser(UserDTO dto) {
//		//1. map DTO -> entity
//		UserEntity user=modelMapper.map(dto, UserEntity.class);
//		//2. encode password
//		user.setPassword(encoder.encode(user.getPassword()));
//		//3. save
//		UserEntity persistentUser = userEntityRepository.save(user);
//		return modelMapper.map(persistentUser, UserDTO.class);
//	}

}
