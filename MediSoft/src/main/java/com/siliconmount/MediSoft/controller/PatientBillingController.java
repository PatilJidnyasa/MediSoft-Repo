package com.siliconmount.MediSoft.controller;

import com.siliconmount.MediSoft.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siliconmount.MediSoft.model.PatientBilling;


@RestController
@RequestMapping("/api/PatientBilling")
class PatientBillingController {


	@Autowired
	BillingService billingService;

	@PostMapping("/calculateBill")
	public ResponseEntity<PatientBilling> calculateBill (@RequestBody PatientBilling PatientBilling)
	{
		billingService.calculateBill(PatientBilling);

	    return ResponseEntity.ok(PatientBilling);	
	}
	

}
