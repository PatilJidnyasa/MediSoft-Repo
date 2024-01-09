package com.siliconmount.MediSoft.service;

import com.siliconmount.MediSoft.model.PatientBilling;
import com.siliconmount.MediSoft.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingService {

    @Autowired
    BillingRepository billingRepository;

    public PatientBilling calculateBill(PatientBilling patientBilling){

        double totalCost;
        double discountedTotal;
        totalCost = patientBilling.getConsultationFees() + patientBilling.getMedicinesCost() +
                patientBilling.getInjectionsCost();
        discountedTotal = totalCost - totalCost * (patientBilling.getDiscount()/100);
        patientBilling.setTotalCost(totalCost);
        patientBilling.setDiscountedTotal(discountedTotal);

        billingRepository.insert(patientBilling);

        return new PatientBilling();
    }
}
