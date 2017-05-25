package practice.cache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LRUCache {
	HashMap<Integer, String> cacheTable;
	LinkedList<Integer> q;
	Integer maxSize;
	
	public static void main(String args[]) {
		LRUCache cache = new LRUCache();
		cache.maxSize = 4;
		cache.cacheTable = new HashMap<Integer, String>();
		cache.q = new LinkedList<Integer>();
		
		cache.set(1, "a");
		cache.set(2, "b");
		cache.set(3, "c");
		cache.set(4, "d");
		cache.set(5, "e");
		cache.set(6, "f");

		String s = cache.get(3);
		cache.get(5);
		System.out.println(s);
		
		for(Integer key : cache.q) {
			System.out.print(cache.cacheTable.get(key) +",");
		}
	}
	
	public void set(int key, String value) {
		if (cacheTable.containsKey(key)) {
			// SLOW
			q.remove(key);
			q.addFirst(key);
			cacheTable.put(key, value);
		} else {
			if (cacheTable.size() >= maxSize) {
				Integer oldKey = q.removeLast();
				cacheTable.remove(oldKey);
				q.addFirst(key);
				cacheTable.put(key,value);
			} else {
				q.addFirst(key);
				cacheTable.put(key,value);
			}
		}
	}
	
	public String get(int key) {
		if (cacheTable.containsKey(key)) {
			// SLOW
			q.remove((Object) key);

			q.addFirst(key);
			return cacheTable.get(key);
		} else {
			return null;
		}
	}
}
