package Ping.Pong;

public class Controller {
	
	private View board;
	private ModelBall ball;
	private ModelPlayer p1, p2;
	
	public Controller(View board, ModelBall ball, 
							ModelPlayer p1, ModelPlayer p2){
		
		this.board = board;
		this.ball  = ball;
		this.p1    = p1;
		this.p2    = p2;
		
	}

}
