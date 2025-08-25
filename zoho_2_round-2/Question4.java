package zoho;

import java.util.*;
import java.lang.*;
public class Question4 {

	public static void main(String[] args) {
		
//		String s1 = "1.01";
//		String s2 = "1.001";
		
//		String s1 = "1.0";
//		String s2 = "1.0.0";
		
		String s1 = "0.1";
		String s2 = "1.1";
		
		String n1 ="";
		String n2 = "";
		// for version 1
		int f1 = 1, f2 = 1,f3=1;
		for(int i=0;i<s1.length();i++) {
			char c = s1.charAt(i);
			if(f1==1 && c=='0') continue;
			if(f2==1 && c=='0') continue;
			
			if(c=='.') {
				if(f3>1) break;
				f3++;
			}
			
			n1+=c;
//			System.out.println(n1);
			
		}
		// for version 2
		f1 = 1; f2 = 1;f3=1;
		for(int i=0;i<s2.length();i++) {
			char c = s2.charAt(i);
//			System.out.println(c);
			if(f1==1 && c=='0') continue;
			if(f2==1 && c=='0') continue;
			
			if(c=='.') {
				if(f3>1) break;
				f3++;
			}
			
			n2+=c;
//			System.out.println(n2);
		}
//		System.out.println(n1+" "+n2);
		double a = Double.parseDouble(n1);
		double b = Double.parseDouble(n2);
		
		
		if(a<b) {
			System.out.println(-1);
		}
		else if(a>b) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
		
		
	}
}
