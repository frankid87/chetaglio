<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/app/admin/salvanegozio" />
<html>
<head>
<title>Crea negozio</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="../../js/test.js"></script>
<link href="../../css/main.css" rel="stylesheet" type="text/css"></link>
</head>
<body>
	<div id="container">
		<div id="header">
			<div id="headtop">
				<a href="#">Site Map</a> <a href="#">Contact</a> <a href="#">About</a>
			</div>
			<div id="headbottom">
				<h1>
					Che Taglio<span style="color: #FF6600;"> admin</span>
				</h1>
				<h2>Your website slogan goes over here.</h2>
			</div>
		</div>
		<div id="menu">
			<ul>
				<li class="current"><a href="#">Home</a></li>
				<li><a href="ricercanegozio">Gestione negozi</a></li>
			</ul>
			<div class="search">
				<form method="post" action="#">
					<input class="inputbutton" type="button" value="Search"> <input
						class="inputtext" type="text">
				</form>
			</div>
		</div>
		<div id="content">
			<div id="leftcontent">

				<div class="navigation">
					<div class="navhead">Navigation</div>
					<ul class="navmenu">
						<li><a href="creanegozio">Crea</a></li>
						<li><a href="ricercanegozio">Ricerca / Modifica</a></li>
						<li><a href="uploadnegozicsv">Import csv</a></li>
					</ul>
				</div>

			</div>

			<div id="rightcontent">
				<h2>Ricerca Negozio</h2>
				<form>

					<label>Insegna:</label> <input id="insegna" name="insegna" /> <select
						id="citta">
						<option value="-1">--- Select ---</option>
						<c:forEach items="${cittaList}" var="citta">
							<option value="${citta.id}">${citta.nome}</option>
						</c:forEach>
					</select> <select id="categoria">
						<option value="-1">--- Select ---</option>
						<c:forEach items="${categoriaList}" var="categoria">
							<option value="${categoria.id}">${categoria.nome}</option>
						</c:forEach>
					</select> <input type="submit" id="cerca" />

				</form>

				<div id="negozi">
					<table>
						<tbody>
							<tr>
								<th>ID</th>
								<th>INSEGNA</th>
								<th>DESCRIZIONE</th>
								<th>INDIRIZZO</th>
								<th></th>
							</tr>
							<c:forEach items="${negoziList}" var="negozio">
								<tr class="rowlight">
									<td>${negozio.id}</td>
									<td>${negozio.insegna}</td>
									<td>${negozio.descrizione}</td>
									<td>${negozio.indirizzo}</td>
									<td><a href="modificanegozio?id=${negozio.id}">modifica</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<script type="text/javascript">
					$(document).ready(function() {
						$("#cerca").click(function() {
							ricerca();
						});
					});
				</script>

			</div>
		</div>

		<div id="footer">
			<div id="footertop">
				<h2>
					<a href="#">Home</a> | <a href="#">Privacy Policy</a> | <a href="#">Contact
						Us</a> | <a href="#">Rss</a> | <a
						href="http://jigsaw.w3.org/css-validator/check/referer">CSS </a>
					and <a href="http://validator.w3.org/check?uri=referer">XHTML</a><br>
					© 2006 <a href="#">Your Name</a> | Design by <a
						href="http://www.flopsoft.co.nr" target="_blank">FlopSoft Inc.</a>
				</h2>
			</div>
			<div id="footerbootom"></div>
		</div>

	</div>
</body>
</html>