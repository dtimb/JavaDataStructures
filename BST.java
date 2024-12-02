/*
* Binary Search Tree
*/
public class BST<E extends Comparable> {
	private Node<E> root;

	public BST() {
		root = null;
	}

	/*-------------------------------------------------------------
	* Add node
	*
	* Wrapper method for add()
	*
	* @param item item to be added to the tree
	* @return boolean; true if item is added to the tree
	*/
	public boolean add(E item) {
		if (root == null) {
			root = new Node<E>(item);
			return true;
		} else {
			return add(root, item);
		}
	}

	/*
	 * Internal recursive method for add
	 *
	 * @param localRoot root of a subtree
	 * 
	 * @param item item to be added to the tree
	 * 
	 * @return boolean; true if item is added to the tree
	 */
	private boolean add(Node<E> localRoot, E item) {
		if (item.compareTo(localRoot.data) == 0) {
// item found - do not add
			return false;
		}
// item is less than localRoot
		else if (item.compareTo(localRoot.data) < 0) {
			if (localRoot.left == null) // if no left subtree, add
			{
				localRoot.left = new Node<E>(item);
				return true;
			} else {
				return add(localRoot.left, item);
			}
		}
// item is greater than localRoot
		else {
			if (localRoot.right == null) // if no right subtree, add
			{
				localRoot.right = new Node<E>(item);
				return true;
			} else {
				return add(localRoot.right, item);
			}
		}
	}

	/*-------------------------------------------------------------
	* Find node
	*
	* Wrapper method for find()
	*
	* @param item item to find in the tree
	* @return E item found, null if not found
	*/
	public E find(E item) {
		if (root == null) // tree is empty
		{
			return null;
		} else {
			return find(root, item);
		}
	}

	/*
	 * Internal recursive method for find
	 *
	 * @param localRoot root of a subtree
	 * 
	 * @param item item to find in the tree
	 * 
	 * @return E item found, null if not found
	 */
	private E find(Node<E> localRoot, E item) {
		if (item.compareTo(localRoot.data) == 0) {
// item found
			return localRoot.data;
		}
// item is less than localRoot
		else if (item.compareTo(localRoot.data) < 0) {
			if (localRoot.left == null) // if no left subtree, not found
			{
				return null;
			} else {
				return find(localRoot.left, item);
			}
		}
// item is greater than localRoot
		else {
			if (localRoot.right == null) // if no right subtree, not found
			{
				return null;
			} else {
				return find(localRoot.right, item);
			}
		}
	}

	/*-------------------------------------------------------------
	* Display formatted binary tree
	*/
	public String toString() {
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root, 1, sb);
		return sb.toString();
	}

	/*
	 * Build formatted tree using preorder traversal
	 *
	 * @param node current node in traversal
	 * 
	 * @param depth depth in tree
	 * 
	 * @param sb StringBuilder object containing formatted tree
	 */
	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
		for (int i = 1; i < depth; i++)
			sb.append(" ");
		if (node == null) {
			sb.append("null\n");
		} else {
			sb.append(node.data.toString());
			sb.append("\n");
			preOrderTraverse(node.left, depth + 1, sb);
			preOrderTraverse(node.right, depth + 1, sb);
		}
	}

	/*-------------------------------------------------------------
	* Node inner class
	*/
	private static class Node<E> {
		private E data;
		private Node<E> left;
		private Node<E> right;

		private Node(E data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		private Node(E data, Node<E> left, Node<E> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
}