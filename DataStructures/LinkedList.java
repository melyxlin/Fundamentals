public class LinkedList
{
    public Node head;
    private class Node
    {
        private int data;
        private Node next;

        public Node (int d)
        {
            this.data = d;
            this.next = null;
        }
    }

    public void add(int item)
    {
        Node newNode = new Node(item);
        if (this.head == null)
        {
            this.head = newNode;
        }
        else
        {
            Node currentNode = this.head;
            Node previousNode = null;
            while (currentNode != null)
            {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
            prevNode.next = newNode;
        }
    }

    public void remove(int data)
    {
        Node currentNode = this.head;
        Node previousNode = null;

        while (currentNode != null)
        {
            if (currentNode.data == data)
            {
                if (previousNode == null)
                {
                    head = head.next;
                    currentNode = head;
                }
                else
                {
                    previousNode.next = currentNode.next;
                    currentNode = currentNode.next;
                }
            }
            else
            {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        }
    }

    public int length()
    {
        int length = 0;
        Node currentNode = head;
        while (current != null)
        {
            length++;
            currentNode = currentNode.next;
        }
        return length;
    }

    public void reverse()
    {
        Node tempNode = null;
        while (head != null)
        {
            Node newHead = this.head.next;
            this.head.next = null;
            tempNode = this.head;
            this.head = newHead;
        }
        this.head = tempNode;
    }

    public String toString()
    {
        String ret = "";
        Node currentNode = this.head;
        while (current != null)
        {
            ret +=  " " + current.data;
            current = current.next;
        }
        return ret;
    }

    public boolean equals(LinkedList other)
    {
        if (other.length() != this.length)
        {
            return false;
        }
        Node currentNode1 = this.head;
        Node currentNode2 = other.head;

        while(current1 != null)
        {
            if(currentNode1.data != currentNode2.data)
            {
                return false;
            }
            current1 = currentNode1.next;
            current2 = currentNode2.next;
        }
        return true;
    }

    public boolean contains(int item)
    {
        Node currentNode = this.head;
        while(currentNode != null)
        {
            if (currentNode.item == item)
            {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    // assuming the linked list is sorted already
    public void removeDuplicates()
    {
        if(head == null)
        {
            return;
        }
        Node currentNode = this.head;
        Node nextNode = this.head.next;
        while(next != null)
        {
            if (currentNode.item == nextNode.item)
            {
                currentNode.next = nextNode.next;
                nextNode = nextNode.next;
            }
            else
            {
                currentNode = nextNode;
                nextNode = nextNode.next;
            }
        }
    }

    public void merge (LinkedList other)
    {
        if (this.head == null)
        {
            this.head = other.head;
        }
        else
        {
            Node currentNode = this.head;
            Node previousNode = null;
            while(currentNode != null)
            {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            previousNode = other.head;
        }
    }

    
    

}