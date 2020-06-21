package Obsluga;

import java.util.Random;
import Budownictwo.Budynek;
import Budownictwo.Hotel;
import Budownictwo.PowerStation;
import Budownictwo.Serwis;
import Budownictwo.Shop;
import Pojazdy.Car;

public class Equipment {
	private String Name;
	private String klasa;
	public Equipment(String type, String Name) {
		klasa = type;
		this.Name = Name;
	}
	public void GetInfo() {
		System.out.println("Imie : "+Name+" Rola : "+klasa);
		System.out.println("=========================================");
	}
	public String GetName() {
		return Name;
	}
	public boolean GetHelp(Car a) {
		Random rnd = new Random();
		switch(klasa) {
		case "Lekarz": {
			int decision = rnd.nextInt(2);
			System.out.println("=========================================");
			System.out.print(this.GetName() + " : ");
			System.out.println("Wyscigi zatrzymane z powodu zlego stanu kierowcy..");
			if(decision == 1) {
				a.SetStamina(50);
				System.out.println("Kontynujemy, lekarz pomogl, kierowca juz zdrowy");
				return true;
			} 
			else {
				System.out.println("Niestety lekarz nie pomogl pacjentowi.. ");
				System.out.println("Wyscigi zakonczone z powodu awarii!");
				System.out.println("=========================================");
				return false;
			}
		}
		default : {
				System.out.println("Nie moge czyms pomoc, niestety!");
				return false;
		}
		}
	}
	public void GetResult(Car a, Car b, int time0, int time1) {
		System.out.println("==========================================");
		System.out.println(this.GetName());
		if(time0 < time1) {
			System.out.printf("%s %s wygral wyscigi z czasem %d\n",a.GetName(),a.GetModel(),time0);
			System.out.printf("%s %s przegral wyscigi z czasem %s\n",b.GetName(),b.GetModel(),time1);
			System.out.println("==========================================");
		}
		if(time0 > time1) {
			System.out.printf("%s %s wygral wyscigi z czasem %d\n",b.GetName(),b.GetModel(),time1);
			System.out.printf("%s %s przegral wyscigi z czasem %d\n",a.GetName(),a.GetModel(),time0);
			System.out.println("==========================================");
		}
		if(time0 == time1) {
			System.out.printf("%s %s ma remis z %s %s\n",b.GetName(),b.GetModel(),a.GetName(),a.GetModel());
			System.out.println("==========================================");
		}
	}
	public void StartEvent(Car a, Budynek b) {
		System.out.println("==========================================");
		System.out.print(this.Name+" : ");
		if(b instanceof Hotel) System.out.printf("%s %s przyjechal do Hotelu\n",a.GetName(),a.GetModel());
		if(b instanceof PowerStation) System.out.printf("%s %s przyjechal do Stacji Paliw\n",a.GetName(),a.GetModel());
		if(b instanceof Serwis) System.out.printf("%s %s przyjechal do Serwisu\n",a.GetName(),a.GetModel());
		if(b instanceof Shop) System.out.printf("%s %s przyjechal do Sklepu\n",a.GetName(),a.GetModel());
		System.out.println("==========================================");
	}
}