package Ping.Pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class View extends JPanel {

	private final int BOARD_WIDTH = 1000;
	private final int BOARD_HEIGHT = 600;
	private final int TILE_SIZE = 20;
	
	//Positions
	private int ballx, bally, p1x, p1y, p2x, p2y,
	//scores and ball direction
				score1, score2, ballDx, ballDy;
	
	//wins who gets to ten
	private boolean p1Win, p2Win, reflect;
	
	private Timer timer;
	
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
        timer.start();
	}
	
	private void initVar(){
		p1x    = 1;
		p1y    = 14;
		p2x	   = 48;
		p2y    = 14;
		score1 = 0;
		score2 = 0;
		p1Win  = false;
		p2Win  = false;
		reflect = false;
		
		timer = new Timer(5, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		
	}
	
	private void initGame(){
		Random rg = new Random();
		ballDx = ((rg.nextInt(131) % 2) * 2) - 1;
		ballDy = ((rg.nextInt(101) % 2) * 2) - ((rg.nextInt(17) % 7) - 3);
		ballx  = 480;
		bally  = 280;
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
		
		if(p1Win || p2Win){
			if(p1Win){
				drawP1Win(g2d);
			}
			if(p2Win){
				drawP2Win(g2d);
			}
		}else{
			drawScore(g2d);
			playGame(g2d);
			
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
        g2d.drawString(str, 100, BOARD_HEIGHT + 50);
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
        g2d.drawString(str, 100, BOARD_HEIGHT + 50);
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
        g2d.drawString(str, 100, BOARD_HEIGHT + 50);
	}
	
	public void playGame(Graphics2D g2d){
		drawPlay1(g2d);
		drawPlay2(g2d);
		moveBall(g2d);
		testKeeperGoal();
		testWin();
	}
	
	public void moveBall(Graphics2D g2d){
		int auxX = ballx + ballDx;
		int auxY = bally + ballDy;
		
		checkReflect();
		
		if(!reflect){
			if(auxY > 5 && auxY < 595){
				bally = auxY;
				ballx = auxX;
			}else{
				ballDy = -ballDy;
				bally = bally + ballDy;
				ballx = auxX;
			}
		}else{
			if(auxY > 5 && auxY < 595){
				ballDx = -ballDx;
				bally = auxY;
				ballx = ballx + ballDx;
				reflect = false;
			}else{
				ballDy = -ballDy;
				ballDx = -ballDx;
				bally = bally + ballDy;
				ballx = ballx + ballDx;
				reflect = false;
			}
		}
		drawBall(g2d);
		
	}
	
	public void checkReflect(){
		if(ballx == 50){
			if((bally >= p1y * TILE_SIZE) && (bally <= (p1y + 8) * TILE_SIZE )){
				reflect = true;}

		}
		if(ballx == 950){
			if((bally >= p2y * TILE_SIZE) && (bally <= (p2y + 8) * TILE_SIZE )){
				reflect = true;}
		
		}
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
		g2d.drawRoundRect(ballx, bally, 
				TILE_SIZE, TILE_SIZE, 90, 90);
		g2d.fillRoundRect(ballx, bally, 
				TILE_SIZE, TILE_SIZE, 90, 90);
	}
	
	public void update(){
		repaint();
	}
	
	public void testKeeperGoal(){
		
		if(ballx == 40){
			if((bally > p1y * TILE_SIZE) && (bally > (p1y + 8) * TILE_SIZE)){
				reflect = true;
			}else{
				if(ballx == 5){
					score2++;
					initGame();
				}
			}
		}else{
			if(ballx == 959){
				if((bally > p2y * TILE_SIZE) && (bally > (p2y + 8) * TILE_SIZE)){
					reflect = true;
				}else{
					if(ballx == 995){
						score1++;
						initGame();
					}
				}
			}else{
				if(ballx == 5){
					score2++;
					initGame();
				}
				if(ballx == 995){
					score1++;
					initGame();
				}
			}
		}
		
	}

	public void testWin(){
		if(score1 == 10){ p1Win = true;}
		if(score2 == 10){ p2Win = true;}
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
	
	public int getBallDx() {
		return ballDx;
	}

	public void setBallDx(int ballDx) {
		this.ballDx = ballDx;
	}

	public int getBallDy() {
		return ballDy;
	}

	public void setBallDy(int ballDy) {
		this.ballDy = ballDy;
	}

	public int[] getMap() {
		return map;
	}

	public boolean isReflect() {
		return reflect;
	}

	public void setReflect(boolean reflect) {
		this.reflect = reflect;
	}

	void addKeyListener(ActionListener e){
		addKeyListener(e);
	}
	
}
