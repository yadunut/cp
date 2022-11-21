class TreeNode {
	val: number;
	left: TreeNode | null;
	right: TreeNode | null;
	constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
		this.val = val === undefined ? 0 : val;
		this.left = left === undefined ? null : left;
		this.right = right === undefined ? null : right;
	}
}

function findTarget(root: TreeNode | null, k: number): boolean {
	return find(root, new Set<number>(), k);
}

function find(root: TreeNode | null, set: Set<number>, k: number): boolean {
	if (root == null) {
		return false;
	}
	if (set.has(k - root.val)) {
		return true;
	}
	set.add(root.val);
	return find(root.left, set, k) || find(root.right, set, k);
}

function findTarget_opt(root: TreeNode | null, k: number): boolean {
	if (root == null) return false;
	if (root.val === k) return true;
}
