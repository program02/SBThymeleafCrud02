package com.exam.crud;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {
	private final StudentRepository repository;

	@Autowired
	public StudentController(StudentRepository repository) {
		super();
		this.repository = repository;
	}

	@GetMapping("/")
	public String studentList(Model model) {
		Iterable<Student> list = repository.findAll();
		model.addAttribute("students", list);
		return "studentList";
	}
	@GetMapping("/add")
	public String studetnAddShow(Student student) {
		return "studentAdd";
	}
	@PostMapping("/add")
	public String studetnAdd(@Valid Student student,BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "studentAdd";
		}
		repository.save(student);
		model.addAttribute("students", repository.findAll());
		return "studentList";
	}
	
	@GetMapping("/update/{id}")
	public String studetnUpdateShow(@PathVariable("id") Long id, Model model) {
		Student student = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("student", student);
		return "studentUpdate";
	}
	
	@PostMapping("/update/{id}")
	public String studetnUpdate(@PathVariable("id") Long id, @Valid Student student, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			student = repository.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
			return "updatestudent";
		}
		
		repository.save(student);
		model.addAttribute("students", repository.findAll());
		return "studentList";
	}
	
	@GetMapping("/delete/{id}")
	public String studetnDelete(@PathVariable("id") Long id, Model model) {
		Student student = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		repository.delete(student);
		model.addAttribute("students", repository.findAll());
		return "studentList";
	}
}
