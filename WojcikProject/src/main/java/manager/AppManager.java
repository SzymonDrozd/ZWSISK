package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import collection.CollectionGenerator;
import compare.CompareCollections;
import thread.ListManager;

public class AppManager {
	long start = 0;
	long stop = 0;
	
	public void startApp() {
		start = System.currentTimeMillis();
    	CollectionGenerator gen = new CollectionGenerator(10000000,1000);
    	List<Integer> list1 = gen.generateCollection();
//    	Set<Integer> set2 = gen.generateCollection();
    	
//    	CompareCollections compare = new CompareCollections();
//    	List<List> lists1 = compare.compareArrays(new ArrayList(set1), new ArrayList(set2));
//    	List<List> lists2 = compare.compareArrays2(new ArrayList(set1), new ArrayList(set2));
    	
    	ListManager manager = new ListManager(100,list1);
    	Long res = manager.manage();
    	stop = System.currentTimeMillis();
    	String text = "";
    	if(res!=null)
    		text = String.valueOf(res);
    	else
    		text = "brak";
    	
    	System.out.println("Wynik: " + text + " Czas: " + ((stop - start)) + "ms");
	}

}
