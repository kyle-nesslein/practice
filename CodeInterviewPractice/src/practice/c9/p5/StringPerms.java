package practice.c9.p5;

import java.util.ArrayList;

public class StringPerms {
	public static void main(String args[]) {
		ArrayList<String> perms = getPerms("this");
		for (String s : perms) {
			System.out.println(s);
		}
	}
	
	public static ArrayList<String> getPerms(String input) {
		if (input == null ) {
			return null;
		}
		ArrayList<String> results = new ArrayList<String>();
		if (input.length() == 0) {
			results.add("");
			return results;
		}
		
		char c = input.charAt(0);
		String remainder = input.substring(1);
		ArrayList<String> subPerms = getPerms(remainder);
		for (String w: subPerms) {
			for(int i = 0; i <= w.length(); i++) {
				String next = w.substring(0,i);
				next += c;
				next += w.substring(i);
				results.add(next);
			}
		}
		return results;
	}

}
