
public class PalindromePartitioning {

	public static void main(String[] args) {
		String str ="vaman";
		minPartition(str.toCharArray());
	}
	
	public static void minPartition(char[] arr){
		boolean[][] P = new boolean[arr.length][arr.length];
		int[][] C = new int[arr.length][arr.length];
		
		for(int i=0; i<arr.length; i++){
			P[i][i] = true;
			C[i][i] = 0;
		}
		
		for(int gap =2; gap<=arr.length; gap++){
			for(int i=0; i<arr.length-gap+1; i++){
				int j = i+gap-1;
				if(gap == 2 && arr[i] == arr[j])
					P[i][j] = true;
				else if(arr[i] == arr[j] && P[i+1][j-1])
					P[i][j] = true;
				else
					P[i][j] = false;
				if(P[i][j] == true)
					C[i][j] = 0;
				else
				{
					C[i][j] = Integer.MAX_VALUE;
					for(int k=i; k<j; k++){
						C[i][j] = Math.min(C[i][j], C[i][k]+C[k+1][j]+1);
					}
				}
			}
				
		}
		System.out.println("Min number of partitions needed are "+C[0][arr.length-1]);
	}

}
