package com.siliconmount.MediSoft.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;


    @Getter
    @Setter
    @EqualsAndHashCode
    @NoArgsConstructor
    @Entity
    @Table(name="patients")
    public class PatientEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name="pat_id")
        private Long id;
        @Column(name="pat_first_name")
        private String fName;
        @Column(name="pat_middle_name")
        private String mName;
        @Column(name="pat_last_name")
        private String lName;
        @Column(name="pat_DOB")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private String dob;
        @Column(name="pat_reg_date")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private String regDate;
        @Column(name="pat_zip")
        private String zip;
        @Column(name="pat_email")
        private String email;
        @Column(name="pat_phone_num")
        private String phoneNumber;
        @Column(name="pat_relationship")
        private String relationship;


       public PatientEntity(Long id,String fName,String mName,String lName,String dob,
                String regDate,String zip,String email,String phoneNumber,String relationship) {
            this.id=id;
            this.fName=fName;
            this.mName=mName;
            this.lName=lName;
            this.dob=dob;
            this.regDate=regDate;
            this.zip=zip;
            this.email=email;
            this.phoneNumber=phoneNumber;
            this.relationship=relationship;
        }
}
