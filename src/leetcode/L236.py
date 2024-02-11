from typing import List, Optional


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
    def lowestCommonAncestor(
        self, root: Optional["TreeNode"], p: "TreeNode", q: "TreeNode"
    ) -> Optional["TreeNode"]:
        def dfs(
            node: Optional["TreeNode"], target: "TreeNode", path: List["TreeNode"] = []
        ):
            if not node:
                return None
            if node == target:
                return path + [node]
            left = dfs(node.left, target, path + [node])
            right = dfs(node.left, target, path + [node])
            if left:
                return left
            if right:
                return right

        pPath = dfs(root, p)
        if pPath:
            print([p.val for p in pPath])
        qPath = dfs(root, q)
        if qPath:
            print([p.val for p in qPath])
        # for i in range(min(len(pPath), len(qPath))):
        #   if pPath[i].val != qPath[i].val:
        #     return pPath[i-1]
        # return pPath[i]


def preOrder(node: Optional["TreeNode"]):
    if not node:
        return
    print(node.val)
    preOrder(node.left)
    preOrder(node.right)


s = Solution()
tree = TreeNode.fromList([3, 5, 1, 6, 2, 0, 8, None, None, 7, 4])
# preOrder(tree)
print(s.lowestCommonAncestor(tree, TreeNode(5), TreeNode(4)))
