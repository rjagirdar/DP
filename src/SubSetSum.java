import java.util.ArrayList;


public class SubSetSum {

	public static void main(String[] args) {
		int arr[] = {1,3,5,2,7};
		int X =10;
		hasSubset(arr, X);
	}
	
	public static int findFirstIndex(boolean[] arr){
		int left =0; int right = arr.length-1;
		while(right-left>1){
			int mid = left +(right-left)/2;
			if(arr[mid]== true)
				right = mid;
			else
				left = mid;
		}
		if(arr[left]== true)
			return left;
		else if(arr[right] == true)
			return right;
		else
			return -1;
	}
	
	public static void hasSubset(int[] arr, int X){
		boolean[][] table = new boolean[X+1][arr.length+1];
		for(int i=0; i<arr.length+1; i++)
			table[0][i] = true;
		for(int i=1; i<X+1; i++)
			table[i][0]=false;
		for(int i=1; i<X+1; i++){
			for(int j=1; j<arr.length+1; j++){
				table[i][j] = table[i][j-1];
				if(i>=arr[j-1]){
					table[i][j] = table[i][j] || table[i-arr[j-1]][j-1];
				}
			}
		}
		System.out.println("Subset can be formed: "+table[X][arr.length]);
		/*for(boolean[] tempArr : table){
			System.out.println(findFirstIndex(tempArr));
		}*/
		if(table[X][arr.length] == true){
			int current_sum = X;
			ArrayList<Integer> list = new ArrayList<Integer>();
			while(current_sum>0){
				int firstIndex = findFirstIndex(table[current_sum]);
				list.add(arr[firstIndex-1]);
				current_sum-=arr[firstIndex-1];
			}
			for(int i: list)
				System.out.print(i+" ");
		}
		
		/*for(int i=arr.length; i>=0; i--){
			int remaining_sum = X;
			ArrayList<Integer> result = new ArrayList<Integer>();
			int j = i;
			while(table[remaining_sum][j] == true && remaining_sum!=0){
				if(arr[j-1] <=remaining_sum){
					result.add(arr[j-1]);
					remaining_sum -= arr[j-1];
				
				}
				j--;
			}
			for(int temp : result)
				System.out.print(temp+" ");
			System.out.println();
		}*/
		System.out.println();
		//printSubSets(table, X, arr.length, arr, new ArrayList<Integer>(), X, 0);
		
 	}
	
	/*public static void printSubSets(boolean[][] table, int row, int col, int[] arr, ArrayList<Integer> tempList, int remaining_sum, int index){
		for(int i = arr.length;i>=0; i++){
			int j = i;
			if(table[remaining_sum][j] == true && remaining_sum!=0){
				if(arr[j-1] <=remaining_sum){
					if(tempList.size()>index)
						tempList.set(index,arr[j-1]);
					else{
						tempList.
					}
					remaining_sum -= arr[j-1];
				}
				printSubSets(table, remaining_sum, col-1, arr, tempList, remaining_sum, index+1);
			}
			else{
				for(int temp : tempList)
					System.out.print(temp+" ");
				System.out.println();
				return;
			}
		}
	*/	
	//}

}
