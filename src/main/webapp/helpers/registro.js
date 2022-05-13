/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

const ventanaInicio = ()=>{
    self.open("index.html","_self");

}

let correoBool=false;


const validateInformation=()=>{
    let user = document.querySelector(".username").value;
    let nombre = document.querySelector(".nombre").value;
    let correo = document.querySelector(".correo").value;
    let password = document.querySelector(".password").value;
    let c_password = document.querySelector(".c_password").value;

    if(user.length != 0){
        console.log("Paso el de user");
        if(nombre.length != 0){
            console.log("Paso el de nombre");
            if(correoBool ===true){
                console.log("Paso el de correo");
                if(password.length !=0){
                    console.log("Paso el de password");
                    if(c_password.length !=0 && password == c_password){
                        console.log("Paso el de otro de password");
                        ventanaInicio();
                    }
                }
            }
        }   
    }
}


const validateUser=()=>{
    let user = document.querySelector(".username");
    if(user.value.length==0){
        if(user.classList.toggle('false')==false){
            /*Aqui pregunta si ya se le agrego el false si es falso se le agrega*/
            user.classList.toggle('false');
        }
    }
    else{
        if(user.classList.toggle('false'==true)){
            user.classList.toggle('false');
        }
        /*Se borra y se agrega la clase active */
        user.classList.toggle('active');
    }

}

const validateName=()=>{
    let user = document.querySelector(".nombre");
    if(user.value.length==0){
        if(user.classList.toggle('false')==false){
            /*Aqui pregunta si ya se le agrego el false si es falso se le agrega*/
            user.classList.toggle('false');
        }
    }
    else{
        if(user.classList.toggle('false'==true)){
            user.classList.toggle('false');
        }
            user.classList.toggle('active');

        /*Se borra y se agrega la clase active */
    }

}

const validateEmail=()=>{
    let emaiRegex=/^(?:[^<>()[\].,;:\s@"]+(\.[^<>()[\].,;:\s@"]+)*|"[^\n"]+")@(?:[^<>()[\].,;:\s@"]+\.)+[^<>()[\]\.,;:\s@"]{2,63}$/i;
    let user = document.querySelector(".correo");
    if(user.value.length==0){
        if(user.classList.toggle('false')==false){
            /*Aqui pregunta si ya se le agrego el false si es falso se le agrega*/
            user.classList.toggle('false');
        }
    }
    else{
        if(user.classList.toggle('false'==true)){
            user.classList.toggle('false');
        }
        if(emaiRegex.test(user.value)==true){
        /*Se borra y se agrega la clase active */
        user.classList.toggle('active');
        correoBool=true;
        }
    }

}

const validatePassword=()=>{
    let user = document.querySelector(".password");
    if(user.value.length==0){
        if(user.classList.toggle('false')==false){
            /*Aqui pregunta si ya se le agrego el false si es falso se le agrega*/
            user.classList.toggle('false');
        }
    }
    else{
        if(user.classList.toggle('false'==true)){
            user.classList.toggle('false');
        }
        /*Se borra y se agrega la clase active */
        user.classList.toggle('active');
    }
}

const validateCPassword=()=>{
    let user = document.querySelector(".c_password");
    let password = document.querySelector(".password").value;
    if(user.value.length==0 && user.value == password){
        if(user.classList.toggle('false')==false){
            /*Aqui pregunta si ya se le agrego el false si es falso se le agrega*/
            user.classList.toggle('false');
        }
    }
    else{
        if(user.classList.toggle('false'==true)){
            user.classList.toggle('false');
        }
        /*Se borra y se agrega la clase active */
        user.classList.toggle('active');
    }
}


