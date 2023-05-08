package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
	private Point center;
	private int radius;
	
	public Circle ()
	{
		
	}
	public Circle (Point center, int radius)
	{
		this.center = center;
		this.radius = radius;
	}
	public Circle (Point center, int radius, boolean selected)
	{
		this(center,radius);
		this.selected = selected;
	}
	// povrsina kruga p
	public double area()
	{
		return radius*radius*Math.PI;
	}
	//obim kruga
	public double circumference()
	{
		return 2 * radius*Math.PI;
	}
	
	public String toString()
	{
		return "Center: "  + center +" , radius = " + radius;
	}
	
	public boolean equals(Object obj)
	{
		if(obj instanceof Circle)
		{
			Circle pomocna  = (Circle) obj;
			if(this.center.equals(pomocna.center)  && this.radius == pomocna.radius)
				return true;
			else 
				return false;
		}
		else 
			return false;
	}
	public boolean contains (int x, int y)
	{
		return center.distance(x, y) <=radius;
	}
	
	public boolean contains( Point p)
	{
		return center.distance(p.getX(), p.getY()) <= radius;
	}
	// get,set
	public Point getCenter()
	{
		return this.center;
	}
	public void setCenter(Point center)
	{
		this.center = center;
	}
	public int getRadius()
	{
		return this.radius;
	}

	
	public void setRadius(int radius) throws Exception
	{
		if(radius <0)
			throw new Exception("Radius ne moze biti negativan broj!");
		this.radius = radius;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		// TODO Auto-generated method stub
		g.drawOval(center.getX()-radius, center.getY()-radius, 2*radius, 2*radius);
		if(selected)
		{
			g.setColor(Color.blue);
			g.drawRect(center.getX()-2, center.getY()-2, 4, 4);
			g.drawRect(center.getX()-radius-2, center.getY()-2, 4, 4);
			g.drawRect(center.getX()+radius-2, center.getY()-2, 4, 4);
			g.drawRect(center.getX()-2, center.getY() + radius-2, 4, 4);
			g.drawRect(center.getX()-2, center.getY() - radius-2, 4, 4);
		}
	}

	
}
