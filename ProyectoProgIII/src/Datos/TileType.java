package Datos;

public enum TileType {

	
	Grass0("te1",true),Grass1("g1",true), Dirt0("ca1",false),Dirt1("m1",false);
	
	public String name;
	
	public boolean cc;
	
	TileType(String name, boolean cc){
		
		
		this.name = name;
		
		this.cc = cc;
		
		
	};
	
	public String getName() {
		return this.name();
	}
	
	
}
