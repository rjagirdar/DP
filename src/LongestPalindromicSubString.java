
public class LongestPalindromicSubString {

	public static void main(String[] args) {
		String str = "forgeeksskeegfor";
		lps(str.toCharArray());
		str = "GEEKSFORGEEKS";
		lpSequence(str.toCharArray());
	}
	
	public static void lps(char[] arr){
		boolean[][] table = new boolean[arr.length][arr.length];
		int maxLength = 2;int startIndex=-1, endIndex=-1;
		for(int i=0; i<arr.length; i++)
			table[i][i] = true;
		
		for(int i=0; i<arr.length-1; i++){
			if(arr[i]==arr[i+1]){
				table[i][i+1] = true;
				startIndex=i;
				maxLength=2;
				endIndex = i+1;
			}
		}
		
		for(int gap=3; gap<=arr.length; gap++){
			for(int i=0; i<arr.length-gap+1; i++){
				int j=i+gap-1;
				if(arr[i]==arr[j] && table[i+1][j-1]){
					table[i][j] = true;
					if(gap>maxLength){
						maxLength=gap;
						startIndex=i;
						endIndex=j;
					}
				}
			}
		}
		
		System.out.println("Length of LPS is "+maxLength);
		System.out.println("LPS is "+new String(arr).substring(startIndex, endIndex+1));
	}
	
	public static void lpSequence(char[] arr){
		int[][] table = new int[arr.length][arr.length];
		
		
		for(int i=0; i<arr.length; i++)
			table[i][i] = 1;
		
		for(int i=0; i<arr.length-1; i++){
			if(arr[i]==arr[i+1]){
				table[i][i+1] = 2;
			}
		}
		
		for(int gap=3; gap<=arr.length; gap++){
			for(int i=0; i<arr.length-gap+1; i++){
				int j=i+gap-1;
				if(arr[i]==arr[j]){
					table[i][j] = 2+table[i+1][j-1];
				}
				else
					table[i][j]= Math.max(table[i+1][j], table[i][j-1]);
			}
		}
		System.out.println("Longest Palindromic SubSequence length is "+table[0][arr.length-1]);
	}

}
