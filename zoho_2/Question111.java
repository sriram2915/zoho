package zoho;

import java.util.*;
public class Question111 {

	public static void main(String[] args) {
		
		char[] st = {'a','1','b','2','c','3','4','c','3','b','2','c','b','3','a','1','d'};
		
		for(int i=0;i<st.length;i++) {
			char t = st[i];
			if(t-'0'<=9 && t-'0'>=0) 
				digitContain1(st,i,t);
			else 
				contains1(st,i,t);
		}
		
		for(char c : st) {
			if(c!='-') System.out.print(c);
			
		}
		
	}
	
	static void contains1(char[] st,int j,char t) {
		for(int i=0;i<j;i++) {
			if(st[i]==t) {
				st[j] = '-';
				break;
			}
		}
	}
	
	static void digitContain1(char[] st, int j,char t) {
		
		for(int i=0;i<j-1;i++) {
			if(st[i]==t) {
				st[i]='-';
			}
		}
	}
}
