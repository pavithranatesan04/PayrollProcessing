<!DOCTYPE html>
<html>
<head>
    <title>Generate Payslip</title>
</head>
<body>
    <h2>Generate Payslip</h2>
    <form action="MainServlet" method="post">
        <input type="hidden" name="operation" value="generate">

        Employee ID: <input type="text" name="empId"><br><br>
        Month (e.g. Jul): <input type="text" name="month"><br><br>
        Year: <input type="text" name="year"><br><br>
        Basic: <input type="text" name="basic"><br><br>
        Commutation: <input type="text" name="commutation"><br><br>
        HR Allowance: <input type="text" name="hrAllowance"><br><br>

        <input type="submit" value="Generate Payslip">
    </form>
</body>
</html>