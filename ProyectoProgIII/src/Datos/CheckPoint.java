package Datos;

public class CheckPoint {
	
	private MapCell cell;
	private int xDirection, yDirection;
	
	
	public CheckPoint(MapCell cell, int xDirection, int yDirection) {
		
		this.cell = cell;
		this.xDirection = xDirection;
		this.yDirection = yDirection;
	}
	
	public MapCell getMapCell() {
		return cell;
	}
	
	public int getxDirection() {
		
		return xDirection;
	}
	
	public int getyDirection() {
		return yDirection;
	}

}
