<!DOCTYPE html>
<html>
<head>
    <title>Display Payslip</title>
</head>
<body>
    <h2>Display Payslip</h2>
    <form action="MainServlet" method="post">
        <input type="hidden" name="operation" value="view">

        Employee ID: <input type="text" name="empId"><br><br>
        Month: <input type="text" name="month"><br><br>
        Year: <input type="text" name="year"><br><br>

        <input type="submit" value="Search">
    </form>
</body>
</html>