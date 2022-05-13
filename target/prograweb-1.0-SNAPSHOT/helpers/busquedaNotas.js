

$('#buscador').on('keyup',(e)=>{
    if (e.keyCode == 13) {
        let texto = $('#buscador').val();
        if (texto != null || texto != " ") {
            $.ajax({
                type: "POST",
                data: {
                    texto: texto
                },
                datatype: "JSON",
                url: "buscarNotasController",
                success: (data) => {
                   console.log("HoLa");
                   self.open("buscarNotasController","_self");
                   //refrescarPaginaNotas();
                }
            }
            );
        }
    }
})

const refrescarPaginaNotas=()=>{
    $.ajax({
        url:"logInController",
        data:"op=notas",
        type:"POST",
        success:(data)=>{
            location.reload();
        }
    })
}