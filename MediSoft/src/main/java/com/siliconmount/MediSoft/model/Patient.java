package com.siliconmount.MediSoft.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class Patient {

	private Long id;
	private String fName;
	private String mName;
	private String lName;
    private String dob;
    private String regDate;
    private String zip;
    private String email;
    private String phoneNumber;
    private String relationship;


}
