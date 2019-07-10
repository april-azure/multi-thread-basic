
class Sleeper extends Thread {
	private final int duration;
	public Sleeper(String name, int duration) {
		super(name);
		this.duration = duration;
		start();
	}
	
	public void run() {
		try {
			sleep(duration); 
		} catch (InterruptedException e) {
			System.out.println(getName() + " was interrupted. " + " isInterrupted() : " + isInterrupted());
			return;
		}
		System.out.println(getName() + " awaken");		
	}
}

class Joiner extends Thread {
	private Sleeper sleeper;
	public Joiner(String name, Sleeper sleeper) {
		super(name); 
		this.sleeper = sleeper;
		start(); 
	}
	
	public void run() {
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			System.out.println(getName() + " is interrpted");
		}
		System.out.println(getName() + " join completed");
	}
}

public class JoinThreadTest {
	public static void main(String[] args) {
		Sleeper 
			sleeper = new Sleeper("Sleepy", 1500),
			grumpy = new Sleeper("Grumpy", 1500);
		Joiner
			dopey = new Joiner("dopey", sleeper),
			doc = new Joiner("doc", grumpy);
		grumpy.interrupt();
		// this will set the interrupt flag for grumpy as true, 
		// however the flag is cleared when the exception is called. 
	}
}
