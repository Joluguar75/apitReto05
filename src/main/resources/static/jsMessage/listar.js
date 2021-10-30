function listarMensaje(){
    $.ajax({
        url:"http://localhost:8080/api/Message/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            listarRespuestaMensaje(respuesta);
        }
    });
}

function listarRespuestaMensaje(respuesta){

    var myTable=`<table border="1">
                <tr>
                    <th>Mensaje</th>
                    <th colspan="2" align="center">Acciones</th>
                </tr>`;
    for(i=0;i<respuesta.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+respuesta[i].messageText+"</td>";
        myTable+="<td> <button onclick='editarMensaje("+respuesta[i].idMessage+")'>Editar</button>";
        myTable+="<td> <button onclick='borrarMensaje("+respuesta[i].idMessage+")'>Borrar</button>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#listado").html(myTable);
}