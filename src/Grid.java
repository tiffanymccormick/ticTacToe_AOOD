import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.*;


  public class Grid extends JPanel{
        private int size;
        private int row;
        private int col;
        private GameController controller;
        JButton[] boardButtons;
        
        public Grid(GameController controller){
            this.row = 3;
            this.col = 3;
            this.controller = controller; // Set to null or provide a default GameController instance
            makeGrid(row, col);
        }

        public Grid(int rows, int cols, GameController controller){
            row = rows;
            col = cols;
            this.controller = controller;
            makeGrid(rows, cols);
        }
        
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.drawLine(50, 50, 350, 250);
        
        }

        public void makeGrid(int i, int j){
            JFrame frame = new JFrame("Grid");

            boardButtons = new JButton[i*j];
            size=i*j;
            GridLayout grid = new GridLayout(i, j);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            frame.setLayout(grid);
            frame.setResizable(false);
            
            for(int k=0; k<i*j; k++){
                boardButtons[k]=new JButton();
                frame.add(boardButtons[k]);

            }
            row=i;
            col=j;
        }

        /**
         * Expands the grid by adding two rows and two columns to the existing grid (can be changed to random grid extension)
         * 
         * It copies the existing buttons to the center of the new grid and sets their colors and enabled state accordingly
         */
        public void expandGrid() {
            //new size
            int newRows = row + 2;
            int newCols = row + 2;

            //create bigger array of buttons
            JButton[] newButtons = new JButton[newRows * newCols];
    
            //clear out old panel, reset layout, and add new buttons
            this.removeAll();
            this.setLayout(new GridLayout(newRows, newCols));
    
            //add new buttons
            for (int i = 0; i < newRows; i++) {
                for (int j = 0; j < newCols; j++) {
                    JButton button = new JButton();
                    button.setBackground(Color.WHITE);
                    button.setEnabled(true);
                    int index = i * newCols + j;
                    newButtons[index] = button;
    
                    // Copy center old buttons into new grid
                    if (i >= 1 && i < newRows - 1 && j >= 1 && j < newCols - 1) {
                        int oldIndex = (i - 1) * col + (j - 1);
                        if (oldIndex < boardButtons.length) {
                            Color prevColor = boardButtons[oldIndex].getBackground();
                            button.setBackground(prevColor);
                            button.setEnabled(false);
                        }
                    }
    
                    //re add the action listeners
                    final int r = i;
                    final int c = j;
                    button.addActionListener(e -> controller.handleMove(button, r, c, this));
                    this.add(button);
                }
            }
    
            row = newRows;
            row = newCols;
            this.boardButtons = newButtons;
            revalidate();
            repaint();
        }
        
        public JButton getButton(int i){
            return boardButtons[i];
        }
        public JButton [] getButtons(){
            return boardButtons;
        }
        public int gridSize(){
           return size;

        }
        public int getRow(){
            return row;
        }
         public int getCol(){
            return col;
        }
        public void resetGrid(){
            makeGrid(3,3);
        } 
        public static void main(String[] args) {
            GameController controller = new GameController();
            Grid g = new Grid(controller);
            JFrame frame = new JFrame("Grid Example");
            g.makeGrid(4,3);
            
        }
}

