package com.siliconmount.MediSoft.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name="patient_billings")
public class PatientBilling {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="bill_id")
	private int bill_id;
    @Column(name = "dr_id")
    private int drId;
    @Column(name = "pat_id")
    private int patId;
    @Column(name = "consultation_fees")
    private double consultationFees;
    @Column(name = "medicines_cost")
    private double medicinesCost;
    @Column(name = "injections_cost")
    private double injectionsCost;
    @Column(name = "total_cost")
    private double totalCost;
    @Column(name = "discount")
    private double discount;
    @Column(name = "discounted_total")
	private double discountedTotal;

}
