package com.siliconmount.MediSoft.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class Doctor {

    private Long id;
    private String fName;
    private String lName;
    private String email;
    private String phoneNumber;
    private String clinicId;
}
