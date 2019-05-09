public class HashTable<K, V> { 
  private class HashNode
  {
    K key;
    V value;
    HashNode next;
    
    public HashNode(K key, V value)
    {
      this.key = key;
      this.value = value;
    }
  }
  
  private ArrayList<HashNode> buckets = new ArrayList<>();
  int numBuckets= 10;
  int size;
  public HashTable()
  {
    for(int i = 0; i < numBuckets; i++)
    {
      buckets.add(null);
    }
  }
  public int getSize()
  {
    return size;
  }
  
  public boolean isEmpty()
  {
    return size == 0;
  }
  private int getBucketIndex(K key)
  {
    int hashCode = key.hashCode();
    return hashCode % numBuckets;
  }
  
  public V get(K key)
  {
    /*
     * 1. get the index of the linked list starting on 'some' bucket!
     */
    int  bucketNumber = getBucketIndex(key);
    HashNode current = buckets.get(bucketNumber);
    while(current != null)
    {
      if(current.key.equals(key))
      {
        return current.value;
      }
      current = current.next;
    }
    return null;
  }
  
  public V remove (K key)
  {
    int bucketNumber = getBucketIndex(key);
    HashNode current = buckets.get(bucketNumber);
    HashNode prev = null;
    while (current != null && !current.key.equals(key)) //find place in the linked list where key is
    {
        prev = current;
        current = current.next;
    }

    if (current == null) //not in the HashTable
    {
        return null;
    }

    V retVal = current.value; //gets the return value
    if (prev != null) {
        prev.next = current.next;
    } 
    else
    {
      buckets.set(bucketNumber, current.next); //sets the first node in the linked list to the next node after current (i.e. removes current)
    }
    size--;
    return retVal;
}
  
  
  public void add(K key, V value)
  {
    int bucketNumber = getBucketIndex(key);
    HashNode current = buckets.get(bucketNumber);
    while (current != null) 
    {
        if (current.key.equals(key)) 
        {
            current.value = value;
            return;
        }
        current = current.next;
    }

    current = buckets.get(bucketNumber); //finds the first node in the arrayList buckets
    HashNode  newNode = new HashNode(key, value); //initializes the added newNode
    newNode.next = current; //sets the newNode to first node of the array list
    size++;
  }

}
