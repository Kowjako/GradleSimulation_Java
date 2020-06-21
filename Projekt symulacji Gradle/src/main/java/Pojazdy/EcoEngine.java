package Pojazdy;

public class EcoEngine implements Engine {
	private int power;
	private int percentage = 100; 
    public EcoEngine(int pow) {
    	power = pow;
    	percentage = 100;
    }
	public void Start() {
		System.out.println("Silnik elektryczny aktywowany");
	}
	public void Stop() {
		System.out.println("Silnik elektryczny zatrzymany");
	}
	public int GetPower() {
		return power;
	}
	public void SetPower(int value) {
		power = value;
	}
	public int GetPercentage() {
		return this.percentage;
	}
	public void SetPercentage(int value) {
		percentage = value;
	}
}