package com.siliconmount.MediSoft.repository;

import com.siliconmount.MediSoft.model.PatientBilling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class BillingRepository {

	@Autowired
    JdbcTemplate jdbcTemplate;

    public int insert(PatientBilling billing) {
        String sql = "insert into medisoftdb.patient_billings " + "(bill_id, dr_id, pat_id, consultation_fees, " +
                "medicines_cost, injections_cost, total_cost, discount, discounted_total) values ("
                + billing.getBill_id()+","+
                billing.getDrId()+","+
                billing.getPatId()+","+
                billing.getConsultationFees()+","+
                billing.getMedicinesCost()+","+
                billing.getInjectionsCost()+","+
                billing.getTotalCost()+","+
                billing.getDiscount()+","+
                billing.getDiscountedTotal() +
                        ")";
        return jdbcTemplate.update(sql);
    }

}
