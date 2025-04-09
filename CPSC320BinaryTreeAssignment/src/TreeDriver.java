/**
 * 
 * @author kwhitman
 */
public class TreeDriver {
	
	public static void main(String[] args) {
		BinaryTree<String> t1 = new BinaryTree<String>("5", "+", "3");
		
		BinaryTree<String> t2 = new BinaryTree<String>("8", "-", "4");
		
		BinaryTree<String> t3 = new BinaryTree<String>(t1, "*", t2);
		System.out.println("postorder");
		t3.postorderPrint();
		
		System.out.println();
		System.out.println();
		System.out.println("Inorder");
		t3.inorderPrint();
		
		System.out.println();
		System.out.println("Level By Level");
		t3.levelByLevelPrint();
		
		System.out.println();
		System.out.println("Size" + "\n" + t3.size());
		
		System.out.println();
		System.out.println("Value" + "\n" + t3.solve());
		
		
	}

}
