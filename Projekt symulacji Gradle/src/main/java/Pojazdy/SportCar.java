package Pojazdy;

public class SportCar extends Car {
	public SportCar(String mod, String n, Engine e, int speed, int mass, int stamina) {	
		super(n,e,speed, mass,mod,stamina);
	}
	@Override
	public int GetSpeed() {
		int power = super.speed * super.GetMass() + super.GetEngine().GetPower();
		int speed = 0;
		switch(power) {
		case 10 : {
			speed = 1;
			break;
		}
		case 11 : {
			speed = 2;
			break;
		}
		case 12:  {
			speed = 3;
			break;
		}
		case 13: {
			speed = 4;
			break;
		}
		default: {
			speed = 5;
			break;
		}
		}
		return speed;
	}
	public void SetSpeed(int value) {
		int _tmp;
		switch(value) {
		case 10 : {
			_tmp = 1;
			break;
		}
		case 11 : {
			_tmp = 2;
			break;
		}
		case 12:  {
			_tmp = 3;
			break;
		}
		case 13: {
			_tmp = 4;
			break;
		}
		default: {
			_tmp = 5;
			break;
		}
		}
		this.speed = _tmp;
	}
}