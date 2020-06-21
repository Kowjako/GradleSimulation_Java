
package Budownictwo;
public abstract class Budynek {
	public String Name;
	private int time_relax;
	private int position;
	public void setPosition(int value) {
		this.position =value;
	}
	public int getPosition() {
		return this.position;
	}
	public Budynek(String n, int czas) {
		Name = n;
		time_relax = czas;
	}
	public int GetTimeRelax() {
		return time_relax;
	}
	public abstract void DisplayInfo(); 
	public abstract int SpendedTime(); 
}