
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Vector;

import javax.sound.midi.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class NewSequencer {
	private static final int CLIP_NUM = 128;
	private static int CTRL_PANE_NUM = 0;
	private boolean loopState = false;
	private int loopCount = 0;
	private Clip[] clips = new Clip[CLIP_NUM];
	
	public NewSequencer(){
		openAudioInputStream();
	}
	
	/*public void openAudioInputStream(){
		try {
			String s1 = "Crop/";
			String s2 = ".wav";
			String s3 = null;
			for(int i=0;i<32;i++){
				s3 = s1+"a"+(i+1)+".wav";
				URL url = this.getClass().getClassLoader().getResource(s3);
				System.out.println(url.getPath());
				AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
				clips[i] = AudioSystem.getClip();
				clips[i].open(audioIn);
			}
			for(int i=32;i<64;i++){
				s3 = s1+"b"+(i-31)+".aiff";
				URL url = this.getClass().getClassLoader().getResource(s3);
				System.out.println(url.getPath());
				AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
				clips[i] = AudioSystem.getClip();
				clips[i].open(audioIn);
			}
			for(int i=64;i<96;i++){
				s3 = s1+"g"+(i-63)+".aiff";
				URL url = this.getClass().getClassLoader().getResource(s3);
				System.out.println(url.getPath());
				AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
				clips[i] = AudioSystem.getClip();
				clips[i].open(audioIn);
			}
			for(int i=96;i<128;i++){
				s3 = s1+"g"+(i-95)+".aiff";
				URL url = this.getClass().getClassLoader().getResource(s3);
				System.out.println(url.getPath());
				AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
				clips[i] = AudioSystem.getClip();
				clips[i].open(audioIn);
			}
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	public void openAudioInputStream(){
		try {
			String s1 = "C:\\Crop\\";
			String s2 = ".wav";
			String s3 = null;
			for(int i=0;i<32;i++){
				s3 = s1+"a"+(i+1)+".wav";
				File url = new File(s3); 
				AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
				clips[i] = AudioSystem.getClip();
				clips[i].open(audioIn);
			}
			for(int i=32;i<64;i++){
				s3 = s1+"b"+(i-31)+".aiff";
				File url = new File(s3); 
				AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
				clips[i] = AudioSystem.getClip();
				clips[i].open(audioIn);
			}
			for(int i=64;i<96;i++){
				s3 = s1+"g"+(i-63)+".aiff";
				File url = new File(s3); 
				AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
				clips[i] = AudioSystem.getClip();
				clips[i].open(audioIn);
			}
			for(int i=96;i<128;i++){
				s3 = s1+"g"+(i-95)+".aiff";
				File url = new File(s3); 
				AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
				clips[i] = AudioSystem.getClip();
				clips[i].open(audioIn);
			}
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void stopPlay(){
		for(int i=0;i<CLIP_NUM;i++){
			if(clips[i].isRunning())
				clips[i].stop();
				clips[i].setFramePosition(0);
		}
	}
	
	public void buttonPlay(int n){
		int buttonNum = n+getCtrlPaneNum()*32;
		Clip c = clips[buttonNum];
		c.setFramePosition(0);
		System.out.println("Button "+buttonNum+" Play");
		if(loopState){
			c.loop(loopCount);
			setLoopState(false,0);
		}else{
			if(c.isRunning()){
				System.out.println("Click while running!@@@@@@@@@@");
				c.stop();
				c.setFramePosition(0);
				c.start();
			}else{
				c.start();
			}
		}
	}
	
	public static int getCtrlPaneNum(){
		return CTRL_PANE_NUM;
	}
	public static void setCtrlPaneNum(int n){
		CTRL_PANE_NUM = n;
	}
	
	public boolean getLoopState(){
		return loopState;
	}
	public void setLoopState(boolean b, int n){
		loopState = b;
		loopCount = n;
	}
}
