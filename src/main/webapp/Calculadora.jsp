<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	
	<script type="text/javascript" src="js/general.js"></script>
	
	<title>Calculadora</title>
</head>
<body>
	<h1>Calculadora</h1>
	<form action="Calculadora" method="POST">
		<table>
			<thead>
				<tr>
					<td colspan="6"><input type="text" value="${resultado}" name="operacion" id="operacion" style="width: 100%; text-align: right;" required></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="button" id="1" value="(" onclick="copiarValor(1,'operacion');"></td>
					<td><input type="button" id="2" value=")" onclick="copiarValor(2,'operacion');"></td>
					<td colspan="2"><input type="button" id="3" value="AC" style="width: 100%;" onclick="borradoCompleto('operacion');"></td>
					<td colspan="2"><input type="button" id="5" value="C" style="width: 100%;" onclick="borrar('operacion');"></td>
				</tr>
				<tr>
					<td><input type="button" id="7" value="sin(" onclick="copiarValor(7,'operacion');"></td>
					<td><input type="button" id="8" value="/" onclick="copiarValor(8,'operacion');"></td>
					<td><input type="button" id="9" value="7" onclick="copiarValor(9,'operacion');"></td>
					<td><input type="button" id="10" value="8" onclick="copiarValor(10,'operacion');"></td>
					<td><input type="button" id="11" value="9" onclick="copiarValor(11,'operacion');"></td>
					<td><input type="button" id="12" value="*" onclick="copiarValor(12,'operacion');"></td>
				</tr>
				<tr>
					<td><input type="button" id="13" value="cos(" onclick="copiarValor(13,'operacion');"></td>
					<td><input type="button" id="14" value="e"onclick="copiarValor(14,'operacion');"></td>
					<td><input type="button" id="15" value="4" onclick="copiarValor(15,'operacion');"></td>
					<td><input type="button" id="16" value="5" onclick="copiarValor(16,'operacion');"></td>
					<td><input type="button" id="17" value="6" onclick="copiarValor(17,'operacion');"></td>
					<td><input type="button" id="18" value="-" onclick="copiarValor(18,'operacion');"></td>
				</tr>
				<tr>
					<td><input type="button" id="19" value="tan(" onclick="copiarValor(19,'operacion');"></td>
					<td><input type="button" id="20" value="^(" onclick="copiarValor(20,'operacion');"></td>
					<td><input type="button" id="21" value="1" onclick="copiarValor(21,'operacion');"></td>
					<td><input type="button" id="22" value="2" onclick="copiarValor(22,'operacion');"></td>
					<td><input type="button" id="23" value="3" onclick="copiarValor(23,'operacion');"></td>
					<td><input type="button" id="24" value="+" onclick="copiarValor(24,'operacion');"></td>
				</tr>
				<tr>
					<td><input type="button" id="25" value="log(" onclick="copiarValor(25,'operacion');"></td>
					<td><input type="button" id="26" value="ln(" onclick="copiarValor(26,'operacion');"></td>
					<td colspan="2"><input type="button" style="width: 100%;" id="27" value="0" onclick="copiarValor(27,'operacion');"></td>
					<td><input type="button" id="28" value="." onclick="copiarValor(28,'operacion');"></td>
					<td><input type="submit" value="="></td>
				</tr>
			</tbody>
		</table>
	</form>
	<div>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Lexema</th>
					<th>Token</th>
				</tr>
			</thead>
			<tbody>
				<c:set value="0" var="id"></c:set>
				<c:if test="${tabla != null}">
					<c:forEach items="${tabla}" var="tupla">
						<tr>
							<td><c:out value="${id}"></c:out></td>
							<td><c:out value="${tupla.lexema}"></c:out></td>
							<td><c:out value="${tupla.token}"></c:out></td>
						</tr>
						<c:set value="${id + 1}" var="id"></c:set>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</body>
</html>