package com.siliconmount.MediSoft.repository;

import org.springframework.stereotype.Repository;

import com.siliconmount.MediSoft.model.Patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class PatientRepository {

	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	/*
	 * public List<Patient> findAll() { //return
	 * jdbcTemplate.query("select * from patients", new ()); }
	 */

	/*
	 * public Patient findById(long id) { return
	 * jdbcTemplate.queryForObject("select * from patients where id=?", new
	 * BeanPropertyRowMapper()<>(Patient.class), id); }
	 */

    public void deleteById(long id) {
        jdbcTemplate.update("delete from patients where id=?", id);
    }

    public int insert(Patient patient) {
        String sql = "insert into medisoftdb.patients(pat_id,pat_first_name,pat_middle_name,pat_last_name,pat_DOB,pat_reg_date,pat_zip,pat_email,pat_phone_num,pat_relationship)" +
				"values("+
				patient.getId()+",'"+
				patient.getFName()+"','"+
				patient.getMName()+"','"+
				patient.getLName()+"','"+
				patient.getDob()+"','"+
				patient.getRegDate()+"',"+
				patient.getZip()+",'"+
				patient.getEmail()+"',"+
				patient.getPhoneNumber()+",'"+
				patient.getRelationship()+"')";

		return jdbcTemplate.update(sql);
    }

	public int update(int id, Patient patient) {
		String update= "UPDATE medisoftdb.patients SET "+
				"pat_first_name = '"+patient.getFName()+"', "+
				"pat_middle_name='"+patient.getMName()+"'," +
				"pat_last_name ='"+patient.getLName()+"'," +
				"pat_DOB = '"+patient.getDob()+"'," +
				"pat_reg_date = '"+patient.getRegDate()+"'," +
				"pat_zip = "+patient.getZip()+"," +
				"pat_email = '"+patient.getEmail()+"', " +
				"pat_phone_num = "+patient.getPhoneNumber()+"," +
				" pat_relationship = '"+patient.getRelationship()+"' " +
				"WHERE pat_id = "+id+"";


		return jdbcTemplate.update(update);

	}


}
