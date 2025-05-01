import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TicTacToe extends JFrame {
    // GUI components
    JButton resetButton = new JButton("Reset");
    JFrame frame = new JFrame("Aood Tic Tac Toe");
   
    public TicTacToe() {
        frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
        
        GameController controller = new GameController();
        Grid grid = new Grid(3, 3, controller);
        frame.add(grid);
    }
  
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToe());
    }
}

