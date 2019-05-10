def BinarySearch(array, target):
    rightIndex = len(array) -1
    leftIndex= 0
    while leftIndex <= rightIndex:
        middleIndex = (leftIndex + rightIndex) // 2
        if array[middleIndex] == target:
            return True
        elif array[middleIndex] < target:
            leftIndex = middleIndex + 1
        else:
            rightIndex = middleIndex - 1
    return False



            
