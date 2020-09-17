package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JComponent;
import javax.swing.JPanel;

//JComponent: is an abstract class for all Swing components; a basic object that can be drawn
//It is abstract, so we cannot create an instance of it.
//JPanel: is simple usable component that can be used for almost anything
//Lightweight general-purpose container
//JPanel is a class, so we can create instances of it; useful for grouping components together

public class DrawArea extends JComponent {  //JPanel also works instead of JComponent
 
  private Image image; 
  
  private Graphics2D g2; 
  
  private int currentX, currentY, oldX, oldY; //record mouse coordinates
 
  public DrawArea() { //constructor
    
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) { //mouse PRESSED
        
        oldX = e.getX(); // save x,y coordinates when mouse is pressed
        oldY = e.getY();
      }
    });
 
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) { //mouse DRAGGED
        
        currentX = e.getX();  //recoreds coordinate when mouse is dragged
        currentY = e.getY();
 
        if (g2 != null) {
          // draw line if g2 not null
          g2.drawLine(oldX, oldY, currentX, currentY);
          
          repaint();
          
          oldX = currentX; // store current x,y coordinates as oldX and oldY
          oldY = currentY;
        }
      }
    });
  }
 
  public void paintComponent(Graphics g) {
    if (image == null) { //if null, we can draw
      
      image = createImage(getSize().width, getSize().height); //getSize() returns the size of the component
      g2 = (Graphics2D) image.getGraphics();
     
      clear();
    }
 
    g.drawImage(image, 0, 0, null); //draws image at coordinate: x,y and observer parameter is null
  }
 
       // methods
  public void clear() { //this method clears the screen when Clear Screen button is pressed
	
    g2.setColor(Color.white); //paint the image white
    g2.fillRect(0, 0, getSize().width, getSize().height); //draw an ampty white rectangle the size of dimension object
    g2.setColor(Color.black); //default paint color is BLACK
    repaint(); //basically refresh
  }
 
  public void red() {
    g2.setColor(Color.red);
  }
 
  public void black() {
    g2.setColor(Color.black);
  }
 
  public void green() {
    g2.setColor(Color.green);
  }
 
  public void blue() {
    g2.setColor(Color.blue);
  }
}