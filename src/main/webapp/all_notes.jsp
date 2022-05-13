<%-- 
    Document   : all_notes
    Created on : 25/09/2021, 03:29:00 PM
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
        <link rel="stylesheet"  href="assets/stylesAllNotes.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="https://i.imgur.com/jQ6eD53.png" sizes="128x128">
        <title>All Notes</title>
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
                    <a href="#"  onclick="ventanaMenu()">
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
        <script src="helpers/all_notesMenu.js"></script>
    </body>
</html>
