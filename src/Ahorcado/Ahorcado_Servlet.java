package Ahorcado;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Ahorcado_Servlet")
public class Ahorcado_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("inicio")!=null) {
			String game = "/inicio.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(game);
	        dispatcher.forward(request, response); 
			
		}else {
		
		
		//si viene de empezar
				if (request.getParameter("empezar") != null) {  
					
					HttpSession miSesion = request.getSession(true);
					String enjuego="";
					
					int intentos=6;
					String palabra = Utilidades.elegirPalabra();
					
					String letras[] = new String[(palabra.length())]; //creo un array para guardar cada letra de la palabra, del tamaño maximo que tiene la palabra			
					// inicializamos el array vacio 
					for(int i=0;i<palabra.length();i++) {   		
							letras[i] = "_";			
					}	
					
					//las letras introducidas
					ArrayList<String> ultimasletras= new ArrayList<String> ();
					
					String letraintroducida="";
					int numimg=0;

					int numpalabra=Utilidades.numeroPalabra(palabra);
					String pista=Utilidades.generaPista(numpalabra);

										
					miSesion.setAttribute("palabra", palabra);
					miSesion.setAttribute("letraintroducida", letraintroducida);
					miSesion.setAttribute("letras", letras);	
					miSesion.setAttribute("ultimasletras", ultimasletras);
					miSesion.setAttribute("intentos", intentos);
					miSesion.setAttribute("enjuego", enjuego);
					miSesion.setAttribute("pista", pista);
					
					
				
					request.setAttribute("palabra",miSesion.getAttribute("palabra"));
					request.setAttribute("letraintroducida",miSesion.getAttribute("letraintroducida")); 
					request.setAttribute("letras",miSesion.getAttribute("letras"));
					request.setAttribute("ultimasletras",Utilidades.recorrerLetras(ultimasletras));
					request.setAttribute("intentos", miSesion.getAttribute("intentos"));
				    request.setAttribute("enjuego", miSesion.getAttribute("enjuego"));
				    request.setAttribute("numimg", numimg);
				    request.setAttribute("pista", miSesion.getAttribute("pista"));
				    
				    String game = "/Pinta_juego.jsp";
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(game);
			        dispatcher.forward(request, response);
				
				
				}else {	
			
					if (request.getSession(false) != null) {  // si existe una sesion
						HttpSession miSesion = request.getSession(true);
						
						request.setAttribute("palabra",miSesion.getAttribute("palabra"));
						request.setAttribute("letraintroducida",miSesion.getAttribute("letraintroducida")); 
						request.setAttribute("letras",miSesion.getAttribute("letras"));
						request.setAttribute("ultimasletras",Utilidades.recorrerLetras((ArrayList<String>) miSesion.getAttribute("ultimasletras")));
						request.setAttribute("intentos", miSesion.getAttribute("intentos"));
						request.setAttribute("enjuego", miSesion.getAttribute("enjuego"));
						request.setAttribute("numimg", 0);
						request.setAttribute("pista", miSesion.getAttribute("pista"));
						
						String game = "/Pinta_juego.jsp";
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(game);
				        dispatcher.forward(request, response);
					
						
					}else { //creamos la sesion
						HttpSession miSesion = request.getSession(true);				
						
						int intentos=6;
						String palabra = Utilidades.elegirPalabra();
						
						String letras[] = new String[(palabra.length())]; //creo un array para guardar cada letra de la palabra, del tamaño maximo que tiene la palabra			
						// inicializamos el array vacio 
						for(int i=0;i<palabra.length();i++) {   		
								letras[i] = "_";			
						}	
						
						//las letras introducidas
						ArrayList<String> ultimasletras= new ArrayList<String> ();
						
						String letraintroducida="";
						String perdido="";
						String enjuego="";
						int numimg=0;

						int numpalabra=Utilidades.numeroPalabra(palabra);
						String pista=Utilidades.generaPista(numpalabra);
											
						miSesion.setAttribute("palabra", palabra);
						miSesion.setAttribute("letraintroducida", letraintroducida);
						miSesion.setAttribute("letras", letras);	
						miSesion.setAttribute("ultimasletras", ultimasletras);
						miSesion.setAttribute("intentos", intentos);
						miSesion.setAttribute("enjuego", enjuego);
						miSesion.setAttribute("pista", pista);
						
						
						
					
						request.setAttribute("palabra",miSesion.getAttribute("palabra"));
						request.setAttribute("letraintroducida",miSesion.getAttribute("letraintroducida")); 
						request.setAttribute("letras",miSesion.getAttribute("letras"));
						request.setAttribute("ultimasletras",Utilidades.recorrerLetras(ultimasletras));
						request.setAttribute("intentos", miSesion.getAttribute("intentos"));
						request.setAttribute("enjuego", miSesion.getAttribute("enjuego"));
						request.setAttribute("numimg",numimg);
						request.setAttribute("pista", miSesion.getAttribute("pista"));

						String game = "/inicio.jsp";
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(game);
				        dispatcher.forward(request, response); 
					}	
				} //fin if empezar
		} //fin else inicio
				
				 		
	} //fin do get


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Si hemos perdido o ganado y le damos a Volver a Jugar,nos vamos al Get
		if (request.getParameter("empezar") != null) {  
			doGet(request, response);
		}
		//Sino, significa que seguimos en partida...
		else {	
	

	    
			HttpSession miSesion= request.getSession(true); 


				String palabra = (String) miSesion.getAttribute("palabra");
				String letraintroducida = (String) miSesion.getAttribute("letraintroducida");
				String letras[] = (String[]) miSesion.getAttribute("letras");
				ArrayList<String> ultimasletras=(ArrayList<String>) miSesion.getAttribute("ultimasletras");
				int intentos =(int) miSesion.getAttribute("intentos");
				
		
				miSesion.setAttribute("palabra", palabra);				
				request.setAttribute("palabra",miSesion.getAttribute("palabra"));
		    
				//recogemos la letra del formulario del campo name="letra"
				letraintroducida = (String) request.getParameter("letra");
			
				// recorro la palabra y saco las letras y las guardo en el array
				for(int i=0;i<palabra.length();i++) {   					
					//letras[i] = palabra.substring(i, i+1);
					
					//me creo un array alternativo
					String prueba[] = new String[(palabra.length())];
					prueba[i] = palabra.substring(i, i+1);
				
						if(prueba[i].equals(letraintroducida)) {
							letras[i] = letraintroducida;	
					    }
				}
				int numimg =0;
				boolean ganar=Utilidades.comprobarGanar(palabra, letras);
				String win="";
				if(ganar==false) { //es false cuando en el array no quedan "_"
					miSesion.setAttribute("win", win);				
					request.setAttribute("win",miSesion.getAttribute("win"));
					
					//llamamos al metodo para generar un numero de imagen de 'felicidades'
					numimg=Utilidades.generaImgFelicidades();
				}				
				request.setAttribute("numimg",numimg); //no hace falta la sesion
				
				int numpalabra=Utilidades.numeroPalabra(palabra);
				String pista=Utilidades.generaPista(numpalabra);

				request.setAttribute("pista", pista);
				

				
				
				
				//letras = Utilidades.pintarpalabra(palabra, letraintroducida);
				
				miSesion.setAttribute("letras", letras);				
				request.setAttribute("letras",miSesion.getAttribute("letras"));
				
				miSesion.setAttribute("letraintroducida",letraintroducida);
				request.setAttribute("letraintroducida", miSesion.getAttribute("letraintroducida"));
				
				
					//si existe==true significa que la 'letraintroducida' no esta en la palabra
				boolean existe = Utilidades.comprobarLetraExiste(palabra,(String[]) miSesion.getAttribute("letras"), letraintroducida);
					//Establecemos el numero de intentos, recogemos el parametro intentos anteriormente de la sesion y lo bajamos o mantenemos
				intentos = Utilidades.generaNumeroIntentos(existe, letraintroducida,(int)miSesion.getAttribute("intentos"));
				if(ultimasletras.contains(letraintroducida)) {
					request.setAttribute("yaintroducida", "ya ha sido introducida");
				}

				String perdido="";
				String enjuego="";
				if(intentos<=0) {
					miSesion.setAttribute("perdido", perdido);
					request.setAttribute("perdido",miSesion.getAttribute("perdido"));
				}else if(intentos>=1 && intentos<=6 && ganar==true) {
					miSesion.setAttribute("enjuego", enjuego);
					request.setAttribute("enjuego",miSesion.getAttribute("enjuego"));
					
				}
			
				miSesion.setAttribute("intentos", intentos);
				request.setAttribute("intentos", miSesion.getAttribute("intentos"));
				
				ultimasletras.add(letraintroducida);
				miSesion.setAttribute("ultimasletras", ultimasletras);
				request.setAttribute("ultimasletras",Utilidades.recorrerLetras(ultimasletras));
				


				
			
			    String game = "/Pinta_juego.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(game);
			    dispatcher.forward(request, response); 
		

		} //fin else - empezar
	}//fin do post
	

}
