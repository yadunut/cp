# 199. Binary Tree Right Side View
# Definition for a binary tree node.
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left: Optional[TreeNode] = left
        self.right: Optional[TreeNode] = right
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


class Solution:
    # level order traversal with BFS, print the rightmost element
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if root == None:
            return result
        q = [root]
        while q:
            print([e.val for e in q])
            result.append(q[len(q) - 1].val)
            for _ in range(len(q)):
                curr = q.pop(0)
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)

        return result

s = Solution()
print(s.rightSideView(TreeNode.fromList([1,2,3,None,5,None,4])))
