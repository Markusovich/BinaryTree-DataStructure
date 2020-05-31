package source;

public interface BinaryTreeInterface<T> extends TreeInterface<T>, TreeIteratorInterface<T> {
	
	public void setRootData(T rootData);  //Sets data portion of root node
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree);
	//Sets left and right node for root. Recursive type behavior.

}
