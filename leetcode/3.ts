function lengthOfLongestSubstring(s: string): number {
	let resultStr = "";
	let result = 0;
	for (const char of s) {
		if (resultStr.includes(char)) {
			// if result contains char, remove from result until char and then append
			resultStr = resultStr.slice(resultStr.indexOf(char) + 1);
		}
		// append
		resultStr += char;
		result = Math.max(result, resultStr.length);
	}
	return result;
}
