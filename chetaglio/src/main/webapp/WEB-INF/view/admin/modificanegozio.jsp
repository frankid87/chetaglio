<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/app/admin/salvanegozio" />
<html>
<head>
<title>Modifica negozio</title>
</head>
<body>
	<h2>Modifica Negozio</h2>
	<form:form action="${url}" method="post" modelAttribute="negozioForm">
	
		<label>Insegna:</label>
		<form:input path="insegna" />
		
		<label>Indirizzo:</label>
		<form:input path="indirizzo" />
		
		<label>Latitudine:</label>
		<form:input path="latitudine" />
		
		<label>Longitudine:</label>
		<form:input path="longitudine" />
		
		<label>Descrizione:</label>
		<form:input path="descrizione" />
		
		<label>Mail:</label>
		<form:input path="mail" />
		
		<label>Telefono:</label>
		<form:input path="telefono" />
		
		<label>Nome titolare:</label>
		<form:input path="nome" />
		
		<label>Cognome titolare:</label>
		<form:input path="cognome" />
		
		<form:select path="citta.id">
			<form:option value="-1" label="--- Select ---" />
			<form:options itemLabel="nome" itemValue="id" items="${cittaList}" />
		</form:select>
	
		<form:input path="" />
		
		<input type="submit" />
		
	</form:form>
</body>
</html>