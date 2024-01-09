package com.siliconmount.MediSoft.service;

import com.siliconmount.MediSoft.model.Patient;
import com.siliconmount.MediSoft.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;
    public int addPatient(Patient patient){

        return patientRepository.insert(patient);
    }

    public int update(int id, Patient patient) {
        return patientRepository.update(id, patient);
    }

}
