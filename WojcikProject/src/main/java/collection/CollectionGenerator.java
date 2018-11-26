package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class CollectionGenerator {
	
	private int size;
	private int range;
	
	public CollectionGenerator(int size, int range) {
		this.size = size;
		this.range = range;
	}
	
	public List<Integer> generateCollection(){
		List<Integer> dataSet = new ArrayList<Integer>();
		Random rand = new Random();
		while(dataSet.size() < size) {
			Integer value = rand.nextInt(range) + 0;
			dataSet.add(value);
		}
		return dataSet;
	}

}
