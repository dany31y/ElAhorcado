<%@ page language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    String palabra = (String) request.getAttribute("palabra");
    String letraintroducida = (String) request.getAttribute("letraintroducida");
    String letras[] = (String[]) request.getAttribute("letras");
    String ultimasletras = (String) request.getAttribute("ultimasletras");
    int intentos = (int) request.getAttribute("intentos");
    String perdido = (String) request.getAttribute("perdido");
    String enjuego = (String) request.getAttribute("enjuego");
    String ruta = "imagenes/" + intentos + ".gif";
    String win = (String) request.getAttribute("win");
    int numimg = (int) request.getAttribute("numimg");
    String rutaganar = "img_felicidades/" + numimg + ".jpg";
    String pista = (String) request.getAttribute("pista");
    String yaintroducida = (String) request.getAttribute("yaintroducida");

    %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>El ahorcado</title>
	<link href="estilos/estilos.css" rel="stylesheet" type="text/css" />
</head>
<body background="imagenes/fondo.jpg">

<h1 align="center">El ahorcado</h1>

<%if(enjuego!=null){ %>
<div class="padre">
 <div class="contenedor">
 	
 	<div class="lft">
	<form action="Ahorcado_Servlet" method="post">
	<div class="pers2">		
		Palabra oculta:&nbsp; <span class="colgris"><%=palabra %> </span><br>
		<!--  Introducir en este comentario la línea de arriba para una mejor experiencia del juego
		
		-->				
		Ultima letra recibida:&nbsp; <span class="colgris"><%=letraintroducida %></span> <br>		
		Ultimas letras introducidas:&nbsp; <span class="colgris"> <%=ultimasletras %> </span> <br>		
		Te quedan:&nbsp; <span class="colgris"><b><%=intentos %> </b></span> &nbsp;intentos <br>
		<%if(yaintroducida!=null){ %>
			<span class="colgris"><%=letraintroducida%> <%=yaintroducida %>	</span> <br>
		<%} %>	
	</div> 
	  <br>
		<span class="adiv">Palabra a adivinar : &nbsp;<br><b>
							<%for ( int i=0;i<letras.length;i++){ %>
								<%=letras[i] %>
							<%} %> </b>
		</span> 
			<br>
				<br>
		<p class="pers3">	&#8595; Introduce una letra &#8595; </p>
							<input type="text" size="1" name="letra" class="pers4"> &nbsp;
							<input type="submit" value="Prueba letra" class="pers4"> <br><br>
							<a class="pers" href="Ahorcado_Servlet?empezar"><span>Elegir otra palabra</span></a>
							<a class="pers" href="inicio.jsp"><span>Elige dificultad</span></a><br>
				


	</form>
	</div>
	
	<div  class="imagenes">
		<img src="<%=ruta %>" width="150px" align="center">
	</div><br>
	
	<div  class="imagenes">
		<p class="bdiv"><%=pista %></p>
	</div>
	
  </div>
</div>
  <div align="center"><img src="imagenes/ahorcado.gif" width="50px" align="center"></div>
<%}

if(perdido!=null) {%>
   <div class="padre">
	<div align="center" class="contenedor2"><%=perdido %> <h1>¡Ohhh! &nbsp; Has perdido...</h1>
	<br> <img src="<%=ruta %>" width="150px"> <br>
	<h2>La palabra correcta era: </h2><h3><%=palabra %></h3>
		<a href="Ahorcado_Servlet?empezar" class="pers">Volver a jugar</a>
	</div>
   </div>
   <div align="center"><img src="imagenes/ahorcado.gif" width="50px" align="center"></div>

<%}

if(win!=null) {%>
   <div class="padre">
	<div align="center" class="contenedor2"><h1>¡Felicidades! &nbsp; ¡Has ganado!</h1>
	<br> <img src="<%=rutaganar %>" width="300px"> <br>
	<h2>La palabra acertada es: </h2><h3><%=palabra %></h3>
		<a href="Ahorcado_Servlet?empezar" class="pers">Volver a jugar</a>
	</div>
   </div>
   <div align="center"><img src="imagenes/ahorcado.gif" width="50px" align="center"></div>

<%} %>
</body>
</html>