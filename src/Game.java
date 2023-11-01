import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel implements ActionListener, KeyListener {
    public class Padle{

        int x;
        int y;
        Padle(int x, int y){
            this.x =  x;
            this.y =  y;

        }
    }
    Padle padle;
    Ball ball;
    int xvel = 2;
    int yvel = 2;
    int smer = 0;
    Timer timer;
    int BrickH = 150/3;
    int BrickW = 600/10;
    int[][] map;
    int nb = 50;
    int m = 1;
  
    public class Ball{
    int x;
        int y;
        Ball(int x, int y){
            this.x =  x;
            this.y =  y;

        }




    }

    Game(){
    setBackground(Color.black);    
    setFocusable(true);
    padle = new Padle(300,250 );
    addKeyListener(this);
    timer = new Timer(1,this);
        timer.start();
    ball = new Ball(300, 200);


        map = new int[10][5];

  
     
        for(int i = 0; i < 5; i++){
             for(int y = 0; y < 10; y++){
                 map[y][i] = 1;
     
     
     
             }
     
     
        }



    }

    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(padle.x, padle.y, 60, 10);

        g.setColor(Color.red);
        g.fillOval(ball.x, ball.y, 20, 20);
        
            g.setColor(Color.blue);
            g.setFont(new Font("MV Boli", Font.BOLD, 25));
            g.drawString("Score: " + (50-nb), 0, 150);
            g.setColor(Color.yellow);

        for(int i = 0; i < 5; i++){
             for(int y = 0; y < 10; y++){

                int a = i+y;
                if(a < 3){
                    g.setColor(Color.RED);
                }
                 else if(a < 6){
                    g.setColor(Color.YELLOW);
                }
               else if(a < 9){
                    g.setColor(Color.GREEN);
                }
                 else if(a < 12){
                    g.setColor(Color.CYAN);
                }
                else{
                    g.setColor(Color.BLUE);
                }



                if(map[y][i] == 1){
                g.fillRect(y*60, i*15,55,12 );
                
            }
     
     
    
             }
     
            
     
        }

      




    }

    public void move(){
        if(ball.y > 300){
            timer.stop();
        
        
        JOptionPane.showMessageDialog(null,"Zedols, skóre: "+(50-nb));
        App.stop();



        
        int input = JOptionPane.showConfirmDialog(null, "Steš ísť znova?");
        if(input == 0){
        App.start();
        
        }
        else{
            System.exit(0);
        }


        }

        if(nb == 0){
            JOptionPane.showMessageDialog(null,"Vyhrals!");
            App.stop();
             int input = JOptionPane.showConfirmDialog(null, "Steš ísť znova?");
        if(input == 0){
        App.start();
        
        }
        else{
            System.exit(0);
        }
        }

        if(new Rectangle(ball.x, ball.y,20,20).intersects(new Rectangle(padle.x, padle.y ,60,10))){
            yvel = -yvel;

        }

        for(int i = 0; i < 5; i++){
             for(int y = 0; y < 10; y++){
               if(map[y][i] == 1){

                if(new Rectangle(ball.x, ball.y,20,20).intersects(new Rectangle(y*60, i*15,55,12))){
                   yvel = -yvel;
                   nb--;
                   map[y][i] = 0; 
               }
            }
              
               }
                
            }
     
     
     
             
     
     
        


       

        if(ball.x == 570|| ball.x == 0){
            xvel = -xvel;
        }
        if(ball.y == 600|| ball.y == 0){
            yvel = -yvel;
        }
        


     
        ball.x += xvel;
        ball.y += yvel;

        


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT&&padle.x != 540){
            padle.x += 20;
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT&& padle.x!= 0){
            padle.x -= 20;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
    


}
