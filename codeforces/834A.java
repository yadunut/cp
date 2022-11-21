import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lines = sc.nextInt();
		for (int i = 0; i < lines + 1; i++) {
			String input = sc.nextLine().trim();
			if (input.isBlank()) {
				continue;
			}
			boolean result = false;
			if (input.startsWith("Y")) {
				result = check(input);
			} else if (input.startsWith("e")) {
				result = check("Y" + input);
			} else if (input.startsWith("s")) {
				result = check("Ye" + input);
			}

			if (result) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
	}

	public static boolean check(String str) {
		char[] yes = "Yes".toCharArray();
		String result = str.replaceAll("Yes", "");
		if (result.isBlank())
			return true;
		char[] strA = str.toCharArray();
		for (int i = 0; i < strA.length; i++) {
			if (strA[i] != yes[i % 3])
				return false;
		}
		return true;
	}

}