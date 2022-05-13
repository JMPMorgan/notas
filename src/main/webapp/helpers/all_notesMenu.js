/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
let btn = document.querySelector("#btn");
let sidebar = document.querySelector(".sidebar");
let searchbtn = document.querySelector(".bx-search-alt");

btn.onclick=() =>{
    sidebar.classList.toggle("active");
}

searchbtn.onclick=() =>{
    sidebar.classList.toggle("active");

}

const profileSettings =()=>{
    self.open("profile.jsp","_self");
}

const ventanaMenu=()=>{
    self.open("menu.jsp","_self");
}

const ventanaLogin=()=>{
    self.open("index.jsp","_self");
}

let creador=document.querySelector("#creadores");

creador.addEventListener('click',()=>{
    self.open("informacion.jsp","_self");
})



