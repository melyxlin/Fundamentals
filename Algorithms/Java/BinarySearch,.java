public class BinarySearch {

	public static boolean performBinarySearch(int[] array,int targetValue)
	{
		int rightIndex=array.length-1;
		int leftIndex=0;
		while(leftIndex<=rightIndex)
		{
			System.out.println(count);
			int middleIndex=(rightIndex+leftIndex)/2;
			if (array[middleIndex]==targetValue)
				return true;
			else if (array[middleIndex]<targetValue)
				leftIndex=middleIndex+1;
			else 
				rightIndex=middleIndex-1;
		}
		return false;
		
	}
}