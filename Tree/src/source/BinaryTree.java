package source;

public class BinaryTree<T> implements BinaryTreeInterface<T> {

	public BinaryNode<T> root;  //creating top node or root of our tree
	
	private void initializeTree() {
		root = null;
	}
	private void initializeTree(T rootData) {
		root = new BinaryNode<>(rootData);
	}
	private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		root = new BinaryNode<T>(rootData);
		if((leftTree != null) && !leftTree.isEmpty()) {
			root.setLeftChild(leftTree.root.copy());  //copies entire left tree
		}
		if((rightTree != null) && !rightTree.isEmpty()) {
			root.setRightChild(rightTree.root.copy());  //copies entire right tree
		}
	}
	public BinaryTree() {
		initializeTree();
	}
	public BinaryTree(T rootData) {
		initializeTree(rootData);
	}
	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		initializeTree(rootData, leftTree, rightTree);
	}
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		initializeTree(rootData, (BinaryTree<T>)leftTree, (BinaryTree<T>)rightTree);
	}
	public void setTree(T rootData) {
		initializeTree(rootData);
	}
	
	public T getRootData() {
		if(isEmpty()) {
			return null;
		}
		else {
			return root.getData();
		}
	}
	public int getHeight() {
		return root.getHeight();
	}
	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	}
	public boolean isEmpty() {
		return root == null;
	}
	public void clear() {
	    root = null;
	}
	public void setRootData(T rootData) {
		root.setData(rootData);
	}
	public BinaryNode<T> add(BinaryNode<T> node, T item){  //add item starting at this node
		if(node == null) {
			node = new BinaryNode<T>(item);
		}
		else {
			if((int)item < (int)node.getData()) {
				node.setLeftChild(add(node.getLeftChild(), item));
			}
			else {
				node.setRightChild(add(node.getRightChild(), item));
			}
		}
		return node;
	}
	public void inorderTraversal() {
		inorderTraversal(root);
	}
	private void inorderTraversal(BinaryNode<T> node) {  //start at root
		if(node == null) {
			return;
		}
		inorderTraversal(node.getLeftChild());
		System.out.print(node.getData() + " ");
		inorderTraversal(node.getRightChild());
		return;
		
	}
	public void preOrderTraversal() {
		preOrderTraversal(root);
	}
	private void preOrderTraversal(BinaryNode<T> node) {
		if(node == null) {
			return;
		}
		System.out.print(node.getData() + " ");
		preOrderTraversal(node.getLeftChild());
		preOrderTraversal(node.getRightChild());
		return;
		
	}
	public void postOrderTraversal() {
		postOrderTraversal(root);
	}
	private void postOrderTraversal(BinaryNode<T> node) {
		if(node == null) {
			return;
		}
		postOrderTraversal(node.getLeftChild());
		postOrderTraversal(node.getRightChild());
		System.out.print(node.getData() + " ");
		return;
		
	}

}
