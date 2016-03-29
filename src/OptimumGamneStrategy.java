
public class OptimumGamneStrategy {

	public static void main(String[] args) {
		int arr[] = {8,15,3,7};
		maxScore(arr);
	}
	
	public static void maxScore(int[] arr){
		int[][] table = new int[arr.length][arr.length];
		int i, j;
		for(int gap = 0; gap <arr.length; gap++){
			for(i=0, j=gap; j<arr.length; i++,j++){
				int x = (i+2<=j)?table[i+2][j] : 0;
				int y = (i+1<=j-1)?table[i+1][j-1]:0;
				int z = (i<=j-2)?table[i][j-2]:0;
				table[i][j] =Math.max(arr[i]+Math.min(x, y), arr[j]+Math.min(y,z));
			}
		}
		for(int[] row : table){
			for(int temp : row)
				System.out.print(temp+"      ");
			System.out.println();
		}
		System.out.println("Max Score is "+table[0][arr.length-1]);
	}

}
