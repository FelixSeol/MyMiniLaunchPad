import java.awt.Color;

import javax.swing.JRadioButton;

public class CtrlButton extends GridButton {
	private static int CTRL_BUTTON_COUNT = 0;
	private int ctrlButtonNum = 0;
	public CtrlButton(){
		super();
		ctrlButtonNum = CTRL_BUTTON_COUNT;
		setBackground(Color.GREEN);
		this.setColors(Color.GREEN,Color.YELLOW);
		String labelStyle = "<html>" +
	            "<body style='text-align: center;'>";
		String labelStyleEnd= "</html>";
		if(ctrlButtonNum == 0){
			setText(labelStyle+"Pane"+"<br />"+"1"+labelStyleEnd);
		}else if(ctrlButtonNum == 1){
			setText(labelStyle+"Pane"+"<br />"+"2"+labelStyleEnd);
		}else if(ctrlButtonNum == 2){
			setText(labelStyle+"Pane"+"<br />"+"3"+labelStyleEnd);
		}else if(ctrlButtonNum == 3){
			setText(labelStyle+"Pane"+"<br />"+"4"+labelStyleEnd);
		}
		CTRL_BUTTON_COUNT++;
	}
	public void ButtonPressed(){
		super.ButtonPressed();
		int in = AbletonGUI.GRID_WIDTH*(AbletonGUI.GRID_HEIGHT-1);
		NewSequencer.setCtrlPaneNum(this.getButtonNum()-in);
	}
	public void ColorChange(){
		super.ColorChange();
		int in = AbletonGUI.GRID_WIDTH*(AbletonGUI.GRID_HEIGHT-1);
		for(int i=0;i<4;i++){
			AbletonGUI.getGridButton(in+i).setBackground(firstColor);
		}
		setBackground(secondColor);
	}
}
