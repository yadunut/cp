from typing import Optional, List

# 105. Construct Binary Tree from Preorder and Inorder Traversal
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val: int = val
        self.left: Optional[TreeNode] = left
        self.right: Optional[TreeNode] = right


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder:
            return None
        root = TreeNode(preorder[0])
        pivot = inorder.index(preorder[0])
        root.left = self.buildTree(preorder[1 : pivot + 1], inorder[0:pivot])
        root.right = self.buildTree(preorder[pivot+1:], inorder[pivot+1:])
        return root


s = Solution()
def printNode(r):
    res = []
    def dfs(root):
        if not root:
            return
        res.append(root.val)
        dfs(root.left)
        dfs(root.right)
    dfs(r)
    return res

r = s.buildTree(preorder=[3, 9, 20, 15, 7], inorder=[9, 3, 15, 20, 7])
print(printNode(r))
