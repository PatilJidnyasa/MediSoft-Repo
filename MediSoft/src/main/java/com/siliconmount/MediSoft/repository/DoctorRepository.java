package com.siliconmount.MediSoft.repository;

import com.siliconmount.MediSoft.entity.DoctorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insert(DoctorEntity doctor) {
        String sql = "INSERT INTO doctors(doctor_id,doctor_first_name,doctor_last_name,doctor_phone_num,doctor_email,clinic_id)\n" +
                "VALUES(" +
                doctor.getId() + ",'" +
                doctor.getFName() + "','" +
                doctor.getLName() + "','" +
                doctor.getPhoneNumber() + "','" +
                doctor.getEmail() + "','" +
                doctor.getClinicId() + "');";

        return jdbcTemplate.update(sql);
    }
}
