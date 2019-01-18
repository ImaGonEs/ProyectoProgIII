package Datos;
import java.util.ArrayList;
import java.util.Collections;

import Datos.Laberinto.Direccion;

public class pofaboh {

	private int filaJugador;   // Posición de fila donde está el jugador del laberinto (-1 si no ha entrado)
	private int colJugador;    // Posición de columna donde está el jugador del laberinto (-1 si no ha entrado)
	private boolean[][] marca = new boolean[30][40]; // Indicación de si se ha pasado o no por la casilla indicada
	
	
	public static enum Direccion { IZQUIERDA, ARRIBA, DERECHA, ABAJO;
		public Direccion dirOpuesta() {
			if (this==Direccion.IZQUIERDA) return Direccion.DERECHA;
			else if (this==Direccion.DERECHA) return Direccion.IZQUIERDA;
			else if (this==Direccion.ARRIBA) return Direccion.ABAJO;
			else return Direccion.ARRIBA;
		}
	}
	
	
	private static int[][] laberinto =  {
			
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, },
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, },
						
	};
	
	
	public int getAltura() {
		return laberinto.length;
	}
	
	public int getAnchura() {
		return laberinto[0].length;
	}
	
	// Calcula fila destino según avance
	private int calculaFilaDestino( Direccion avance ) {
		int filaDestino = filaJugador;
		if (avance==Direccion.ARRIBA) filaDestino--;
		else if (avance==Direccion.ABAJO) filaDestino++;
		return filaDestino;
	}
	
	// Calcula columna destino según avance
	private int calculaColDestino( Direccion avance ) {
		int colDestino = colJugador;
		if (avance==Direccion.IZQUIERDA) colDestino--;
		else if (avance==Direccion.DERECHA) colDestino++;
		return colDestino;
	}
	//public static int cont=0;
	private static boolean resuelveLaberinto( pofaboh l ) {
		if (l.acabado()) return true;
		Direccion dir;
		while ((dir = l.posibleMovimiento()) !=null) {
			                        // Corte: Si se cierra la ventana, se acaba
			l.mueve( dir ,false); 
			//cont++;
			//if(cont>=50) return false;
			boolean fin = resuelveLaberinto( l );
			
			if (fin) return true; // Truncamos el proceso cuando se acaba (observa que si se comenta esta línea, no se trunca la recursión y se hacen todos los caminos posibles)
			
			l.mueve( dir.dirOpuesta() ,true);  
			
		}
		return l.acabado();
	}
	
	public void borra() {
		
		laberinto[filaJugador][colJugador]=0;
		
		if(laberinto[filaJugador-1][colJugador]!=1&&laberinto[filaJugador-1][colJugador]!=4&&laberinto[filaJugador-1][colJugador]!=3)
			laberinto[filaJugador-1][colJugador]=0;
//			
//			if(laberinto[filaJugador-1][colJugador+1]!=1)
//			laberinto[filaJugador-1][colJugador+1]=2;
//			
			if(laberinto[filaJugador][colJugador-1]!=1&& laberinto[filaJugador][colJugador-1]!=4&& laberinto[filaJugador][colJugador-1]!=3)
			laberinto[filaJugador][colJugador-1]=0;
//			
			if(laberinto[filaJugador][colJugador+1]!=1&&laberinto[filaJugador][colJugador+1]!=4&&laberinto[filaJugador][colJugador+1]!=3)
			laberinto[filaJugador][colJugador+1]=0;
//			
//			if(laberinto[filaJugador+1][colJugador-1]!=1)
//			laberinto[filaJugador+1][colJugador-1]=2;
//			
			if(laberinto[filaJugador+1][colJugador]!=1&&laberinto[filaJugador+1][colJugador]!=4&&laberinto[filaJugador+1][colJugador]!=3)
			laberinto[filaJugador+1][colJugador]=0;
		
		
	}	
	
	public boolean mueve( Direccion avance ,boolean a) {
		int filaDestino = calculaFilaDestino(avance);
		int colDestino = calculaColDestino(avance);
		if (filaDestino>=getAltura() || filaDestino<0 || colDestino>=getAnchura() || colDestino<0)
			return false;
		else if (laberinto[filaDestino][colDestino]==2)  // Pared
			return false;
		
		else {  // Movimiento válido
			
			//laberinto[filaJugador][colJugador] =1;
			System.out.println("fila: " +filaJugador+"  columna: "+colJugador);
			if(laberinto[filaDestino][colDestino]!=4&&laberinto[filaDestino][colDestino]!=3)
			laberinto[filaDestino][colDestino]=1;
			System.out.println("fila: " +filaJugador+"  columna: "+colJugador);
		
			
			//if(filaJugador-1>=0&&colJugador-1>=0) {
//			if(laberinto[filaJugador-1][colJugador-1]!=1)
//			laberinto[filaJugador-1][colJugador-1]=2;
//			
			
			if(!a) {
			if(laberinto[filaJugador-1][colJugador]!=1&&laberinto[filaJugador-1][colJugador]!=4&&laberinto[filaJugador-1][colJugador]!=3)
			laberinto[filaJugador-1][colJugador]=2;
//			
//			if(laberinto[filaJugador-1][colJugador+1]!=1)
//			laberinto[filaJugador-1][colJugador+1]=2;
//			
			if(laberinto[filaJugador][colJugador-1]!=1&& laberinto[filaJugador][colJugador-1]!=4&&laberinto[filaJugador][colJugador-1]!=3)
			laberinto[filaJugador][colJugador-1]=2;
//			
			if(laberinto[filaJugador][colJugador+1]!=1&&laberinto[filaJugador][colJugador+1]!=4&&laberinto[filaJugador][colJugador+1]!=3)
			laberinto[filaJugador][colJugador+1]=2;
//			
//			if(laberinto[filaJugador+1][colJugador-1]!=1)
//			laberinto[filaJugador+1][colJugador-1]=2;
//			
			if(laberinto[filaJugador+1][colJugador]!=1&&laberinto[filaJugador+1][colJugador]!=4&&laberinto[filaJugador+1][colJugador]!=3)
			laberinto[filaJugador+1][colJugador]=2;
			}else {
				borra();
			}
//			
//			if(laberinto[filaJugador-1][colJugador+1]!=1)
//			laberinto[filaJugador-1][colJugador+1]=2;
			//}
			
			
			
			filaJugador = filaDestino;
			colJugador = colDestino;
			
			marca[filaDestino][colDestino] = true; 
			System.out.println("fila: " +filaJugador+"  columna: "+colJugador);
			for (int i = 0; i < laberinto.length; i++) {
				for (int j = 0; j < laberinto[i].length; j++) {
					System.out.print(laberinto[i][j]);
				}
				System.out.println();
			}
			
			}
			return true;
		}
	
	public boolean hayPasilloEn( Direccion avance ) {
		int filaDestino = calculaFilaDestino(avance);
		int colDestino = calculaColDestino(avance);
		if (filaDestino>=getAltura() || filaDestino<0 || colDestino>=getAnchura() || colDestino<0) {
			
			return false;
		}
			
		else if (laberinto[filaDestino][colDestino]!=2)
			return true;
		else {
			System.out.println("no hay pasillo en " +avance);return false;
		}
	}
	
	public boolean hayMarcaEn( Direccion avance ) {
		int filaDestino = calculaFilaDestino(avance);
		int colDestino = calculaColDestino(avance);
		if (filaDestino>=getAltura() || filaDestino<0 || colDestino>=getAnchura() || colDestino<0)
			return false;
		
		else {
			System.out.println( filaDestino + " " + colDestino+" con dir "+avance);
			
			System.out.println(marca[filaDestino][colDestino]);
			for (int i = 0; i < laberinto.length; i++) {
				for (int j = 0; j < laberinto[i].length; j++) {
					System.out.print(laberinto[i][j]);
				}
				System.out.println();
			}
			return marca[filaDestino][colDestino];
		}
	}
	
	public Direccion posibleMovimiento() {
		ArrayList<Direccion> ds = new ArrayList<>();
		for (Direccion d : Direccion.values()) {
			ds.add(d);
		}
		Collections.shuffle(ds);
		
		
		
		
		for (Direccion d : ds) {
			if (!hayMarcaEn(d)&&hayPasilloEn(d)) {
			
				System.out.println(d);
				return d;
			}
			
			
			
		}
		return null;
	}
	
	public boolean acabado() {
		
		
		return (laberinto[filaJugador][colJugador] == 4);
		
		
	}
	
	
	public void entra() {
		for (int fila=0; fila<laberinto.length; fila++) {
			for (int col=0;col<laberinto[1].length; col++) {
				if (laberinto[fila][col]==3) {
					filaJugador = fila;
					colJugador = col;
					marca[filaJugador][colJugador] = true;
					return;
				}
			}
		}
	}
	
	
	
	
	public static int[][] getLaberinto() {
		return laberinto;
	}


	public int[][] main(){
		
		
		entra();
		boolean fin;
		fin = resuelveLaberinto(this);
		
		return getLaberinto();
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pofaboh l = new pofaboh();
		l.entra();
		boolean fin;
		fin = resuelveLaberinto(l);
		System.out.println(fin);
		
		
		
		
		
	}

}

