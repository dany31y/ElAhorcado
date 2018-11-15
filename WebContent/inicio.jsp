<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Inicio - Elige dificultad</title>
	<link href="estilos/estilos.css" rel="stylesheet" type="text/css" />
</head>
<body background="imagenes/fondo.jpg">
<h1 align="center">El ahorcado</h1>

<div class="padre">
 <div class="contenedor">
 	
 	<div class="lft">
	<form action="Ahorcado_Servlet" method="get">
	
	<br><br><br><br><br><br>
		<a class="pers" href="Ahorcado_Servlet">Modo fácil</a> &nbsp; &nbsp; &nbsp; &nbsp;<a class="pers" href="Ahorcado_Servlet">Modo difícil</a>
	<br><br><br><br><br><br>
		
	
	</form>
	</div>
 </div>
</div>
<div align="center"><img src="imagenes/ahorcado.gif" width="50px" align="center"></div>



</body>
</html>