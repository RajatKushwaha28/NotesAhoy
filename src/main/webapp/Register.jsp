<%@page  errorPage="error.html" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/RegisterStyle.css">
  <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Angkor&family=Caveat:wght@400..700&family=Libre+Baskerville:ital,wght@0,400;0,700;1,400&family=Noto+Sans+JP:wght@100..900&family=Nunito+Sans:ital,opsz,wght@0,6..12,200..1000;1,6..12,200..1000&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Truculenta:opsz,wght@12..72,100..900&display=swap" rel="stylesheet">
  <title>Login & Registration</title>
  <link rel="icon" type="image/x-icon" href="icons/NotesAhoy.ico">
</head>
<body background="img/img3.jpg">
<div class="wrapper">
  <nav class="nav">
    <div class="nav-logo">
      <p>NOTES AHOY</p>
    </div>

  </nav>

  <!--------------------Form box---------------------->
  <div class="form-box">
    <!------------registririon form-------------------->
    <div class="register-container" id="register">
      <div class="top">
<span>Have an account? <a href="login.jsp">Login</a></span>
        <header>Sign Up</header>
      </div>
      <div class="two-forms">
        <div class="input-box">
          <form action="SaveUser" method="post">
          <input type="text" name="fname" class="input-field" placeholder="First name" required>
          <i class="bx bx-user"></i>
        </div>
        <div class="input-box">
          <input type="text" name="lname" class="input-field" placeholder="Last name">
          <i class="bx bx-user"></i>
        </div>
        <div class="input-box">
          <input type="email" name="email" class="input-field" placeholder="Email" required>
          <i class="bx bx-envelope"></i>
        </div>
        <div class="input-box">
          <input type="password" name="pass" class="input-field" placeholder="Password" required>
          <i class="bx bx-lock-alt"></i>
        </div>
        <div class="input-box">
          <input type="submit" class="submit" value="Register">
        </div>
        </form>
        
      </div>
     
      
    </div>
       
  </div>
 

</body>
</html>