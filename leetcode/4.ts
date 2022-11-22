function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
	let medianIndex = (nums1.length + nums2.length) / 2 - 1;

	if (Number.isInteger(medianIndex)) {
		medianIndex = Math.ceil(medianIndex);
		let nums1Index = 0;
		let nums2Index = 0;
		let resultArr: number[] = [];
		for (let i = 0; i <= medianIndex + 1; i++) {
			if (nums1[nums1Index] == null) {
				resultArr.push(nums2[nums2Index]);
				nums2Index++;
			} else if (nums2[nums2Index] == null) {
				resultArr.push(nums1[nums1Index]);
				nums1Index++;
			} else if (nums1[nums1Index] < nums2[nums2Index]) {
				resultArr.push(nums1[nums1Index]);
				nums1Index++;
			} else {
				resultArr.push(nums2[nums2Index]);
				nums2Index++;
			}
		}
		return (resultArr[medianIndex + 1] + resultArr[medianIndex]) / 2;
		// calculate the middle of the 2 numbers in middle
	} else {
		// calculate the upper median
		medianIndex = Math.ceil(medianIndex);

		let nums1Index = 0;
		let nums2Index = 0;
		let resultArr: number[] = [];
		for (let i = 0; i <= medianIndex; i++) {
			if (nums1[nums1Index] == null) {
				resultArr.push(nums2[nums2Index]);
				nums2Index++;
			} else if (nums2[nums2Index] == null) {
				resultArr.push(nums1[nums1Index]);
				nums1Index++;
			} else if (nums1[nums1Index] < nums2[nums2Index]) {
				resultArr.push(nums1[nums1Index]);
				nums1Index++;
			} else {
				resultArr.push(nums2[nums2Index]);
				nums2Index++;
			}
		}
		return resultArr[medianIndex];
	}
}

console.log(findMedianSortedArrays([1, 2, 3], [1, 1, 6]));
console.log(findMedianSortedArrays([1, 2, 3, 4], []));
