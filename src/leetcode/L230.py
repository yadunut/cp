from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    @classmethod
    def fromList(cls, data: List[Optional[int]], index=0) -> Optional["TreeNode"]:
        pNode = None
        if index < len(data):
            if data[index] == None:
                return
            pNode = TreeNode(data[index])
            pNode.left = TreeNode.fromList(data, 2 * index + 1)  # [1, 3, 7, 15, ...]
            pNode.right = TreeNode.fromList(data, 2 * index + 2)  # [2, 5, 12, 25, ...]
        return pNode


# Some intuitions
# Smallest element is the leftmost node with no left children.
# One way is to get the preorder traversal (left, visit, right) and return the kth element in that list
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        path = []

        def dfs(node):
            if not node:
                return
            if len(path) == k:
                return
            dfs(node.left)
            path.append(node.val)
            dfs(node.right)

        dfs(root)
        print(path)
        return path[k - 1]

    def kthSmallestIter(self, root: Optional[TreeNode], k: int) -> int:
        path = []
        stack = [root]
        curr = root
        while curr and stack:
            while curr:
                stack.append(curr)
                curr = curr.left
            # After this, current is at the leftmost place
            curr = stack.pop()  # last added element
            path.append(curr)
            if curr:
                curr = curr.right


s = Solution()
print(s.kthSmallest(TreeNode.fromList([5, 3, 6, 2, 4, None, None, 1]), k=3))
