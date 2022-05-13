<%-- 
    Document   : index
    Created on : 29/09/2021, 08:39:31 PM
    Author     : Morgan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset='utf-8'>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet"  href="assets/styles.css" type="text/css">
        <link rel="shortcut icon" href="https://i.imgur.com/jQ6eD53.png">
        <title>Log In</title>
    </head>
    <body>
         <div class="container">
            <form action="logInController" method="POST">
                <p class="heading">Log In</p>
                <div class="box">
                    <p>Username</p>
                    <div>
                         <input type="text" name="username" class="usuario"  placeholder="Enter your email" onkeydown="validateUser()" onkeyup="validateUser()" onclick="validateUser()">  
                    </div>
                </div> 
                <div class="box">
                    <p>Password</p>
                    <div>
                        <input type="password" name="password" class="password" placeholder="Enter your password" onkeydown="validatePassword()" onkeyup="validatePassword()" onclick="validatePassword()">

                    </div>
                    <p class="text">Dont have an account <a onclick="ventanaRegistro()" href="#"> Sing Up</a></p>
                    <p class="text"><a href="#">Forget password/Username</a></p>
                </div>
                 <input class="loginBtn" onclick="validateInformation()" type="submit" value="Log In">
            </form>

        </div>
        <script src="helpers/iniciosesion.js"></script>
    </body>
</html>
