import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class SpringApplet extends JApplet implements MouseListener, MouseMotionListener, ActionListener{ //Informacja o implementacji interfejsu MouseListener i interfejsu MouseMotionListener przez
	//klas� SpringApplet (s�owo kluczowe �implements�).
	
	private SimEngine poleSimEngine; //Prywatne pole do przechowywania obiektu klasy SimEngine.
	private SimTask poleSimTask; //Prywatne pole do przechowywania obiektu klasy SimTask.
	private Timer poleTimer; //Prywatne pole do przechowywania obiektu klasy Timer.
	
	//Prywatne pole do przechowywania warto�ci logicznej m�wi�cej czy w danym momencie
	//nast�puje �przeci�ganie� kursora myszy
	private boolean dragging;
	
	
	//Metody konieczne do implementacji interfejs�w MouseListener i MouseMotionListener.

	@Override
	public void mouseDragged(MouseEvent dragged) {
		// TODO Auto-generated method stub
		
		if(dragging)
		{
			x = dragged.getX(); //odczytanie pozycji kursora myszy
			y = dragged.getY();
			
			y = poleSimEngine.getMassY();
			
			repaint();  
		}
		
		dragged.consume();
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	private double x, y;
	
	@Override
	public void mousePressed(MouseEvent pressed) {
		// TODO Auto-generated method stub
		
		//odczytanie po�o�enia kursora
		x = pressed.getX();
		y = pressed.getY();	
		
		//sprawdzenie czy pozycja kursora znajduje si� w obr�bie ko�a przedstawiaj�cego mas�
		if((x>=480) && (x<=520) && (y>=10+(int)(poleSimEngine.getMassY())) && (y<=50+(int)(poleSimEngine.getMassY())))
		{
			poleTimer.cancel(); //wy��czenie timera
			
			dragging = true; //ustawienie warto�ci logicznej 1 dla pola stanu myszy
		}
		
		pressed.consume(); //wywo�anie metody consume() dla obiektu typu MouseEvent.
	}

	@Override
	public void mouseReleased(MouseEvent released) {
		// TODO Auto-generated method stub
		
		if(dragging = true)
		{
			poleTimer.scheduleAtFixedRate(poleSimTask,0,20);
			dragging = false;
		}
		
		released.consume();
		
	}
	
	
	//Przeci��ona, publiczna, bezparametrowa metoda init():
		public void init( )
		{		
			setSize(1000,1000);//Rozmiar okienka apletu
			
			//utworzenie nowego obiektu klasy SimEngine za pomoc� konstruktora z parametrami
			//i przypisanie go do pola
			SimEngine obiektSimEngine = new SimEngine(50,1,0.8,0.3,10,5,5,5,4,5,10);
			poleSimEngine = obiektSimEngine;
			
			//utworzenie nowego obiektu klasy SimTask za pomoc� konstruktora z parametrami
			//i przypisanie go do pola
			poleSimTask = new SimTask(obiektSimEngine,this,1.5);
			
			//Utworzenie obiektu klasy Timer
			poleTimer = new Timer();
			poleTimer.scheduleAtFixedRate(poleSimTask,0,20);
			
			
			dragging = false;
			addMouseListener(this); //dodanie �nas�uchiwacza� myszy do appletu � addMouseListener()
			addMouseMotionListener(this); //dodanie �nas�uchiwacza� ruchu myszy do appletu � addMouseMotionListener()
		}

		//Przeci��ona, publiczna, metoda paint() z parametrem typu Graphics
		public void paint(Graphics g)
		{
			Graphics2D g2 =  (Graphics2D) g;
			
			g.setColor(Color.GRAY); //Kolor t�a
			g.fillRect(0, 0, 1000, 1000); 
			
			g.setColor(Color.RED);//Kolor linki - czerwony
			
			g2.setStroke(new BasicStroke(4));//Grubo�� linki - 4
			g.drawLine(500,10,500,10+(int)(poleSimEngine.getMassY())); //narysowanie linii reprezentuj�cej spr�yn� + symulacja zmiany po�o�enia
			
			g2.setStroke(new BasicStroke(2));
			g.setColor(Color.GREEN);//Kolor kulki - zielony
			g.fillOval(480,10+(int)(poleSimEngine.getMassY()),40,40); //narysowanie owalu reprezentuj�cego mas� + symulacja zmiany po�o�enia
		}

		
		
		//Metoda konieczna do implementacji interfejsu ActionListener.
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		private JButton przyciskUstawien;
		private JButton przyciskReset;
		
		
		
		
		
		
		

	
}









