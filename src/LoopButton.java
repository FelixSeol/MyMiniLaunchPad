import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class LoopButton extends GridButton {
	private static int LOOP_BUTTON_COUNT = 0;
	private int loopButtonNum = 0;
	public LoopButton(){
		super();
		loopButtonNum = LOOP_BUTTON_COUNT;
		this.setColors(Color.BLACK, Color.PINK);
		String labelStyle = "<html>" +
	            "<body style='text-align: center;'>";
		String labelStyleEnd= "</html>";
		if(loopButtonNum == 0){
			setText(labelStyle+"Loop"+"<br />"+"4"+labelStyleEnd);
		}else if(loopButtonNum == 1){
			setText(labelStyle+"Loop"+"<br />"+"2"+labelStyleEnd);
		}else if(loopButtonNum == 2){
			setText(labelStyle+"Loop"+"<br />"+"∞"+labelStyleEnd);
		}
		setOpaque(false);
		setForeground(firstColor);
		
		setBorderPainted(true);
		LOOP_BUTTON_COUNT++;
	}
	public void ButtonPressed(){
		super.ButtonPressed();
		switch (loopButtonNum){
		case 0: 
			deck.setLoopState(true, 3);break;
		case 1:
			deck.setLoopState(true, 1);break;
		case 2:
			deck.setLoopState(true, 100);break; // loop infinitely
		}
		//ColorChange();
	}
	public void ColorChange(){
		super.ColorChange();
		if(getForeground()==secondColor)
			setForeground(firstColor);
		else
			setForeground(secondColor);
	}
}
