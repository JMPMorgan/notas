/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
const ventanaRegistro = ()=>{
    self.open("registro.jsp","_self");
}
const ventanaMenu=()=>{
    self.open("menu.jsp","_self");
}




const validateInformation=()=>{
    let usuario= document.querySelector(".usuario").value;
    let password=document.querySelector(".password").value;

    if(usuario.length == 0){

        return;
    }
    else{
        if(password.length == 0){

        }
        else{
            ventanaMenu();
        }
    }
}

const validateUser=()=>{
    let usuario= document.querySelector(".usuario").value;
    let classUser =document.querySelector(".usuario");
        if(usuario.length==0){
            if(classUser.classList.toggle('false')==false){
                classUser.classList.toggle('false');
            }
        }
        else{
            if(classUser.classList.toggle('false')==true){
                classUser.classList.toggle('false');
            }
            classUser.classList.toggle('active');
        }


}

const validatePassword=()=>{
    let password=document.querySelector(".password").value;
    let classPassword = document.querySelector(".password");
    if(password.length==0){
        if(classPassword.classList.toggle('false')==false){
            classPassword.classList.toggle('false')
        }
    }
    else{
        if(classPassword.classList.toggle('false')==true){
            classPassword.classList.toggle('false');
        }
        classUser.classList.toggle('active');
    }
}




