import java.util.ArrayList;
import java.util.HashSet;


public class WordBreak {
	static HashSet<String> dictionary = new HashSet<String>();
	
	static {
		dictionary.add("mobile");
		dictionary.add("samsung");
		dictionary.add("sam");
		dictionary.add("sung");
		dictionary.add("man");
		dictionary.add("mango");
		dictionary.add("icecream");
		dictionary.add("and");
		dictionary.add("go");
		dictionary.add("i");
		dictionary.add("like");
		dictionary.add("ice");
		dictionary.add("cream");
		dictionary.add("ilike");
		dictionary.add("ilikesamsung");
	}
	
	public static void main(String[] args) {
		String str = "ilikesamsung";
		wordBreak(str);
	}
	
	public static boolean search(String str){
		System.out.println(str);
		return dictionary.contains(str);
	}
	
	public static void wordBreak(String str){
		
		if(str.length() == 0){
			System.out.println("Cannot be Broken into Dictionary Words");
			return;
		}
		int size = str.length();
		boolean[] wb = new boolean[str.length()+1];
		int j=-1;
		for(int i=1; i<=str.length(); i++){
			
			if(wb[i] == false && search(str.substring(0, i))){
				wb[i] = true;
			}
			
			if(wb[i] == true){
				if(i == size){
					System.out.println("The string can be broken into Dictionary Words");
					
				}
				for(j=i+1; j<=size; j++){
					if(wb[j] == false && search(str.substring(i, j)))
						wb[j] = true;
				}
				
				if(j==size && wb[j] == true){
					System.out.println("The string can be broken into Dictionary Words");
				}
			}
			
			
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<=str.length(); i++){
			if(wb[i])
				list.add(i);
			
		}
		
		permutate(list, str, 0, new String[list.size()], 0, 0);
			
	}
	
	public static void permutate(ArrayList<Integer> indexes, String str, int listIndex, String[] finalList, int stringIndex, int finalListIndex){
		
		if(listIndex == indexes.size()){
			for(String temp : finalList)
				System.out.print(temp+" ");
			return;
		}
		
		for(int i=listIndex; i<indexes.size(); i++){
			if(search(str.substring(stringIndex, indexes.get(i)))){
				finalList[finalListIndex]=str.substring(stringIndex, indexes.get(i)); 
				permutate(indexes, str, listIndex+1, finalList, indexes.get(i),finalListIndex+1);
			}
				
		}
	}

}

