import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadException implements Runnable {

	@Override
	public void run() {
		throw new RuntimeException(); 
	}
	
}

public class ThreadWithExceptionTest{

	public static void main(String[] args) {
		System.out.println("method start");
		try {
			ExecutorService exec = Executors.newCachedThreadPool();
			exec.execute(new ThreadException());
		} catch (Exception e) {
			System.out.println("exception is caught! ");
		}
		System.out.println("method end");
	}
	
}
