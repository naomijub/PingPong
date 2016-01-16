package Ping.Pong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class Controller {
	
	private View board;
	private ModelPlayer p1, p2;
	private Timer timer;
	
	public Controller(View board,
							 ModelPlayer p1,  ModelPlayer p2){
		
		this.board = board;
		this.p1    = p1;
		this.p2    = p2;
		
		insertValues();
		
		this.board.addKeyListener(new TAdapter());
		
	}
	
	public void insertValues(){
		p1.setX(board.getP1x());
		p1.setY(board.getP1y());
		p2.setX(board.getP2x());
		p2.setY(board.getP2y());
	}
	
	public void updateValues(){
		board.setP1x(p1.getX());
		board.setP1y(p1.getY());
		board.setP2x(p2.getX());
		board.setP2y(p2.getY());
	}

	
	class TAdapter implements KeyListener{

		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			if ((key == KeyEvent.VK_UP)) {
	            	p2.moveUp();
	            	updateValues();
	            	board.update();
	        }
			
			if ((key == KeyEvent.VK_DOWN)) {
	            	p2.moveDown();
	            	updateValues();
	            	board.update();
	        }
			
			if ((key == KeyEvent.VK_A)) {
            	p1.moveUp();
            	updateValues();
            	board.update();
	        }
			
			if ((key == KeyEvent.VK_Z)) {
            	p1.moveDown();
            	updateValues();
            	board.update();
	        }
			
			
		}

		public void keyReleased(KeyEvent e) {
			
		}

		public void keyTyped(KeyEvent e) {
			
		}

	
		
	}

}

