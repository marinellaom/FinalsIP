import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.io.IOException;
import java.io.File;

public class MyFrame extends JFrame implements KeyListener{

	 Draw drawing;
	 Sound sound;

	 

	
	public MyFrame(){
	this.drawing = new Draw();
	this.sound = new Sound();

}

	public void keyPressed(KeyEvent e){
		
		
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
        else if(e.getKeyCode() == KeyEvent.VK_ALT){
            drawing.attack3();
            System.out.println("bow");
        }

       else if(e.getKeyCode() == KeyEvent.VK_ENTER){
            drawing.attack4();
            System.out.println("swordAttack1");
        }
        else if(e.getKeyCode() == KeyEvent.VK_SHIFT){
            drawing.attack5();
            System.out.println("swordAttack2");
        }
        else if(e.getKeyCode() == KeyEvent.VK_S){
			drawing.spawnEnemy();
			System.out.println("spawn enemy");
		}
		else if(e.getKeyCode() == KeyEvent.VK_P){
			sound.play();
			System.out.println("play sound");
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
	}
}