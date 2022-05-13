let btn = document.querySelector("#btn");
let sidebar = document.querySelector(".sidebar");
let searchbtn = document.querySelector(".bx-search-alt");
let card=document.querySelector(".all_cards");
let all_cards=document.querySelector("#all_notes");
//PARA EL CONTADOR//
let counter = document.getElementById('counter');
let cancelBtn= document.getElementById('cancel');
let cancelBtnVer= document.getElementById('cancel_ver');
let completeBtn=document.getElementById('complete');
let noteDialog= document.getElementById('alta_nota');
let editar_nota=document.getElementById('editar');
let borrar_nota=document.getElementById('borrar-nota');
let viewNoteDialog=document.querySelector("#ver_nota");


//PARA EL LOGOUT

let logout=document.querySelector("#log_out");

logout.addEventListener('click',()=>{
    
    $.ajax({
       url:"logInController?op=cerrar",
       type:"POST",
       datatype:"JSON",
       success:(data)=>{
           self.open("index.jsp","_self");
       }
    });
})

const incrementar= ()=>{
    let createDialog = document.getElementById('crearDialog');
    noteDialog.showModal();
    let count =$('#counter').text();
    console.log(count);
    count++;
    counter.innerHTML=count;
}

const verNota= (id,idnotas)=>{
    $.ajax({
        url:"logInController?op=mostrar&id="+id+"&idnotas="+idnotas,
        type:"GET",
        dataType:"JSON",
        success: (data)=>
        {
            idUser=data.id_usuario;
            idNota=data.id_nota;
            $('.titulo_notatexto-ver').val(data.titulo);
            $('#hastag-nota-texto').val(data.hastag);
            $('#area-nota-texto').val(data.texto);
            $("#ver_nota").show();


        }
    }
    );
}

cancelBtn.addEventListener('click',()=>{
    noteDialog.close();
    decrementar();
})

cancelBtnVer.addEventListener('click',()=>{
    console.log("hola");
    idUser=null;
    idNota=null;
    $('#ver_nota').hide();
})

let idUser=null;
let idNota=null;

editar_nota.addEventListener('click',()=>{
    let t=$(".titulo_notatexto-ver").val();
    let h=$("#hastag-nota-texto").val();
    let te=$("#area-nota-texto").val();
    console.log(idUser,idNota);
        $.ajax({
        type:"POST",
        data:{
            iduser:idUser,
            idnota:idNota,
            te:t,
            he:h,
            tex:te
        },
        datatype:"JSON",
        url:"editarnotaController",
        success: (data)=>{
            console.log(data);
            $('#ver_nota').hide();
            refrescarPaginaEliminar(idUser);
            //refrescarPagina(idUser);
            console.log("hola");
        }
    }
    );
})

const refrescarPagina=(idUsuario)=>{
    $.ajax({
        url:"logInController",
        data:"op=refrescar&id="+idUsuario,
        type:"POST",
        success: (data)=>{
            console.log("SALUDITOS");
        }
    }
    );
}

const refrescarPaginaEliminar=(idUsuario)=>{    
    $.ajax({
        url:"logInController",
        data:"op=refrescar&id="+idUsuario,
        type:"POST",
        success: (data)=>{
            console.log("SALUDITOS");
        }
    }
    );
    
}

borrar_nota.addEventListener('click',()=>{
    console.log("entron a borrar");
    
    $.ajax({
      type:"POST",
       data:{
           iduser:idUser,
           idnote:idNota
       },
       datatype:"JSON",
       url:"eliminarnotaController",
       success:(data)=>{
            console.log(data);
            $('#ver_nota').hide();
            refrescarPaginaEliminar(idUser);
            //console.log("borre");
       }
    });
})

completeBtn.addEventListener('click',()=>{
    noteDialog.close();
})

all_cards.addEventListener('click',()=>{
    self.open("all_notes.jsp","_self")
})


const decrementar=()=>{
    let count =$('#counter').text();
    
    console.log(count);
    count--;
    if(count<=0){
        counter.innerHTML=0;
        count=0;
    }
    else{
        counter.innerHTML=count;
    }
}

//PARA EL CONTADOR//


btn.onclick=() =>{
    sidebar.classList.toggle("active");
    card.classList.toggle('active');
}


searchbtn.onclick=() =>{
    sidebar.classList.toggle("active");
    card.classList.toggle('active');
}

//CAMBIO DE PERFIL//

const profileSettings =()=>{
    self.open("profile.jsp","_self");
}


//Mostrar footer

let creador=document.querySelector("#creadores");

creador.addEventListener('click',()=>{
    self.open("informacion.jsp","_self");
})




