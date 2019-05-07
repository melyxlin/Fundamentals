class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None

    def insertNode(self, item):
        newNode = Node(item)
        if self.head == None:
            self.head = newNode
        else:
            currentNode = self.head
            previousNode = None
            while (currentNode != None):
                previousNode = currentNode
                currentNode = currentNode.next
            previousNode.next = newNode

    def __repr__(self):
        retString = "";
        currentNode = self.head
        while currentNode != None:
            retString += str(currentNode.data) + "->"
            currentNode = currentNode.next;
        return retString + "null"

    def deleteNode(self, item): #assuming there are no duplicates
        currentNode = self.head
        previousNode = None
        while currentNode != None:
            if currentNode.data == item:
                if previousNode == None:
                    self.head = self.head.next
                    currentNode = self.head
                else:
                    previousNode.next = currentNode.next
                    currentNode = currentNode.next
            else:
                previousNode = currentNode
                currentNode = currentNode.next

    def length(self):
        length = 0
        currentNode = self.head
        while currentNode != None:
            currentNode = currentNode.next
            length += 1
        return length

    def reverse(self):
        tempNode = None
        while self.head != None:
            newHead = self.head.next
            self.head.next = tempNode
            tempNode = self.head
            self.head = newHead
        self.head = tempNode;

    def removeDuplicates(self): #assuming linked list is sorted
        if self.head == None:
            return
        else:
            currentNode = self.head.next
            previousNode = self.head
            while currentNode != None:
                if currentNode.data == previousNode.data:
                    previousNode.next = currentNode.next
                    currentNode = currentNode.next
                else:
                    previousNode = currentNode
                    currentNode = currentNode.next
                    
        
        
                    
