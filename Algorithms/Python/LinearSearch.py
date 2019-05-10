def LinearSearch(array, target):
    index = 0
    while index < len(array) -1:
        if array[index] == target:
            return True
        index += 1
    return False
