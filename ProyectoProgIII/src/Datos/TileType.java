package Datos;

public enum TileType {

	
	Grass("g42",true), Dirt("green2",false);
	
	public String name;
	
	public boolean cc;
	
	TileType(String name, boolean cc){
		this.name = name;
		
		this.cc = cc;
		
		
	};
	
	
}
