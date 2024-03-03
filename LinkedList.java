public class LinkedList<T> implements List<T> {
    Node<T> head;    //if list is empty, set to null
    Node<T> tail;    //if list is empty, set to null
    int size;        //if list ist empty, set to 0

    public LinkedList() {
        head = null;
        tail = null;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getTail() {
        return this.tail;
    }

    // Interface methods

    public void addAtIndex(T data, int index) {
        Node<T> current = head;
        Node<T> temp;
        int indexCounter = 0;

        if (index > this.size - 1 || index < 0) {
            return;
        }
        
        while (current != null) {
            temp = current;


            if (indexCounter == index) {
               temp.next = new Node(data, current.next);
               return;
            }

            if (current.next == null) {
                return;
            }
            
            current = current.next;
            indexCounter++;
        }
    }

    public T getAtIndex(int index) {
        Node<T> current = head;
        int indexCounter = 0;

        if (index > this.size - 1 || index < 0) {
            return null;
        }

        while (current != null) {
            if (indexCounter == index) {
                return current.data;
            }

            if (current.next != null) {
                current = current.next;
                indexCounter++;
            } else {
                break;
            }
        }
        
        return null;
    }

    public T removeAtIndex(int index) {
        Node<T> current = head;
        Node<T> previous;
        T removedData;
        int indexCounter = 0;

        if (current == null) {
            return null;
        }

        if (index == 0) {
            removedData = head.data;
            head = head.next;
            this.size = size - 1;
            return removedData;
        }

        while (current != null) {
            previous = current;

            

            if (indexCounter == index) {

                if (current.next == null) {
                    removedData = current.data;
                    previous.next = null;
                    this.size = this.size - 1;
                    return removedData;
                }

                removedData = current.data;
                previous.next = current.next;
                this.size = this.size - 1;
                return removedData;
            }


            indexCounter++;
            current = current.next;
        }
        return null;
    }

    public T remove(T data) {
        Node<T> current = head;
        Node<T> temp;

        if (current == null) {
            this.size = 0;
            return null;
        }

        while (current != null) {
            if (current.data == data) {
                if (data == head.data) {
                    head = current.next;
                    break;
                }
                temp = current.next;
                current.next = temp.next;
                temp = null;
            }
        }
        this.size = this.size - 1;
        return data;
    }

    public void clear() {
        Node<T> current = head;
        Node<T> temp;
        while(current != null) {
            if (current.next != null) {
                temp = current.next;
                current = null;
                current = temp;
                temp = null;
            }
            if (current.next == null) {
                current = null;
            }
        }
        this.size = 0;
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.size;
    }
}
