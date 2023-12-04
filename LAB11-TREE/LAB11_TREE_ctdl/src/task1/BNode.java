package task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BNode<E extends Comparable<E>> {
	private E data;
	private BNode<E> left;
	private BNode<E> right;

	public BNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BNode(E data, BNode<E> left, BNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public BNode<E> getLeft() {
		return left;
	}

	public void setLeft(BNode<E> left) {
		this.left = left;
	}

	public BNode<E> getRight() {
		return right;
	}

	public void setRight(BNode<E> right) {
		this.right = right;
	}

	public BNode<E> addRecursive(E value) {
		if (value == null)
			return this;

		if (value.compareTo(data) < 0) {
			if (left == null) {
				left = new BNode<>(value);
			} else {
				left = left.addRecursive(value);
			}
		} else if (value.compareTo(data) > 0) {
			if (right == null) {
				right = new BNode<>(value);
			} else {
				right = right.addRecursive(value);
			}
		}
		return this; // Trả về nút gốc sau khi chèn
	}

	// Phương thức đệ quy để tính độ sâu
	public int depth(E value, int currentDepth) {
		if (value == null)
			return -1; // Trường hợp không tìm thấy

		if (value.compareTo(data) < 0) {
			return left == null ? -1 : left.depth(value, currentDepth + 1);
		} else if (value.compareTo(data) > 0) {
			return right == null ? -1 : right.depth(value, currentDepth + 1);
		} else {
			return currentDepth; // Tìm thấy nút
		}
	}

	// Recursive method to calculate the height of the tree
	public int height() {
		// If the node is a leaf, its height is 0
		if (left == null && right == null) {
			return 0;
		}
		// Calculate the height of the left and right subtrees
		int leftHeight = (left == null) ? 0 : left.height();
		int rightHeight = (right == null) ? 0 : right.height();
		// The height of the node is the greater of its two children's heights, plus 1
		return Math.max(leftHeight, rightHeight) + 1;
	}

	// Phương thức đệ quy để tính tổng số nút
	public int size() {
		int leftSize = (left == null) ? 0 : left.size();
		int rightSize = (right == null) ? 0 : right.size();
		return 1 + leftSize + rightSize; // 1 cho chính nút hiện tại
	}

	// Phương thức đệ quy để kiểm tra sự tồn tại của một giá trị
	public boolean contains(E value) {
		if (value == null) {
			return false;
		}

		if (value.compareTo(data) < 0) {
			return left != null && left.contains(value);
		} else if (value.compareTo(data) > 0) {
			return right != null && right.contains(value);
		} else {
			// Giá trị bằng nhau, nghĩa là đã tìm thấy nút
			return true;
		}
	}

	

	// Recursive method to remove a value
	public BNode<E> remove(E value, BNode<E> parent) {
		if (value.compareTo(data) < 0) {
			if (left != null) {
				left = left.remove(value, this);
			}
		} else if (value.compareTo(data) > 0) {
			if (right != null) {
				right = right.remove(value, this);
			}
		} else {
			if (left != null && right != null) {
				// Node has two children
				data = right.findMinNode().data;
				right = right.remove(data, this);
			} else {
				if (parent == null) {
					// Removing the root node with one child
					return left != null ? left : right;
				} else if (parent.left == this) {
					parent.left = (left != null) ? left : right;
				} else if (parent.right == this) {
					parent.right = (left != null) ? left : right;
				}
			}
		}
		return this;
	}

	// Method to get all descendants of the node
	public List<E> descendants() {
		List<E> result = new ArrayList<>();
		if (left != null) {
			result.addAll(left.descendants());
		}
		result.add(data); // Add the current node's data
		if (right != null) {
			result.addAll(right.descendants());
		}
		return result;
	}

	public List<E> getDescendants() {
		List<E> result = descendants();
		result.remove(data);
		return result;
	}

	// Helper method to find a node
	public BNode<E> findNode(E value) {
		if (value.compareTo(data) < 0) {
			return (left != null) ? left.findNode(value) : null;
		} else if (value.compareTo(data) > 0) {
			return (right != null) ? right.findNode(value) : null;
		} else {
			return this; // Node found
		}
	}
	

    // Tìm nút có giá trị nhỏ nhất
	// Phương thức tìm nút có giá trị nhỏ nhất trong cây con của nút này
    public BNode<E> findMinNode() {
        if (this.left == null) {
            return this;
        } else {
            return this.left.findMinNode();
        }
    }

    // Phương thức tìm nút có giá trị lớn nhất trong cây con của nút này
    public BNode<E> findMaxNode() {
        if (this.right == null) {
            return this;
        } else {
            return this.right.findMaxNode();
        }
    }

	// Trong lớp BNode<E extends Comparable<E>>
	// Trong lớp BNode<E extends Comparable<E>>
		public List<E> getAncestors(E value) {
			List<E> ancestors = new ArrayList<>();
			BNode<E> current = this;
			while (current != null) {
				int compareResult = value.compareTo(current.data);
				if (compareResult < 0) {
					ancestors.add(current.data);
					current = current.left;
				} else if (compareResult > 0) {
					ancestors.add(current.data);
					current = current.right;
				} else {
					break; // Khi nút được tìm thấy, kết thúc vòng lặp
				}
			}
			if (current == null) {
	// Nếu không tìm thấy nút, trả về một danh sách rỗng hoặc null tùy thuộc vào yêu cầu
				return Collections.emptyList(); // hoặc throw new IllegalArgumentException("Value not found in BST.");
			}
			return ancestors;
		}
		
		

}