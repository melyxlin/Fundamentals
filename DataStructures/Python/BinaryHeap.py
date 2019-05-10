class BinaryHeap:

    def __init__(self):
        self.DEFAULT_CAPACITY = 10
        self.size = 0
        self.array = [None for i in range(10)]

    def add(self, value):
        if size >= array.length - 1:
            array = self.resize()
        self.size += 1
        self.index = size
        self.array[index] = value
        bubbleUp()

    def remove(self, value):
        retVal = self.peek()
        self.array[1] = self.array[size];
        self.array[size] = None
        self.size -= 1
        bubbleDown()
        return retVal

    def bubbleDown():
        index = 1
        while(self.hasLeftChild(index)):
            smallerChildIndex = self.leftChildIndex(index)
            if self.hasRightChild(index) and self.array[leftChildIndex(index)] > self.array[rightChild(index)]:
                smallerChildIndex = self.rightChild(index)
            if self.array[index] > self.array[smallerChildIndex]:
                self.swap(index, smallerChildIndex)
            else:
                break
            index = smallerChild;

    def bubbleUp():
        index = self.size
        while self.hasParent(index) and self.array[self.parentIndex(index)] > self.array[index]:
            swap(index, self.parentIndex(index))
            index = self.parentIndex(index)

    def hasParent(i):
        return i > 1

    def leftChildIndex(i):
        return i * 2

    def hasLeftChildIndex(i):
        
            
            
        
