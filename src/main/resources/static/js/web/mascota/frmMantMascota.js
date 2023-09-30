$(document).on("click", "#btnagregar", function(){
    $("#txtnommascota").val("");
    $("#txtfechanac").val("");
    $("#hddcodmascota").val("0");
    $("#txtnomprop").val("");
    $("#cbotipomascota").empty();
    $("#txtraza").val("");
    $("#cboestado").empty();
    listarCboTipoMascotaEstado(0,0);
    $("#modalNuevo").modal("show");
});


$(document).on("click", ".btnactualizar", function(){
    $("#txtnommascota").val($(this).attr("data-nombre"));
    $("#txtfechanac").val($(this).attr("data-fechanacimiento"));
    $("#hddcodmascota").val($(this).attr("data-idmascota"));
    $("#txtnomprop").val($(this).attr("data-nombrepropietario"));
    $("#cbotipomascota").empty();
    $("#txtraza").val($(this).attr("data-raza"));
    $("#cboestado").empty();
    listarCboTipoMascotaEstado($(this).attr("data-tipomascota"), $(this).attr("data-estado"));
    $("#modalNuevo").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/mascota/guardar",
        contentType: "application/json",
        data: JSON.stringify({
            idmascota: $("#hddcodmascota").val(),
            nombre: $("#txtnommascota").val(),
            fechanacimiento: $("#txtfechanac").val(),
            nombrepropietario: $("#txtnomprop").val(),
            idtipomascota: $("#cbotipomascota").val(),
            raza: $("#txtraza").val(),
            idestado: $("#cboestado").val(),
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarMascotas();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});

function listarCboTipoMascotaEstado(idtipomascota, idestado){
    $.ajax({
        type: "GET",
        url: "/tipomascota/listar",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cbotipomascota").append(
                    `<option value="${value.idtipomascota}">${value.tipomascota}</option>`
                )
            });
            if(idtipomascota > 0){
                $("#cbotipomascota").val(idtipomascota);
            }
            $.ajax({
                    type: "GET",
                    url: "/estado/listar",
                    dataType: "json",
                    success: function(resultado){
                        $.each(resultado, function(index, value){
                            $("#cboestado").append(
                                `<option value="${value.idestado}">${value.estado}</option>`
                            )
                        });
                        if(idestado > 0){
                            $("#cboestado").val(idestado);
                        }
                    }
                })
        }
    });
}

function listarMascotas(){
    $.ajax({
        type: "GET",
        url: "/mascota/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblmascota > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblmascota > tbody").append("<tr>"+
                    "<td>"+value.idmascota +"</td>"+
                    "<td>"+value.nombre +"</td>"+
                    "<td>"+value.fechanacimiento +"</td>"+
                    "<td>"+value.nombrepropietario +"</td>"+
                    "<td>"+value.tipomascota.tipomascota +"</td>"+
                    "<td>"+value.raza +"</td>"+
                    "<td>"+value.estado.estado +"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-idmascota='"+value.idmascota +"'"+
                                     "data-nombre='"+value.nombre +"'"+
                                     "data-fechanacimiento='"+value.fechanacimiento +"'"+
                                     "data-nombrepropietario='"+value.nombrepropietario +"'"+
                                     "data-tipomascota='"+value.tipomascota.tipomascota +"'"+
                                     "data-raza='"+value.raza +"'"+
                                     "data-estado='"+value.estado.estado +"'"+
                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}