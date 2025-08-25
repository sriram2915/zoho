package zoho;

public class Question11 {
	
	static int n =0;

	public static void main(String[] args) {
		
		StringBuilder str = new StringBuilder("a1b2c34c3b2cb3a1d");
		
		for(int i=0;i<str.length();i++) {
			char t = str.charAt(i);
			
			if(t-'0'<=9 && t-'0'>=0) 
				digitContain(str,t,i);
			else 
				contains(t,str,i);
		}
		System.out.println(str);
	}

	static void contains(char t, StringBuilder str,int m) {
	
		for(int i=0;i<m-n;i++) {
			if(str.charAt(i)==t) {
				str.deleteCharAt(m);
				n++;
				break;
			}
		}
	}

	static void digitContain(StringBuilder s, char t,int m) {
	
		int c = 0;
		for(int i=0;i<m-n-1;i++) {
			if(s.charAt(i)==t) {
				s.deleteCharAt(i);
				c++;
			}
		}
		n+=c;
	}
}
