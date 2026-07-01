package com.wipro.payroll.bean;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAYSLIP_TB")
public class PayslipBean {

    @EmbeddedId
    private PayslipId id;

    @Column(name = "BASIC" , columnDefinition = "NUMBER(10,2)")
    private double basic;

    @Column(name = "COMMUTATION" ,columnDefinition = "NUMBER(10,2)")
    private double commutation;

    @Column(name = "HRALLOWANCE",columnDefinition = "NUMBER(10,2)")
    private double hrAllowance;

    @Column(name = "PROVIDENTFUND",columnDefinition = "NUMBER(10,2)")
    private double providentFund;

    @Column(name = "TOTAL_SALARY",columnDefinition = "NUMBER(10,2)")
    private double totalSalary;

    @Column(name = "INCOME_TAX",columnDefinition = "NUMBER(10,2)")
    private double incomeTax;

    @Column(name = "PAYABLE_AMOUNT",columnDefinition = "NUMBER(10,2)")
    private double payableAmount;

    public PayslipBean() {
    }

    public PayslipBean(PayslipId id, double basic, double commutation, double hrAllowance,
                        double providentFund, double totalSalary, double incomeTax, double payableAmount) {
        this.id = id;
        this.basic = basic;
        this.commutation = commutation;
        this.hrAllowance = hrAllowance;
        this.providentFund = providentFund;
        this.totalSalary = totalSalary;
        this.incomeTax = incomeTax;
        this.payableAmount = payableAmount;
    }

    public PayslipId getId() {
        return id;
    }

    public void setId(PayslipId id) {
        this.id = id;
    }

    public double getBasic() {
        return basic;
    }

    public void setBasic(double basic) {
        this.basic = basic;
    }

    public double getCommutation() {
        return commutation;
    }

    public void setCommutation(double commutation) {
        this.commutation = commutation;
    }

    public double getHrAllowance() {
        return hrAllowance;
    }

    public void setHrAllowance(double hrAllowance) {
        this.hrAllowance = hrAllowance;
    }

    public double getProvidentFund() {
        return providentFund;
    }

    public void setProvidentFund(double providentFund) {
        this.providentFund = providentFund;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public double getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(double incomeTax) {
        this.incomeTax = incomeTax;
    }

    public double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(double payableAmount) {
        this.payableAmount = payableAmount;
    }

    
    public String getEmpId() {
        return id == null ? null : id.getEmpId();
    }

    public void setEmpId(String empId) {
        if (id == null) id = new PayslipId();
        id.setEmpId(empId);
    }

    public String getMonth() {
        return id == null ? null : id.getMonth();
    }

    public void setMonth(String month) {
        if (id == null) id = new PayslipId();
        id.setMonth(month);
    }

    public String getYear() {
        return id == null ? null : id.getYear();
    }

    public void setYear(String year) {
        if (id == null) id = new PayslipId();
        id.setYear(year);
    }
}