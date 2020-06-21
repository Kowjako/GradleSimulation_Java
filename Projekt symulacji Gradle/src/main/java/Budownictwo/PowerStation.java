package Budownictwo;

import java.util.Random;

import Pojazdy.Car;
import Pojazdy.EcoEngine;

public class PowerStation extends Budynek {
	private Random rnd = new Random();
	private final int chargetime = 1;
	public PowerStation(String name, int time) {
		super(name,time);
	}
	@Override
	public void DisplayInfo() {
		System.out.printf("Witamy Pana na Stacji Eco-Paliw {%s} \n",super.Name);
	}
	@Override
	public int SpendedTime() {
		int out_time = rnd.nextInt(15)+5;
		return super.GetTimeRelax() + out_time;
	}
	public int ChargeBattery(Car a) {
		if(a.GetEngine() instanceof EcoEngine) 
		{
		   int currentBattery = a.GetEngine().GetPercentage();
		   int chargeTime = (100 - currentBattery) * chargetime;
		   a.GetEngine().SetPercentage(100);
		   System.out.printf("Samochod naladowany, czas ladowania = %d m \n",chargeTime);
		   return chargeTime;
		}
		else  
		{
			System.out.println("Przepraszamy, ale to stacja dla eco-pojazow. Do widzenia!");
			return 0;
		}
	}
}