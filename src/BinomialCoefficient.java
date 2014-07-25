
public class BinomialCoefficient {

	public static void main(String[] args) {
		int n=5; int k=2;
		binomialCoefficient(n, k);
	}
	
	public static void binomialCoefficient(int n, int k){
		int[][] table = new int[n+1][k+1];
		
		for(int i=0; i<=n; i++){
			for(int j=0; j<=Math.min(i, k); j++){
				if(i==0 || j==0)
					table[i][j] =1;
				else
					table[i][j] = table[i-1][j-1]+table[i-1][j];
			}
		}
		System.out.println("Coefficient is "+table[n][k]);
	}

}
