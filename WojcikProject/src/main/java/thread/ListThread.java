package thread;

import java.util.List;
import java.util.concurrent.Callable;

import sort.Sort;

public class ListThread implements Callable<Long> {

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
	public Long call() throws Exception {
		System.out.println("Thread is starting: " + threadName);
		Long sum = 0L;
		Sort sort = new Sort();
		sort.quickSort(list, 0, list.size()-1);
		if(list.size()!=0) {
			for (Integer value : list) {
				sum += value;
//				System.out.println(threadName + " : " + sum);
			}
			return sum / list.size();
		} else
			return sum;

	}

}
