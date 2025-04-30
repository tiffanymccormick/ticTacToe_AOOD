import java.awt.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class GameController {
    private Player player1;
    private Player player2;

    private Player winner;
    private Player currentPlayer;
    private  int count;

    public GameController(){
        player1 = new Player("Player 1", Color.RED);
        player2 = new Player("Player 2", Color.BLUE);
        winner = new Player("Player 1", Color.RED);
        currentPlayer = player1;
        
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    //checks current tile color, if red+blue or vice versa, mix to purple, call checkWin. if true, then expand grid
    public void handleMove(JButton button, int row, int col, Grid grid) {
        Color currentColor = currentPlayer.getColor();
        Color existingColor = button.getBackground();
        if(count>=5){
            button.setBackground(Color.WHITE);
            return;
        }

        if(currentColor.equals(Color.BLUE) && existingColor.equals(Color.RED) || currentColor.equals(Color.RED) && existingColor.equals(Color.BLUE)){
            button.setBackground(new Color(171, 52, 235));
        } else {
            button.setBackground(currentColor);
        }

        if (checkWin(grid, button.getBackground())) {
            JOptionPane.showMessageDialog(null, currentPlayer.getName() + " wins!");
            grid.expandGrid(); // Expand the grid after a win
            currentPlayer = (currentPlayer == player1) ? player1 : player2; //winner goes first
        } else {
            if (isBoardFull(grid)) {
                JOptionPane.showMessageDialog(null, "It's a draw");
                grid.resetGrid();
                currentPlayer = player1; // Player 1 starts after a draw
            } else {
                switchPlayer();
            }
        }
    }
    
    private boolean isBoardFull(Grid grid){
        JButton[] buttons = grid.getButtons();
        for(JButton button : buttons){
            if(button.getBackground()==Color.WHITE){
                return false;
            }
        }
        return true;
    }

    public boolean checkWin(Grid grid, Color color) {
        int rows = grid.getRow();
        int cols = grid.getCol();
        int winLength = rows <= 3 ? 3 : rows <= 5 ? 4 : 5;
    
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
