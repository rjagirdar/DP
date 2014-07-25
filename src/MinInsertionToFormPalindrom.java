
public class MinInsertionToFormPalindrom {

	public static void main(String[] args) {
		String A ="abbd";
		findNoOfInsertions(A.toCharArray());
	}
	
	public static void findNoOfInsertions(char[] arr){
		int[][] table = new int[arr.length][arr.length];
		int i,j;
		for(int gap =1; gap<arr.length; gap++){
			for(i=0, j=gap; j<arr.length; ++i,++j){
				if(arr[i]==arr[j])
					table[i][j] = table[i+1][j-1];
				else
					table[i][j] = Math.min(table[i][j-1], table[i+1][j])+1;
			}
		}
		System.out.println("Min number of Insertions is "+table[0][arr.length-1]);
	}

}
