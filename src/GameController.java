import java.awt.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class GameController {
    private Player player1 = new Player("Player 1", Color.RED);
    private Player player2 = new Player("Player 2", Color.BLUE);

    private Player winner = new Player("Player 1", Color.RED);
    private Player currentPlayer = player1;

    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    //checks current tile color, if red+blue or vice versa, mix to purple, call checkWin. if true, then expand grid
    public void handleMove(JButton button, int row, int col, Grid grid) {
        Color currentColor = currentPlayer.getColor();
        Color existingColor = button.getBackground();

        if(currentColor.equals(Color.BLUE) && existingColor.equals(Color.RED) || currentColor.equals(Color.RED) && existingColor.equals(Color.BLUE)){
            button.setBackground(new Color(171, 52, 235));
        } else {
            button.setBackground(currentColor);
        }

        if (checkWin(grid, button.getBackground())) {
            JOptionPane.showMessageDialog(null, currentPlayer.getName() + " wins");
            // Winner goes first again
        } else {
            switchPlayer();
        }
    }

    public boolean checkWin(Grid grid, Color color) {
        int rows = grid.getRow();
        int cols = grid.getCol();
        int winLength = Math.min(5, Math.max(rows, cols)); // or fixed to 3, 4, etc.
    
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int index = row * cols + col;
    
                if (!grid.getButton(index).getBackground().equals(color)) continue;
    
                // Directions: right, down, diag ↘, diag ↗
                if (checkDirection(grid, row, col, 0, 1, color, winLength)) return true;  // →
                if (checkDirection(grid, row, col, 1, 0, color, winLength)) return true;  // ↓
                if (checkDirection(grid, row, col, 1, 1, color, winLength)) return true;  // ↘
                if (checkDirection(grid, row, col, -1, 1, color, winLength)) return true; // ↗
            }
        }
    
        return false;
    }
    
    private boolean checkDirection(Grid grid, int startRow, int startCol, int rowStep, int colStep, Color color, int winLength) {
        int rows = grid.getRow();
        int cols = grid.getCol();
    
        for (int i = 0; i < winLength; i++) {
            int r = startRow + i * rowStep;
            int c = startCol + i * colStep;
    
            if (!isInBounds(r, c, rows, cols)) return false;
    
            int index = r * cols + c;
            if (!grid.getButton(index).getBackground().equals(color)) return false;
        }
    
        return true; // all tiles matched
    }

    private boolean isInBounds(int row, int col, int totalRows, int totalCols) {
        return row >= 0 && row < totalRows && col >= 0 && col < totalCols;
    }    
}
