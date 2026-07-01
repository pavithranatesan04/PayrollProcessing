package com.wipro.payroll.bean;

import java.io.Serializable;
import jakarta.persistence.Embeddable;

@Embeddable
public class PayslipId implements Serializable {


    private String empId;
    private String month;
    private String year;

    public PayslipId() {
    }

    public PayslipId(String empId, String month, String year) {
        this.empId = empId;
        this.month = month;
        this.year = year;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayslipId that = (PayslipId) o;
        return empId != null && empId.equals(that.empId)
            && month != null && month.equals(that.month)
            && year != null && year.equals(that.year);
    }

    @Override
    public int hashCode() {
        int result = empId != null ? empId.hashCode() : 0;
        result = 31 * result + (month != null ? month.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }
}