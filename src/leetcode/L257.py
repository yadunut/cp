from typing import Optional, List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left: Optional["TreeNode"] = None
        self.right: Optional["TreeNode"] = None

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
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        result = []
        if not root:
            return result

        def dfs(node, path=[]):
            # path.append(node)
            if not node.left and not node.right:
                result.append("".join(map(str, path + [node])))
                return
            if node.left:
                dfs(node.left, path + [node])
            if node.right:
                dfs(node.right, path + [node])

        dfs(root)
        return result
