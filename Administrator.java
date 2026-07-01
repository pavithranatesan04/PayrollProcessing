package com.wipro.payroll.service;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import com.wipro.payroll.bean.PayslipBean;
import com.wipro.payroll.dao.PayslipDAO;
import com.wipro.payroll.util.InvalidInputException;

public class Administrator {

    private PayslipDAO payslipDAO = new PayslipDAO();

    public String addPayslip(PayslipBean payslipBean) throws InvalidInputException {

        if (payslipBean == null || isEmpty(payslipBean.getEmpId()) || isEmpty(payslipBean.getMonth()) || isEmpty(payslipBean.getYear()) || payslipBean.getBasic() <= 0   || payslipBean.getCommutation() <= 0 || payslipBean.getHrAllowance() <= 0) {
            throw new InvalidInputException();
        }

        LocalDate now = LocalDate.now();
        String currentMonth = now.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        String currentYear = String.valueOf(now.getYear());

        if (!payslipBean.getMonth().equalsIgnoreCase(currentMonth)|| !payslipBean.getYear().equals(currentYear)) {
            return "INVALID MONTH OR YEAR";
        }

        if (payslipDAO.payslipExists(payslipBean.getEmpId(), payslipBean.getMonth(), payslipBean.getYear())) {
            return "ALREADY EXISTS";
        }

        double basic = payslipBean.getBasic();
        double commutation = payslipBean.getCommutation();
        double hrAllowance = payslipBean.getHrAllowance();

        double providentFund = basic * 0.12;
        double incomeTax = calculateIncomeTax(basic);
        double totalSalary = basic + commutation + hrAllowance + providentFund;
        double payableAmount = totalSalary - incomeTax - providentFund;

        payslipBean.setProvidentFund(providentFund);
        payslipBean.setIncomeTax(incomeTax);
        payslipBean.setTotalSalary(totalSalary);
        payslipBean.setPayableAmount(payableAmount);

        return payslipDAO.createPayslip(payslipBean);
    }

    public PayslipBean viewPayslip(String empID, String month, String year) {
        return payslipDAO.fetchPayslip(empID, month, year);
    }

    private double calculateIncomeTax(double basic) {
        if (basic > 84000) {
            return basic * 0.30;
        } else if (basic > 42000) {
            return basic * 0.20;
        } else if (basic > 21000) {
            return basic * 0.10;
        } else {
            return 0;
        }
    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}