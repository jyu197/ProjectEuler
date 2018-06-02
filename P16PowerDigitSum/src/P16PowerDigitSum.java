import java.math.BigInteger;

public class P16PowerDigitSum {

	static int exp = 1000;
	
	public static void main(String[] args) {
		int sum = 0;
		BigInteger n = new BigInteger("2");
		n = n.pow(exp);
		String text = n.toString();
		for (int i = 0; i < text.length(); i++) {
			String digit = text.substring(i, i + 1);
			sum += Integer.parseInt(digit);
		}
		System.out.println(sum);
	}
	
}
