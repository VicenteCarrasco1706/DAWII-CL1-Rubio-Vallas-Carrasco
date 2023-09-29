$(document).on("click", "#btnagregar", function(){
    $("#txtdescservicio").val("");
    $("#txtprecio").val("");
    $("#hddcodprod").val("0");
    $("#cboestado").empty();

    listarCboEstado(0);
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtdescservicio").val($(this).attr("data-descripcion"));
    $("#txtprecio").val($(this).attr("data-precio"));
    $("#hddcodprod").val($(this).attr("data-codservicio"));
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
