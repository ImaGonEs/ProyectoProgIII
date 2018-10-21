package Datos;

public enum TileType {

	
	Grass0("g0",true),Grass1("g1",true), Dirt0("d0",false),Dirt1("m1",false), Dirt2("m2",false);
	
	public String name;
	
	public boolean cc;
	
	TileType(String name, boolean cc){
		this.name = name;
		
		this.cc = cc;
		
		
	};
	
	
}
