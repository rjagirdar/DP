
public class LongestArithmeticProgression {

	public static void main(String[] args) {
		int arr[] = {1, 7, 10, 13, 14, 19};
		llap(arr);
	}
	
	public static void llap(int[] arr){
		int[][] L = new int[arr.length][arr.length];
		int llap = 2;
		
		for(int i=0; i<arr.length; i++)
			L[i][arr.length-1] = 2;
		int i=-1,j=-1,k=-1;
		for(j = arr.length-2; j>=1; j--){
			i = j-1; k=j+1;
			while(i>=0 &&  k<=arr.length-1){
				if(arr[i]+arr[k] < 2*arr[j])
					k++;
				else if(arr[i]+arr[k] > 2*arr[j]){
					L[i][j] =2; i--;
				}
				else{
					L[i][j] = L[j][k]+1;
					
					llap = Math.max(llap, L[i][j]);
					i--; k++;
				}
			}
		}
		while(i>=0){
			L[i][j] = 2;
			i--;
		}
		
		for(i=0; i<arr.length; i++){
			for(j=0; j<arr.length; j++){
				System.out.print(L[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("Length of Longest Arithmetic Progression is "+llap);	
	}

}
