package Budownictwo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import Pojazdy.Car;
import Pojazdy.ClassicEngine;
import Pojazdy.EcoEngine;
import Pojazdy.Engine;
import Pojazdy.SportCar;
import Pojazdy.TruckCar;

public class Map {
	public List<Car> carlist = new LinkedList<Car>();
	public List<Budynek> buildinglist = new ArrayList<Budynek>();
	private int tracklength = 0;
	public Map(int track) {
		this.tracklength = track;
	}
	public int getLength() {
		return this.tracklength;
	}
	public List<Integer> SpawnBuildings() 
	{
		Engine engine1 = new ClassicEngine(1);
		Engine engine2 = new EcoEngine(4);
		TruckCar car1 = new TruckCar("XC","Volvo",engine1,2,5,100,3);
		SportCar car2 = new SportCar("M2","BMW",engine2,4,2,100);
		Hotel[] hotel = new Hotel[] {
				new Hotel("Alfa - Centaur",6),
				new Hotel("DoubleTree",5),
				new Hotel("Starlet",7)
		};
		Serwis[] serwis = new Serwis[] {
				new Serwis("Twoj pojazd",3),
				new Serwis("Swiat samochodow",4),
				new Serwis("Zlote rece",5)
		};
		Shop[] shop = new Shop[] {
				new Shop("Biedornka",1),
				new Shop("Zabka",1),
				new Shop("Auchan",2),
				new Shop("Carrefour",1),
				new Shop("KFC",2)
		};
		PowerStation[] station = new PowerStation[] {
				new PowerStation("A-100",4),
				new PowerStation("Orlen",5)
		};
		Sleep(3000);
		System.out.println("Pierwszy pojazd prygotowany:");
		Sleep(3000);
		System.out.printf("%s %s szybkosc = %d km/h \n", car1.GetName(), car1.GetModel(), car1.GetSpeed()*75);
		car1.GetEngine().Start();
		Sleep(3000);
		System.out.println("Drugi pojazd prygotowany: ");
		Sleep(3000);
		System.out.printf("%s %s szybkosc = %d km/h \n", car2.GetName(), car2.GetModel(), car2.GetSpeed()*75);
		car2.GetEngine().Start();
		Sleep(3000);
		System.out.printf("Przewidywana droga : %d km \n",tracklength);
		Sleep(3000);
		System.out.println("Obiekty umieszczone na drodze!");
		Sleep(3000);
		carlist.add(car1);
		carlist.add(car2);
		buildinglist.add(hotel[0]);
		buildinglist.add(hotel[1]);
		buildinglist.add(hotel[2]);
		buildinglist.add(serwis[0]);
		buildinglist.add(serwis[1]);
		buildinglist.add(serwis[2]);
		buildinglist.add(station[0]);
		buildinglist.add(station[1]);
		buildinglist.add(shop[0]);
		buildinglist.add(shop[1]);
		buildinglist.add(shop[2]);
		buildinglist.add(shop[3]);
		buildinglist.add(shop[4]);
		Random rnd = new Random();
		carlist.get(0).position = 0;
		carlist.get(1).position = 0;
		/** Spawn Buildings **/
		List<Integer> tmp = new ArrayList<Integer>();
		for(int i=0;i<13;i++) {
			int pack = rnd.nextInt(tracklength);
			buildinglist.get(i).setPosition(pack);
			tmp.add(pack);
		}
		return tmp;
	}
	public Budynek getBuildingByPosition(int pos) {
		for(int i=0;i<13;i++) {
			if(buildinglist.get(i).getPosition() == pos) return buildinglist.get(i);
		}
		return null;
	}
	public static void Sleep(int time) 
	{
		try 
		{
			Thread.sleep(time);
		} 
		catch(InterruptedException ex) 
		{
			System.out.println("Blad programu ERROR!");
		}
	}
}
