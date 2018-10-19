import javax.swing.JLabel;

public class MapCell { //extends JLabel

	
	private int id1;
	private int id2;
	private int x,y; //32x32 TAMAÑO
	private int type;
	
	
	public MapCell(int id1,int id2, int x, int y, int type) {
		super();
		this.id1 = id1;
		this.id2 = id2;
		this.x = x;
		this.y = y;
		this.type = type;
	} 
	

	public MapCell() {
		super();
		this.id1 = 0;
		this.id2 = 0;
		this.x = 0;
		this.y = 0;
		this.type = 0;
	}


	public int getId1() {
		return id1;
	}


	public void setId1(int id1) {
		this.id1 = id1;
	}

	public int getId2() {
		return id2;
	}


	public void setId2(int id2) {
		this.id2 = id2;
	}

	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	} 
	

	
}
