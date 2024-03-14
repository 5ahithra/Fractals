
//Sahithra Kesavan
//Period 4
// I tried to make a seconf fractual a square shaped one, but i just couldnt figure it out, so I typed out what I had :(

import java.awt.*;
public class fractalsShell {
	public static void main(String[] args) {
		//This is the code used to create the image you see on the panel.
		
		DrawingPanel panel = new DrawingPanel(300,300); //The Canvas
		panel.setBackground(Color.WHITE);
		Graphics g = panel.getGraphics();//Create the paintbrush
		
		//Everything else in main is for adding aspects to the canvas
		
		g.setColor(Color.RED); //Setting the paintbrush to the color red
		g.drawString("Hello, world!", 20, 50); //create a RED string onto the canvas
		
		g.setColor(Color.BLACK);//Setting the paintbrush to the color BLACK
		
		//Now I need to assign the points of my equilateral triangle.
		Point bottomLeft = new Point(50, 250);
		Point topMiddle = new Point(150, 50);
		Point bottomRight = new Point(250, 250);

		//Time to use my custom method!
		drawTriangle(g, bottomLeft, topMiddle, bottomRight);
		recur(g,bottomLeft,topMiddle,bottomRight,4);
	
		
		//For the second fractals (square)
		//Point square = new Point(300,50);
		//int size = 200;
	    //drawSquareFractal(g, square, size, 4);
		 
	        
	}
		 

	public static void drawTriangle(Graphics g, Point p1, Point p2, Point p3)
	{
		/* 
			Since the Graphics class doesn't contain a drawTriangle method,
			I decided to create my own using the Polygon class, which will
			basically trace the shape starting from the first point to the
			next point and so on and so on. It will then close the shape by
			tracing from the last point to the first point.
		*/

		//If you want to create a custom shape, edit this function to fit the
			//your design.
		Polygon p = new Polygon();
		p.addPoint(p1.x, p1.y);
		p.addPoint(p2.x, p2.y);
		p.addPoint(p3.x, p3.y);
		
		
		
		g.setColor(Color.BLACK);
		g.drawPolygon(p);
		//or you can use:   g.drawPolygon(p);
	
		
  	}
	
	// public static void drawSquare(Graphics g, Point topLeft, int size) {
		//    g.setColor(Color.BLACK);
	       // g.fillRect(topLeft.x, topLeft.y, size, size);
	       // g.setColor(Color.BLACK);
	       // g.drawRect(topLeft.x, topLeft.y, size, size);
	  //  }
	 
	// public static void drawSquareFractal(Graphics g, Point topLeft, int size, int repeats) {
	   //     if (repeats == 0) {
	     //   	g.setColor(Color.BLACK);
		//		drawSquare(g,topLeft,size);
	     //   } 
	      //  else
	      //  {
	        //	  g.setColor(Color.BLACK); 
	        //	  drawSquare(g, topLeft, size);

	            //  int newSize = size / 3;
	            //  Point topLeftInner = new Point(topLeft.x + newSize, topLeft.y - newSize);

	            //  drawSquareFractal(g, topLeftInner, newSize, repeats - 1);
	            //  drawSquareFractal(g, new Point(topLeftInner.x + newSize, topLeftInner.y - 2 * newSize), newSize, repeats- 1);
	            //  drawSquareFractal(g, new Point(topLeftInner.x + 2 * newSize, topLeftInner.y - newSize), newSize, repeats - 1);
	             // drawSquareFractal(g, new Point(topLeftInner.x + newSize, topLeftInner.y), newSize, repeats - 1);
	      //  }
	 //}
	
  	
  	public static Point midpoint(Point p1, Point p2) //Calculating the midpoints by finding the half of the side lenghts of the triangle
  	{
  		//This method should give us the midpoint of 2 coordinates
		  	//Use this site as a guide: https://www.mathsisfun.com/algebra/line-midpoint.html
  		
  		Point mid = new Point();
  		mid.x = (p1.x + p2.x) / 2;
  		mid.y = (p1.y + p2.y) / 2;
  		
  		return mid;
  	}

	public static void recur(Graphics g, Point p1, Point p2, Point p3, int tris) //making a reursive method to make the triangle
	{
		if(tris == 0)
			{
			g.setColor(Color.BLACK); //Setting paintbrush to black
			drawTriangle(g,p1,p2,p3); //Drawing a triangle with the og given points 
			
			}
		else
		{
			//Calculating the midpoints of the sides of the triangle
			Point left = midpoint(p1,p2);
			Point right = midpoint(p2,p3);
			Point middle = midpoint(p1,p3);
			
			//using the midpoints to recursively draw three trianglers inside the og triangle by continuing to split up the triangle into smaller triangles 
			recur(g, p1, left, middle, tris - 1);
	        recur(g, left, p2, right, tris - 1);
	        recur(g, middle, right, p3, tris - 1);
	       
			
		}
	}
	
}