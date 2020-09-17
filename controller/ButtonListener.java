package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Paint;

public class ButtonListener implements ActionListener {

	public Paint panel; //Paint object called panel

	public ButtonListener(Paint panel){
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == panel.getClearButton()) {
			panel.drawArea.clear();
		  } else if (e.getSource() == panel.getBlackButton()) {
			panel.drawArea.black();
		  } else if (e.getSource() == panel.getBlueButton()) {
			panel.drawArea.blue();
		  } else if (e.getSource() == panel.getGreenButton()) {
			panel.drawArea.green();
		  } else if (e.getSource() == panel.getRedButton()) {
			panel.drawArea.red();
		  } 
	}
}