import java.util.*;
public class RunnerQ1 {
    static class Node {
        protected int regd_no;
        protected float mark;
        protected Node next;
    }
    public static Node create(Node start) {
        Scanner sc = new Scanner(System.in);
        char ch;
        Node p = new Node();
        do {
            Node n = new Node();
            System.out.println("Enter Registrstion number");
            n.regd_no = sc.nextInt();
            System.out.println("Enter Mark");
            n.mark = sc.nextFloat();
            n.next = null;
            if (start == null)
                start = n;
            else
                p.next = n;
            p = n;
            System.out.println("Enter Y to add next value in node.");
            ch = sc.next().charAt(0);
        } while (ch == 'Y');
        return start;
    }

    public static Node display(Node start) {
        Node temp;
        temp = start;
        if (temp == null)
            System.out.println("Empty list");
        else {
            System.out.println("List Created");
            while (temp != null) {
                System.out.print("Registration number " + temp.regd_no + " Mark " + temp.mark);
                temp = temp.next;
            }
        }
        return start;
    }

    public static Node insBeg(Node start) {
        Scanner sc = new Scanner(System.in);
        Node n = new Node();
        System.out.println("Enter Registration number and marks");
        n.regd_no = sc.nextInt();
        n.mark = sc.nextFloat();
        n.next = start;
        start = n;
        return start;
    }

    public static Node insEnd(Node start) {
        Scanner sc = new Scanner(System.in);
        Node n = new Node();
        Node temp;
        System.out.println("Enter Registration number and marks");
        n.regd_no = sc.nextInt();
        n.mark = sc.nextFloat();
        n.next = null;
        temp = start;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = n;
        return start;
    }

    public static Node insAny(Node start) {

        Scanner sc = new Scanner(System.in);
        Node curr, p;
        int i = 1, count = 0, loc;
        p = start;
        System.out.println("Enter the Location");
        loc = sc.nextInt();
        while (p != null) {
            count++;
            p = p.next;
        }
        if (loc <= count + 1) {
            if (loc == 1)
                start = insBeg(start);
            else if (loc == count + 1)
                start = insEnd(start);
            else {
                p = start;
                while (i < loc - 1) {
                    p = p.next;
                    i++;
                }
                curr = new Node();
                System.out.println("Enter the registration no. & marks of the student");
                curr.regd_no = sc.nextInt();
                curr.mark = sc.nextFloat();
                curr.next = p.next;
                p.next = curr;
            }
        } else
            System.out.println("\n Invalid location \n");
        return start;

    }

    public static Node search(Node start) {
        Node temp = start;
        if (start == null)
            System.out.println("List is empty.");
        else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Registration number to search");
            int q = sc.nextInt();
            while (temp != null) {
                if (q == temp.regd_no) {
                    System.out.print("Enter marks to be updated");
                    temp.mark = sc.nextFloat();
                }
                temp = temp.next;
            }
        }
        return start;
    }

    public static Node delBeg(Node start) {

        if (start == null)
            System.out.println("List is empty.");
        else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Node to  deleted  " + start.regd_no + " " + start.mark + "at" + start);
            start = start.next;
        }
        return start;
    }

    public static Node delEnd(Node start) {
        Scanner sc = new Scanner(System.in);
        Node temp1 = start;
        Node temp2 = null;
        while (temp1.next != null) {
            temp2 = temp1;
            temp1 = temp1.next;
        }
        System.out.println("element to be deleted " + temp1.regd_no + " " + temp1.mark + " at " + temp1);
        temp2.next = null;
        return start;
    }

    public static Node delAny(Node start) {
        Scanner sc = new Scanner(System.in);
        Node n = start;
        Node q = new Node();
        System.out.println("Enter location");
        int l = sc.nextInt();
        for (int i = 1; i < l && n.next != null; i++) {
            q = n;
            n = n.next;
        }
        q.next = n.next;
        return start;
    }

    public static void main(String[] args) {
        int c;
        Scanner sc = new Scanner(System.in);
        Node start = null;
        while (true) {
            System.out.println("***MENU****");
            System.out.println("0:Exit");
            System.out.println("1:Creation");
            System.out.println("2:Display");
            System.out.println("3:Insert at beg");
            System.out.println("4:Insert at end");
            System.out.println("5:Insert at specific location");
            System.out.println("6:Search");
            System.out.println("7:Delete at beg");
            System.out.println("8:Delete at end");
            System.out.println("9:Delete at specific location");
            System.out.println("Enter the choice");
            c = sc.nextInt();
            switch (c) {
                case 0:
                    System.exit(0);
                case 1:
                    start = create(start);
                    break;
                case 2:
                    start = display(start);
                    break;
                case 3:
                    start = insBeg(start);
                    break;
                case 4:
                    start = insEnd(start);
                    break;
                case 5:
                    start = insAny(start);
                    break;
                case 6:
                    start = search(start);
                    break;
                case 7:
                    start = delBeg(start);
                    break;
                case 8:
                    start = delEnd(start);
                    break;
                case 9:
                    start = delAny(start);
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }
}