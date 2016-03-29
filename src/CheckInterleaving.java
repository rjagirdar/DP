
public class CheckInterleaving {
	
	public static void main(String[] args){
		String A = "XY";
		String B = "WZ";
		String C = "WXZY";
		checkInterleaving(A, B, C);
	}
	
	public static void checkInterleaving(String A, String B, String C){
		if(C.length() != A.length()+B.length())
			return;
		boolean[][] IL = new boolean[A.length()+1][B.length()+1];
		
		for(int i=0; i<=A.length(); i++){
			for(int j=0; j<=B.length(); j++){
				
				if(i==0 && j==0)
					IL[i][j] = true;
				
				else if(i==0 && (B.charAt(j-1) == C.charAt(j-1)))
					IL[i][j] = IL[i][j-1];
				
				else if(j==0 && A.charAt(i-1) == C.charAt(i-1))
					IL[i][j] = IL[i-1][j];
				
				else if(A.charAt(i-1) == C.charAt(i+j-1) && B.charAt(j-1)!= C.charAt(i+j-1))
					IL[i][j] = IL[i-1][j];
				
				else if(A.charAt(i-1) != C.charAt(i+j-1) && B.charAt(j-1)== C.charAt(i+j-1))
					IL[i][j] = IL[i][j-1];
				
				else if(A.charAt(i-1) == C.charAt(i+j-1) && B.charAt(j-1)== C.charAt(i+j-1))
					IL[i][j] = IL[i-1][j] || IL[i][j-1];
			}
		}
		
		System.out.println("C is Interleaving of A and B :"+ IL[A.length()][B.length()]);
	}
	
}
