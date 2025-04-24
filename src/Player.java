import java.awt.*;

public class Player {
    private String name;
    private Color color;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    public String getName() {
        return name;
    }
    public void setName(String n) {
        name=n;
    }
    public void getColor(Color c) {
        color=c;
    }
}
