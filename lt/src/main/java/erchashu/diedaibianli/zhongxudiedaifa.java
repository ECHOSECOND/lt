package erchashu.diedaibianli;

public class zhongxudiedaifa {

    /**
     * 递归二叉树脑子里要有 一下子到最左侧叶子节点 然后回到最左侧叶子节点的父节点，去找父节点的右节点
     */

    /**
     * class Solution {
     * public:
     *     vector<int> inorderTraversal(TreeNode* root) {
     *         vector<int> result;
     *         stack<TreeNode*> st;
     *         TreeNode* cur = root;
     *         while (cur != NULL || !st.empty()) {  // 1. 注意while控制的是 两种情况：1.  cur!=nulll 是往栈加元素，直到cur==null 也就是一路走到最左侧边角的left节点 2. cur==null 从栈取元素 取最左侧第一个root节点开始处理 root的右节点
     *             if (cur != NULL) { // 指针来访问节点，访问到最底层
     *                 st.push(cur); // 将访问的节点放进栈
     *                 cur = cur->left;                // 左
     *             } else {
     *                 cur = st.top(); // 从栈里弹出的数据，就是要处理的数据（放进result数组里的数据）
     *                 st.pop();
     *                 result.push_back(cur->val);     // 中
     *                 cur = cur->right;               // 右
     *             }
     *         }
     *         return result;
     *     }
     * };
     */
}
