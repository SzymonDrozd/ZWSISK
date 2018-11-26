package WojcikProject.WojcikProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import collection.CollectionGenerator;
import compare.CompareCollections;
import manager.AppManager;
import thread.ListManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	CollectionGenerator gen = new CollectionGenerator(300,600);
//    	Set<Integer> set1 = gen.generateCollection();
//    	Set<Integer> set2 = gen.generateCollection();
//    	
//    	CompareCollections compare = new CompareCollections();
//    	List<List> lists1 = compare.compareArrays(new ArrayList(set1), new ArrayList(set2));
//    	List<List> lists2 = compare.compareArrays2(new ArrayList(set1), new ArrayList(set2));
//    	
//    	ListManager manager = new ListManager(2,lists1,null);
//    	System.out.println(manager.result());
    	AppManager manager = new AppManager();
    	manager.startApp();
    }
}
