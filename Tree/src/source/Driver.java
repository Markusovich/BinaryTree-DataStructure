package source;

public class Driver {

	public static void main(String[] args) {
		
		int i = 0;
		int arr[] = {26,41,16,28,22,23,32,42,9,39};
		Queue<Integer> x = new Queue<Integer>();
		while(i < arr.length) {
			x.enqueue(arr[i]);
			i++;
		}
		
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.setTree(x.dequeue());
		while(!x.isEmpty()) {
			int item = x.dequeue();
			tree.add(tree.root, item);
		}
		
		System.out.println("Tree Root: " + tree.getRootData());
		System.out.println("Number of nodes: " + tree.getNumberOfNodes());
		System.out.println("Height of tree: " + tree.getHeight());
		
		System.out.print("Inorder traversal: ");
		tree.inorderTraversal();
		System.out.println();
		System.out.print("Preorder traversal: ");
		tree.preOrderTraversal();
		System.out.println();
		System.out.print("Postorder traversal: ");
		tree.postOrderTraversal();
		System.out.println();
		
	}

}
