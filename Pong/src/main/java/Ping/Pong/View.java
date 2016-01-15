package Ping.Pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

public class View extends JPanel {

	private final int BOARD_WIDTH = 1000;
	private final int BOARD_HEIGHT = 600;
	private final int TILE_SIZE = 20;
	
	//Positions
	private int ballx, bally, p1x, p1y, p2x, p2y,
	//scores and ball direction
				score1, score2;//, ballDx, ballDy;
	
	//wins who gets to ten
	private boolean p1Win, p2Win;
	
	private final int[] map = {
			5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
			6, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 10};
	
	public View(){
		setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT + 100));
    	setBackground(new Color(0, 0, 0));
        setFocusable(true);
        setDoubleBuffered(true);

        initVar();
        initGame();
	}
	
	private void initVar(){
		ballx  = 24;
		bally  = 14;
		p1x    = 1;
		p1y    = 14;
		p2x	   = 48;
		p2y    = 14;
		score1 = 0;
		score2 = 0;
		p1Win  = false;
		p2Win  = false;
		
	}
	
	private void initGame(){
		Random rg = new Random();
		//ballDx = ((rg.nextInt(131) % 2) * 2) - 1 ;
		//ballDy = ((rg.nextInt(101) % 2) * 2) - ((rg.nextInt(17) % 7) - 3) ;
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
	
	public void doDrawing(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		//draw black board
		g2d.setColor(new Color(0, 0, 0));
		g2d.drawRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
		g2d.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
		
		drawMap(g2d);
		
		if(!p1Win || !p2Win){
			drawScore(g2d);
			playGame(g2d);
		}else{
			if(p1Win){
				drawP1Win(g2d);
			}
			if(p2Win){
				drawP2Win(g2d);
			}
		}
	}
	
	private void drawMap(Graphics2D g2d){
		for(int i = 0; i < map.length;i++){
			int y = (int) i / 50;
			int x = i % 50;
			
			//top and botton green lighta
			if((map[i] & 1) != 0){
				g2d.setColor(new Color(15, 240, 20));
                g2d.drawRect(x * 20, y * 20, TILE_SIZE, 5);
                g2d.fillRect(x * 20, y * 20, TILE_SIZE, 5);
			}
			if((map[i] & 2) != 0){
				g2d.setColor(new Color(15, 240, 20));
                g2d.drawRect(x * 20, (y * 20) + TILE_SIZE,
                		TILE_SIZE, 5);
                g2d.fillRect(x * 20, (y * 20) + TILE_SIZE,
                		TILE_SIZE, 5);
			}
			//left and right white lines
			if((map[i] & 4) != 0){
				g2d.setColor(new Color(240, 240, 240));
                g2d.drawRect(x * 20, y * 20, 5, TILE_SIZE);
                g2d.fillRect(x * 20, y * 20, 5, TILE_SIZE);
			}
			if((map[i] & 8) != 0){
				g2d.setColor(new Color(240, 240, 240));
                g2d.drawRect((x * 20) + TILE_SIZE - 5, y * 20, 5, TILE_SIZE);
                g2d.fillRect((x * 20) + TILE_SIZE - 5, y * 20, 5, TILE_SIZE);
			}
		}
	}
	
	private void drawScore(Graphics2D g2d){
		Font font = new Font("Arial", Font.BOLD, 25);
		String str = "Player 1: " + score1 + " X Player 2: " + score2;
		
		//Scoreboard
		g2d.setColor(new Color(0, 0, 50));
        g2d.fillRect(0, BOARD_HEIGHT + 5, BOARD_WIDTH, 50);
        g2d.drawRect(0, BOARD_HEIGHT + 5, BOARD_WIDTH, 50);
        
        //score string
        g2d.setColor(Color.WHITE);
        g2d.setFont(font);
        g2d.drawString(str, 100, BOARD_HEIGHT + 30);
	}
	
	public void drawP1Win(Graphics2D g2d){
		Font font = new Font("Arial", Font.BOLD, 25);
		String str = "Player 1: WINS " + score1 + " x " + score2;
		
		//Scoreboard
		g2d.setColor(new Color(0, 0, 50));
        g2d.fillRect(0, BOARD_HEIGHT + 5, BOARD_WIDTH, 50);
        g2d.drawRect(0, BOARD_HEIGHT + 5, BOARD_WIDTH, 50);
        
        //score string
        g2d.setColor(Color.WHITE);
        g2d.setFont(font);
        g2d.drawString(str, 100, BOARD_HEIGHT + 30);
	}
	
	public void drawP2Win(Graphics2D g2d){
		Font font = new Font("Arial", Font.BOLD, 25);
		String str = "Player 2: WINS " + score2 + " x " + score1;
		
		//Scoreboard
		g2d.setColor(new Color(0, 0, 50));
        g2d.fillRect(0, BOARD_HEIGHT + 5, BOARD_WIDTH, 100);
        g2d.drawRect(0, BOARD_HEIGHT + 5, BOARD_WIDTH, 100);
        
        //score string
        g2d.setColor(Color.WHITE);
        g2d.setFont(font);
        g2d.drawString(str, 100, BOARD_HEIGHT + 30);
	}
	
	public void playGame(Graphics2D g2d){
		drawPlay1(g2d);
		drawPlay2(g2d);
		drawBall(g2d);
	}
	
	public void drawPlay1(Graphics2D g2d){
		g2d.setColor(Color.RED);
		g2d.drawRect(p1x * TILE_SIZE, p1y * TILE_SIZE, 
				TILE_SIZE, TILE_SIZE * 8);
		g2d.fillRect(p1x * TILE_SIZE, p1y * TILE_SIZE,
				TILE_SIZE, TILE_SIZE * 8);
	}
	
	public void drawPlay2(Graphics2D g2d){
		g2d.setColor(Color.BLUE);
		g2d.drawRect(p2x * TILE_SIZE, p2y * TILE_SIZE, 
				TILE_SIZE, TILE_SIZE * 8);
		g2d.fillRect(p2x * TILE_SIZE, p2y * TILE_SIZE,
				TILE_SIZE, TILE_SIZE * 8);
	}
	
	public void drawBall(Graphics2D g2d){
		g2d.setColor(new Color(15, 240, 20));
		g2d.drawRoundRect(ballx * TILE_SIZE, bally * TILE_SIZE, 
				TILE_SIZE, TILE_SIZE, 90, 90);
		g2d.fillRoundRect(ballx * TILE_SIZE, bally * TILE_SIZE, 
				TILE_SIZE, TILE_SIZE, 90, 90);
	}
	
	public void update(){
		repaint();
	}

	public int getBallx() {
		return ballx;
	}

	public void setBallx(int ballx) {
		this.ballx = ballx;
	}

	public int getBally() {
		return bally;
	}

	public void setBally(int bally) {
		this.bally = bally;
	}

	public int getP1x() {
		return p1x;
	}

	public void setP1x(int p1x) {
		this.p1x = p1x;
	}

	public int getP1y() {
		return p1y;
	}

	public void setP1y(int p1y) {
		this.p1y = p1y;
	}

	public int getP2x() {
		return p2x;
	}

	public void setP2x(int p2x) {
		this.p2x = p2x;
	}

	public int getP2y() {
		return p2y;
	}

	public void setP2y(int p2y) {
		this.p2y = p2y;
	}

	public int getScore1() {
		return score1;
	}

	public void setScore1(int score1) {
		this.score1 = score1;
	}

	public int getScore2() {
		return score2;
	}

	public void setScore2(int score2) {
		this.score2 = score2;
	}

	public boolean isP1Win() {
		return p1Win;
	}

	public void setP1Win(boolean p1Win) {
		this.p1Win = p1Win;
	}

	public boolean isP2Win() {
		return p2Win;
	}

	public void setP2Win(boolean p2Win) {
		this.p2Win = p2Win;
	}
	
	
	
}
