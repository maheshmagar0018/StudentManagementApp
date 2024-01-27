package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {
	
	
//	@Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
	
	
	@Autowired
	private StudentRepository studentRepository;
	
//	@DeleteMapping("/delete/{id}")
//	public String deleteStudentById(@PathVariable Long id) {
//		studentRepository.deleteById(id);
//		return"Student with Id " + id + "deleted successfully!";		
//	}
	
	
	
//	@PostMapping("/authenticate")
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDto userDto) throws Exception {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword())
//            );
//
//            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//            String token = jwtTokenUtil.generateToken(userDetails);
//            
//         // Add logs to check the generated token
//            System.out.println("Generated Token: " + token);
//
//            Map<String, String> response = new HashMap<>();
//            response.put("token", token);
//            return ResponseEntity.ok(response);
//        } catch (BadCredentialsException e) {
//            return ResponseEntity.status(401).body("Invalid credentials");
//        }
//    }
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id){
		if(studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
			return new ResponseEntity<>("Student with Id " + id + " deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Student with Id " + id + " not found", HttpStatus.NOT_FOUND);
		}
	}

}
