import java.util.ArrayList;




public class Pruebamapatext extends Map{

	
	
protected static Map gen0Al () {
		
		
		int x = 20;    
		int y = x;
		MapCell [][] lel = new MapCell[x][y];
		String o = "";
		String e = "";
		for (int i = 0; i < lel.length; i++) {
			for (int j = 0; j < lel[i].length; j++) {
				lel [i][j] = new MapCell (i,j,32,32,0);
				if(i==9) {
				lel[i][j].setType(0);
				}else {
					
					lel[i][j].setType((int)(Math.random()*2+1));
					
				}
			}
		}
		
		Map z = new Map(lel,20,20);
		return z;
		
	}
	
	

protected static void imprimeMap(Map a) {
		
	
		
	
		for (int i = 0; i < a.getC().length; i++) { //imprime en pantalla el tablero
			for (int j = 0; j < a.getC()[i].length; j++) {
				
				System.out.print(a.getC()[i][j].getType());
			}
			System.out.println();
		}
		
		
	}
	
	
protected static int setIni(Map a) {
	
	
	
	
	for (int i = 0; i < a.getC().length; i++) { //imprime en pantalla el tablero
		for (int j = 0; j < a.getC()[i].length; j++) {
			
			if(a.getC()[i][j].getType()==1);
			return j;
		}
		
	}
	return 0;
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map a;
		a = gen0Al();
		
		imprimeMap(a);
		
		Thread hola = new Thread(new Runnable() {
			public void run() {
				
				Ene e = new Ene(0,setIni(a));
				System.out.println(e.getPosX()+" "+e.getPosY());
				while(true) {
					
					
							
							int federico = e.getPosX(); //x
							int garcia = e.getPosY()-1;	//y
					
							for (int i1 = 0; i1 < 2; i1++) {
								
								int comp1 = a.getC()[federico][garcia].getX();
								int comp2 = a.getC()[federico][garcia].getX();
								int comp = comp1+comp2;
								for (int j1 = 0; j1 < 3; j1++) {
										
										if (a.getC()[federico][garcia].getType()==1) {
											e.setPosX(federico);
											e.setPosY(garcia);
											System.out.println(e.getPosX()+" "+e.getPosY());
											try {
												Thread.sleep(2000);
											} catch (InterruptedException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											garcia = e.getPosY()-1;
											federico = e.getPosX();
											break;
										}else {

									
									garcia++;
									}
								}
								if(comp== e.getPosX()+e.getPosY()) {
								federico ++;
								garcia=e.getPosY()-1;
								
								}else {break;}
								
							}
							
							
					}
					
					
				}
				
				
				
			
				
				
			
		});

		hola.start();
		
		
	}

}
