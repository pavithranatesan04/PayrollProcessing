<%@ page import="com.wipro.payroll.bean.PayslipBean" %>
<!DOCTYPE html>
<html>
<head>
    <title>Payslip</title>
</head>
<body>
    <h2>Payslip Details</h2>

    <%
        PayslipBean payslip = (PayslipBean) request.getAttribute("payslip");
        String message = (String) request.getAttribute("message");
    %>

    <% if (payslip == null) { %>
        <p><%= message %></p>
    <% } else { %>
        <table border="1">
            <tr><td>Employee ID</td><td><%= payslip.getEmpId() %></td></tr>
            <tr><td>Month</td><td><%= payslip.getMonth() %></td></tr>
            <tr><td>Year</td><td><%= payslip.getYear() %></td></tr>
            <tr><td>Basic</td><td><%= payslip.getBasic() %></td></tr>
            <tr><td>Commutation</td><td><%= payslip.getCommutation() %></td></tr>
            <tr><td>HR Allowance</td><td><%= payslip.getHrAllowance() %></td></tr>
            <tr><td>Provident Fund</td><td><%= payslip.getProvidentFund() %></td></tr>
            <tr><td>Total Salary</td><td><%= payslip.getTotalSalary() %></td></tr>
            <tr><td>Income Tax</td><td><%= payslip.getIncomeTax() %></td></tr>
            <tr><td>Payable Amount</td><td><%= payslip.getPayableAmount() %></td></tr>
        </table>
    <% } %>

    <br>
    <a href="menu.html">Back to Menu</a>
</body>
</html>