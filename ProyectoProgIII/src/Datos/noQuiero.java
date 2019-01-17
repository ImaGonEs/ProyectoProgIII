package Datos;

import Datos.Laberinto.Direccion;

public class noQuiero {

	public static enum Direccion { IZQUIERDA, ARRIBA, DERECHA, ABAJO;
		public Direccion dirOpuesta() {
			if (this==Direccion.IZQUIERDA) return Direccion.DERECHA;
			else if (this==Direccion.DERECHA) return Direccion.IZQUIERDA;
			else if (this==Direccion.ARRIBA) return Direccion.ABAJO;
			else return Direccion.ARRIBA;
		}
	}
	
	public static int [][] laberinto = {
			
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
						
	};
	
	private boolean [][] visitado = new boolean[30][40];
	private int filaAct;
	private int colAct;
	
	public int getAltura() {
		return laberinto.length;
	}	
	public int getAnchura() {
		return laberinto[0].length;
	}
	
	public void entra() {
		for (int i = 0; i < laberinto.length; i++) {
			for (int j = 0; j < laberinto[0].length; j++) {
				if (laberinto[i][j]==3) {
					filaAct = i;
					colAct = j;
					visitado[i][j]=true;
					return;
				}
			}
		}
	}	
	// Calcula fila destino según avance
	private int calculaFilaDestino( Direccion avance ) {
		int filaDestino = filaAct;
		if (avance==Direccion.ARRIBA) filaDestino--;
		else if (avance==Direccion.ABAJO) filaDestino++;
		return filaDestino;
	}
	
	// Calcula columna destino según avance
	private int calculaColDestino( Direccion avance ) {
		int colDestino = colAct;
		if (avance==Direccion.IZQUIERDA) colDestino--;
		else if (avance==Direccion.DERECHA) colDestino++;
		return colDestino;
	}
	
	public Direccion posibleMovimiento() {
		for (Direccion d : Direccion.values()) {
			if (hayPasilloEn(d) && !hayMarcaEn(d)) {
				return d;
			}
		}
		return null;
	}
	public boolean hayMarcaEn( Direccion avance ) {
		int filaDestino = calculaFilaDestino(avance);
		int colDestino = calculaColDestino(avance);
		if (filaDestino>=getAltura() || filaDestino<0 || colDestino>=getAnchura() || colDestino<0)
			return false;
		else return visitado[filaDestino][colDestino];
	}
	public boolean hayPasilloEn( Direccion avance ) {
		int filaDestino = calculaFilaDestino(avance);
		int colDestino = calculaColDestino(avance);
		if (filaDestino>=getAltura() || filaDestino<0 || colDestino>=getAnchura() || colDestino<0)
			return false;
		else if (laberinto[filaDestino][colDestino]!=2)
			return true;
		else return false;
	}
	public boolean mueve( Direccion avance ) {
		int filaDestino = calculaFilaDestino(avance);
		int colDestino = calculaColDestino(avance);
		if (filaDestino>=getAltura() || filaDestino<0 || colDestino>=getAnchura() || colDestino<0)
			return false;
		else if (laberinto[filaDestino][colDestino]==2)  // Pared
			return false;
		else {  // Movimiento válido
			
			

//			if((filaAct<=getAltura() && filaAct>0 )){
//				
//
//				if(laberinto[filaAct-1][colAct]!=1)
//					laberinto[filaAct-1][colAct]=2;
//				if(laberinto[filaAct-1][colAct+1]!=1)
//					laberinto[filaAct-1][colAct+1]=2;			
//			}
//			
//			if((colAct<=getAltura() && colAct>0 )){
//				
//
//				if(laberinto[filaAct][colAct-1]!=1)
//					laberinto[filaAct][colAct-1]=2;
//				if(laberinto[filaAct+1][colAct-1]!=1)
//					laberinto[filaAct+1][colAct-1]=2;
//			}
			
//			if(laberinto[filaAct][colAct+1]!=1)
//				laberinto[filaAct][colAct+1]=2;
//			if(laberinto[filaAct+1][colAct]!=1)
//				laberinto[filaAct+1][colAct]=2;
//			


			
			
			if(laberinto[filaAct][colAct]!=3)
				laberinto[filaAct][colAct]=1;
			
			
			filaAct = filaDestino;
			colAct = colDestino;
			

			
			
			visitado[filaDestino][colDestino] = true;  
			
			return true;
		}
	}
	
	public boolean acabado() {
		if(laberinto[filaAct][colAct] == 4)
		for (int i = 0; i < laberinto.length; i++) {
			for (int j = 0; j < laberinto[i].length; j++) {
				System.out.print(laberinto[i][j]);
			}
			System.out.println();
		}
		return (laberinto[filaAct][colAct] == 4);
		

	}
	
	private static boolean resuelve (noQuiero l) {
		

		
		
		if (l.acabado()) return true;
		
		Direccion dir;
		
		while ((dir = l.posibleMovimiento())!=null) {
			
			l.mueve(dir);
			boolean fin = resuelve( l );
			if (fin) return true;
			//BACKTRACKING
			l.mueve( dir.dirOpuesta() );
		}
		
		
		
		return l.acabado();
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		noQuiero l = new noQuiero();
		
		l.entra();
		boolean fin = resuelve( l );
		System.out.println(fin);
		
	
		
		
	}

}
