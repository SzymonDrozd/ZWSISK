package collection;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CollectionGenerator {
	
	private int size;
	private int range;
	
	public CollectionGenerator(int size, int range) {
		this.size = size;
		this.range = range;
	}
	
	public Set<Integer> generateCollection(){
		Set<Integer> dataSet = new HashSet<Integer>();
		Random rand = new Random();
		while(dataSet.size() < size) {
			Integer value = rand.nextInt(range * (dataSet.size()+1)) + 0;
			dataSet.add(value);
		}
		return dataSet;
	}

}
