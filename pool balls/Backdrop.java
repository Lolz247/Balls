import java.awt.Graphics;
import java.awt.Color;

public class Backdrop implements Draw{
    private int fWidth = Constant.FRAME_WIDTH;
    private int fHeight = Constant.FRAME_HEIGHT;
    private int wallSize = Constant.BORDER_SIZE;
    private int bordWidth = fWidth-(wallSize*3);
    private int bordHeight = fHeight-(wallSize*5);
    private Color DARK_GREEN = new Color(0, 102, 0);
    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.fWidth, this.fHeight);
        g.setColor(this.DARK_GREEN);
        g.fillRect(wallSize, wallSize, bordWidth, bordHeight);
    }
}

