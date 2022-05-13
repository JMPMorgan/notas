<%-- 
    Document   : profile
    Created on : 25/09/2021, 03:31:42 PM
    Author     : Morgan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset='utf-8'>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <script src="https://kit.fontawesome.com/ff6522caa2.js" crossorigin="anonymous"></script>
        <link rel="stylesheet"  href="assets/stylesProfile.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="https://i.imgur.com/jQ6eD53.png">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <title>Profile Settings</title>
    </head>
    <body>
        <div class="sidebar">
            <div class="logo_content">
                <div class="logo">
                    <img src="https://i.imgur.com/jQ6eD53.png"  class="imagen_logo">
                    <div class="logo_name">ZNOTA</div>
                </div>
                <i class='bx bx-food-menu' id="btn"></i>
            </div>
            <ul class="nav_list">
                <li>
                        <i class='bx bx-search-alt' ></i>
                        <input type="text" placeholder="Search...">
                    <span class="tooltip">Search</span>
                </li>
                <li>
                    <a href="#" onclick="ventanaMenu()">
                        <i class='bx bxs-grid' ></i>
                        <span class="links_name" onclick="ventanaMenu()">Dashboard</span>
                    </a>
                    <span class="tooltip">Dashboard</span>
                </li>
                <li>
                    <a href="#">
                        <i class='bx bxs-user' ></i>
                        <span class="links_name">User</span>
                    </a>
                    <span class="tooltip">User</span>
                </li>
                <li>
                    <a href="#">
                        <i class='bx bx-notepad' ></i>
                        <span class="links_name">All Notes</span>
                    </a>
                    <span class="tooltip">All Notes</span>
                </li>
                <li id="creadores">
                    <a href="#">
                        <i class='bx bx-bookmark-heart' ></i>
                        <span class="links_name">Creadores</span>
                    </a>
                    <span class="tooltip">Creadores</span>
                </li>
            </ul>
            <div class="profile_content">
                <div class="profile">
                    <div class="profile_details"> 
                        <img src="TEXTING.jpg" alt="" onclick="profileSettings()">
                        <div class="name_job">
                            <div class="name">Octavio</div>
                            <div class="job">Gonzalez</div>
                        </div>
                    </div>
                    <i class='bx bx-log-out' id="log_out" onclick="ventanaLogin()"></i>
                </div>
            </div>
        </div>
        <div class="card center">
            <input type="checkbox" name="" id="" class="btn_checkbox">
            <div class="left_container center">
                <img src="TEXTING.jpg" id="imagen-perfil" class="imagen_profile">
            </div>
            <div class="right_container center">
                <p class="user_info" id="user"></p>
                <p class="user_info" id="nombre"></p>
                <p class="user_info" id="email"></p>
                <p class="user_info" id="fecha"></p>
            </div>
            <div class="slide center">
                <h2>Edicion de Usuario</h2>
                <div class="edits">
                    <!--<form action="editarUsuarioController" method="POST" enctype="multipart/form-data">-->
                        <div><p>Nombre:<input name="nombre" id="nombre-edit" type="text" placeholder="Ingresa tu Nombre"></p></div>
                    <div><p>Apellido:<input name="apellido" id="apellido-edit" type="text" placeholder="Ingresa tu Apellido"></p></div>
                    <div><p>Email:<input name="email" id="email-edit" type="email" placeholder="Enter your Email"></p></div>
                    <div><p>Contraseña:<input name="password" id="password-edit" type="password" placeholder="Enter your Email"></p></div>
                    <div><p>Foto de Perfil:<input name="foto"  size="1" type="file" placeholder="Enter your Email" id="foto-edit" ></p></div>
                    <div><p>Fecha de Nacimiento:<input name="fecha" type="date" id="fecha-edit" ></p></div>
                    <div><button id="editar"  >Editar</button></div>
                    <!--</form>>-->
                    <div><p></p></div> 
                </div>
            </div>
        </div>

        <script src="helpers/perfil.js"></script>
        
    </body>
</html>
