class Node:
    def __init__(self, d):
        self.data = d
        self.right = None
        self.left = None

class BinarySearchTree:
    def __init__(self):
        self.root = None

    def add(self, item):
        self.root =  self.__add(self.root, item)

    def __add(self, node, item):
        if node == None:
            node = Node(item)
            return node
        else:
            if (node.data > item):
                if node.left == None:
                    node.left = Node(item)
                else:
                    self.__add(node.left, item)
            else:
                if node.right == None:
                    node.right = Node(item)
                else:
                    self.__add(node.right, item)
        return node

    def findMax(self):
        if self.root == None:
            return None
        else:
            maxVal = self.root.data
            currentNode = self.root.right
            while currentNode != None:
                maxVal = currentNode.data
                currentNode = currentNode.right
            return maxVal

    def findMin(self):
        if self.root == None:
            return None
        else:
            minVal = self.root.data
            currentNode = self.root.left
            while currentNode != None:
                minVal = currentNode.data
                currentNode == currentNode.left
            return minVal

    def __repr__(self):
        return self.__printPreOrder(self.root, 0)

    def __printPreOrder(self, node, depth):
        ret = ""
        if node == None:
            return ret
        else:
            i = 0
            while i < depth:
                ret += " "
                i+= 1
            ret += str(node.data) +"\n"
            ret += self.__printPreOrder(node.left, depth + 1)
            ret += self.__printPreOrder(node.right, depth + 1)
            return ret    
