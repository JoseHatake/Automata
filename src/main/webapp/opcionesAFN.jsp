<%@page import="mx.ipn.escom.compiladores.AFN.AFN"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>Autómata</title>
</head>
<body>
	<%
		AFN afn1,afn2,especial;
		afn1 = (AFN)session.getAttribute("afn1");
		afn2 = (AFN)session.getAttribute("afn2");
		especial = (AFN)session.getAttribute("especial");
	%>
	<h1>Clase AFN</h1>
	<p>En el siguiente menú se muestras las opciones que se puede hacer con el autómata creado y que se muestra en el panel.</p>
	<form action="Automata" method="POST">
		<input type="radio" name="menu" value="1" required>
		<label for="simbolo">Crear AFN básico</label>
		<input type="text" name="simbolo" maxlength="1" placeholder="Un Sí­mbolo">
		<br>
		<input type="radio" name="menu" value="2" required>
		<label for="orden">Concatenar AFN's</label>
		<select name="orden">
			<option value="Primer AFN">AFN</option>
			<option value="1">A</option>
			<option value="2">B</option>
		</select>
		<br>
		<input type="radio" name="menu" value="3" required>
		<label for="">Unir AFN's</label>
		<br>
		<input type="radio" name="menu" value="4" required>
		<label for="ckleene">Cerradura de Kleene *</label>
		<select name="cualK">
			<option value="AFN a aplicar Kleene">AFN</option>
			<option value="1">A</option>
			<option value="2">B</option>
		</select>
		<br>
		<input type="radio" name="menu" value="5" required>
		<label for="cpositiva">Cerradura de Positiva +</label>
		<select name="cualP">
			<option value="AFN a aplicar positiva">AFN</option>
			<option value="1">A</option>
			<option value="2">B</option>
		</select>
		<br>
		<input type="radio" name="menu" value="6" required>
		<label for="opcional">Opcional ?</label>
		<select name="cualOP">
			<option value="AFN a aplicar opcional">AFN</option>
			<option value="1">A</option>
			<option value="2">B</option>
		</select>
		<br>
		<input type="radio" name="menu" value="7" required>
		<label for="unionEspecial">Unión especial</label>
		<select name="cualEspecial">
			<option value="AFN a unir al especial">AFN</option>
			<option value="1">A</option>
			<option value="2">B</option>
		</select>
		<br>
		<input type="submit" value="Procesar">
	</form>
	<div class="contenedor">
		<div>
			<% if (afn1 != null){%>
			<p>A <%=afn1%></p>	
			<%
				afn1.resetImpresion();
			}
			%>
		</div>
		<div>
			<% if (afn2 != null){%>
			<p>B <%=afn2%></p>	
			<%
				afn2.resetImpresion();
			}
			%>
		</div>
		<div>
			<% if (especial != null){%>
			<p>Especial <%=especial%></p>	
			<%
				especial.resetImpresion();
			}
			%>
		</div>
	</div>
</body>
</html>