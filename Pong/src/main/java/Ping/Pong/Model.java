package Ping.Pong;

public abstract class Model {
	protected int x;
	protected int y;
	
	public Model(){
		x = 0;
		y = 0;
	}
	
	public void moveUp(){
		if(y > 0){
			y--;
		}
	}
	
	public void moveDown(){
		if(y < 22){
			y++;
		}
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
	
	
}
