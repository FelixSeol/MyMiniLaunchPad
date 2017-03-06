import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.sound.midi.Track;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GridButton extends JButton {
	protected static int BUTTON_COUNT = 0;
	protected int buttonNum;
	protected Color firstColor = null;
	protected Color secondColor = null;
	protected NewSequencer deck;
	
	public GridButton(){
		super();
		buttonNum = BUTTON_COUNT;
		setOpaque(true);
		setBorderPainted(false);
		setFocusPainted(false);
		setPreferredSize(new Dimension(80,80));
		setVisible(true);
		setFont(new Font("Helvetica",Font.BOLD,18));
		setHorizontalAlignment(SwingConstants.CENTER);
		
		BUTTON_COUNT++;
	}
	public void ButtonPressed(){
		ColorChange();
	}
	public int getButtonNum(){
		return this.buttonNum;
	}
	public void linkButtontoSequencer(NewSequencer _deck){
		this.deck = _deck;
	}
	public void setColors(Color fc, Color sc){
		this.firstColor = fc;
		this.secondColor = sc;
	}
	
	public void ColorChange(){
		String n = this.getClass().getName();
		System.out.println(n);
	}
}
	