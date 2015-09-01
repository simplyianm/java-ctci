import java.util.*;

public class Problem2_1 {
  public static void main(String args[]) {
    Node list = makeList(new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 1, 5, 7 });
    printList(list);
    removeDupes(list);
    printList(list);
  }

  public static void removeDupes(Node head) {
    Set<Integer> ints = new HashSet<>();

    Node node = head;
    ints.add(node.val);
    while (node.next != null) {
      if (ints.contains(node.next.val)) {
        node.next = node.next.next;
      } else {
        ints.add(node.next.val);
        node = node.next;
      }
    }
  }

  public static Node makeList(int[] arr) {
    // makes list backwards bc im a lazy pos
    Node head = null;
    for (int i : arr) {
      if (head == null) {
        head = new Node(i);
      } else {
        Node h = new Node(i);
        h.next = head;
        head = h;
      }
    }
    return head;
  }

  public static void printList(Node head) {
    List<Integer> list = new ArrayList<>();
    while (head != null) {
      list.add(head.val);
      head = head.next;
    }
    System.out.println(list);
  }

  static class Node {
    Node next;
    int val;

    public Node(int val) {
      this.val = val;
    }
  }
}
