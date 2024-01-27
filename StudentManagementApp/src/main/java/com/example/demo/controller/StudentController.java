package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Controller
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
		   
	@GetMapping("/students")
	public String getAllStudents(Model model) {
		
		model.addAttribute("students", studentRepository.findAll());
		return "student-list";
		
	}
	
	@GetMapping("/students/add")
	public String showAddForm(Model model) {
		
		model.addAttribute("student", new Student());
		return "add-student";
		
	}
	
	  @PostMapping("/students/add")
	  public String addStudent(@ModelAttribute Student student,Map<String,Object> map) {
		
		studentRepository.save(student);								
		map.put("students", studentRepository.findAll());
		return "student-list";
	  }
	  
	  
	  
	    @GetMapping("/students/addUs")
		public String showAddUsForm(Model model) {
			
			model.addAttribute("student", new Student());
			return "add-studentUs";
			
		}
	  
		    @PostMapping("/students/addUs")
			public String addUsStudent(@ModelAttribute Student student ,Map<String,Object> map, Model model ) {
			
			studentRepository.save(student);
			map.put("students", studentRepository.findAll());
			model.addAttribute("message", "Student Details Saved Successfully!");
			return "add-studentUs";
		  }
		  
		  
	  @GetMapping("/students/edit/{id}") 
	  public String showEditForm(@PathVariable Long id, Model model) {
	  
	  Student student = studentRepository.findById(id).orElseThrow(() -> new
	  IllegalArgumentException("Invalid student id: " + id));
	  model.addAttribute("student", student);
	  
	  return "edit-student"; 
	  
	  }
	  
	  @PostMapping("/students/edit/{id}") 
	  public String editStudent(@PathVariable Long id, @ModelAttribute Student student) {
	  
	  student.setId(id); 
	  studentRepository.save(student);
	  return  "redirect:/students";
	  
	  }
	  
	  @GetMapping("/students/delete/{id}")
	  public String deleteStudent(@PathVariable Long id) {
	  
	  studentRepository.deleteById(id); 
	  return "redirect:/students";
	  
	  }
	  
	  @GetMapping("/students/view")
//	  @PreAuthorize("hasAuthority('ADMIN')")
	  public String viewAllStudents(Model model) {	
		  
		  model.addAttribute("students", studentRepository.findAll());
		  return "student-list";
	  }	   
}

