package task2;

public class BST {
	private static class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	private Node root;

	public BST() {
		root = null;
	}

	public void insert(int data) {
		root = insertRec(root, data);
	}

	private Node insertRec(Node root, int data) {
		// Trường hợp ngoại lệ: Nếu nút đã tồn tại, không thêm vào và thông báo cho
		// người dùng
		if (root != null && root.data == data) {
			System.out.println("Node with value " + data + " already exists!");
			return root;
		}

		if (root == null) {
			root = new Node(data);
			return root;
		}

		if (data < root.data)
			root.left = insertRec(root.left, data);
		else if (data > root.data)
			root.right = insertRec(root.right, data);

		return root;
	}

	public void delete(int data) {
		root = deleteRec(root, data);
	}

	private Node deleteRec(Node root, int data) {
		if (root == null)
			return root;

		if (data < root.data)
			root.left = deleteRec(root.left, data);
		else if (data > root.data)
			root.right = deleteRec(root.right, data);
		else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			root.data = minValue(root.right);
			root.right = deleteRec(root.right, root.data);
		}

		return root;
	}

	int minValue(Node root) {
		int minValue = root.data;
		while (root.left != null) {
			minValue = root.left.data;
			root = root.left;
		}
		return minValue;
	}

	public boolean search(int data) {
		return searchRec(root, data);
	}

	private boolean searchRec(Node root, int data) {
		if (root == null)
			return false;
		if (root.data == data)
			return true;

		return data < root.data ? searchRec(root.left, data) : searchRec(root.right, data);
	}

	public void inorder() {
		inorderRec(root);
	}

	private void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.data + " ");
			inorderRec(root.right);
		}
	}

	public void preorder() {
		preorderRec(root);
	}

	private void preorderRec(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorderRec(root.left);
			preorderRec(root.right);
		}
	}

	public void postorder() {
		postorderRec(root);
	}

	private void postorderRec(Node root) {
		if (root != null) {
			postorderRec(root.left);
			postorderRec(root.right);
			System.out.print(root.data + " ");
		}
	}

	public static void main(String[] args) {
		BST bst = new BST();

		// Thêm các phần tử
		System.out.println("Adding elements: 25, 15, 10, 4, 12, 22, 18, 24, 50, 35, 31, 44, 70, 66, 90");
		int[] elementsToAdd = { 25, 15, 10, 4, 12, 22, 18, 24, 50, 35, 31, 44, 70, 66, 90 };
		for (int element : elementsToAdd) {
			bst.insert(element);
		}

		// Duyệt và in kết quả
		System.out.println("Preorder traversal:");
		bst.preorder();
		System.out.println("\nInorder traversal:");
		bst.inorder();
		System.out.println("\nPostorder traversal:");
		bst.postorder();

		// Thêm phần tử 15 (đã tồn tại)
		System.out.println("\n\nAdding element 15 again to the BST");
		bst.insert(15);
		bst.inorder();

		// Xóa phần tử 50
		System.out.println("\n\nDeleting element 50 from the BST");
		bst.delete(50);
		bst.inorder();

		// Kiểm tra tìm kiếm
		int searchValue = 22;
		System.out.println("\n\nSearching for " + searchValue);
		System.out.println("Found " + searchValue + ": " + bst.search(searchValue));

		// Kiểm tra tìm kiếm một giá trị không tồn tại
		searchValue = 100;
		System.out.println("\nSearching for " + searchValue);
		System.out.println("Found " + searchValue + ": " + bst.search(searchValue));
	}

}
