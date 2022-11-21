class ListNode {
	val: number;
	next: ListNode | null;
	constructor(val?: number, next?: ListNode | null) {
		this.val = val === undefined ? 0 : val;
		this.next = next === undefined ? null : next;
	}
}

function addTwoNumbers(
	l1: ListNode | null | undefined,
	l2: ListNode | null | undefined,
): ListNode | null {
	let result: ListNode | null = new ListNode();
	let current: ListNode | null = result;

	let carry = 0;
	while (l1 != null || l2 != null || carry !== 0) {
		current.next = new ListNode();
		current = current.next;
		current.val += l1?.val ?? 0;
		current.val += l2?.val ?? 0;
		current.val += carry;
		carry = 0;
		if (current.val >= 10) {
			current.val -= 10;
			carry++;
		}
		l1 = l1?.next;
		l2 = l2?.next;
	}
	return result.next;
}
