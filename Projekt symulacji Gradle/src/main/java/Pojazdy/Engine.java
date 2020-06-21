package Pojazdy;
public interface Engine {
	void Start();
	void Stop();
	int GetPower();
	int GetPercentage();
	void SetPercentage(int val);
}