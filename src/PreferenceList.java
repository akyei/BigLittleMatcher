import java.util.ArrayList;

public class PreferenceList {
	private class Node {
		private Person key;
		private Node next;

		public Node(Node n) {
			this.key = n.key;
			this.next = n.next;
		}

		public Node(Person p) {
			this.key = p;
			this.next = null;
		}

	}

	private Node head;

	public void enqueue(Node n) {
		if (head == null) {
			head = n;
		} else {
			Node curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = n;
		}
	}


	public Person dequeue() {
		if (head == null){
			return null;
		}
		Node ret = new Node(head);
		head = head.next;
		return ret.key;
	}
	
	

	public PreferenceList(ArrayList<String> preferences) {
		for (String s : preferences) {
			//System.out.println(s);
			Person preference = new Person(s.trim());
			Node n = new Node(preference);
			this.enqueue(n);
		}
	}

	public int indexInList(Person p) {
		int i = 0;
		Node curr = head;
		while (curr != null) {
			if (curr.key.getName().equals(p.getName())) {
				return i;
			} else {
				curr = curr.next;
				i++;
			}
		}
		return -1;
	}

	public boolean inList(Person s) {
		Node curr = head;
		while (curr != null) {
			if (curr.key.getName().equals(s.getName())) {
				return true;
			} else {
				curr = curr.next;
			}
		}
		return false;
	}

	public String toString() {
		Node curr = head;
		StringBuffer buf = new StringBuffer();
		while (curr != null) {
			buf.append("" + curr.key + " -> ");
			curr = curr.next;
		}
		return buf.toString();
	}
}
