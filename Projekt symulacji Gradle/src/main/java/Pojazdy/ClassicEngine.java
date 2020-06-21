package Pojazdy;

public class ClassicEngine implements Engine {
	private int power;
    public ClassicEngine(int pow) {
    	if(pow < 0) System.out.println("Niepoprawne dane"); else
    	power = pow;
    }
	public void Start() {
		System.out.println("Silnik klasyczny aktywowany");
	}
	public void Stop() {
		System.out.println("Silnik klasyczny zatrzymany");
	}
	public int GetPower() {
		return power;
	}
	public void SetPower(int value) {
		if(value < 0) System.out.println("Niepoprawne dane"); else
		power = value;
	}
	public int GetPercentage() {
		System.out.println("To jest silnik zwykły a nie elektryczny");
		return 0;
	}
	public void SetPercentage(int x) {}
	public void GetOilLevel() {}
	public int SetOilLevel() {return 0;}
}
