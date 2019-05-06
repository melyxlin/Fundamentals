public class QuickSort {

	private static int partition(int[] items,int low, int high)
	{
		
		int i=low;
		int j=low;
		int k=high+1;
		int pivot=items[high];
		while(j<k)
		{
			if (items[j]<pivot)
			{
				swap(j,i,items);
				j++;
				i++;				
			}
			else if(items[j]==pivot)
			{
				j++;
			}
			else
			{
				swap(j,k-1,items);
				k--;
			}
		}
		return i;
	}
	
	private static void swap(int i,int j,int[] items)
	{
		int temp=items[i];
		items[i]=items[j];
		items[j]=temp;
	}
	
	
	public static void quicksort(int[] arr)
	{
		quicksort(arr,0,arr.length-1);
	}
	private static void quicksort(int[] arr, int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr,low,high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            quicksort(arr, low, pi-1); 
            quicksort(arr, pi+1, high); 
        } 
    } 
}
