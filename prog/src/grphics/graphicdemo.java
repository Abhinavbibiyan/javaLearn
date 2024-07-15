package grphics;

import javax.swing.*;

import java.awt.*;

public class graphicdemo extends JPanel{
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		Graphics2D g2d=(Graphics2D)g;
		int[] xpoint= {50,100,150,200,250,300,350};
		int[] ypoint= {350,250,275,200,275,150,100};
		int npoint=xpoint.length;
		
		
		GradientPaint paint=new GradientPaint(0, 0, Color.red,420, 0, Color.white);
		
		
		g2d.setColor(Color.MAGENTA);
	    g2d.setStroke(new BasicStroke(14));
		g2d.drawLine(200,200,400,400);
		
		
		
		
//		
//		    g2d.setColor(Color.GREEN);
//            g2d.setStroke(new BasicStroke(2));
//            g2d.drawPolyline(xpoint, ypoint, npoint);
//		    g2d.setFont(new Font("Comic Sans",Font.ITALIC,25));
//            g2d.drawString("STONKS",100,100);
		
//		int [] x= {100,200,300};
//		int[] y= {300,130,300};
//		//g2d.setColor(Color.YELLOW);  //////triangle
//           g2d.setColor(Color.RED);
//		// g2d.drawPolygon(x,y,3);       ///3 is no of point 
//		
//		 g2d.fillPolygon(x,y,3); 
	    
//		g2d.drawRect(50,50 , 300, 300);
//		g2d.setColor(Color.BLUE);
//		g2d.fillRect(50,50,300,300);
		
		
		
		
	g2d.setColor(Color.red);
	  g2d.drawOval(50, 50, 300,300 );	
	  g2d.fillOval(150,150, 30,30);	
	  g2d.fillOval(200,200,30,30);
		
		
		
	//	g2d.setPaint(new Color(150,250,150));
		g2d.setPaint( paint);
		//g2d.drawArc(50, 50,300, 300, 0, 180);
		
		g2d.fillArc(100, 100, 300, 300, 0, 360);
	    	
	
	}

}
