<%-- 
    Document   : informacion
    Created on : 21/10/2021, 01:11:30 PM
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
        <link rel="stylesheet"  href="assets/stylesInfo.css">
        <link rel="shortcut icon" href="https://i.imgur.com/jQ6eD53.png" sizes="128x128">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion</title>
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
                    <input type="text"  id="buscador" placeholder="Search...">
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
                        <img src="<%=session.getAttribute("profile-pic")%>" alt="" onclick="profileSettings()">
                        <div class="name_job">
                            <div class="name"><%= session.getAttribute("Username")%></div>
                            <div class="job"><%= session.getAttribute("ID User")%></div>
                        </div>
                    </div>
                    <i class='bx bx-log-out' id="log_out" onclick="ventanaLogin()"></i>
                </div>
            </div>
        </div>
        <div class="home_content">
              <div class="container">
                  <div class="card">
                      <div class="imgBx">
                          <img src="assets/images/fatima.png">
                          <p>On-site</p>
                      </div>
                      <div class="title">
                          <h3>Fatima Donjuan</h3>
                          <p>Frontend Developer</p>
                      </div>
                      <button>FOLLOW</button>
                      <div class="social-links">
                          <a href=""><i class="fab fa-facebook-f"></i></a>
                          <a href=""><i class="fab fa-twitter"></i></a>
                          <a href=""><i class="fab fa-github"></i></a>
                          <a href="url"><i class="fab fa-tiktok"></i></a>
                      </div>
                  </div>
                  <div class="card">
                      <div class="imgBx">
                          <img src="assets/images/jonathan.png">
                          <p>On-site</p>
                      </div>
                      <div class="title">
                          <h3>Jonathan Morgan</h3>
                          <p>Backend Developer</p>
                      </div>
                      <button>FOLLOW</button>
                      <div class="social-links">
                          <a href=""><i class="fab fa-facebook-f"></i></a>
                          <a href=""><i class="fab fa-twitter"></i></a>
                          <a href=""><i class="fab fa-github"></i></a>
                          <a href="url"><i class="fab fa-tiktok"></i></a>
                      </div>
                  </div>
              </div>
        </div>
        <script src="helpers/informacion.js"></script>
    </body>
</html>
