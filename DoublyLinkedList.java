
import java.util.*;

public class DoublyLinkedList {
    static Node start;

    static Scanner sc = new Scanner(System.in);

    static class Node {
        protected int regd_no;
        protected float mark;
        protected Node next;
        protected Node prev;

    }

    public static Node create(Node start) {
        Node newNode = new Node();
        System.out.println("Input registration no. and marks of the student: ");
        newNode.regd_no = sc.nextInt();
        newNode.mark = sc.nextFloat();
        newNode.next = newNode.prev = null;
        start = newNode;
        System.out.println("Do you want to add more nodes(1/0)");
        int ch = sc.nextInt();
        Node anotherNode;
        while (ch == 1) {
            anotherNode = new Node();
            System.out.println("Input registration no. and marks of the student: ");
            anotherNode.regd_no = sc.nextInt();
            anotherNode.mark = sc.nextFloat();
            anotherNode.next = anotherNode.prev = null;
            newNode.next = anotherNode;
            anotherNode.prev = newNode;
            newNode = anotherNode;
            System.out.println("Do you want to add more nodes(1/0)");
            ch = sc.nextInt();
        }
        System.out.println("List created: ");
        return (start);
    }

    public static Node insertAtBeg(Node start) {
        Node newNode = new Node();
        System.out.println("Input registration no. and marks of the student: ");
        newNode.regd_no = sc.nextInt();
        newNode.mark = sc.nextFloat();
        if (start == null) {
            start = newNode;
            newNode.prev = null;
            newNode.next = null;
        } else if (start != null) {
            newNode.next = start;
            start.prev = newNode;
            start = newNode;
            newNode.prev = null;
            System.out.println("List Updated");
        }
        return (start);
    }

    public static Node insertAtEnd(Node start) {
        Node newNode = new Node();
        System.out.println("Input registration no. and marks of the student: ");
        newNode.regd_no = sc.nextInt();
        newNode.mark = sc.nextFloat();
        if (start == null) {
            start = newNode;
            newNode.prev = null;
            newNode.next = null;
        } else if (start != null) {
            Node last = start;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
            newNode.next = null;
            newNode.prev = last;
            System.out.println("List updated");
        }
        return (start);
    }

    public static int count(Node start) {
        int count = 0;
        Node currentNode = start;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }

    public static Node insertAtAny(Node start) {
        Node newNode = new Node();
        System.out.println("Input registration no. and marks of the student: ");
        newNode.regd_no = sc.nextInt();
        newNode.mark = sc.nextFloat();
        System.out.println("enter the node no. after which you want to insert: ");
        int location = sc.nextInt();
        Node currentNode = start;
        int c = count(start);
        int counter = 1;
        if (location == 1 && start != null) {
            newNode.next = start.next;
            start.next = newNode;
            newNode.prev = start;
            System.out.println("list updated");
        } else if (location == c) {
            insertAtEnd(start);
            System.out.println("list updated");
        } else if (location < c) {
            while (currentNode != null) {
                if (counter == location) {
                    newNode.prev = currentNode;
                    newNode.next = currentNode.next;
                    currentNode.next = newNode;
                    System.out.println("list updated");
                    break;
                } else {
                    currentNode = currentNode.next;
                    counter++;
                }
            }
        } else {
            System.out.println("location not found");
        }
        return (start);
    }

    public static Node delBeg(Node start) {
        if (start == null) {
            System.out.println("List is empty");
        } else {
            start = start.next;
            start.prev = null;
        }
        System.out.println("List updated");
        return (start);
    }

    public static Node delEnd(Node start) {
        Node last = start;
        if (start == null) {
            System.out.println("List is empty");
        } else {
            while (last.next != null) {
                last = last.next;
            }
            last.prev.next = null;
        }
        System.out.println("List updated");
        return (start);
    }

    public static Node delFromAny(Node start) {
        System.out.println("Enter the node no. which you want to delete");
        int location = sc.nextInt();
        int c = count(start);
        if (start == null) {
            System.out.println("List is empty");
        } else if (location == 1) {
            delBeg(start);
        } else if (location == c) {
            delEnd(start);
        } else {
            Node currentNode = start;
            int counter = 1;
            while (location != counter && currentNode != null) {
                currentNode = currentNode.next;
                counter++;
            }
            if (location == counter && currentNode != null) {
                currentNode.prev.next = currentNode.next;
                currentNode.next.prev = currentNode.prev;
                System.out.println("List Updated");
            } else {
                System.out.println("location not found");
            }
        }
        return (start);
    }

    public static void search(Node start) {
        System.out.println("Enter the regd_no to update the marks: ");
        int reg_No = sc.nextInt();
        Node currentNode = start;
        while (currentNode != null) {
            if (currentNode.regd_no != reg_No) {
                currentNode = currentNode.next;
            } else if (currentNode.regd_no == reg_No) {
                System.out.println("Enter new mark: ");
                currentNode.mark = sc.nextFloat();
                System.out.println("Marks updated");
                return;
            } else {
                System.out.println("Error: regd_no not found");
                return;
            }

        }
    }

    public static void Display(Node start) {
        Node currentNode = start;
        System.out.println("List: ");
        while (currentNode != null) {
            System.out.print("(" + currentNode.regd_no + ": " + currentNode.mark + "), ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public static void menuFunction() {
        int choice = 0;
        while (choice != 1) {
            System.out.println("1:Exit");
            System.out.println("2:Display");
            System.out.println("3:Insert a node at beginning of the list");
            System.out.println("4:Insert a node at the end of the list");
            System.out.println("5:Insert a node at a specific position of the list");
            System.out.println("6:Delete a node from the beggining of the list");
            System.out.println("7:Delete a node from the end of the list");
            System.out.println("8:Delete a node from a specific position of the list");
            System.out.println("9:Search the list");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.exit(0);
                case 2:
                    Display(start);
                    break;
                case 3:
                    start = insertAtBeg(start);
                    break;
                case 4:
                    start = insertAtEnd(start);
                    break;
                case 5:
                    start = insertAtAny(start);
                    break;
                case 6:
                    start = delBeg(start);
                    break;
                case 7:
                    start = delEnd(start);
                    break;
                case 8:
                    start = delFromAny(start);
                    break;
                case 9:
                    search(start);
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("****MENU*****");
            System.out.println("0:Exit");
            System.out.println("1:Creation");
            System.out.println("2:Display");
            System.out.println("Enter the choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    start = create(start);
                    break;
                case 2:
                    Display(start);
                    break;
                default:
                    System.out.println("Wrong choice");
            }
            menuFunction();
        }
    }
}