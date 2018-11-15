package Ahorcado;

import java.util.ArrayList;

public class Utilidades {
	
	static String palabras[] = {"manzana","pera","plátano","naranja","kiwi","albaricoque","limón","caqui","papaya","arándano",
			"andrei","daniel","carlos","alejandro","david","guillermo","francisco","eustaquio","eugenio","amador",
			"maria","eugenia","isabel","clara","fernanda","francesca","eustaquia","jazmín","josefa","matilde"}; //mapa de palabras
	
	public static int numeroPalabra(String x) {
		int num=0;
		for(int i=0;i<palabras.length;i++) {
			if(palabras[i].equals(x)) {
				num=i;
			}
		}
		return num;
	}
	
	public static String elegirPalabra() {
		int x =(int) (Math.random()*(palabras.length)); //generamos un numero aleatorio
		String palabra = palabras[x];  //asignamos una palabra del mapa
		
		return palabra;
	}
	
	public static String recorrerLetras(ArrayList<String> letrasIntroducidas) {
		String letras="";
		for(int i=0;i<letrasIntroducidas.size();i++) {
			letras=letras+letrasIntroducidas.get(i);
		}
		return letras;
	}
	
	
	public static boolean comprobarLetraExiste(String palabra,String letras[],String letraintroducida) {
		boolean x = true;
		for(int i=0;i<palabra.length();i++) {
			if(letras[i].equals(letraintroducida)) {
				x=false;
			}
		}

		return x;
	}
	
	
	public static String[] pintarpalabra(String palabra, String letraintroducida){
		String letras[]=new String[(palabra.length())];
		for(int i=0;i<palabra.length();i++) {   					
			//letras[i] = palabra.substring(i, i+1);
			
			//me creo un array alternativo
			String prueba[] = new String[(palabra.length())];
			prueba[i] = palabra.substring(i, i+1);
		
				if(prueba[i].equals(letraintroducida)) {
					letras[i] = letraintroducida;	
			    }
		}
		return letras;
		
	}
	
	public static boolean comprobarGanar(String palabra,String letras[]) {
		boolean result=false;
		for(int i =0;i<palabra.length();i++) {
			if(letras[i].equals("_")) {
				result=true;
			}
		}
		return result;
		
	}
	public static int generaImgFelicidades() {
		int x = (int) (Math.random()*10);
		return x;		
	}
	
	public static String generaPista(int numero) {
		String pista="";
		if(numero>=0 && numero<=9) {
			pista = "Pista: Fruto";
		}else if(numero>=10 && numero<=19) {
			pista = "Pista: Nombre de chico";
		}else if(numero>=20 && numero<=29) {
			pista = "Pista: Nombre de chica";
		}
		
		return pista;
		
	}
	
	/**Metodo que genera el numero de intentos que lleva el juego
	 * comprueba primero si la letra introducida se encuentra en la palabra o no con la variable existe que a su vez llama a su metodo
	 * si no existe (existe=true) disminuye el numero de intentos
	 * El numero de intrntos lo recogemos de la sesion
	 * Mediante una expresion regular verificamos si la letraintroducida es cualquier otra cosa menos una letra
	 * si es asi, para la mejor experiencia del usuario aumentamos otra vez los intentos para que no cuenten como error**/
	public static int generaNumeroIntentos(boolean existe,String letraintroducida,int intentos) {
		final String expresionR = "^{0,1}[a-zA-Z]$"; //0 o 1 caracter solo letras minusculas y mayusculas
		
		if(existe==true) { //si no existe la letra
			intentos--;

				if(letraintroducida.matches(expresionR)==false) //si no cumple no contamos como fallo
				intentos++; //no contamos las cifras ni tampoco cualquier signo ni espacio, ni 2 o mas letras
		}
		return intentos;
		
	}
	

}
