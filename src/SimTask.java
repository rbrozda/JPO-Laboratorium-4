import java.util.TimerTask;
import java.util.Timer;

public class SimTask extends TimerTask
{
	private SimEngine poleSimEngine; //Prywatne pole do przechowywania obiektu klasy SimEngine.
	private SpringApplet poleSpringApplet;//Prywatne pole do przechowywania obiektu klasy SpringApplet
	private double odstepCzasowy;//Prywatne pole do przechowywania odstêpu czasowego pomiêdzy kolejnymi krokami symulacji
	
	
	//Konstruktor z parametrami pozwalaj¹cy na przypisanie do pól klasy obiektu klasy SimEngine,
	//obiektu klasy SpringApplet i odstêpu czasowego pomiêdzy kolejnymi krokami symulacji.

	public SimTask (SimEngine poleSimEngine, SpringApplet poleSpringApplet, double odstepCzasowy)
	{
		this.poleSimEngine = poleSimEngine;
		this.poleSpringApplet = poleSpringApplet;
		this.odstepCzasowy = odstepCzasowy;	
	}


	//Przeci¹¿ona, publiczna, bezparametrowa metoda run():
	public void run() 
	{
		poleSimEngine.symulacja(odstepCzasowy);	//uruchomienie obliczenia kolejnego kroku symulacji		
		poleSpringApplet.repaint();//odœwie¿enie wyœwietlania powierzchni appletu (
	}
}
