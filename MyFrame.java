import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;

public class MyFrame extends JFrame implements KeyListener{

	 Draw drawing;
	
	public MyFrame(){
	this.drawing = new Draw();
}

	public void keyPressed(KeyEvent e){
		System.out.println("boom!");
		
		if(e.getKeyCode() == KeyEvent.VK_UP){
			drawing.moveUp();
			System.out.println("pos:" + drawing.x + "," + drawing.y);	
		}

		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			drawing.moveDown();
			System.out.println("pos:" + drawing.x + "," + drawing.y);		
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			drawing.moveRight();
			System.out.println("pos:" + drawing.x + "," + drawing.y);	
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT){
			drawing.moveLeft();
			System.out.println("pos:" + drawing.x + "," + drawing.y);	
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            drawing.attack();
            System.out.println("kick");
        }
        else if(e.getKeyCode() == KeyEvent.VK_J){
            drawing.attack2();
            System.out.println("jump");
        }
        else if(e.getKeyCode() == KeyEvent.VK_SHIFT){
            drawing.attack3();
            System.out.println("bow");
        }

       else if(e.getKeyCode() == KeyEvent.VK_ENTER){
            drawing.attack4();
            System.out.println("attack");
        }
        else if(e.getKeyCode() == KeyEvent.VK_ALT){
            drawing.attack5();
            System.out.println("attack2");
        }
		drawing.reloadImage();
	}

	public void keyReleased(KeyEvent e){

	}

	public void keyTyped(KeyEvent e){

	}

	public static final Color LIGHT = new Color(255,255,204);

	public static void main (String[] args){

		MyFrame  gameFrame = new MyFrame();

		gameFrame.setSize(620,600);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
		gameFrame.getContentPane().add(gameFrame.drawing);
		gameFrame.getContentPane().setBackground(LIGHT);
		gameFrame.addKeyListener(gameFrame);
		System.out.println("practical programming");
	}


}