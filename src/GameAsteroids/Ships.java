package GameAsteroids;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class Ships extends MovingSpaceObjects implements Collider, Steerable,Movable,Drawable,Selectable{

	private boolean selected;
	private Random myRNG;
	private int xWidth;
	private int yHeight;
	private int base;
	private int height;
	private Point top;
	private Point lowerLeft;
	private Point lowerRight;
	private boolean incSpeed;
	private AffineTransform myAT;
	private boolean collision;
	private int collisioncounter;
	private boolean start;
	private Point line1;
	private Point line2;
	private Point line3;
	private Point line4;
	private Point line5;
	private Point line6;
	private Point line7;
	private Point line8;
	private Point line9;
	private Point line10;
	private Point line11;
	private Point line12;
	
	private Rectangle rect;
	private double WB;
	private double WT;
	private boolean left=false;
	private boolean right=false;
	private boolean up=false;
	private boolean down=false;
	
	public Ships(int u,int r){
		incSpeed=false;
		collision=false;
		collisioncounter=0;
		start=false;
		xWidth=u;
		yHeight=r;
		selected=false;
		myRNG=new Random();
		int x=myRNG.nextInt(3000);
		int y=myRNG.nextInt(3000);
		setColor(new Color(0,0,255));
		setSpeed(0);
		setLocation(x,y);
		
		base=15;
		height=25;
		
		myAT=new AffineTransform();
		top=new Point();
		lowerLeft=new Point();
		lowerRight=new Point();
		
		line1=new Point();
		line2=new Point();
		line3=new Point();
		line4=new Point();
		line5=new Point();
		line6=new Point();
		line7=new Point();
		line8=new Point();
		line9=new Point();
		line10=new Point();
		line11=new Point();
		line12=new Point();
		
		rect=new Rectangle();
		
	}

	
	public Ships(int u,int r,int locationx, int locationy){
		collision=false;
		collisioncounter=0;
		myRNG=new Random();
		xWidth=u;
		yHeight=r;
		selected=false;
		setColor(new Color(0,0,255));
		setSpeed(0);
		setLocation(locationx,locationy);
		base=15;
		height=25;
		
		myAT=new AffineTransform();
		top=new Point();
		lowerLeft=new Point();
		lowerRight=new Point();
		
		line1=new Point();
		line2=new Point();
		line3=new Point();
		line4=new Point();
		line5=new Point();
		line6=new Point();
		line7=new Point();
		line8=new Point();
		line9=new Point();
		line10=new Point();
		line11=new Point();
		line12=new Point();
	}
	
	public void setincSpeed(boolean sr){
		incSpeed=sr;
	}
	public boolean contains(int x, int y) {
		Point ptp=getLocation();
		
		double x1=ptp.getX();
		double y1=ptp.getY();
		
		if((x>(x1+(-base/2)))&&(x<(x1+(base/2)))&&(y>(y1+(-height/2)))&&(y<(y1+(height/2)))){
			return true;
		}else{
			return false;
		}
	}

	public void setSelected(boolean newVal) {
		selected=newVal;
		
	}
	public boolean isSelected() {
		return selected;
	}
	public Point getTop(){
		return top;
	}
	public Point getBounds1(){
		double x=top.getX();
		double y1=top.getY();
		x=(x-(base/2));
		double y=(yHeight-y1);
		Point p2=new Point();
		p2.setLocation(x,y);
		return p2;
	}
	
	public Point getBounds2(){
		double h=height;
		double w=base;
		Point p2=new Point();
		p2.setLocation(w, h);
		return p2;
	}
	public void highlight(Graphics2D g){
		g.setColor(new Color(255,255,0));
		int height1=yHeight;
		
		g.drawLine((int)top.getX()-base,height1-((int)top.getY()),
		(int)top.getX() +base,height1-((int)top.getY()));
		g.drawLine((int)top.getX() +base,height1-((int)top.getY()),
		(int)lowerRight.getX()+ base,height1-((int)lowerRight.getY()));
		g.drawLine((int)lowerRight.getX()+ base,height1-((int)lowerRight.getY()),
		(int)lowerLeft.getX()-base,height1-((int)lowerLeft.getY()));
		g.drawLine((int)lowerLeft.getX()-base,height1-((int)lowerLeft.getY()),
		(int)top.getX()-base,height1-((int)top.getY()));
	}
	public void draw(Graphics2D g) {
		int height1=yHeight;
		if(!(collision)){
			rect=g.getClipBounds();
			AffineTransform saveAT=g.getTransform();
			
			Point location=getLocation();
			top.setLocation(0,(height/2));
			lowerLeft.setLocation(-((double)base/2),-((double)height/2));
			lowerRight.setLocation(-((double)base/2),-((double)height/2));
			

			line1.setLocation(lowerLeft.getX() +2,lowerLeft.getY());
			line2.setLocation(lowerLeft.getX()+ 2,lowerRight.getY()-6);
			line3.setLocation(lowerLeft.getX() +4,lowerLeft.getY());
			line4.setLocation(lowerLeft.getX()+ 4,lowerRight.getY()-6);
			line5.setLocation(lowerLeft.getX()+ 6,lowerLeft.getY());
			line6.setLocation(lowerLeft.getX() +6,lowerRight.getY()-6);
			line7.setLocation(lowerLeft.getX()+ 8,lowerLeft.getY());
			line8.setLocation(lowerLeft.getX() +8,lowerRight.getY()-6);
			line9.setLocation(lowerLeft.getX() +10,lowerLeft.getY());
			line10.setLocation(lowerLeft.getX()+ 10,lowerRight.getY()-6);
			line11.setLocation(lowerLeft.getX() +12,lowerLeft.getY());
			line12.setLocation(lowerLeft.getX() +12,lowerRight.getY()-6);
			
			myAT.setToIdentity();
			
			myAT.translate((int)location.getX(),(int)location.getY());


			myAT.rotate(Math.toRadians(getHeading()));
			myAT.transform(top,top);
			myAT.transform(lowerLeft,lowerLeft);
			myAT.transform(lowerRight,lowerRight);
			myAT.transform(line1,line1);
			myAT.transform(line2,line2);
			myAT.transform(line3,line3);
			myAT.transform(line4,line4);
			myAT.transform(line5,line5);
			myAT.transform(line6,line6);
			myAT.transform(line7,line7);
			myAT.transform(line8,line8);
			myAT.transform(line9,line9);
			myAT.transform(line10,line10);
			myAT.transform(line11,line11);
			myAT.transform(line12,line12);
			
			g.setColor(getColor());
			
			g.drawLine((int)top.getX(),height1-((int)top.getY()),
			(int)lowerLeft.getX(),height1-((int)lowerLeft.getY()));
			g.drawLine((int)lowerLeft.getX(),height1-((int)lowerLeft.getY()),
			(int)lowerRight.getX(),height1-((int)lowerRight.getY()));
			g.drawLine((int)lowerRight.getX(),height1-((int)lowerRight.getY()),
			(int)top.getX(),height1-((int)top.getY()));
			
			int winglength=10;
			
			g.drawLine((int)top.getX(),height1-((int)top.getY()),
			(int)lowerRight.getX() +winglength,height1-((int)lowerRight.getY()));
			g.drawLine((int)lowerRight.getX() +winglength,height1-((int)lowerRight.getY()),
			(int)lowerRight.getX(),height1-((int)lowerRight.getY()));
		

			g.drawLine((int)top.getX(),height1-((int)top.getY()),
			(int)lowerLeft.getX()-winglength,height1-((int)lowerLeft.getY()));
			g.drawLine((int)lowerLeft.getX()-winglength,height1-((int)lowerLeft.getY()),
			(int)lowerLeft.getX(),height1-((int)lowerLeft.getY()));

			if(incSpeed){
				incSpeed=false;
				g.setColor(Color.yellow);
				
				g.drawLine((int)line1.getX(),height1-(int)line1.getY(),(int)line2.getX(),height1-(int)line2.getY());
				g.drawLine((int)line3.getX(),height1-(int)line3.getY(),(int)line4.getX(),height1-(int)line4.getY());
				g.drawLine((int)line5.getX(),height1-(int)line5.getY(),(int)line6.getX(),height1-(int)line6.getY());
				g.drawLine((int)line7.getX(),height1-(int)line7.getY(),(int)line8.getX(),height1-(int)line8.getY());
				g.drawLine((int)line9.getX(),height1-(int)line9.getY(),(int)line10.getX(),height1-(int)line10.getY());
				g.drawLine((int)line11.getX(),height1-(int)line11.getY(),(int)line12.getX(),height1-(int)line12.getY());

				g.setColor(getColor());
			}
			if((selected))
				highlight(g);
			
		g.transform(this.myAT);
		g.setTransform(saveAT);
		}
		else{
			Point location=getLocation();
			g.setColor(getColor());
			g.drawOval((int)location.getX(),height-(int)location.getY(),collisioncounter,collisioncounter);
			if(!start)
				collisioncounter++;
		}
	}
	public void setWBWT(double WB1, double WT1){
		WB=WB1;
		WT=WT1;
	}
	public boolean getUp(){
		return up;
	}
	public boolean getDown(){
		return down;
	}
	public boolean getRight(){
		return right;
	}
	public boolean getLeft(){
		return left;
	}
	
	@Override
	public void move(int elapsedMilliSecs) {
		if(!(collision)){
			double speed=(double)getSpeed();
			if(speed!=0){
				double heading=getHeading();
				if(speed<0){
					heading+=180;
					if(heading>359)
						heading-=359;
				}
				speed=Math.abs(speed);
				speed=(speed/((double)elapsedMilliSecs));
				double heading2=Math.toRadians(heading);
				Point p=getLocation();
				double x=p.getX();
				double y=p.getY();
				left=false;
				right=false;
				up=false;
				down=false;
				
				if((600-y)>((rect.getY() + rect.getHeight()))){
					up=true;
				}
				if((600-y)<(rect.getY())){
					down=true;
				}
				if(x>(WT)){
					right=true;
				}
				if((x<(WB))){
					left=true;
				}
				if(!((left)||(right)||(up)||(down))){
					
					double x1=Math.sin(heading2);
					double y1=Math.cos(heading2);
					if((heading>0)&&(heading<90)){
					x1 +=x;
					y1 +=y;	
					x1 -=speed;
					y1 +=speed;
					}
					if((heading<180)&&(heading>90)){
						x1 +=x;
						y1 +=y;
						x1 -=speed;
						y1 -=speed;
					}
					if((heading<270)&&(heading>180)){
						x1 +=x;
						y1 +=y;
						x1 +=speed;
						y1 -=speed;
					}
					if((heading<360)&&(heading>270)){
						x1 +=x;
						y1 +=y;
						x1 +=speed;
						y1 +=speed;
					}
					if(heading==0){
						x1+=x;
						y1+=y;
						y1+=speed;
					}
					if(heading==90){
						x1+=x;
						y1+=y;
						x1-=speed;
					}
					if(heading==180){
						x1+=x;
						y1+=y;
						y1-=speed;
					}
					if(heading==270){
						x1+=x;
						y1+=y;
						x1+=speed;
					}
					if(x1>3000){
						x1=3000;
					}
					if(x1<-3000){
						x1=-3000;
					}
					if(y1>3000){
						y1=3000;
					}
					if(y1<-3000){
						y1=-3000;
					}
					setLocation((int)x1,(int)y1);
				}
				
			}
		}
		
	}
	@Override
	public void changeSpeed(int amount) {
		setSpeed(amount);
		
	}
	@Override
	public void changeHeading(int amount) {
		setHeading(amount);
		
	}
	public void collision(){
		collision=true;
	}
	public boolean returnCollision(){
		return collision;
	}
	public boolean removeCollision(){
		if(collisioncounter>20){
			return true;
		}else
			return false;
	}
	public void setStart(boolean a){
		start = a;
	}
	public boolean bounds(Point p1,Point p2){
		double z4=p1.getX();
		double s4=p1.getY();
		double z5=p2.getX();
		double s5=p2.getY();

		double x=top.getX();
		double y1=top.getY();
		
		x=(x-(base/2));
		
		double y=(yHeight-y1);
		double h=height;
		double w=base;
		if((z4>x)&&(z4<x +w)&&(s4<y+ h)&&(s4>y))
			return true;
		else
			return false;
	}
}
