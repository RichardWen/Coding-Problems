package rWen;

public class Node {

	public int data;
	public Node left;
	public Node right;
	public Node next;
	public Node random;
	
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.next = null;
		this.random = null;
	}

	static public Node SetupTree1() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(5);

		root.left.left = new Node(3);
		root.left.right = new Node(4);

		root.right.right = new Node(6);
		return root;
	}

	static public Node SetupTree2() {
		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);

		root.left.left = new Node(5);
		root.left.right = new Node(15);

		root.right.left = new Node(25);
		root.right.right = new Node(35);

		root.left.right.left = new Node(12);
		root.left.right.right = new Node(18);

		return root;
	}

	static public Node SetupTree3() {
		Node root = new Node(5);
		root.left = new Node(4);
		root.right = new Node(8);

		root.left.left = new Node(11);

		root.right.left = new Node(13);
		root.right.right = new Node(4);

		root.left.left.left = new Node(7);
		root.left.left.right = new Node(2);

		root.right.right.left = new Node(5);
		root.right.right.right = new Node(1);
		return root;
	}

	public static Node SetupList1() {
		Node head = new Node(5);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(1);
		head.random = head.next;
		head.next.random = head.next;
		head.next.next.random = head.next;
		head.next.next.next.random = head.next.next.next.next;
		head.next.next.next.next.random = head.next.next;
		return head;

	}
	public static Node SetupList2() {
		Node head = new Node(5);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(1);
		return head;

	}
	public static Node SetupRing1() {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next  = head;
		return head;
	}
	public int findLevel1(Node root, int count) {
		if (root == null) {
			return count;
		}
		count++;
		int leftTotal = findLevel1(root.left, count);
		int rightTotal = findLevel1(root.right, count);
		if (leftTotal > rightTotal) {
			return leftTotal;
		} else {
			return rightTotal;
		}
	}
	public static void printList(Node root) {
		if(root != null) {
			System.out.println(root.data);
			printList(root.next);
		}
	}
	public int findLevel2(Node root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + Math.max(findLevel2(root.left), findLevel2(root.right));
		}
	}

	public static boolean isSearchTree(Node root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}
		if(root.data > minValue || root.data <= maxValue) {
			return false;
		}
		return isSearchTree(root.left, minValue, Math.min(maxValue, root.data))
				&& isSearchTree(root.right, Math.max(minValue, root.data),
						maxValue);
	}
	public static int getHeight(Node node) {
		if(node == null) {
			return 0;
		}
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}
	
	public static Node findKElement(Node root, int k) {
		Node headLead = root;
		Node headLag  = root;
		for(int i = 0; i < k; i++) {
			if(headLead.next != null) {
				headLead = headLead.next;
			}
			else {
				return null;
			}
		}
		while(headLead != null) {
			headLead = headLead.next;
			headLag = headLag.next;
		}
		return headLag;
	} 
	public static int findLargestSum(Node node) {
		int sumLeft = 0;
		int sumRight = 0;
		if (node != null) {
			sumLeft = findLargestSum(node.left);
			sumRight = findLargestSum(node.right);
			sumLeft += node.data;
			sumRight += node.data;
		}

		if (sumLeft + sumRight > sumRight && sumLeft + sumRight > sumLeft) {
			return sumLeft + sumRight;
		} else if (sumLeft > sumRight) {
			return sumLeft;
		} else {
			return sumRight;
		}

	}
	
	public static Node copyList(Node root) {
		Node newHead = new Node(0);
		Node loop = newHead;
		newHead.data = root.data;
		while(root.next != null) {
			Node addNode = new Node(root.next.data);
			loop.next = addNode;
			loop = loop.next;
			root = root.next;
		
		}
		return newHead;
	}
	public static Node reverseList(Node root) {
		Node prev = null;
		Node current = root;
		Node next;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
	public static Node copyRandomLinkedList(Node root)
	{
		if(root == null) {
			return null;
		}
		Node p = root;
		while(p != null) 
		{
			Node temp1  = new Node(p.data);
			temp1.next = p.next;
			p.next = temp1;
			p = p.next.next;
		}
		p = root;
		while(p != null) 
		{
			p.next.random = p.random.next;
			if(p.next != null) {
				p.next.random = p.random.next;
				}
			p = p.next.next;
			
		}
		p = root;
		Node newRoot = p.next;
		while(p != null) 
		{
			Node temp3 = p.next;
			p.next  = temp3.next;
			if(temp3.next != null) {
				temp3.next = temp3.next.next;
			}
			p = p.next;
		}
		return newRoot;
	}
	public static void reverseRing(Node head)
	{
		Node previousCheck = head;
		Node currentCheck = head.next;
		Node nextCheck;
		if(head == null || previousCheck == currentCheck) {
			return;
		}
		do {
			nextCheck = currentCheck.next;
			currentCheck.next = previousCheck;
			previousCheck = currentCheck;
			currentCheck = nextCheck;
		} while(previousCheck != head);
	}
	public static void printRing(Node head) {
		Node original = head;
		do {
			System.out.println(head.data);
			head = head.next;
		} while(head != original);
	}
	public void printInOrderTraversal(Node root) {
		if(root != null) {
			printInOrderTraversal(root.left);
			System.out.println(root.data);
			printInOrderTraversal(root.right);	
		}
	}
	public static void alterList(Node root) {
		if(root != null) {
			root.next = new Node(root.data);
			alterList(root.next.next);
		}
	} 
	public static void printAlteredList(Node root) {
		if(root != null) {
			System.out.println(root.data);
			printAlteredList(root.next.next);
		}
	}
	public static void main(String[] args) { 
		Node ring1 = SetupRing1();
		reverseRing(ring1);
		printRing(ring1);
	}

}
