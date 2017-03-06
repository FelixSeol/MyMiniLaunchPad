import java.awt.Color;


public class InstButton extends GridButton {
	private char key[] = {'1','2','3','4','5','6','7','8',
							'Q','W','E','R','T','Y','U','I',
							'A','S','D','F','G','H','J','K',
							'Z','X','C','V','B','N','M',','};

	public InstButton(){
		super();
		setBackground(Color.WHITE);
		this.setColors(Color.WHITE, Color.CYAN);
		String s = ""+key[buttonNum];
		setText(s);
	}
	public void ButtonPressed(){
		super.ButtonPressed();
		deck.buttonPlay(this.getButtonNum());
	}
	public void ColorChange(){
		super.ColorChange();
		if(getBackground()==secondColor)
			setBackground(firstColor);
		else
			setBackground(secondColor);
	}
}