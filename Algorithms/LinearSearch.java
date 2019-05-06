public class LinearSearch {

	public static boolean performLinearSearch(int[] array,int targetElement)
	{
		int index=0;
		while(index<array.length)
		{
            if(array[index]==targetElement)
            {
                return true;
            }
			index=index+1;
		}
		return false;
	}
	

}