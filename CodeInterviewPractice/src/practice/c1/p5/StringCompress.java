package practice.c1.p5;

public class StringCompress {
	public static void main(String args[]) {
		System.out.println(compress("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadkeifffffeefciiii"));
		
	}
	
	public static String compress(String input) {
		if (input != null && input != "") {
			char lastChar = input.charAt(0);
			int charCount = 1;
			StringBuffer out = new StringBuffer();
			for (int i = 1; i < input.length(); i++) {
				if (input.charAt(i) == lastChar) {
					charCount++;
				} else {
					out.append(lastChar).append(charCount);
					charCount = 1;
					lastChar = input.charAt(i);
				}
			}
			out.append(lastChar).append(charCount);
			if (out.length() < input.length()) {
				return out.toString();
			}
		}
		return input;
	}
	
	public static String expand(String input) {
		return null;
	}

}
