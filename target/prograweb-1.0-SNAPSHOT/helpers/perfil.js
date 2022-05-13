/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

let btn = document.querySelector("#btn");
let sidebar = document.querySelector(".sidebar");
let searchbtn = document.querySelector(".bx-search-alt");
let editarbtn=document.querySelector("#editar");

btn.onclick=() =>{
    sidebar.classList.toggle("active");
    card.classList.toggle('active');
}


searchbtn.onclick=() =>{
    sidebar.classList.toggle("active");
    card.classList.toggle('active');
}

const ventanaLogin=()=>{
    self.open("index.jsp","_self");
}

const profileSettings =()=>{
    self.open("profile.jsp","_self");
}

const ventanaMenu=()=>{
    self.open("menu.jsp","_self");
}


let idUser=null;
let idNota=null;

$(document).ready(function(){
    cargarInfo();
})

const cargarInfo=()=>{
       $.ajax({
        url:"profileController",
        type:"GET",
        dataType:"JSON",
        success:(data)=>{
            console.log(data);
            $('#nombre').text(data.nombre);
            $('#nombre-edit').val(data.nombre);
            $('#apellido-edit').val(data.apellido);
            $('#fecha').text(data.fecha);
            $('#email').text(data.email);
            $('#fecha-edit').val(data.fecha);
            $('#email-edit').val(data.email);
            $('#password-edit').val(data.password);
            $('#user').text(data.user);
            $('#imagen-perfil').attr("src",data.imagen);
        }
    }) ;
}

editarbtn.addEventListener('click',()=>{
    let formdata= new FormData();
    let nombre=$("#nombre-edit").val();
    formdata.append('nombre',nombre);
    let apellido=$("#apellido-edit").val();
    formdata.append('apellido',apellido);
    let email=$("#email-edit").val();
    formdata.append('email',email);
    let password=$("#password-edit").val();
    formdata.append('password',password);
    let fotoinfo=document.querySelector('#foto-edit');
    let foto= fotoinfo.files[0];
    formdata.append('foto',foto);
    let fecha=$("#fecha-edit").val();
    formdata.append('fecha',fecha);
    for (var value of formdata.values()) {
     console.log(value);
    }
    console.log(foto);
    console.log(formdata.values());
    console.log(fecha);
    fetch("editarUsuarioController",{
    method: "POST",
    body: formdata
    }).then(()=>{
        alert("Estoy aqui");
        cargarInfo();
    });
    /*$.ajax({
        type: "POST",
        data:formdata,
        datatype: "html",
        processData:false,
        contentType: false,
        url: "editarUsuarioController",
        success: (data) => {
            console.log(data);
            cargarInfo();
        }
   }
  );*/

})


let creador=document.querySelector("#creadores");

creador.addEventListener('click',()=>{
    self.open("informacion.jsp","_self");
})





