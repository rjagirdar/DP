
public class KnapsackProblem {

	public static void main(String[] args) {
		int weights[] = {1, 2, 3};
		int values[] = {6, 10, 12};
		int W = 5;
		knapsack(weights, values, W);
	}
	
	public static void knapsack(int[] weights, int[] values, int W){
		int[][] table = new int[W+1][weights.length+1];
		
		for(int i=0; i<=W; i++){
			for(int j=0; j<=weights.length; j++){
				if(i==0 || j==0)
					table[i][j] = 0;
				else if(weights[j-1]>i)
					table[i][j] = table[i][j-1];
				else
					table[i][j] = Math.max(values[j-1]+table[i-weights[j-1]][j-1], table[i][j-1]);
			}
		}
		System.out.println("Max Value is "+table[W][weights.length]);
	}

}
