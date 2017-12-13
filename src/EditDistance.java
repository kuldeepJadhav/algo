

import java.util.Arrays;

public class EditDistance {
	
	public static void main(String[] args) {
		String str1 = "abcdef";
		String str2 = "azced";
		System.out.println("String 1 is " + str1);
		System.out.println("String 2 is " + str2);
		System.out.println("Calculated edit distance is " + calculateEditDistance(str1, str2));
		
	}
	
	private static char[] convertStringToArray(String str) {
		char[] charArr = new char[str.length() + 1];
		charArr[0] = '#';
	  final int [] counter = {1};
		Arrays.stream(str.split("")).forEach((ele) -> {
			charArr[counter[0]++] = ele.charAt(0);
		});
		return charArr;
	}
	
	private static int calculateEditDistance(String str1, String str2) {
		char[] arr1 = convertStringToArray(str1);
		char[] arr2 = convertStringToArray(str2);
		int [][] editDistance = new int [arr2.length][arr1.length];
		for (int i=0; i<arr2.length; i++) {
			editDistance[i][0] = i;
		}
		for (int i=0; i<arr1.length; i++) {
			editDistance[0][i] = i;
		}	
		for (int i = 1; i < arr2.length; i++) {
			for (int j=1; j< arr1.length; j++) {
				if (arr2[i] == arr1[j]) {
					editDistance[i][j] = editDistance[i-1][j-1];
				} else {
					int min = editDistance[i-1][j-1];
					if (min > editDistance[i][j-1]) {
						min = editDistance[i][j-1];
					}
					if (min > editDistance[i-1][j]) {
						min = editDistance[i-1][j];
					}
					editDistance[i][j] = min + 1;
				}
			}
		}
		for(int i=0; i < arr2.length; i++) {
			String str = "";
			for(int j=0; j < arr1.length; j++) {
				str = str + editDistance[i][j];
				
			}
		}
		return editDistance[arr2.length-1][arr1.length-1];
	}

}
