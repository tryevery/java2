package homework8;
/**
 * ÌÞ³ý×Ö·û´®ÖÐµÄÊý×Ö
 * @author lcj
 *
 */
public class Test5 {
	public static void main(String[] args) {
		String regex = "\\D{1,}";
		String str = "ab123you";
		str = str.replaceAll(regex, "");
		System.out.println(str);
	}
}
