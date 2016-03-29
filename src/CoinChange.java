
public class CoinChange {

	public static void main(String[] args) {
		int arr[] = {1,2,3};
		int n = 4;
		countCoinChange(arr, n);
	}
	
	public static void countCoinChange(int[] arr, int n){
		int[][] table = new int[n+1][arr.length+1];
		
		for(int j=0; j<=arr.length; j++)
			table[0][j] =1;
		for(int i=1; i<=n; i++)
			table[i][0] =0;
		for(int i=1; i<=n; i++){
			for(int j=1; j<=arr.length; j++){
				int inclusive_sum=0,exclusive_sum=0;
				if(i>=arr[j-1])
					inclusive_sum = table[i-arr[j-1]][j];
				else
					inclusive_sum =0;
				exclusive_sum = table[i][j-1];
				table[i][j] = inclusive_sum+exclusive_sum;
			}
		}
		
		for(int[] temp: table){
			for(int ele : temp)
				System.out.print(ele+" ");
			System.out.println();
		}
		
		System.out.println("No of ways of generating "+n+" cents of change is "+table[n][arr.length]);
		
	}

}
