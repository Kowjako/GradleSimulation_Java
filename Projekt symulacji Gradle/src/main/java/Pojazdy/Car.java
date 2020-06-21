package Pojazdy;

public abstract class Car {
	private Engine engine;   
	private int mass;
	private String model;
	private int stamina;
	public int position;
	String Name;
	public int speed;
	public Car(String Name, Engine engine, int speed, int mass,String model, int stamina) {
		this.Name = Name;
		this.engine = engine;
		this.speed = speed;
		this.mass = mass;
		this.model = model;
		this.stamina = stamina;
	}
	public String GetModel() {
		return this.model;
	}
	public void SetModel(String value) {
		if(value != null)
		model = value; else
		System.out.println("Niepoprawne dane");
	}
	public String GetName() {
		return this.Name;
	}
	public int GetStamina() {
		return stamina;
	}
	public void SetStamina(int value) {
		stamina = value;
	}
	public Engine GetEngine() {
		return this.engine;
	}
	public void SetEngine(Engine e) {
		this.engine = e;
	}
	public int GetMass() {
		return mass;
	}
	public abstract int GetSpeed();
}
