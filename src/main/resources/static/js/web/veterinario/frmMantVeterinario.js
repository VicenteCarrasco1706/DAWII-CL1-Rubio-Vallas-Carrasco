$(document).on("click", "#btnagregar", function(){
    $("#txtnombres").val("");
    $("#txtnrodocumento").val("");
    $("#txtcorreo").val("");
    $("#hddcodveterinario").val("0");
    $("#cboespecialidad").empty();
    $("#cboestado").empty();
    listarCboEspecialidad(0);
    listarCboEstado(0);
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtnombres").val($(this).attr("data-nombres"));
    $("#txtnrodocumento").val($(this).attr("data-nrodocumento"));
     $("#txtcorreo").val($(this).attr("data-correo"));
    $("#hddcodveterinario").val($(this).attr("data-codveterinario"));
     $("#cboespecialidad").empty();
    $("#cboestado").empty();
    listarCboEspecialidad($(this).attr("data-especialidad"));
    listarCboEstado($(this).attr("data-estado"));
    $("#modalNuevo").modal("show");
});


$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/veterinario/guardar",
        contentType: "application/json",
        data: JSON.stringify({
            idveterinario: $("#hddcodveterinario").val(),
            nombrecompleto: $("#txtnombres").val(),
            numerodocumento: $("#txtnrodocumento").val(),
            correo: $("#txtcorreo").val(),
            idespecialidad: $("#cboespecialidad").val(),
            idestado: $("#cboestado").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarVeterinarios();
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

function listarCboEspecialidad(idespecialidad) {
    $.ajax({
        type: "GET",
        url: "/especialidad/listar",
        dataType: "json",
        success: function (resultado) {
            $.each(resultado, function (index, value) {
                $("#cboespecialidad").append(
                    `<option value="${value.idespecialidad}">${value.especialidad}</option>`
                );
            });
            if (idespecialidad > 0) {
                $("#cboespecialidad").val(idestado);
            }
        }
    });
}



function listarVeterinarios(){
    $.ajax({
        type: "GET",
        url: "/veterinario/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblveterinario > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblveterinario > tbody").append("<tr>"+
                    "<td>"+value.idveterinario +"</td>"+
                    "<td>"+value.nombrecompleto +"</td>"+
                    "<td>"+value.numerodocumento +"</td>"+
                    "<td>"+value.correo +"</td>"+
                     "<td>"+value.especialidad.especialidad +"</td>"+
                    "<td>"+value.estado.estado +"</td>"+

                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-codveterinario='"+value.idveterinario+"'"+
                                     "data-nombres='"+value.nombrecompleto+"'"+
                                     "data-nrodocumento='"+value.numerodocumento+"'"+
                                     "data-correo='"+value.correo+"'"+
                                     "data-especialidad='"+value.especialidad.especialidad +"'"+
                                     "data-estado='"+value.estado.estado +"'"+

                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}