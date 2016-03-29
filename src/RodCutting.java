
public class RodCutting {

	public static void main(String[] args) {
		int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println("Price of cutting is "+findMaxValue(price, 8));
	}
	
	public static int findMaxValue(int[] price, int n){
		 int[] val=new int[price.length+1];
		 val[0] = 0;
		for(int i=1; i<=n; i++){
			int max_val = Integer.MIN_VALUE;
			for(int j=0; j<i; j++){
				max_val = Math.max(max_val, price[j]+val[i-j-1]);
			}
			val[i] = max_val;
		}
		for(int i : val)
			System.out.print(i+" ");
		return val[n];
	}

}
