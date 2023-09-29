$(document).on("click", "#btnagregar", function(){
    $("#txtdescservicio").val("");
    $("#txtprecio").val("");
    $("#hddcodservicio").val("0");
    $("#cboestado").empty();

    listarCboEstado(0);
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtdescservicio").val($(this).attr("data-descripcion"));
    $("#txtprecio").val($(this).attr("data-precio"));
    $("#hddcodservicio").val($(this).attr("data-codservicio"));
    $("#cboestado").empty();
    listarCboEstado($(this).attr("data-estado"));
    $("#modalNuevo").modal("show");
});


$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/servicio/guardar",
        contentType: "application/json",
        data: JSON.stringify({
            idservicio: $("#hddcodservicio").val(),
            descripcion: $("#txtdescservicio").val(),
            precio: $("#txtprecio").val(),
            idestado: $("#cboestado").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarServicios();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});


function listarCboEstado(idestado) {
    $.ajax({
        type: "GET",
        url: "/estado/listar",
        dataType: "json",
        success: function (resultado) {
            $.each(resultado, function (index, value) {
                $("#cboestado").append(
                    `<option value="${value.idestado}">${value.estado}</option>`
                );
            });
            if (idestado > 0) {
                $("#cboestado").val(idestado);
            }
        }
    });
}


function listarServicios(){
    $.ajax({
        type: "GET",
        url: "/servicio/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblservicio > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblservicio > tbody").append("<tr>"+
                    "<td>"+value.idservicio +"</td>"+
                    "<td>"+value.descripcion +"</td>"+
                    "<td>"+value.precio +"</td>"+
                    "<td>"+value.estado.estado +"</td>"+

                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-codservicio='"+value.idservicio+"'"+
                                     "data-descripcion='"+value.descripcion+"'"+
                                     "data-precio='"+value.precio+"'"+
                                     "data-estado='"+value.estado.estado +"'"+

                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}