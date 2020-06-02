
import java.util.*;

public class LinkedList {
    static Node start;

    static class Node {
        protected int regd_no;
        protected float mark;
        protected Node next;
    }

    static Scanner sc = new Scanner(System.in);

    public static Node create(Node start) {
        Node p = new Node();
        System.out.println("Input registration no. and marks of the student: ");
        p.regd_no = sc.nextInt();
        p.mark = sc.nextFloat();
        p.next = null;
        start = p;
        System.out.println("Do you want more nodes(y/n)");
        char ch = sc.next().charAt(0);
        while (ch != 'n') {
            Node newNode = new Node();
            System.out.println("Input registration no. and marks of the student: ");
            newNode.regd_no = sc.nextInt();
            newNode.mark = sc.nextFloat();
            p.next = newNode;
            p = newNode;
            System.out.println("Do you want more nodes(y/n)");
            ch = sc.next().charAt(0);
        }
        System.out.println("List Created ");
        return start;
    }

    public static Node InsBeg(Node start) {
        Node newNode = new Node();
        System.out.println("Input registration no. and marks of the student: ");
        newNode.regd_no = sc.nextInt();
        newNode.mark = sc.nextFloat();
        newNode.next = null;

        newNode.next = start;
        start = newNode;

        System.out.println("List Updated");
        return start;
    }

    public static Node InsEnd(Node start) {
        Node newNode = new Node();
        System.out.println("Input registration no. and marks of the student: ");
        newNode.regd_no = sc.nextInt();
        newNode.mark = sc.nextFloat();

        if (start == null) {
            start = newNode;
        } else {
            Node last = start;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        System.out.println("List Updated");
        return start;
    }

    public static int count() {
        int c = 0;
        Node p = start;
        while (p != null) {
            c++;
            p = p.next;
        }
        return c;
    }

    public static Node InsAny(Node start) {
        System.out.println("Input node number");
        int location = sc.nextInt();
        int c = count();
        if (location <= c + 1) {
            if (location == 1) {
                InsBeg(start);
            } else if (location == c + 1) {
                InsEnd(start);
            } else {
                Node newNode = new Node();
                System.out.println("Input registration no. and marks of the student: ");
                newNode.regd_no = sc.nextInt();
                newNode.mark = sc.nextInt();
                newNode.next = null;

                Node previousNode = start;
                int cnt = 1;
                while (cnt < location - 1) {
                    cnt++;
                    previousNode = previousNode.next;
                }
                newNode.next = previousNode.next;
                previousNode.next = newNode;
            }
        }
        System.out.println("List Updated");
        return start;
    }

    public static Node DelBeg(Node start) {
        if (start == null) {
            System.out.println("The linked list is empty");
        } else {
            start = start.next;
        }
        System.out.println("List Updated");
        return start;
    }

    public static Node DelEnd(Node start) {
        if (start == null) {
            System.out.println("The linked list is empty");
        } else {
            Node previousNode = start;
            Node last = start;
            while (last.next != null) {
                previousNode = last;
                last = last.next;
            }
            previousNode.next = null;
        }
        System.out.println("List Updated");
        return start;
    }

    public static Node DelAny(Node start) {
        System.out.println("Enter the node number that you want to delete");
        int location = sc.nextInt();
        Node currentNode = start;
        Node previousNode = start;

        if (location == 1 && currentNode != null) {
            start = start.next;
            System.out.println("List Updated");
            return start;
        }

        int counter = 0;
        while (currentNode != null) {
            if (counter + 1 != location) {
                previousNode = currentNode;
                currentNode = currentNode.next;
                counter++;
            } else {
                previousNode.next = currentNode.next;
                break;
            }
        }
        System.out.println("List Updated");
        return start;
    }

    public static void search(Node search) {
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

    public static Node reverse(Node start) {
        Node currentNode = start;
        Node previousNode = null;
        Node next = null;
        while (currentNode != null) {
            next = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = next;
        }
        start = previousNode;
        System.out.println("List Updated");
        return start;
    }

    public static Node sort(Node start) // quick sort
    {
        Node current = start;
        Node index = null;
        while (current != null) {
            index = current.next;
            while (index != null) {
                if (current.mark > index.mark) {
                    int tempRegNo = current.regd_no;
                    float tempMark = current.mark;
                    current.regd_no = index.regd_no;
                    current.mark = index.mark;
                    index.regd_no = tempRegNo;
                    index.mark = tempMark;
                }
                index = index.next;
            }
            current = current.next;
        }
        System.out.println("List Updated");
        return start;
    }

    public static void display(Node start) {
        Node currentNode = start;
        System.out.print("LinkedList: ");
        while (currentNode != null) {
            System.out.print(currentNode.regd_no + ":" + currentNode.mark + ", ");
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
            System.out.println("9:Reverse the list");
            System.out.println("10:Search the list");
            System.out.println("11:Sort the list");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.exit(0);
                case 2:
                    display(start);
                    break;
                case 3:
                    start = InsBeg(start);
                    break;
                case 4:
                    start = InsEnd(start);
                    break;
                case 5:
                    start = InsAny(start);
                    break;
                case 6:
                    start = DelBeg(start);
                    break;
                case 7:
                    start = DelEnd(start);
                    break;
                case 8:
                    start = DelAny(start);
                    break;
                case 9:
                    start = reverse(start);
                    break;
                case 10:
                    search(start);
                    break;
                case 11:
                    start = sort(start);
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
                    display(start);
                    break;
                default:
                    System.out.println("Wrong choice");
            }
            menuFunction();
        }

    }
}
