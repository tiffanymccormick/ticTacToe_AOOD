import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.*;


  public class Grid extends JPanel{
        private int size;
          public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.drawLine(50, 50, 350, 250);
        
        }
        public void makeGrid(int i, int j){
            GridLayout grid = new GridLayout(i, j);
            for(int k=0; k<=i*j; k++){
                JButton1

            
            }
        }

    
        
}

