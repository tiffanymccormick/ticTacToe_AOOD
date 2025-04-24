import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.*;


  public class Grid extends JPanel{
        private int size;
        private int row;
        private int col;
        
        // JButton[][] boardButtons = new JButton[3][3];
        JButton[] boardButtons;
        public Grid(){
            row=0;
            col=0; 
            size=0;
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
             //ASK BETANIA (DO NOT DELETE THIS LINE) 
            for(int k=0; k<i*j; k++){
                boardButtons[k]=new JButton();
                frame.add(boardButtons[k]);

            }
            row=i;
            col=j;
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
            Grid g = new Grid();
            g.makeGrid(3,3);
        }

}

