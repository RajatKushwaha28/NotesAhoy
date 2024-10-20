<!DOCTYPE html>
<html lang="en">
<head>
 <%@page import="com.DAO.UserDAO" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Autofocus Field</title>
    <link rel="stylesheet" type="text/css" href="css/otp.css">
</head>
<body>
<%
			UserDAO ud= new UserDAO();
			//String otp = ud.generateOTP();
%>
    <div class="container">
        <h1>ENTER OTP</h1>
        <div class="userInput">
            <form action="checkUpdateOTP" method="post">
                <input type="number" name="ist "id='ist' maxlength="1" onkeyup="clickEvent(this,'sec')" required>
                <input type="number" name="sec" id="sec" maxlength="1" onkeyup="clickEvent(this,'third')" required>
                <input type="number" name="third" id="third" maxlength="1" onkeyup="clickEvent(this,'fourth')" required>
                <input type="number" name="fourth" id="fourth" maxlength="1" required><br>
                <center><button type="submit">CONFIRM</button></center>
            </form>
        </div>
    </div>
    
    <script src="js/otp.js"></script>
</body>
</html>
