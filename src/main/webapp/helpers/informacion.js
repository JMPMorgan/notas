let btn = document.querySelector("#btn");
let sidebar = document.querySelector(".sidebar");
let searchbtn = document.querySelector(".bx-search-alt");

btn.onclick=() =>{
    sidebar.classList.toggle("active");

}


searchbtn.onclick=() =>{
    sidebar.classList.toggle("active");

}


let creador=document.querySelector("#creadores");

creador.addEventListener('click',()=>{
    self.open("informacion.jsp","_self");
})




