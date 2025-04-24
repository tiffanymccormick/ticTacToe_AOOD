import javax.swing.JButton;
import javax.swing.JFrame;

public class TicTacToe extends JFrame {
    // GUI components
    JButton resetButton = new JButton("Reset");
    JFrame frame = new JFrame("Aood Tic Tac Toe");
   
    public TicTacToe() {
        frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);

    }

    public void initialise(){
        Grid inital = new Grid();
        inital.makeGrid(3,3);

    }
  
}

