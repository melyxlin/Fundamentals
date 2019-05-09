class HashNode:
    def __init__(self, k, v):
        self.key = k
        self.value = v
        self.next = None

class HashTable:
    def __init__(self):
        self.numBuckets = 10
        self.size = 0
        self.buckets = [None for i in range(self.numBuckets)]

    def getSize(self):
        return self.size

    def isEmpty(self):
        return self.size == 0

    def getHashCode(self, key):
        hashCode = hash(key)
        hashIndex = hashCode % self.numBuckets
        return hashIndex

    def get(self, key):
        bucketNumber = self.getHashCode(key)
        currentNode = self.buckets[bucktNumber]
        while currentNode != None:
            if currentNode.key == key:
                return currentNode.value
            currentNode = currentNode.next
        return None

    def insert(self, key, value):
        bucketNumber = self.getHashCode(key)
        currentNode = self.buckets[bucketNumber]
        newNode = HashNode(key, value)
        if currentNode == None:
            self.buckets[bucketNumber] = newNode
            self.size+= 1
        else:
            while currentNode != None:
                if(currentNode.key == key):
                    currentNode.value = value;
                    size += 1
                    break
                currentNode = currentNode.next
            if currentNode == None:
                currentNode = self.buckets[bucketNumber]
                newNode.next = currentNode
                self.buckets[bucketNumber] = newNode
                self.size+=1

    def remove(self, key):
        bucketNumber = self.getHashCode(key)
        currentNode = self.buckets[bucketNumber]
        previousNode = None
        while currentNode != None and currentNode.key != key:
            previousNode = currentNode
            currentNode = currentNode.next
        retVal = currentNode.value
        if previousNode != None:
            previousNode.next = currentNode.next
        else:
            self.buckets[bucketNumber] = currentNode.next
            self.size -= 1
        return retVal            
