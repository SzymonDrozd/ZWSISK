package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ListManager {

	private int quantityOfThreads;
	private List<Integer> list;

	public ListManager(int quantityOfThreads, List<Integer> list) {
		this.quantityOfThreads = quantityOfThreads;
		this.list = list;
	}

	public Long manage() {
		Long sum = 0L;
		if (list != null) {
			if (quantityOfThreads != 0) {
				List<Future<Long>> futureResult = new ArrayList<>();
				int size = list.size() / quantityOfThreads;
				for (int i = 0; i < quantityOfThreads; i++) {
					List<Integer> newList = list.subList(i * size, (i + 1) * size);
					ExecutorService executorService = Executors.newSingleThreadExecutor();
					Future<Long> future = executorService.submit(new ListThread("Watek" + (i + 1), newList));
					futureResult.add(future);
				}
				for (int i = 0; i < futureResult.size(); i++) {
					try {
						sum += futureResult.get(i).get();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return sum;
	}

	// public Long manage() {
	// if (list != null && lists == null) {
	// if (quantityOfThreads == 1) {
	// try {
	// ExecutorService executorService = Executors.newSingleThreadExecutor();
	// Future<Long> future = executorService.submit(new ListThread("Watek1", list));
	// return future.get();
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (ExecutionException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// } else {
	// Long sum = 0L;
	// for (Integer value : list) {
	// sum += value;
	// }
	// return sum / list.size();
	// }
	//
	// } else {
	// if (lists != null) {
	// if (quantityOfThreads == 2) {
	// try {
	// List<Integer> tempList = lists.get(1);
	// tempList.addAll(lists.get(2));
	// ExecutorService executorService1 = Executors.newSingleThreadExecutor();
	// ExecutorService executorService2 = Executors.newSingleThreadExecutor();
	//
	// Future<Long> future1 = executorService1.submit(new ListThread("Watek1",
	// lists.get(0)));
	// Future<Long> future2 = executorService2.submit(new ListThread("Watek2",
	// tempList));
	// return (future1.get() + future2.get()) / 2;
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (ExecutionException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// } else if (quantityOfThreads == 1) {
	// try {
	// List<Integer> tempList = lists.get(0);
	// tempList.addAll(lists.get(1));
	// tempList.addAll(lists.get(2));
	// ExecutorService executorService = Executors.newSingleThreadExecutor();
	// Future<Long> future1 = executorService.submit(new ListThread("Watek1",
	// tempList));
	// return future1.get();
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (ExecutionException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// } else if (quantityOfThreads == 3) {
	// try {
	//
	// ExecutorService executorService1 = Executors.newSingleThreadExecutor();
	// ExecutorService executorService2 = Executors.newSingleThreadExecutor();
	// ExecutorService executorService3 = Executors.newSingleThreadExecutor();
	//
	// Future<Long> future1 = executorService1.submit(new ListThread("Watek1",
	// lists.get(0)));
	// Future<Long> future2 = executorService2.submit(new ListThread("Watek2",
	// lists.get(1)));
	// Future<Long> future3 = executorService3.submit(new ListThread("Watek3",
	// lists.get(2)));
	//
	// return (future1.get() + future2.get() + future3.get()) / 3;
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (ExecutionException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// } else {
	// System.out.println("Nieobsluzone opcje");
	// return null;
	// }
	//
	// } else
	// return null;
	// }
	// return null;
	// }

	// public Integer result() {
	// Integer res = manage();
	// return res;
	// }

}
