
public class LongestCommonSubString {

	public static void main(String[] args) {
		String A = "geeksfor";
		String B = "forgeeks";
		longestCommonSubString(A, B);
	}
	
	public static void longestCommonSubString(String A, String B){
		int[][] table = new int[A.length()+1][B.length()+1];
		int result = Integer.MIN_VALUE;
		int max_i=-1; int max_j=-1;
		for(int i=0; i<=A.length(); i++){
			for(int j=0; j<=B.length(); j++){
				if(i==0 || j==0)
					table[i][j] =0;
				else{
					if(A.charAt(i-1)==B.charAt(j-1)){
						table[i][j] = table[i-1][j-1]+1;
						if(table[i][j]>result){
							max_i = i;
							max_j = j;
							result = table[i][j];
						}
							
						//result = Math.max(result, table[i][j]);
					}
					else{
						table[i][j] = 0;
						
					}
						
				}
			}
		}
		System.out.println("Length of Longest Common Substring is "+result);
		System.out.println("Coordinates are "+max_i+" "+max_j );
		for(int[] row : table){
			for(int item : row){
				System.out.print(item +" ");
			}
			System.out.println();
		}
		int i, j;
		StringBuffer buffer = new StringBuffer();
		if(max_i!=-1 && max_j!=-1){
			for(i=max_i,j=max_j; table[i][j]>0; --i,--j){
				if(A.charAt(i-1) == B.charAt(j-1)){
					buffer.append(A.charAt(i-1));
				}
			}
		}
		System.out.println("And the common SubString is "+new String(buffer.reverse()));
		
	}

}
