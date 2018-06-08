//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;

	public Ship()
	{
		this(400,450,35,35,2);
	}

	public Ship(int x, int y)
	{
	   this(x,y,35,35,2);
	}

	public Ship(int x, int y, int s)
	{
	   this(x,y,35,35,s);
	}

	public Ship(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
		try
		{
			URL url = getClass().getResource("/images/ship.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			System.out.println("Ship Error :: "+e.toString());
		}
	}


	public void setSpeed(int s)
	{
	   speed=s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void move(String direction)
	{
		if(direction.equals("up")){
			setY(getY()-speed);
		}else if(direction.equals("down")){
			setY(getY()+speed);
		}else if(direction.equals("left")){
			setX(getX()-speed);
		}else if(direction.equals("right")){
			setX(getX()+speed);
		}
	}

	public void draw( Graphics window )
	{
   		window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
