<%-- 
    Document   : registro
    Created on : 25/09/2021, 03:32:12 PM
    Author     : Morgan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controlers.signInController"%>
<!---->
    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html"charset="UTF-8">
        <meta charset='utf-8'>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">  
        <link rel="stylesheet"  href="assets/stylesRegistro.css" type="text/css">
        <link rel="shortcut icon" href="https://i.imgur.com/jQ6eD53.png">
        <title>Registro de Usuario</title>
        
    </head>  
    <body>
        <div class="container">
            <p class="heading">Registro de Usuario</p>
            <form  action="signInController" method="POST">
             <div class="box">
                <p>Nombre</p>
                <div>
                    <input type="name" name="nombre" class="nombre" id="input" placeholder="Enter your name" onkeydown="validateName()" onkeyup="validateName()" onclick="validateName()">
                </div>
            </div>
            <div class="box">
                <p>Correo</p>
                <div>
                    <input type="email" name="email" class="correo" id="input" placeholder="Enter your email" onkeydown="validateEmail()" onkeyup="validateEmail()" onclick="validateEmail()">
                </div>
            </div>
            <div class="box">
                <p>Password</p>
                <div>
                    <input type="password" name="password" class="password" id="input" placeholder="Enter your password" onkeydown="validatePassword()" onkeyup="validatePassword()" onclick="validatePassword()">
                </div>
            </div>
            <div class="box">
                <p>Confirm your Password</p>
                <div>
                    <input type="password" name="cpassword" class="c_password" id="input" placeholder="Confirm your password" onkeydown="validateCPassword()" onkeyup="validateCPassword()" onclick="validateCPassword()">
                </div>
            </div>
            <div class="box">
                <p>Username</p>
                <div>
                    <input type="username" name="username" class="username" id="input" placeholder="Enter your username"  onkeydown="validateUser()" onkeyup="validateUser()" onclick="validateUser()">
                </div>
            </div>
                 <input class="signBtn" value="Sing Up" onclick="validateInformation()" type="submit" >
            </form>

        </div>
        <script src="helpers/registro.js"></script>



    </body>    
</html>
