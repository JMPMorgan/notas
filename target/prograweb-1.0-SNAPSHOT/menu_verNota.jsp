<%-- 
    Document   : menu_verNota
    Created on : 6/10/2021, 07:30:37 PM
    Author     : Morgan
--%>

<%@page import="java.util.List"%>
<%@page import="models.Notas"%>
<%@page import="dao.NotasDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
       Notas nota=(Notas)request.getAttribute("Nota");
       List<Notas> notas = (List<Notas>)request.getAttribute("notas");
    %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset='utf-8'>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet"  href="assets/stylesMenu.css">
        <link rel="shortcut icon" href="https://i.imgur.com/jQ6eD53.png" sizes="128x128">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script language="JavaScript" type="text/javascript" src="helpers/menu.js"></script>
        <title>Log In</title>
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
                    <a href="#">
                        <i class='bx bxs-grid' ></i>
                        <span class="links_name">Dashboard</span>
                    </a>
                    <span class="tooltip">Dashboard</span>
                </li>
                <li>
                    <a href="#" onclick="profileSettings()">
                        <i class='bx bxs-user' ></i>
                        <span class="links_name">User</span>
                    </a>
                    <span class="tooltip">User</span>
                </li>
                <li>
                    <a href="#" id="all_notes">
                        <i class='bx bx-notepad' ></i>
                        <span class="links_name">All Notes</span>
                    </a>
                    <span class="tooltip">All Notes</span>
                </li>
                <li>
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
                        <img src="<%=session.getAttribute("profile-pic")%>" alt="" onclick="profileSettings()">
                        <div class="name_job">
                            <div class="name"><%= session.getAttribute("Username") %></div>
                            <div class="job"><%= session.getAttribute("ID User") %></div>
                        </div>
                    </div>
                    <i class='bx bx-log-out' id="log_out" onclick="ventanaLogin()"></i>
                </div>
            </div>
        </div>
        <div class="home_content">
            <div class="text">Home Content</div>
        </div>
        <div class="all_cards">
        </div>
<!--
        <div class="container_counter">
            <p class="heading_counter">Counter</p>
            <p class="counter" id="counter">0</p>
            <button class="inc_counter" onclick="incrementar()"><i class='bx bx-plus'></i></button>
            <button class="dec_counter" onclick="decrementar()"><i class='bx bx-minus' ></i></button>
            <button class="edit_counter"><i class='bx bx-message-square-edit'></i></button>
        </div>
-->
        

        <dialog id="alta_nota">
            <form action="menuController" method="POST">
            <div class="titulo_nota">
                <p>Titulo de Nota</p>
                <input type="text" name="titulo" class="titulo_notatexto">
            </div>
            <div class="hastags_nota">
                <p>#Hastags</p>
                <input type="text" name="hastag">
            </div>
            <div class="text-nota">
                <textarea name="textonota" placeholder="Escribe tu nota...."></textarea>
            </div>
            <div class="buttons">
                <button id="cancel" type="reset">Cancelar</button>
                <button id="complete" type="submit">Completar</button>
            </div>
            </form>
        </dialog >
        <!-- <dialog id="ver_nota">comment -->
             <form action="" method="POST">
            <div class="titulo_nota">
                <p><%=nota.getTituloNota() %></p>
                <input type="text" name="titulo" class="titulo_notatexto">
            </div>
            <div class="hastags_nota">
                <p><%= nota.getHastagNota()%></p>
                <input type="text" name="hastag">
            </div>
            <div class="text-nota">
                <textarea name="textonota" ><%=nota.getTextoNota() %></textarea>
            </div>
            <div class="buttons">
                <button id="cancel_ver" type="reset">Cancelar</button>
                <button id="complete" type="submit">Editar</button>
                <button id="cancel" type="submit">Borrar</button>
            </div>
            </form>  
        <!--</dialog>-->
        <script src="helpers/menu.js"></script>
    </body>
</html>