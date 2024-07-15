package grphics;

import javax.swing.*;

public class myframe  extends JFrame{
	graphicdemo graphicdemo= new graphicdemo();
	  public myframe() {
		  this.setSize(420,420);
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  this.setVisible(true);
		  this.add(graphicdemo);
	  }

}
