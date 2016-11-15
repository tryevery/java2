package homework8;

import java.util.StringTokenizer;

public class test {
	public static void main(String[] args) {
		/*System.out.println("ÄãºÃ KU".length());
		System.out.println("\n\t\t".length());
//		System.out.println(Integer.parseInt("12.9"));
		String s;
		short str = Short.parseShort("567");
		byte m = (byte) Integer.parseInt("2");
		String str1 = new String("Æ»¹û");
		modify(str1);
		System.out.println(str1);*/
		
		/*String str = "We Love This Game";
		GetToken to = new GetToken();
		String s1 = to.getToken(2, str),
		s2 = to.getToken(4, str);
		System.out.println(s1+" "+s2);*/
		regex();
	}
	
	public static void modify(String s){
		s = s+"ºÃ³Ô";
	}
	
	public static void regex(){
		String regex = "\\djava\\w{1,}";
		String str = "88javaookk";
		String str1 = "9javaHello";
		if(str.matches(regex)){
			System.out.println(str);
		}
		if(str1.matches(regex)){
			System.out.println(str1);
		}
	}
	
}

class GetToken{
	String []s;
	public String getToken(int index,String str){
		StringTokenizer fenxi = new StringTokenizer(str);
		int number = fenxi.countTokens();
		s = new String[number+1];
		int k = 1;
		while(fenxi.hasMoreTokens()){
			String trmp = fenxi.nextToken();
			s[k] = trmp;
			k++;
		}
		
		if(index<=number){
			return s[index];
		}else{
			return null;
		}
	}
}
