import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AbletonGUI{
	static final int GRID_WIDTH = 8;
	static final int GRID_HEIGHT = 5;
	static final int CTRL_BUTTON_COUNT = 4;
	static final int LOOP_BUTTON_COUNT = 3;
	private JFrame mainFrame;
	private NewSequencer player;
	private static GridButton[] gridButtons;
	private JPanel gridPanel;
	AbletonGUI(NewSequencer _player){
		this.player = _player;
		/*
		 *  mainframe
		 */
		mainFrame = new JFrame("Mini Ableton");
		JPanel background = new JPanel(new BorderLayout());
		background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		/*
		 *  main GridLayout Panel
		 */
		GridLayout gridLayout = new GridLayout(GRID_HEIGHT, GRID_WIDTH);
		gridLayout.setHgap(15);
		gridLayout.setVgap(15);
		gridPanel = new JPanel(gridLayout);
		/*
		 *  Center GridLayout Panel (contains Instrumental Buttons , Control Buttons, Loop Buttons) = GRID_WIDTH*GRID_HEIGHT-1
		 */
		gridButtons = new GridButton[GRID_WIDTH*GRID_HEIGHT-1];
		for(int i=0; i<GRID_WIDTH*GRID_HEIGHT-1; i++){
			if(i>=GRID_WIDTH*(GRID_HEIGHT-1)){	
				// BOTTOM Most side 1 to 4: PaneControlButton
				if(i>=GRID_WIDTH*(GRID_HEIGHT-1)+CTRL_BUTTON_COUNT){
					gridButtons[i] = new LoopButton();
				}else
					gridButtons[i] = new CtrlButton();
			}else
				gridButtons[i] = new InstButton();
			gridButtons[i].linkButtontoSequencer(player);
			gridPanel.add(gridButtons[i]);
		}
		gridButtons[GRID_WIDTH*(GRID_HEIGHT-1)].ColorChange();
		
				//RIGHT-BOTTOM Most section with ImageLabel
		gridPanel.add(new ImageLabel());
		gridPanel.setBackground(Color.BLACK);
		/*
		 * Pack-up
		 */
		background.add(BorderLayout.CENTER, gridPanel);
		background.setBackground(Color.BLACK);
		gridPanel.setFocusable(true);
		gridPanel.addKeyListener(new MyKeyListener());
		mainFrame.getContentPane().add(background);
		mainFrame.setBounds(50,50,300,300);
		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public JPanel getGridPanel(){
		return gridPanel;
	}
	public static GridButton getGridButton(int num){
		return gridButtons[num];
	}
	
	class MyKeyListener extends KeyAdapter{
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int keyCode = e.getKeyCode();
			System.out.println(e.getKeyChar()+" is pressed");
			if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
				player.stopPlay();
			else{
				GridButton button = searchButton(keyCode);
				if(button!=null)
					button.ButtonPressed();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			int keyCode = e.getKeyCode();
			GridButton button = searchButton(keyCode);
			if(button!=null)
				button.ColorChange();
		}
				
		public GridButton searchButton(int keyCode){
			GridButton button = null;
			switch(keyCode){
			case KeyEvent.VK_1 :
				button = gridButtons[0];break;
			case KeyEvent.VK_2 :
				button = gridButtons[1];break;
			case KeyEvent.VK_3 :
				button = gridButtons[2];break;
			case KeyEvent.VK_4 :
				button = gridButtons[3];break;
			case KeyEvent.VK_5 :
				button = gridButtons[4];break;
			case KeyEvent.VK_6 :
				button = gridButtons[5];break;
			case KeyEvent.VK_7 :
				button = gridButtons[6];break;
			case KeyEvent.VK_8 :
				button = gridButtons[7];break;
			case KeyEvent.VK_Q :
				button = gridButtons[8];break;
			case KeyEvent.VK_W :
				button = gridButtons[9];break;
			case KeyEvent.VK_E :
				button = gridButtons[10];break;
			case KeyEvent.VK_R :
				button = gridButtons[11];break;
			case KeyEvent.VK_T :
				button = gridButtons[12];break;
			case KeyEvent.VK_Y :
				button = gridButtons[13];break;
			case KeyEvent.VK_U :
				button = gridButtons[14];break;
			case KeyEvent.VK_I :
				button = gridButtons[15];break;
			case KeyEvent.VK_A :
				button = gridButtons[16];break;
			case KeyEvent.VK_S :
				button = gridButtons[17];break;
			case KeyEvent.VK_D :
				button = gridButtons[18];break;
			case KeyEvent.VK_F :
				button = gridButtons[19];break;
			case KeyEvent.VK_G :
				button = gridButtons[20];break;
			case KeyEvent.VK_H :
				button = gridButtons[21];break;
			case KeyEvent.VK_J :
				button = gridButtons[22];break;
			case KeyEvent.VK_K :
				button = gridButtons[23];break;
			case KeyEvent.VK_Z :
				button = gridButtons[24];break;
			case KeyEvent.VK_X :
				button = gridButtons[25];break;
			case KeyEvent.VK_C :
				button = gridButtons[26];break;
			case KeyEvent.VK_V :
				button = gridButtons[27];break;
			case KeyEvent.VK_B :
				button = gridButtons[28];break;
			case KeyEvent.VK_N :
				button = gridButtons[29];break;
			case KeyEvent.VK_M :
				button = gridButtons[30];break;
			case KeyEvent.VK_COMMA :
				button = gridButtons[31];break;
			case KeyEvent.VK_F1 :
				button = gridButtons[32];break;
			case KeyEvent.VK_F2 :
				button = gridButtons[33];break;
			case KeyEvent.VK_F3 :
				button = gridButtons[34];break;
			case KeyEvent.VK_F4 :
				button = gridButtons[35];break;
			case KeyEvent.VK_F5 :
				button = gridButtons[36];break;
			case KeyEvent.VK_F6 :
				button = gridButtons[37];break;
			case KeyEvent.VK_F7 :
				button = gridButtons[38];break;
			case KeyEvent.VK_F8 :
				button = gridButtons[39];break;
			default : break;
			}
			;
			
			return button;
		}
	}	
}