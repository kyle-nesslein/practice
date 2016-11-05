package practice.c1.p4;

public class ReplaceSpaces {
	public static void main(String args[]) {
		String input = "John Smith    ";
		System.out.println(replaceSpaces(input, 10));
	}
	
	public static String replaceSpaces(String input, int trueLength) {
		char[] array = input.toCharArray();
		int numSpaces = 0;
		for (int i = trueLength -1; i >= 0; i--) {
			if(array[i] == ' ') {
				numSpaces++;
			}
		}
		if ((numSpaces *2) + trueLength > input.length()) {
			return null;
		}
		int insert = trueLength + numSpaces*2 -1;
		for (int read = trueLength -1; read >= 0; read--) {
			if (array[read] == ' ') {
				array[insert] = '0';
				insert--;
				array[insert] = '2';
				insert--;
				array[insert] = '%';
				insert--;
			} else {
				array[insert] = array[read];
				insert--;
			}
		}
		return new String(array);
	}
}
