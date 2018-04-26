public class Vector2D {
	public double wspolrzednaX, wspolrzednaY; //publiczne pola wspó³rzêdnych wektora (x, y).
	
	public Vector2D() //konstruktor domyœlny inicjuj¹cy pola klasy zerami
	{
		wspolrzednaX = 0;
		wspolrzednaY = 0;
	}
	
	public Vector2D (double x, double y) //konstruktor z parametrami pozwalajacy na nadanie dowolnych wartoœci polom klasy.
	{
		wspolrzednaX = x;
		wspolrzednaY = y;
	}
	
	public double getX() //akcesor parametru 'wspolrzednaX'
	{
		return wspolrzednaX;
	}
	
	public double getY() //akcesor parametru 'wspolrzednaY'
	{
		return wspolrzednaY;
	}
	
	
	//Metoda z parametrem zwracaj¹ca nowy obiekt klasy Vector2D, bêd¹cy sum¹ wektora, dla
	//którego zosta³a wywo³ana i wektora podanego jako parametr.
	
	Vector2D sumaWektorow(double x, double y)
	{
		double sumaX = getX() + x;
		double sumaY = getY() + y;
		
		Vector2D wynik = new Vector2D(sumaX,sumaY);
		
		return wynik; //zwrócenie obiektu
	}
	
	
	//Metoda z parametrem zwracaj¹ca nowy obiekt klasy Vector2D, bêd¹cy ró¿nic¹ wektora, dla
	//którego zosta³a wywo³ana i wektora podanego jako parametr.
	
	Vector2D roznicaWektorow(double x, double y)
	{
		double roznicaX = getX() - x;
		double roznicaY = getY() - y;
		
		Vector2D wynik = new Vector2D(roznicaX,roznicaY);
		
		return wynik; //zwrócenie obiektu
	}
	
	
	//Metoda z parametrem zwracaj¹ca nowy obiekt klasy Vector2D, bêd¹cy przemno¿onym przez
	//sta³¹ wektorem, dla którego zosta³a wywo³ana.
	
	Vector2D iloczynWektora(double stala)
	{
		double iloczynX = stala * getX();
		double iloczynY = stala * getY();
		
		Vector2D wynik = new Vector2D(iloczynX,iloczynY);
		
		return wynik; //zwrócenie obiektu
	}
	
	
	//Metoda bez parametrów zwracaj¹ca d³ugoœæ wektora
	public double getDlugosc() 
	{
		double dlugosc = Math.sqrt((getX()*getX()) + (getY()*getY()));
		return dlugosc;
	}
	
	
	//Metoda bez parametrów zwracaj¹ca nowy obiekt klasy Vector2D, bêd¹cy
	//znormalizowanym wektorem, dla którego zosta³a wywo³ana.
	Vector2D wektorNormalny()
	{
		double normalnyX = getX() / getDlugosc();
		double normalnyY = getY() / getDlugosc();
		
		Vector2D wynik = new Vector2D(normalnyX,normalnyY);
		return wynik; //zwrócenie obiektu
	}
}
	
	
	
	
	
	/*public static void main(String[] args)
	{
		SpringApplet test = new SpringApplet();
		test.init();
	}
}*/








