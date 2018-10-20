import java.util.ArrayList;




public class Pruebamapatext {


//	
//protected static Map gen0Al () {
//		
//		
//		int x = 20;    
//		int y = x;
//		MapCell [][] lel = new MapCell[x][y];
//		String o = "";
//		String e = "";
//		for (int i = 0; i < lel.length; i++) {
//			for (int j = 0; j < lel[i].length; j++) {
//				lel [i][j] = new MapCell (i,j,32,32,0);
//				if(i==9) {
//				lel[i][j].setType(0);
//				}else {
//					
//					lel[i][j].setType(1);
//					
//				}
//			}
//		}
//		
//		Map z = new Map(lel,20,20);
//		return z;
//		
//	}
//	
//	
//
//protected static void imprimeMap(Map a) {
//		
//	
//		
//	
//		for (int i = 0; i < a.getC().length; i++) { //imprime en pantalla el tablero
//			for (int j = 0; j < a.getC()[i].length; j++) {
//				
//				System.out.print(a.getC()[i][j].getType());
//			}
//			System.out.println();
//		}
//		
//		
//	}
//	
//	
//protected static int setIni(Map a) {
//	
//	
//	int r = 22;
//	
//	 for (int i = 0; i< a.getC().length; i++) {
//		for (int j = 0; j < a.getC()[i].length; j++) {
//			System.out.println(a.getC()[i][j].getType());
//			
//			if(a.getC()[i][j].getType()==0){
//			r = i;  //i son las filas y j las columnas?¿
//			break;
//			}
//		}
//		
//	 }
//	System.out.println(r);
//	return r;
//	
//	
//	
//}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		Map a;
//		a = gen0Al();
//		
//		imprimeMap(a);
//		
//		Thread hola = new Thread(new Runnable() {
//			public void run() {
//				
//				Ene e = new Ene(0,setIni(a));
//				System.out.println(e.getPosY()+" "+e.getPosX());
//				while(true) {
//					
//					
//							
//							int federico = e.getPosY(); //y
//							int garcia = e.getPosX()-1;	//x
//							int comp1= federico;;
//							int comp2= garcia;
//							for (int i1 = 0; i1 < 2; i1++) {
//								if (garcia!=-1) {
//									comp1 = a.getC()[federico][garcia].getX();	
//									comp2 = a.getC()[federico][garcia].getY();
//								}/*else {comp1 = a.getC()[federico][garcia+1].getX();
//									   comp2 = a.getC()[federico][garcia+1].getY();
//								};*/
//								
//								
//								int comp = comp1+comp2;
//								
//								for (int j1 = 0; j1 < 3; j1++) {
//									if (!(federico<0||garcia<0||federico>a.getC().length-1||garcia>a.getC()[i1].length-1)) {
//										if (a.getC()[federico][garcia].getType()==1) {
//											e.setPosY(garcia);
//											e.setPosX(federico);
//											System.out.println(e.getPosY()+" "+e.getPosX());
//											try {
//												Thread.sleep(2000);
//											} catch (InterruptedException e1) {
//												// TODO Auto-generated catch block
//												e1.printStackTrace();
//											}
//											garcia = e.getPosY()-1;
//											federico = e.getPosX();
//											break;
//										}else {
//
//									
//									garcia++;
//									}
//									}
//								}
//								
//									
//								federico ++;
//								garcia=e.getPosX()-1;
//								
//								
//								
//							}
//							
//							
//					}
//					
//					
//				}
//				
//				
//				
//			
//				
//				
//			
//		});
//
//		hola.start();
//		
//		
//	}

}
