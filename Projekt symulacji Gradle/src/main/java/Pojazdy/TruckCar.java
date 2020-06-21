package Pojazdy;

public class TruckCar extends Car {
	private int packagemass = 10;
	private int packs = 0;
	public TruckCar(String mod, String n, Engine e, int speed, int mass, int stamina, int packs) {	
		super(n,e,speed, mass,mod,stamina);
		this.packs = packs;
	}
	public void SetPackageMass(int n, int mass) {
		packagemass = n*mass;
	}
	public int GetPackageMass() {
		return packs * packagemass;
	}
	@Override
	public int GetSpeed() {
		int power = super.speed * (super.GetMass()+ this.GetPackageMass()) + super.GetEngine().GetPower();
		int speed = 0;
		switch(power) {
		case 20 : {
			speed = 7;
			break;
		}
		case 21 : {
			speed = 5;
			break;
		}
		case 22:  {
			speed = 4;
			break;
		}
		case 23: {
			speed = 3;
			break;
		}
		default: {
			speed = 4;
			break;
		}
		}
		return speed;
	}
	public void SetSpeed(int value) {
		super.speed = value;
	}
}