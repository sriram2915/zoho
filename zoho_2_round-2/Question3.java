package zoho;

import java.util.*;
public class Question3 {
	
	public static void main(String[] args) {
	
//		String s1 = "abcbbcabb";
//		String s2 = "cb*cab+";
		
		String s1 = "abcfbbbacbk";
		String s2 = "bbk*ad+";
		
		StringBuilder s = new StringBuilder();
		int n = s2.length();
		
		char c = s2.charAt(0);
		int id = 0;
		for(int i=0;i<s1.length();i++) {
			if(c==s1.charAt(i)) {
				id = i;
				break;
			}
		}
		
		int i;
		char t2 ='#',t;
		for(i=0;i<s2.length();i++) {
			
			t = s2.charAt(i);
			if(t == '+') {
				t2 = s2.charAt(i-1);
				if(t2 == s1.charAt(i)) {
					s.append(t2);
				}
			}
			else if(t == '*') {
				t2 = s2.charAt(i-1);
				if(t2 == s1.charAt(i+1)) {
					s.append(t2);
				}
				else {
					s.deleteCharAt(i-1);
				}
			}
			
			else s.append(t);
			
		}
		if(s2.charAt(s2.length()-1)=='+') i++;
		while(s2.charAt(n-1)=='+' && i<s1.length()) {  
			if(s1.charAt(i)!=s1.charAt(i-1)) break;
			s.append(t2);
			i++;
		}
		
		System.out.println(s);
	}

}
