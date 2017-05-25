package practice.j8;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Stream;

public class Demo {
	public static void main(String args[]) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < 100; i ++) {
			l.add(i);
		}
		Stream<Integer> s = l.parallelStream().filter(i -> i % 5 == 0).map( i -> i+2);
		int sum = l.parallelStream().reduce(0, (a,b) -> a+b);
		s = s.sequential();
		
		ArrayList<Integer> out = new ArrayList<Integer>();
		s.forEach(i -> out.add(i));
		
		for (Integer i : out) {
			System.out.println(i);
		}
		
		System.out.println("reduce: " + sum);

		
	}

}
