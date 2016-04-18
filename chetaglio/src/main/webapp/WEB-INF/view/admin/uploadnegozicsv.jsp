<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/app/admin/uploadFile" />
<html>
<head>
<title>Upload csv</title>
</head>
<body>
	<div>
		<p>${message}</p>
		<form method="POST" enctype="multipart/form-data" action="${url}">
			<table>
				<tr>
					<td>File to upload:</td>
					<td><input type="file" name="file" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Upload" /></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>