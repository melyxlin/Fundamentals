import java.util.Arrays;
public class InsetionSort
{
    public static void insertionSort(int[] args)
	{
		int startIndexOfUnsortedArray=1;
		while(startIndexOfUnsortedArray<args.length)
		{
			int valueToBeInserted=args[startIndexOfUnsortedArray];
			int bestPositionSoFar=startIndexOfUnsortedArray;
			while(0<bestPositionSoFar && args[bestPositionSoFar-1]>=valueToBeInserted)
			{
				args[bestPositionSoFar]=args[bestPositionSoFar-1];
				bestPositionSoFar--;
			}
			args[bestPositionSoFar]=valueToBeInserted;
			startIndexOfUnsortedArray++;
		}
	}
}