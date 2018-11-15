package thread;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ListManager {

	private int quantityOfThreads;
	private List<List> lists;
	private List<Integer> list;

	public ListManager(int quantityOfThreads, List<List> lists, List<Integer> list) {
		this.quantityOfThreads = quantityOfThreads;
		this.lists = lists;
		this.list = list;
	}

	public Integer manage() {
		if (list != null) {
			if (quantityOfThreads == 1) {
				try {
					ExecutorService executorService = Executors.newSingleThreadExecutor();
					Future<Integer> future = executorService.submit(new ListThread("Watek1", list));
					return future.get();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				Integer sum = 0;
				for (Integer value : list) {
					sum += value;
				}
				return sum / list.size();
			}

		} else {
			if (lists != null) {
				if (quantityOfThreads == 2) {
					try {
						List<Integer> tempList = lists.get(1);
						tempList.addAll(lists.get(2));
						ExecutorService executorService = Executors.newSingleThreadExecutor();
						Future<Integer> future1 = executorService.submit(new ListThread("Watek1", lists.get(0)));
						Future<Integer> future2 = executorService.submit(new ListThread("Watek2", tempList));
						return (future1.get() + future2.get()) / 2;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (quantityOfThreads == 1) {
					try {
						List<Integer> tempList = lists.get(0);
						tempList.addAll(lists.get(1));
						tempList.addAll(lists.get(2));
						ExecutorService executorService = Executors.newSingleThreadExecutor();
						Future<Integer> future1 = executorService.submit(new ListThread("Watek1", tempList));
						return future1.get();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (quantityOfThreads == 3) {
					try {

						ExecutorService executorService = Executors.newSingleThreadExecutor();
						Future<Integer> future1 = executorService.submit(new ListThread("Watek1", lists.get(0)));
						Future<Integer> future2 = executorService.submit(new ListThread("Watek2", lists.get(1)));
						Future<Integer> future3 = executorService.submit(new ListThread("Watek3", lists.get(2)));

						return (future1.get() + future2.get() + future3.get()) / 3;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println("Nieobsluzone opcje");
					return null;
				}

			} else
				return null;
		}
		return null;
	}

}
