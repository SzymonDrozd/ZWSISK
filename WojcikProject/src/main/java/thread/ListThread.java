package thread;

import java.util.List;
import java.util.concurrent.Callable;

public class ListThread implements Callable<Integer> {

	private String threadName;
	private List<Integer> list;

	private Integer result;

	public ListThread(String threadName, List<Integer> list) {
		this.threadName = threadName;
		this.list = list;

	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("Thread is starting: " + threadName);
		Integer sum = 0;
		for (Integer value : list) {
			sum += value;
		}
		return sum / list.size();
	}

}
