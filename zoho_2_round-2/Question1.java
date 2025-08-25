package zoho;

import java.util.*;
//import java.lang.StringBuilder.*;
public class Question1 {
	
	public static void main(String arg[]) {
		
		StringBuilder s = new StringBuilder();
	
		StringBuilder str = new StringBuilder("a1b2c34c3b2cb3a1d");

		for(int i=0;i<str.length();i++) {
			char t = str.charAt(i);
			if(t-'0'<=9 && t-'0'>=0) {
				s.append(t);
				digitContain(s,t);
			}
			else {
				if(contains(t,s)) {
					s.append(t);
				}
			}
		}
		System.out.println(s);
	}
	
	
	
	static boolean contains(char t, StringBuilder s) {
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==t) {
//				str.deleteCharAt(n);
				return false;
			}
		}
		return true;
		
	}
	
	static void digitContain(StringBuilder s, char t) {
		
		for(int i=0;i<s.length()-1;i++) {
			if(s.charAt(i)==t) {
				s.deleteCharAt(i);
			}
		}
	}
	
}
