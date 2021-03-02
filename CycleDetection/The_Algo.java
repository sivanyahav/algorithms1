package CycleDetection;

public class The_Algo {
	static Node meeting_point = null;
	static int length_of_arm = 0;

	/**
	 * �� ��� ������ ������ ���� ����� ��"� �� �� �������.
	 * @param list
	 * @return true if there is a cycle. 
	 */
	public static boolean isCycled(LinkedList list) {
		if(list.head == null)
			return false;
		Node hare = list.head;
		Node turtle = list.head;

		while (hare.next.next != null) {
			hare = hare.next.next;
			turtle = turtle.next;
			if(hare == turtle) {
				meeting_point = hare;
				return true;
			}
		}

		return false;
	}
	
	/**
	 * ���� ���� �������� ������ ���� �� ����� ������ ������ ���� ���� ���' �����.
	 * ����� ������� ���� ������� �� ���. ���� �������� �� ����� ���� ����� ����� ����� 
	 * �� ��' ������ �� �����, ����� ��' ����� ���� ��� ��' ������ �� �����.
	 * ����� ����� �� ������ ���� ��� �� ��� ���� ��� ���� �����.
	 * @param list
	 * @return
	 */
	public static Node firstNodeOfCircle(LinkedList list) {
		if(list.head == null)
			return null;

		length_of_arm = 0;
		Node turtle = meeting_point;
		Node hare = list.head;

		while (hare.next != null) {
			if (turtle != null) {
				turtle = turtle.next;
			}
			length_of_arm++;
			hare = hare.next;
			if(hare == turtle) {
				return hare;
			}
		}
		return null;
	}
	
	/**
	 * ����� ���� ���' ������ �� ����� ���� ���� �� ���� ����� �� �����- 
	 * ��' ������ ���� ��� ��� ���� �����.
	 * @param firstNodeOfCircle
	 * @return
	 */
	public static int lengthOfCircle(Node firstNodeOfCircle) {
		int length = 0;
		Node tortoise = firstNodeOfCircle;
		length++;
		tortoise = tortoise.next;
		while (tortoise != firstNodeOfCircle) {
			length++;
			tortoise = tortoise.next;
		}
		return length;
	}
	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		for(int i = 0 ; i < 6 ; i++)
			list.add(new Node());

		list.print();
		System.out.println("isCycled?: " + isCycled(list));
		list.tail.next = list.getNode(2);
		System.out.println("isCycled?: " + isCycled(list));

		// Question 1 - return a node in the circle.
		System.out.println(meeting_point.id);
		
		// Question 2 - return the first node of the circle.
		Node firstNode = firstNodeOfCircle(list);
		System.out.println(firstNode.id);
		
		// Question 3 - return the length of the arm.
		System.out.println(length_of_arm);
		
		// Question 4 - return the length of the circle.
		System.out.println(lengthOfCircle(firstNode));

	}
}
