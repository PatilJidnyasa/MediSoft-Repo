package com.siliconmount.MediSoft.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="doctors")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="doctor_id")
	private Long id;
    @Column(name="doctor_first_name")
    private String fName;
    @Column(name="doctor_last_name")
    private String lName;
    @Column(name="doctor_email")
    private String email;
    @Column(name="doctor_phone_num")
    private String phoneNumber;
    @Column(name="clinic_id")
    private String clinicId;
    
    public DoctorEntity(Long id, String fName, String lName, String email, String phoneNumber, String clinicId) {
    	this.id=id;
    	this.fName=fName;
    	this.lName=lName;
    	this.email=email;
    	this.phoneNumber=phoneNumber;
    	this.clinicId=clinicId;
    }

}
