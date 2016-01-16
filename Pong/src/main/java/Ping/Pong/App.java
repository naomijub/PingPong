package Ping.Pong;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * Hello world!
 *
 */
public class App extends JFrame
{
	public App(){
		
		initUI();
		
		//Exit Listener
  		addWindowListener(new WindowAdapter() {
  			public void windowClosed(WindowEvent e) {
  				System.exit(0);
  			}
  		});
	}
	
	public void initUI(){
		View      	board 	= new View();
        ModelPlayer p1 		= new ModelPlayer();
        ModelPlayer p2 		= new ModelPlayer();
        Controller 	control = new Controller(board, p1, p2);
        
        setSize(1010, 700);
        setResizable(false);
        setTitle("PingPong@naomijub");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        add(board);
	}
	
    public static void main( String[] args )
    {
    	 EventQueue.invokeLater(new Runnable() {		 
	            public void run() {
	                App ex = new App();
	                ex.setVisible(true);
	            }
	        });
        
    }
}
