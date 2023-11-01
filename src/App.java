import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class App {
                public static JFrame frame;

    public static void main(String[] args) throws Exception {
        start();
}
 public static void start(){
    frame = new JFrame();
        frame.setBounds(700, 400, 600, 300);

        frame.setVisible(true);
        frame.setResizable(false);
        Game game = new Game();

        frame.add(game);
        game.requestFocus();
}

public static void stop(){
    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
}







}
