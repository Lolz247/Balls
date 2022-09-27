import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class Ball implements Draw{
    private int fWidth = Constant.FRAME_WIDTH;
    private int fHeight = Constant.FRAME_HEIGHT;
    private int border = Constant.BORDER_SIZE;
    private int size = 40;
    private int speed = size/2;
    private double Xcoord = (Math.random()*(fWidth-border-size*2-4));
    private double Ycoord = (Math.random()*(fHeight-border-size*2-4));
    private int ballNum;
    private double[] direction = {Math.random()*(2*speed+1)-speed, Math.random()*(2*speed+1)-speed};
    private Color color;
    private Color[] ballColours = {Color.YELLOW, Color.BLUE, Color.RED, Color.MAGENTA, Color.ORANGE, Color.GREEN, Color.PINK, Color.BLACK};

    public Ball(int ballNum){
        this.color = ballColours[ballNum-1];
        this.ballNum = ballNum;
    }

    public int getX(){
        return (int)Xcoord;
    }

    public int getY(){
        return (int)Ycoord;
    }

    public int getSize(){
        return size;
    }

    public void move(){
        Xcoord += direction[0];
        Ycoord += direction[1];
    }

    public void collidesLeft(){
        direction[0] = Math.abs(direction[0]);
    }

    public void collidesRight(){
        direction[0] = Math.abs(direction[0]) * (-1);
    }

    public void collidesTop(){
        direction[1] = Math.abs(direction[1]);
    }

    public void collidesBot(){
        direction[1] = Math.abs(direction[1]) * (-1);
    }

    public void oppDirection(){
        direction[0] = direction[0] * (-1);
        direction[1] = direction[1] * (-1);
    }

    public void draw(Graphics g){
        g.setColor(this.color);
        g.fillOval((int)this.Xcoord, (int)this.Ycoord, this.size, this.size);
        g.setColor(Color.WHITE);
        g.fillOval((int)this.Xcoord+size/4, (int)this.Ycoord+size/4, this.size/2, this.size/2);
        Font tfont = new Font("Courier New", Font.PLAIN, size/2);
        g.setFont(tfont);
        g.setColor(Color.BLACK);
        g.drawString(this.ballNum + "", (int)this.Xcoord+size/3, (int)this.Ycoord+size*2/3);
    }
}