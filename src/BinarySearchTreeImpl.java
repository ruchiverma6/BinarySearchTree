
public class BinarySearchTreeImpl {
	NodeData root;

	public static void main(String[] args) {
		BinarySearchTreeImpl bstImpl = new BinarySearchTreeImpl();
		bstImpl.insert(10, bstImpl.root);
		bstImpl.insert(20, bstImpl.root);
		bstImpl.insert(5, bstImpl.root);
		bstImpl.insert(3, bstImpl.root);
		bstImpl.insert(15, bstImpl.root);
		bstImpl.insert(14, bstImpl.root);
		// bstImpl.inOrderTraversal(bstImpl.root);
		//bstImpl.preOrderTraversal(bstImpl.root);
		
		bstImpl.deleteNodeFromBst(10,  bstImpl.root);
		bstImpl.postOrderTraversal(bstImpl.root);
	}

	private void insert(int value, NodeData current) {

		if (root == null) {
			root = new NodeData(value);

		} else if (value <= current.value) {
			if (current.left == null) {
				current.left = new NodeData(value);
				return;
			}
			insert(value, current.left);
		} else if (value > current.value) {
			if (current.right == null) {
				current.right = new NodeData(value);
				return;
			}
			insert(value, current.right);
		}

	}

	private void inOrderTraversal(NodeData current) {
		if (current == null) {
			return;
		}
		inOrderTraversal(current.left);
		System.out.println(current.value);
		inOrderTraversal(current.right);
	}

	private void preOrderTraversal(NodeData current) {

		if (current == null) {
			return;
		}
		System.out.println(current.value);
		preOrderTraversal(current.left);
		preOrderTraversal(current.right);
	}

	private void postOrderTraversal(NodeData current) {

		if (current == null) {
			return;
		}

		postOrderTraversal(current.left);
		postOrderTraversal(current.right);
		System.out.println(current.value);
	}
	
	private NodeData deleteNodeFromBst(int value, NodeData current) {
		if(value < current.value) {
			current.left = deleteNodeFromBst(value, current.left);
		}else if(value> current.value) {
			current.right = deleteNodeFromBst(value, current.right);
		}else {
			if(current.left == null) {
				return current.right;
			}else if(current.right == null) {
				return current.left;
			}else {
			int data = FindMinimum(current.right);
			System.out.println(data);
			current.value = data;
			
			current.right = deleteNodeFromBst(data, current.right);
			}
		}
		return current;
	}

	private int FindMinimum(NodeData nodeData) {
		if(nodeData.left == null) {
			return nodeData.value;
		}
		return FindMinimum(nodeData.left);
		
	}

}
