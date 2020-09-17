package model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JComponent;
 
//REFERENCES used:
/*
https://www.programcreek.com/java-api-examples/?class=java.awt.Component&method=createImage
https://stackoverflow.com/questions/9445182/drawimage-doesnt-draw/9445499
https://www.codota.com/code/java/methods/java.awt.Graphics/drawImage
https://stackoverflow.com/questions/20170641/creating-a-custom-method-to-draw-graphics-2d-g2-is-null
*/


public class DrawArea extends JComponent {
 
  private Image image; 
  
  private Graphics2D g2; 
  
  private int currentX, currentY, oldX, oldY; //record mouse coordinates
 
  public DrawArea() { //constructor
    
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        
        oldX = e.getX(); // save x,y coordinates when mouse is pressed
        oldY = e.getY();
      }
    });
 
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        
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
    if (image == null) { //when its null we can draw
      
      image = createImage(getSize().width, getSize().height);
      g2 = (Graphics2D) image.getGraphics();
     
      clear();
    }
 
    g.drawImage(image, 0, 0, null);
  }
 
  // methods
  public void clear() {
	
    g2.setColor(Color.white); //paint the image white
    g2.fillRect(0, 0, getSize().width, getSize().height);
    g2.setColor(Color.black); //default paint color is BLACK
    repaint();
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