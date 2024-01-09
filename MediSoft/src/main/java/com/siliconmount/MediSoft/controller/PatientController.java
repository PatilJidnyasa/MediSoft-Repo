package com.siliconmount.MediSoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.siliconmount.MediSoft.model.Patient;
import com.siliconmount.MediSoft.repository.PatientRepository;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
	
	@Autowired
	PatientRepository patientRepository;
	
	@PostMapping("/addPatient")
	void savePatient(@RequestBody Patient patient) {
		patientRepository.insert(patient);
	}

	@PostMapping("/getPatient")
	void getPatient(@RequestBody Patient patient) {
		patientRepository.insert(patient);
	}

	@PutMapping("/update/{id}")

	public int update(@RequestBody Patient patient, @PathVariable("id") int id) {
		return  patientRepository.update(id, patient);
	}

	@PostMapping("/deletePatient")
	void deletePatient(@RequestBody Patient patient) {
		patientRepository.insert(patient);
	}

}
