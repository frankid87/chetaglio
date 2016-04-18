function ricerca(){
	var insegna = $("#insegna").val();
    var idCitta = $('#citta').val();
    var idCategoria = $('#categoria').val();
    window.location = "/chetaglio/app/admin/ricercanegozio?" + "insegna=" + insegna + "&idCitta=" + idCitta + "&idCategoria=" + idCategoria;
}

function modificanegozio(){
	var id = event.target.id;
	window.location = "/chetaglio/app/admin/modificanegozio?id=" + id;
}