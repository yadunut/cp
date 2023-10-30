package leetcode;

// Add Binary
public class L67 {
    public static String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int max = Math.max(a.length(), b.length());
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < max; i++) {
            int cA = a.length() > i ? a.charAt(i) - '0' : 0;
            int cB = b.length() > i ? b.charAt(i) - '0' : 0;
            int r = cA + cB + carry;
            carry = r > 1 ? 1 : 0;
            result.append(r % 2 == 1 ? '1' : '0');
        }
        if (carry == 1) result.append('1');
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));

    }
}
