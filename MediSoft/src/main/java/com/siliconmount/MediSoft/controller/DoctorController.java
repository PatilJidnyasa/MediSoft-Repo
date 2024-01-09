package com.siliconmount.MediSoft.controller;

import com.siliconmount.MediSoft.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siliconmount.MediSoft.model.Doctor;
import com.siliconmount.MediSoft.repository.DoctorRepository;

@RestController
@RequestMapping("/api/doctor")
public class
DoctorController {
	
	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	DoctorService doctorService;
	@PostMapping("/add")
	void saveDoctor(@RequestBody Doctor doctor) {
		doctorService.createDoctor(doctor);
	}

	@PostMapping("/getDoctor")
	void getDoctor(@RequestBody Doctor doctor) {
		doctorRepository.insert(null);
	}

	@PostMapping("/updateDoctor")
	void updateDoctor(@RequestBody Doctor doctor) {
		doctorRepository.insert(null);
	}

	@PostMapping("/deleteDoctor")
	void deleteDoctor(@RequestBody Doctor doctor) {
		doctorRepository.insert(null);
	}

}
