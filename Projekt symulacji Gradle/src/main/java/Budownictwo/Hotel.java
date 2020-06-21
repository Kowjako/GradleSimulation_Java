
package Budownictwo;

import java.util.Random;

import Pojazdy.Car;

public class Hotel extends Budynek {
	private int klasa = 0;
	private Random rnd = new Random();
	public Hotel(String name, int time) {
		super(name,time);
	}
	public void SetType(int value) {
		klasa = value;
	}
	@Override
	public void DisplayInfo() {
		if(klasa == 0) {
			klasa = 1; 
			System.out.printf("Witamy w Hotelu <%s> klasy %s \n",super.Name, klasa);
		} else
		System.out.printf("Witamy w Hotelu <%s> klasy %s \n",super.Name, klasa);
	}
	@Override
	public int SpendedTime() {
		int out_time = rnd.nextInt(10)+5;
		return super.GetTimeRelax() + out_time;
	}
	public boolean Sleep(Car a) {
			System.out.println("Proponujemu Panu odpoczac godzinke w najlepszym hotelu");
			System.out.println("Chcesz odpoczac? 1-TAK, 2-NIE");
			System.out.printf("Stamina = %d \n", a.GetStamina());
			int change = rnd.nextInt(2)+1;
			System.out.println(change);
			switch(change) {
			case 1: {
				a.SetStamina(100);
				System.out.println("Dziekujemy za wizyte, milej drogi!");
				return true;			
			}
			case 2: {
				if(a.GetStamina()<50)
				System.out.println("Radze panu odpoczac lub jechac bardzo powoli!");
				System.out.println("Dziekujemy za wizyte, milej drogi!");
				break;
			}
			default: {
				System.out.println("Niepoprawny klawisz zostal nacisniety!");
				break;
			}
			}
		return false;
	}
	public final int SleepTime = 5;
}