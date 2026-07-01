package com.wipro.payroll.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wipro.payroll.bean.PayslipBean;
import com.wipro.payroll.bean.PayslipId;
import com.wipro.payroll.util.HibernateUtil;

public class PayslipDAO {

    public String createPayslip(PayslipBean payslipBean) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(payslipBean);
            transaction.commit();
            return "SUCCESS";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "FAIL";
        }
    }

    public PayslipBean fetchPayslip(String empID, String month, String year) {
        PayslipId id = new PayslipId(empID, month, year);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(PayslipBean.class, id);
        }
    }

    public boolean payslipExists(String empID, String month, String year) {
        return fetchPayslip(empID, month, year) != null;
    }
}