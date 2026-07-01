package com.wipro.payroll.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.wipro.payroll.bean.PayslipBean;
import com.wipro.payroll.bean.PayslipId;
import com.wipro.payroll.service.Administrator;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Administrator administrator = new Administrator();

    public String generatePayslip(HttpServletRequest request) {
        String empId = request.getParameter("empId");
        String month = request.getParameter("month");
        String year = request.getParameter("year");

        double basic = parseDouble(request.getParameter("basic"));
        double commutation = parseDouble(request.getParameter("commutation"));
        double hrAllowance = parseDouble(request.getParameter("hrAllowance"));

        PayslipId id = new PayslipId(empId, month, year);
        PayslipBean payslipBean = new PayslipBean(id, basic, commutation, hrAllowance, 0, 0, 0, 0);

        try {
            return administrator.addPayslip(payslipBean);
        } catch (Exception e) {
            return e.toString();
        }
    }

    public PayslipBean viewPayslip(HttpServletRequest request) {
        String empId = request.getParameter("empId");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        return administrator.viewPayslip(empId, month, year);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String operation = request.getParameter("operation");

        if ("generate".equals(operation)) {
            String result = generatePayslip(request);
            if ("SUCCESS".equals(result)) {
                response.sendRedirect("success.html");
            } else {
            	response.sendRedirect("error.html?reason=" + java.net.URLEncoder.encode(result, "UTF-8"));
            }
        } else if ("view".equals(operation)) {
            PayslipBean payslipBean = viewPayslip(request);
            if (payslipBean == null) {
                request.setAttribute("message", "No matching records exists! Please try again!");
            } else {
                request.setAttribute("payslip", payslipBean);
            }
            request.getRequestDispatcher("displayPayslip.jsp").forward(request, response);
        }
    }

    private double parseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            return 0;
        }
    }
}