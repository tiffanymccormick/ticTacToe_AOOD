import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TicTacToe extends JFrame {
    JButton[][] boardButtons = new JButton[3][3];
    JButton resetButton = new JButton("Reset");
    JFrame frame = new JFrame("Aood Tic Tac Toe");

    // Player colors
    Color playerOneColor = Color.RED;
    Color playerTwoColor = Color.BLUE;
    
    public TicTacToe() {
        frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);

    }
    
    public void initialise(){
        
    }
  
}

