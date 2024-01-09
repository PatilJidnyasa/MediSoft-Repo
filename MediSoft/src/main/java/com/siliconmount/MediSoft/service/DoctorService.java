package com.siliconmount.MediSoft.service;

import com.siliconmount.MediSoft.entity.DoctorEntity;
import com.siliconmount.MediSoft.model.Doctor;
import com.siliconmount.MediSoft.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    public void createDoctor(final Doctor doctor) {
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(doctor.getId());
        doctorEntity.setEmail(doctor.getEmail());
        doctorEntity.setFName(doctor.getFName());
        doctorEntity.setLName(doctor.getLName());
        doctorEntity.setClinicId(doctor.getClinicId());
        doctorEntity.setPhoneNumber(doctor.getPhoneNumber());
        int insert = doctorRepository.insert(doctorEntity);
        if (insert != 1) {
            throw new RuntimeException("Error while saving a doctor " + doctor.getId());
        }
    }
}
