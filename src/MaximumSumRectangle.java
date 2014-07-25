import java.util.Arrays;


public class MaximumSumRectangle {

	public static int top=-1;
	public static int bottom=-1;
	
	public static void main(String[] args) {
		int arr[][] ={{1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}};
		findRectangle(arr);
		
	}
	public static int kadane(int[] temp){
		int sum=0;
		int max_so_far=0;
		int local_start=-1;
		for(int i=0; i<temp.length; i++){
			sum+=temp[i];
			if(sum<0){
				sum=0;
				local_start= i+1;
			}
			else if(sum>max_so_far){
				top = local_start;
				bottom = i;
				max_so_far = sum;
			}
		}
		
		if(bottom==-1){
			max_so_far = temp[0];
			top=bottom=0;
			for(int i=1; i<temp.length; i++){
				if(max_so_far<temp[i]){
					max_so_far=temp[i];
					top=bottom=i;
				}
			}
		}
		return max_so_far;
	}
	
	public static void findRectangle(int[][] arr){
		int fLeft=0,fRight=0,fTop=0,fBottom=0;
		int[] temp = new int[arr.length];
		int max_sum = Integer.MIN_VALUE;
		int left=-1,right=-1;
		for( left=0; left<arr[0].length; left++){
			Arrays.fill(temp, 0);
			for(right=left; right<arr[0].length; right++){
				
				for(int i=0; i<arr.length; i++)
					temp[i] +=arr[i][right];
				
				int sum = kadane(temp);
				if(sum>max_sum){
					max_sum = sum;
					fLeft = left;
					fRight = right;
					fTop = top;
					fBottom = bottom;
				}
			}
		}
		
		System.out.println("Maximum Rectangle Sum is "+max_sum);
		System.out.println("And the rectangle is ");
		for(int i= fTop; i<=fBottom; i++){
			for(int j=fLeft; j<=fRight; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
