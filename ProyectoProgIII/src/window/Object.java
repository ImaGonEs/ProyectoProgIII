package window;

public class Object {
	
	private double miVelocidad; // Velocidad en pixels/segundo
	protected double miDireccionActual; // Direcci�n en la que estoy mirando en grados (de 0 a 360)
	protected double posX; // Posici�n en X (horizontal)
	protected double posY; // Posici�n en Y (vertical) 
	
	public void setLocation(int x, int y) {
		
		posX = x;
		posY = y;
	}
	
	
	
}
