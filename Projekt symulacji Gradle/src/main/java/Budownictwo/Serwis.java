package Budownictwo;
import java.util.Random;
import Pojazdy.*;
public class Serwis extends Budynek {
	private String Stars;
	private Random rnd = new Random();
	public Serwis(String name, int time) {
		super(name,time);
	}
	public void SetStars(String st) {
		Stars = st;
	}
	@Override
	public void DisplayInfo() {
		if(Stars == null) {
			Stars = "**";
			System.out.printf("Witamy w Serwisie [%s] serwis ma %s gwiazdy \n",super.Name,Stars);
		}
		else
			System.out.printf("Witamy w Serwisie [%s] serwis ma %s gwiazdy \n",super.Name,Stars);
	}
	@Override
	public int SpendedTime() {
		int out_time = rnd.nextInt(15) + 5;
		return super.GetTimeRelax() + out_time;
	}
	public boolean ChangeEngine(Car a) {
		System.out.println("Chcesz zamienic silnik?");
		System.out.println("Proponujemy silniki Elektryczny - 1 oraz Standardowy - 2, nie wymieniac - 3");
	    int i = rnd.nextInt(4)+1;
	    System.out.println(i);
	    switch(i) {
	    case 1: {
	    	if(a instanceof SportCar) {
	    		int power = rnd.nextInt(5) + 1;
		    	Engine newEngine = new EcoEngine(power);
		    	int newspeed = newEngine.GetPower() + a.GetMass() * a.speed;
		    	((SportCar)a).SetSpeed(newspeed);
		    	a.SetEngine(newEngine);
		    	return true;
	    	}
	    	if(a instanceof TruckCar) {
	    		int power = rnd.nextInt(5) + 1;
		    	Engine newEngine = new EcoEngine(power);
		    	int newspeed = newEngine.GetPower() + a.GetMass() * a.speed;
		    	((TruckCar)a).SetSpeed(newspeed);
		    	a.SetEngine(newEngine);
		    	return true;	
	    	}
	    }
	    case 2: {
	    	if(a instanceof SportCar) {
	    		int power = rnd.nextInt(4) + 2;
		    	Engine newEngine = new ClassicEngine(power);
		    	int newspeed = newEngine.GetPower() + a.GetMass()*a.speed;
		    	((SportCar)a).SetSpeed(newspeed);
		    	a.SetEngine(newEngine);
		    	return true;
	    	}	    	
	    	if(a instanceof TruckCar) {
	    		int power = rnd.nextInt(4) + 2;
		    	Engine newEngine = new ClassicEngine(power);
		    	int newspeed = newEngine.GetPower() + a.GetMass()*a.speed;
		    	((TruckCar)a).SetSpeed(newspeed);
		    	a.SetEngine(newEngine);
		    	return true;
	    	}	
	    }
	    case 3: {
	    	System.out.println("To jest Pana(i) wola! Do widzenia!");
	    	break;
	    }
	    default: {
	    	System.out.println("Niepoprawny klawisz");
	    	break;
	    }
	    }
	    return false;
	}
}