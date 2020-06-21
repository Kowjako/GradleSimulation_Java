package Budownictwo;

import java.util.Random;

import Pojazdy.Car;

public class Shop extends Budynek {
	private String kategoria;
	private Random rnd = new Random();
	public Shop(String name, int time) {
		super(name,time);
	}
	public void SetType(String value) {
		kategoria = value;
	}
	@Override
	public void DisplayInfo() {
		if(kategoria == null) {
			kategoria = "zwykly";
			System.out.printf("Witamy w Sklepie =%s= Kategoria: %s \n",super.Name, kategoria);
		}
		else
			System.out.printf("Witamy w Sklepie =%s= Kategoria: %s \n",super.Name, kategoria);
	}
	@Override
	public int SpendedTime() {
		int out_time = rnd.nextInt(7)+3;
		return super.GetTimeRelax() + out_time;
	}
	public void DrinkCoffee(Car a) {
		if(a.GetStamina() > 50) {
			System.out.println("Proponujemy Panu wypic kawe! 1-TAK , 2- NIE");
			System.out.printf("Pana stamina wynosi = %d \n",a.GetStamina());
			int change = rnd.nextInt(2)+1;
			System.out.println(change);
			switch(change) {
			case 1: {
				a.SetStamina(100);
				break;
			}
			case 2: {
				System.out.println("Zapraszamy ponownie na kawe!");
				break;
			}
			default: {
				System.out.println("Niepoprawny klawisz zostal nacisniety!");
				break;
			}
			}
		}
		if(a.GetStamina() <= 50) {
			System.out.println("Pan jest bardzo zmeczony!");
			System.out.printf("Pana stamina wynosi = %d \n",a.GetStamina());
			System.out.println("Proponujemy Panu wypic kawe! 1-TAK , 2- NIE");
			int change = rnd.nextInt(2)+1;
			System.out.println(change);
			switch(change) {
			case 1: {
				a.SetStamina(100);
				break;
			}
			case 2: {
				System.out.println("Radze panu odpoczac lub jechac bardzo powoli!");
				break;
			}
			default: {
				System.out.println("Niepoprawny klawisz zostal nacisniety!");
				break;
			}
			}
		}
	}	
}