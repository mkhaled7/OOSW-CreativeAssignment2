package view;
import model.DrawArea;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.ButtonListener;
 
public class Paint {
 
  private JButton clearButton = new JButton("Clear Screen");
  private JButton blackButton = new JButton("Black");
  private JButton blueButton = new JButton("Blue");
  private JButton greenButton = new JButton("Green");
  private JButton redButton = new JButton("Red");

  public DrawArea drawArea;
 
  public void view() {
    
    JFrame window = new JFrame("Paint App");
    Container cp = window.getContentPane();
    cp.setLayout(new BorderLayout());
    drawArea = new DrawArea();
    cp.add(BorderLayout.CENTER, drawArea);
    JPanel panel = new JPanel();

	// add buttons to the panel
  	panel.add(blackButton);
    panel.add(greenButton);
    panel.add(blueButton);
    panel.add(redButton);
    panel.add(clearButton);
 
    // add panel to cp and set window size
    cp.add(panel, BorderLayout.SOUTH);
    window.setSize(800, 700);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	window.setVisible(true);
	
	//add action listeners to the buttons
	  final ButtonListener listener = new ButtonListener(this);
    clearButton.addActionListener(listener);
    blackButton.addActionListener(listener);
    blueButton.addActionListener(listener);
    greenButton.addActionListener(listener);
    redButton.addActionListener(listener);
  }

  public JButton getClearButton(){
	  return clearButton;
  }

  public JButton getBlackButton(){
  	return blackButton;
  }

  public JButton getBlueButton(){
	  return blueButton;
  }
  
	public JButton getGreenButton(){
	  return greenButton;
  }
  
	public JButton getRedButton(){
		return redButton;
  }
  
}

