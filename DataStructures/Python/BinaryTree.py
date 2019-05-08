class Node:
    def __init__(self, d):
        self.data = d
        self.right = None
        self.left = None

class BinaryTree:
    def __init__(self):
        self.root = None

    def printPreOrder(self):
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

    def printPostOrder(self):
        return self.__printPostOrder(self.root, 0)

    def __printPostOrder(self, node, depth):
        ret = ""
        if node == None:
            return ret
        ret += self.__printPostOrder(node.left, depth + 1)
        ret+= self.__printPostOrder(node.right, depth + 1)
        i = 0
        while i < depth:
            ret += " "
            i += 1
        ret += str(node.data) + "\n"
        return ret

    def getSum(self):
        return self.__getSum(self.root)

    def __getSum(self, node):
        sum = 0
        if node == None:
            return sum
        else:
            sum += node.data
            sum += self.__getSum(node.left)
            sum += self.__getSum(node.right)
            return sum

    def getMirror(self):
        return self.__getMirror(self.root)

    def __getMirror(self, node):
        if node != None:
            __getMirror(self, node.left)
            __getMirror(self, node.right)
            temp = node.right
            node.right = node.left
            node.left = temp

    def getHeight(self):
        return self.__getHeight(self.root)

    def __getHeight(self, node):
        if node == None:
            return 0
        else:
            height = 1
            rightHeight = self.__getHeight(node.right)
            leftHeight = self.__getHeight(node.left)
            height += max(leftHeight, rightHeight)
            return height;
    



                
        
        

