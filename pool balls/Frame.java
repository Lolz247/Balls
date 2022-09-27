import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.util.ArrayList;

public class Frame {
    private int frameWidth = Constant.FRAME_WIDTH;
    private int frameHeight = Constant.FRAME_HEIGHT;
    private int border = Constant.BORDER_SIZE;
    JFrame frame = new JFrame("Pool Table");
    Display display = new Display();
    BasicKeyListener keyListener = new BasicKeyListener();
    Backdrop backdrop = new Backdrop();
    ArrayList<Ball> balls = new ArrayList<Ball>();

    public Frame(){
        for(int i=1;i<=8;i++){
            balls.add(new Ball(i));
        }
    }

    public void setUp(){
            this.frame.setSize(this.frameWidth, this.frameHeight);
            this.frame.setLocationRelativeTo(null);
            this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.frame.setVisible(true);
            this.frame.add(this.display);
            this.frame.addKeyListener(this.keyListener);
    }

    public void runLoop(){
        while(true){
            update();
            this.frame.repaint();
            try{Thread.sleep(20);} catch(Exception e){};
        }
    }

    public void update(){
        for(Ball i:balls){
            i.move();
            if(i.getX() < border){
                i.collidesLeft();
            }
            if(i.getY() < border){
                i.collidesTop();
            }
            if(i.getX() > frameWidth-border*2-i.getSize()){
                i.collidesRight();
            }
            if(i.getY() > frameHeight-border*4-i.getSize()){
                i.collidesBot();
            }
        }
    }

    class Display extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);

            backdrop.draw(g);
            for(Ball i:balls){
                i.draw(g);
            }
        }
    }

    public class BasicKeyListener implements KeyListener{
        public void keyPressed(KeyEvent e){
            char key = e.getKeyChar();
            int num = 0;
            for(Ball i: balls){
                num++;
                if((key+"").equals(num+"")){
                    i.oppDirection();
                    break;
                }
            }
        }
        public void keyReleased(KeyEvent e){
        }
        public void keyTyped(KeyEvent e){
        }
    }
}