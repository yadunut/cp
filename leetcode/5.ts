function longestPalindrome(s: string): string {
	let result: string[] = [];
	for (let i = 0; i < s.length; i++) {
		result.push(findPalindrome(s, i));
	}
	return result.reduce(
		(prev, curr) => (prev.length > curr.length ? prev : curr),
		"",
	);
}

function findPalindrome(s: string, index: number): string {
	// grows left and right from the given index to find palindrome
	let grow = 1;
	let result = s[index];
	while (grow + index - 1 < s.length && index - grow >= 0) {
		if (s[index - grow] === s[index + grow]) {
			result = s[index - grow] + result + s[index + grow];
		} else {
			break;
		}
		grow++;
	}
	return result;
}

console.log(longestPalindrome("cbbd"));
