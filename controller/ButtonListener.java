
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.DrawArea;
import view.Paint;

public class ButtonListener implements ActionListener {

	DrawArea drawArea;

	public Paint panel;

	public ButtonListener(Paint panel){
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//Object source = e.getSource();
		//JButton button = e.getSource();

		if (e.getSource() == panel.getClearButton()) {
			drawArea.clear();
		  } else if (e.getSource() == panel.getBlackButton) {
			drawArea.black();
		  } else if (e.getSource() == panel.getBlueButton) {
			drawArea.blue();
		  } else if (e.getSource() == panel.getGreenButton) {
			drawArea.green();
		  } else if (e.getSource() == panel.getRedButton) {
			drawArea.red();
		  } 

	}
	
}

