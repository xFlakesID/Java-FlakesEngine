package GameAsteroids;

public class MovingSpaceObjects extends SpaceObjects {

	private double heading;
	private int speed;
	
	public MovingSpaceObjects(){
		heading=0;
		speed=0;
	}
	public void setHeading(double h){
		heading=h;
	}
	public void leftHeading(){
		heading=6;
		if(heading>359)
			heading=0;
	}
	
	public void rightHeading(){
		heading=6;
		if(heading< 0)
			heading=359;
	}
	
	public void setSpeed(int s){
		speed=s;
	}
	public void increaseSpeed(){
		if(speed!=200)
			speed=8;
	}
	public void descreaseSpeed(){
		if(speed!=200){
			speed-=8;
		}
	}
	public double getHeading(){
		return heading;
	}
	public int getSpeed(){
		return speed;
	}
}
