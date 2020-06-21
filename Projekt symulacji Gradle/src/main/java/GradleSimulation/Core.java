package GradleSimulation;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Budownictwo.*;
import Pojazdy.*;
import Obsluga.*;
public class Core {
	static Random rnd = new Random();
	static Map map;
	static Equipment[] eqt;
	public static void main(String[] args) 
	{
		Start();
		int x = GenerateLength();
		StartSimulate(x);
	}
	public static void StartSimulate(int length) 
	{
		map = new Map(length);
		List<Integer> builds = map.SpawnBuildings();
	 	eqt = new Equipment[] {
				new Equipment("Lekarz","Marcel Looker"),
				new Equipment("Sedzia sportu", "Michal Rublewski"),
				new Equipment("Stoper", "Kamil Malewicz")
		};
		System.out.println("Sklad grupy pomocniczej : ");
		{
			eqt[0].GetInfo();
			eqt[1].GetInfo();
			eqt[2].GetInfo();
		}
		System.out.println("Zaczynamy za 5 sekund");
		Sleep(5000);
		clearScreen();
		int time1 = 0, pos1 = 0;
		int time2 = 0, pos2 = 0;
		int flaga = 2;
		    while(flaga > 0) {
			System.out.println("==========================================");
			pos1 += (map.carlist.get(0)).GetSpeed();
			pos2 += (map.carlist.get(1)).GetSpeed();
			System.out.printf("%s : Time Mercedes-Benz = %d, Time BMW = %d \n",eqt[2].GetName(), time1, time2);
				if(builds.contains(pos1)) {
					Budynek tmp = map.getBuildingByPosition(pos1);
					if(tmp instanceof Serwis) {
					eqt[1].StartEvent(map.carlist.get(0), (Serwis)tmp);
					((Serwis)tmp).DisplayInfo();
					int spendtime = ((Serwis)tmp).SpendedTime();
					boolean x = ((Serwis)tmp).ChangeEngine(map.carlist.get(0));
					if(x) System.out.printf("Silnik zamieniony %s nowa szybkosc = %d km/h \n" , map.carlist.get(0).GetName(), map.carlist.get(0).GetSpeed());
					else
						System.out.printf("%s nie zmienia swoj silnik \n", map.carlist.get(0).GetName());
					time1 +=spendtime;
					} else
					if(tmp instanceof Hotel) {
					eqt[1].StartEvent(map.carlist.get(0), (Hotel)tmp);
					((Hotel)tmp).DisplayInfo();
					boolean x = ((Hotel)tmp).Sleep(map.carlist.get(0));
					if(x) time1 += ((Hotel)tmp).SleepTime;
						else 
							System.out.printf("%s %s zdecydowal nie odpoczywac \n",map.carlist.get(0).GetName(),map.carlist.get(0).GetModel());
					int spendtime = ((Hotel)tmp).SpendedTime();
					time1 += spendtime;
					} else 
					if(tmp instanceof PowerStation) {
					eqt[1].StartEvent(map.carlist.get(0), (PowerStation)tmp);
					((PowerStation)tmp).DisplayInfo();
					int charge = ((PowerStation)tmp).ChargeBattery(map.carlist.get(0));
					int spendtime = ((PowerStation)tmp).SpendedTime();
					time1 += spendtime;
					time1 += charge;
					} else
					if(tmp instanceof Shop) {
					eqt[1].StartEvent(map.carlist.get(0), (Shop)tmp);
					((Shop)tmp).DisplayInfo();
					((Shop)tmp).DrinkCoffee(map.carlist.get(0));
					int spendtime = ((Shop)tmp).SpendedTime();
					time1 += spendtime;
					}
				}
				if(builds.contains(pos2)) {
					Budynek tmp = map.getBuildingByPosition(pos2);
					if(tmp instanceof Serwis) {
					eqt[1].StartEvent(map.carlist.get(1), (Serwis)tmp);
					((Serwis)tmp).DisplayInfo();
					int spendtime = ((Serwis)tmp).SpendedTime();
					boolean x = ((Serwis)tmp).ChangeEngine(map.carlist.get(1));
					if(x) System.out.printf("Silnik zamieniony %s nowa szybkosc = %d km/h \n" , map.carlist.get(1).GetName(), map.carlist.get(0).GetSpeed());
					else
						System.out.printf("%s nie zmienia swoj silnik \n", map.carlist.get(1).GetName());
					time2 +=spendtime;
					} else
					if(tmp instanceof Hotel) {
					eqt[1].StartEvent(map.carlist.get(1), (Hotel)tmp);
					((Hotel)tmp).DisplayInfo();
					boolean x = ((Hotel)tmp).Sleep(map.carlist.get(1));
					if(x) time2 += ((Hotel)tmp).SleepTime;
						else 
							System.out.printf("%s %s zdecydowal nie odpoczywac \n",map.carlist.get(0).GetName(),map.carlist.get(0).GetModel());
					int spendtime = ((Hotel)tmp).SpendedTime();
					time2 += spendtime;
					} else
					if(tmp instanceof PowerStation) {
					eqt[1].StartEvent(map.carlist.get(0), (PowerStation)tmp);
					((PowerStation)tmp).DisplayInfo();
					int buf = ((PowerStation)tmp).ChargeBattery(map.carlist.get(1));
					int spendtime = ((PowerStation)tmp).SpendedTime();
					time2 += spendtime;
					time2 += buf;
					} else
					if(tmp instanceof Shop) {
					eqt[1].StartEvent(map.carlist.get(1), (Shop)tmp);
					((Shop)tmp).DisplayInfo();
					((Shop)tmp).DrinkCoffee(map.carlist.get(1));
					int spendtime =((Shop)tmp).SpendedTime();
					time2 += spendtime;
					}
				}
			if(pos1 < map.getLength() && pos2 < map.getLength()) {
				time1++;
				time2++;		
			} 
			else {
				flaga = 0;
				eqt[1].GetResult(map.carlist.get(0),map.carlist.get(1),time1,time2);
			}
			Sleep(700);
			int tmp_flag = CheckStamina(map.carlist.get(0),map.carlist.get(1));
			if(tmp_flag == 1) {
				boolean x = eqt[0].GetHelp(map.carlist.get(0));
				if(!x) flaga = 0;
			}
			if(tmp_flag == 2) {
				boolean x = eqt[0].GetHelp(map.carlist.get(1));
				if(!x) flaga = 0;
			}
			
			map.carlist.get(0).SetStamina(map.carlist.get(0).GetStamina()-2);
			map.carlist.get(1).SetStamina(map.carlist.get(1).GetStamina()-3);
			
			int tmp_flag2 = CheckEcoEngine(map.carlist.get(0),map.carlist.get(1));
			if(tmp_flag2 == 1) {
				flaga = 0;
			}
			if(tmp_flag2 == 2) {
				flaga = 0;
			}
		}
		
	}
	public static int CheckStamina(Car a, Car b) 
	{
		if(a.GetStamina()<10) 
			System.out.printf("[UWAGA ! Kierowca %s %s jest bardzo zmeczony!] \n",a.GetName(), a.GetModel());
		if(b.GetStamina()<10) 
			System.out.printf("[UWAGA ! Kierowca %s %s jest bardzo zmeczony!] \n",b.GetName(), b.GetModel());
		if(a.GetStamina()<=0) {
			return 1;
		} 
		else
		if(b.GetStamina()<=0) {
			return 2;
		}
		else return 0;
	}
	public final static void clearScreen()
	{
		for (int i = 0; i < 100; ++i) System.out.println();
	}
	public static int CheckEcoEngine(Car a, Car b) {
		if(a.GetEngine() instanceof EcoEngine) {
			if(a.GetEngine().GetPercentage() <= 0) {
				System.out.printf("Samochod %s %s nie ma ladunku zeby jechac!",a.GetName(), a.GetModel());
				return 1;
			}
			a.GetEngine().SetPercentage(a.GetEngine().GetPercentage()-1);
			System.out.printf("Silnik %s ma ladunek = %d\n",a.GetName(),a.GetEngine().GetPercentage());
		}
		if(b.GetEngine() instanceof EcoEngine) {
			if(b.GetEngine().GetPercentage() <= 0) {
				System.out.printf("Samochod %s %s nie ma ladunku zeby jechac!",b.GetName(), b.GetModel());
				return 2;
			}
			b.GetEngine().SetPercentage(b.GetEngine().GetPercentage()-1);
			System.out.printf("Silnik %s ma ladunek = %d\n",b.GetName(),b.GetEngine().GetPercentage());
		}
		return 0;
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
	public static void Start() 
	{
		System.out.println("Witmay w programie symulacji Racingu");
		System.out.println("Zyczymy udanej podrozy");
	}
	public static int GenerateLength() 
	{
		System.out.println("Wprowadz dlugosc drogi wieksza od 100");
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		sc.close();
		return length;
	}
}