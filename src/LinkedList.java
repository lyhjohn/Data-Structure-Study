/**
 * 연결리스트 삽입, 삭제, 출력, 검색 기능 구현
 */
class Node {

	int data;
	Node next;

	Node() {
	}

	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

}

public class LinkedList {

	Node head;

	public LinkedList() {
	}

	public LinkedList(Node head) {
		this.head = head;
	}

	// empty check
	public boolean isEmpty() {
		if (this.head == null) {
			return true;
		}
		return false;
	}

	// data 추가
	public void addData(int data) {
		if (this.head == null) {
			this.head = new Node(data, null);
			return;
		}

		Node cur = this.head;
		// head is not null -> 현재 노드(cur)를 가장 끝 노드로 지정한다.
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = new Node(data, null);
	}

	// data 삭제
	public void removeData() {

		if (isEmpty()) {
			System.out.println("List is empty!");
			return;
		}

		Node cur = this.head;
		Node prev = cur;
		while (cur.next != null) {
			prev = cur;
			cur = cur.next;
		}

		// int 타입인 cur을 null로 바꾸는건 불가능.
		// Integer로 가져가는 것 보다는 prev.next를 null로 만듦으로써 관계를 아예 끊어내자.
		if (cur == this.head) {
			this.head = null;
		} else {
			prev.next = null;
		}
	}

	// data 검색
	public void findData(int data) {
		if (isEmpty()) {
			System.out.println("List is empty!");
			return;
		}

		int idx = 0;
		Node cur = this.head;

		// cur.next가 아닌 cur를 탐색하는 것에 주의
		while (cur != null) {
			if (cur.data == data) {
				System.out.println("Data index = " + idx);
				return;
			}
			idx++;
			cur = cur.next;
		}
		System.out.println("Data is not found");
	}


	// data 출력
	public void printData() {
		if (isEmpty()) {
			System.out.println("List is empty!");
			return;
		}

		Node cur = this.head;
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
	}

	public static void main(String[] args) {
		Node node1 = new Node(1, null);
		LinkedList list = new LinkedList(node1);
		list.addData(2);
		list.addData(3);
		list.addData(4);
		list.removeData();

		list.findData(4);
		list.printData();

	}
}