
public class MatrixChainMultiplication {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4};
		matrixchainmultiplication(arr);
	}
	
	public static void matrixchainmultiplication(int[] arr){
		int[][] table = new int[arr.length][arr.length];
		int count;
		for(int i=1; i<arr.length; i++){
			table[i][i] = 0;
		}
		
		for(int gap =2; gap<=arr.length; gap++){
			for(int i=1; i<arr.length-gap+1; i++){
				int j=i+gap-1;
				count = Integer.MAX_VALUE;
				for(int k=i; k<j; k++){
					count = Math.min(count, table[i][k]+table[k+1][j]+arr[i-1]*arr[k]*arr[j]);
				}
				table[i][j] = count;
			}
		}
		
		System.out.println("Output "+table[1][arr.length-1]);
	}

}
