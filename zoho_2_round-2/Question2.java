package zoho;

import java.util.*;
public class Question2 {
	
	public static void main(String[] args) {
		
		String s = "43211";
//		String s = "1223334444";
		int[] freq = new int[10];
		for(int i = 0;i<s.length();i++) {
			freq[s.charAt(i)-'0']++;
		}
		HashMap<Integer,Integer> has = new HashMap<>();
		for(int i=0;i<freq.length;i++) {
			
			if(freq[i]==0) continue;
			has.put(freq[i], has.getOrDefault(freq[i], 0)+i*freq[i]);
			
		}
		System.out.println(has);
	}

}
