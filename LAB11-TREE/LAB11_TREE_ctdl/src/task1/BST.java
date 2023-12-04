package task1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	public void add(E e) {
		if (root == null) {
			root = new BNode<>(e);
		} else {
			root.addRecursive(e);
		}
	}

	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	// Phương thức để tính độ sâu của một nút
	public int depth(E node) {
		if (root == null)
			return -1;
		return root.depth(node, 0);
	}

	// Method to calculate the height of the BST
	public int height() {
		// If the tree is empty, its height is 0
		if (root == null) {
			return 0; // Sửa đổi từ -1 thành 0
		}
		// Otherwise, calculate the height of the tree
		return root.height();
	}

	// Phương thức để tính tổng số nút
	public int size() {
		if (root == null) {
			return 0;
		} else {
			return root.size();
		}
	}

	// Phương thức để kiểm tra sự tồn tại của một giá trị
	public boolean contains(E e) {
		if (root == null) {
			return false;
		} else {
			return root.contains(e);
		}
	}

	// Phương thức tìm giá trị nhỏ nhất trong BST
	// Phương thức tìm giá trị nhỏ nhất trong BST
	public E findMin() {
		if (this.root == null) {
			throw new NoSuchElementException("The BST is empty.");
		}
		return this.root.findMinNode().getData();
	}

	// Phương thức tìm giá trị lớn nhất trong BST
	public E findMax() {
		if (this.root == null) {
			throw new NoSuchElementException("The BST is empty.");
		}
		return this.root.findMaxNode().getData();
	}

	// Method to remove a value from the BST
	// Method to remove a value from the BST
	public void remove(E e) {
		if (root == null) {
			return; // Cannot remove from an empty tree
		}
		root = removeRecursive(root, e);
	}

	private BNode<E> removeRecursive(BNode<E> current, E value) {
		if (current == null) {
			return null;
		}

		if (value.equals(current.getData())) {
			// Node to delete found
			if (current.getLeft() == null && current.getRight() == null) {
				return null; // No children
			}
			if (current.getRight() == null) {
				return current.getLeft();
			}
			if (current.getLeft() == null) {
				return current.getRight();
			}

			// Node with two children: Get data from the rightmost node in the left subtree
			E smallestValue = findSmallestValue(current.getRight());
			current.setData(smallestValue);
			current.setRight(removeRecursive(current.getRight(), smallestValue));
			return current;
		}
		if (value.compareTo(current.getData()) < 0) {
			current.setLeft(removeRecursive(current.getLeft(), value));
			return current;
		}
		current.setRight(removeRecursive(current.getRight(), value));
		return current;
	}

	private E findSmallestValue(BNode<E> root) {
		return root.getLeft() == null ? root.getData() : findSmallestValue(root.getLeft());
	}

	// Method to get the descendants of a node
	public List<E> descendants(E data) {
		if (root == null) {
			return new ArrayList<>(); // If the tree is empty, return an empty list
		}
		BNode<E> node = root.findNode(data);
		return (node != null) ? node.descendants() : new ArrayList<>();
	}

	// Method to get the ancestors of a node
	// Phương thức để lấy danh sách các tổ tiên của một nút cụ thể
	public List<E> ancestors(E data) {
		if (data == null) {
			throw new IllegalArgumentException("Data cannot be null.");
		}
		List<E> ancestorList = new ArrayList<>();
		findAncestors(root, data, ancestorList);
		return ancestorList;
	}

	// Phương thức trợ giúp để tìm tổ tiên một cách đệ quy
	private boolean findAncestors(BNode<E> currentNode, E data, List<E> ancestorList) {
		// Nếu nút hiện tại là null, tức là giá trị không tồn tại trong cây
		if (currentNode == null) {
			return false;
		}
		// Nếu tìm thấy nút, trả về true
		if (currentNode.getData().compareTo(data) == 0) {
			return true;
		}
		// Nếu giá trị nằm ở bên trái của nút hiện tại
		if (data.compareTo(currentNode.getData()) < 0) {
			if (findAncestors(currentNode.getLeft(), data, ancestorList)) {
				ancestorList.add(currentNode.getData()); // thêm nút hiện tại vào danh sách nếu tìm thấy nút trong nhánh
															// con
				return true;
			}
		}
		// Nếu giá trị nằm ở bên phải của nút hiện tại
		else {
			if (findAncestors(currentNode.getRight(), data, ancestorList)) {
				ancestorList.add(currentNode.getData()); // thêm nút hiện tại vào danh sách nếu tìm thấy nút trong nhánh
															// con
				return true;
			}
		}
		return false;
	}

	// Method to get all descendants of the node excluding the node itself
	public List<E> getDescendants(E data) {
		if (root == null) {
			return new ArrayList<>(); // If the tree is empty, return an empty list
		}
		BNode<E> node = root.findNode(data);
		return (node != null) ? node.getDescendants() : new ArrayList<>();
	}

	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();

		// Thêm các nút vào BST như trong hình ảnh bạn cung cấp
		int[] nodes = { 25, 15, 50, 10, 22, 35, 70, 4, 12, 18, 24, 31, 44, 66, 90 };
		for (int node : nodes) {
			bst.add(node);
		}

		// Kiểm tra xem các nút có trong BST hay không
		System.out.println("Contains 15: " + bst.contains(15)); // Expected: true
		System.out.println("Contains 90: " + bst.contains(90)); // Expected: true
		System.out.println("Contains 100: " + bst.contains(100)); // Expected: false

		// Tính chiều cao của BST
		System.out.println("Height of BST: " + bst.height()); // Expected: 3

		// Tính kích thước của BST
		System.out.println("Size of BST: " + bst.size()); // Expected: 15

		// Xóa một nút và kiểm tra lại kích thước và chiều cao
		bst.remove(22);
		System.out.println("Size of BST after removing 22: " + bst.size()); // Expected: 14
		System.out.println("Height of BST after removing 22: " + bst.height()); // Expected: 3 or less

		// Lấy danh sách con cháu của nút 50
		// Lấy danh sách hậu duệ của nút 50
		System.out.println("Descendants of 50: " + bst.getDescendants(50)); // Chỉnh sửa từ descendants sang
																			// getDescendants

		// Lấy danh sách tổ tiên của nút 44

		testAncestors(bst, 44);

		testAncestors(bst, 15);
		testAncestors(bst, 70);

		// Kiểm tra độ sâu của một nút
		System.out.println("Depth of node 15: " + bst.depth(15)); // Kỳ vọng: 1 hoặc 2 tùy theo cách tính
		System.out.println("Depth of node 70: " + bst.depth(70)); // Kỳ vọng: 1 hoặc 2 tùy theo cách tính
		System.out.println("Depth of node 31: " + bst.depth(31)); // Kỳ vọng: 3 hoặc 4 tùy theo cách tính
		System.out.println("Depth of node 100 (not in BST): " + bst.depth(100)); // Kỳ vọng: -1 (không tìm thấy)

		// Kiểm tra tìm giá trị nhỏ nhất trong BST
		try {
			Integer min = bst.findMin();
			System.out.println("Minimum value in BST: " + min); // Kỳ vọng: 4
		} catch (NoSuchElementException e) {
			System.out.println("Cannot find minimum value in an empty BST.");
		}

		// Kiểm tra tìm giá trị lớn nhất trong BST
		try {
			Integer max = bst.findMax();
			System.out.println("Maximum value in BST: " + max); // Kỳ vọng: 90
		} catch (NoSuchElementException e) {
			System.out.println("Cannot find maximum value in an empty BST.");
		}
	}

	private static void testAncestors(BST<Integer> bst, Integer value) {
		try {
			List<Integer> ancestors = bst.ancestors(value);
			if (ancestors.isEmpty()) {
				System.out.println("Node " + value + " does not have ancestors or is not present in the BST.");
			} else {
				System.out.println("Ancestors of node " + value + ": " + ancestors);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
