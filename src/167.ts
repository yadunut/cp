function twoSum(numbers: number[], target: number): number[] {
	let leftIndex = 0;
	let rightIndex = numbers.length - 1;
	// i can infinitely loop as the test assures I have result
	while (leftIndex !== rightIndex) {
		const sum = numbers[leftIndex] + numbers[rightIndex];
		if (sum < target) {
			leftIndex += 1;
		} else if (sum > target) {
			rightIndex -= 1;
		} else {
			return [leftIndex + 1, rightIndex + 1];
		}
	}
	return [-1, -1];
}
console.log(twoSum([2, 7, 11, 15], 9));
