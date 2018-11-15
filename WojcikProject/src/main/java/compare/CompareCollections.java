package compare;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompareCollections {

	public List<List> compareArrays(List<Integer> list1, List<Integer> list2) {
		List<List> listOfSets = new ArrayList<List>();

		List<Integer> copiedList1 = new ArrayList(list1);
		List<Integer> copiedList2 = new ArrayList(list2);

		List<Integer> copiedList3 = new ArrayList(list1);
		List<Integer> copiedList4 = new ArrayList(list2);

		List<Integer> commonSet = new ArrayList<Integer>();

		copiedList1.removeAll(list2);
		copiedList2.removeAll(list1);

		copiedList3.removeAll(copiedList1);
		copiedList4.removeAll(copiedList2);

		commonSet.addAll(copiedList3);
		commonSet.addAll(copiedList4);
		listOfSets.add(copiedList1);
		listOfSets.add(copiedList2);
		listOfSets.add(commonSet);

		return listOfSets;
	}

	public List<List> compareArrays2(List<Integer> list1, List<Integer> list2) {
		List<List> listOfSets = new ArrayList<List>();
		List<Integer> copy1 = new ArrayList(list1);
		List<Integer> copy2 = new ArrayList(list2);
		List<Integer> commonSet = new ArrayList<>();

		Iterator<Integer> iterator1 = copy1.iterator();
		Iterator<Integer> iterator2 = copy2.iterator();

		Integer a = copy1.stream().findFirst().get();
		Integer b = copy2.stream().findFirst().get();

		while (iterator1.hasNext() && iterator2.hasNext()) {
			if (a.equals(b)) {
				a = iterator1.next();
				b = iterator2.next();
				commonSet.add(a);
				copy1.remove(a);
				copy2.remove(b);
			} else if (a < b) {
				a = iterator1.next();
			} else {
				b = iterator2.next();
			}

		}
		listOfSets.add(copy1);
		listOfSets.add(copy2);
		listOfSets.add(commonSet);
		return listOfSets;

	}

}
