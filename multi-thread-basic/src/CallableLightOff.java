import java.util.concurrent.Callable;

public class CallableLightOff implements Callable<String>{
	private final int taskNo;
	public CallableLightOff(int taskNo) {
		this.taskNo = taskNo; 
	}
	
	@Override
	public String call() throws Exception {
		return "Task #" + taskNo; 
	}

}
