function twoSum(nums: number[], target: number): number[] {
	for (let i = 0; i < nums.length; i++) {
		for (let j = 0; j < nums.length; j++) {
			if (i === j) {
				continue;
			}
			if (nums[i] + nums[j] === target) {
				return [i, j];
			}
		}
	}
	return [-1, -1];
}

//
function twoSum_opt(nums: number[], target: number): number[] {
	const map: Record<number, number> = {};
	for (let i = 0; i < nums.length; i++) {
		const inverse = target - nums[i];
		if (map[inverse] != null) {
			return [map[inverse], i];
		}
		map[nums[i]] = i;
	}
	return [-1, -1];
}

console.log(twoSum_opt([3, 2, 4], 6));
