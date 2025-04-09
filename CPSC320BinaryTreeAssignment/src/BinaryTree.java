import java.util.Queue;

public class BinaryTree<T> {
	
	BiNode root = null;
	
	public BinaryTree(T leftData, T rootdata, T rightData) {
		BiNode<T> left = null;
		BiNode<T> right = null;
		if (leftData != null) { // create leaf
			left = new BiNode(null, leftData, null);
		}
		if (rightData != null) { // create leaf
			right = new BiNode(null, rightData, null);
		}
		root = new BiNode(left, rootdata, right);
	}
	
	public BinaryTree(BinaryTree<T> leftChild, T rootData, BinaryTree<T> rightChild) {
		root = new BiNode(rootData);
		if (leftChild != null) {
			root.setLchild(leftChild.getRoot());
		}
		if (rightChild != null) {
			root.setRchild(rightChild.getRoot());
		}
	}
	
	/** wrapper for recursive call with root node */
	public void postorderPrint() {
		postorderPrint(root);
	}
	
	/** print children after root, recursively */
	private void postorderPrint(BiNode tree) {
		
		if (tree != null && tree.data != null) {
			
			if (tree.lchild != null) {
				postorderPrint(tree.lchild);
			}
			if (tree.rchild != null) {
				postorderPrint(tree.rchild);
			}
			System.out.print(tree.getData().toString() + " ");
		}
	}
	
	public BiNode getRoot() {
		return root;
	}
	
	/** private inner class means enclosing class can access BiNode data*/
	class BiNode<T> {
		
		
		
		T data = null;
		BiNode lchild = null;
		BiNode rchild = null;
		
		BiNode(T rootData) {
			data = rootData;
		}
		
		BiNode(BiNode left, T element, BiNode right) {
			lchild = left;
			rchild = right;
			data = element;
		}
		
		public T getData() {
			return data;
		}
		
		public void setData(T data) {
			this.data = data;
		}
		
		public BiNode getLchild() {
			return lchild;
		}
		
		public void setLchild(BiNode lchild) {
			this.lchild = lchild;
		}
		
		public BiNode getRchild() {
			return rchild;
		}
		
		public void setRchild(BiNode rchild) {
			this.rchild = rchild;
		}
	}
	
	public void inorderPrint() {
		inorderPrint(root);
		System.out.println();
	}
	
	private void inorderPrint(BiNode tree) {
		if (tree != null && tree.data != null) {
		inorderPrint(tree.lchild);
		System.out.print(tree.data.toString() + " ");
		inorderPrint(tree.rchild);
		}
	}
	
	public void levelByLevelPrint() {
		levelByLevelPrint(root);
	}
	
	private void levelByLevelPrint(BiNode tree) {
		if (tree == null) return;
		
		BiNode[] queue = new BiNode[100];
		int top = 0;
		int bottom = 0;
		
		queue[bottom++] = root;
		
		while (top < bottom) {
			BiNode current = queue[top++];
			
			if (current != null && current.data != null) {
				System.out.print(current.data + " ");
				
				if (current.lchild != null) {
					queue[bottom++] = current.lchild;
				}
				if (current.rchild != null) {
					queue[bottom++] = current.rchild;
				}
			}
		}
		
		System.out.println();
	}
	
	public int size() {
		return size(root);
		
	}
	
	private int size(BiNode tree) {
		if (tree == null || tree.data == null) return 0;
				return 1 + size(tree.lchild) + size(tree.rchild);
	}
	
	public double solve() {
		return solve(root);
	}
	
	public double solve(BiNode tree) {
		if (tree == null || tree.data == null) return 0;
		
		if (tree.lchild == null && tree.rchild == null) {
			return Double.parseDouble(tree.data.toString());
		}
		
		double left = solve(tree.lchild);
		double right = solve(tree.rchild);
		String operationSymbol = tree.data.toString();
		
		if (operationSymbol.equals("+")) {
			return left + right;
		}
		else if (operationSymbol.equals("-")) {
			return left - right;
		}
		else if (operationSymbol.equals("*")) {
			return left * right;
		}
		else if (operationSymbol.equals("/")) {
			return left / right;
		}
		else {
			return 0;
		}
		
	}
	
	

}
