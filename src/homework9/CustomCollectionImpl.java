package homework9;

public class CustomCollectionImpl {
    private Node head;
    private int size = 0;

    public CustomCollectionImpl() {
        head = null;
    }

    private static class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }

        public Node() {
            this.data = null;
            this.next = null;
        }
    }

    public boolean add(String data) {
        Node newNote = new Node(data);
        Node currentNote = head;
        if (head == null) {
            head = newNote;
        } else {
            while (currentNote.next != null) {
                currentNote = currentNote.next;
            }
            currentNote.next = newNote;
        }
        size++;
        return true;
    }

    public boolean contains(String str) {
        if (head == null) {
            return false;
        }
        Node currentNote = head;
        if (str == null) {
            if (head.data == null) {
                return true;
            }
            while (currentNote.next != null) {
                currentNote = currentNote.next;
                if (currentNote.data == null) {
                    return true;
                }
            }
        } else {
            if (str.equals(head.data)) {
                return true;
            }
            while (currentNote.next != null) {
                currentNote = currentNote.next;
                if (str.equals(currentNote.data)) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean addAll(CustomCollectionImpl strColl) {
        if (strColl == null || strColl.size() == 0) {
            return false;
        }
        if (head == null) {
            head = strColl.head;
            return true;
        }
        Node currentNote = head;
        while (currentNote.next != null) {
            currentNote = currentNote.next;
        }
        currentNote.next = strColl.head;
        return true;
    }

    public boolean clear() {
        head = null;
        size = 0;
        return true;
    }

    public boolean delete(String str) {
        Node currentNote = head;
        int currentIndex = 1;
        while (currentIndex <= size) {
            if (currentNote.data == str) {
                return delete(currentIndex);
            }
            currentNote = currentNote.next;
            currentIndex++;
        }
        return false;
    }

    public boolean delete(int index) {
        Node currentNote = head;
        Node previousNode = null;
        int currentIndex = 1;
        if (index < 1 || index > size) {
            return false;
        }
        if (index == 1) {
            if (currentNote.next == null) {
                head = null;
            } else {
                head = currentNote.next;
            }
            size--;
            return true;
        }
        while (currentIndex <= size) {
            if (index == currentIndex++) {
                previousNode.next = currentNote.next;
                size--;
                return true;
            }
            previousNode = currentNote;
            currentNote = currentNote.next;
        }
        return false;
    }

    public String get(int index) {
        Node currentNote = head;
        int currentIndex = 1;
        if (index < 1 || head == null) {
            System.out.println("Элемент отсутствует");
        }
        while (currentNote != null) {
            if (index == currentIndex++) {
                System.out.println(currentNote.data);
            }
            currentNote = currentNote.next;
        }
        return null;
    }

    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }


    public int size() {
        return size;
    }


    public boolean trim() {
        return true;
    }
}
