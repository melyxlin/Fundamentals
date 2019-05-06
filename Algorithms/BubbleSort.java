public class BubbleSort
{
    public static void bubbleSortNew(int[] items) {
		int positionOfSortedArray = items.length;
		while (0 < positionOfSortedArray) {
			int leftIndex = 0;
			boolean isSwap=false;
			while (leftIndex < positionOfSortedArray - 1) {
				int rightIndex = leftIndex + 1;
				if (items[leftIndex] > items[rightIndex]) {
					isSwap=true;
					int temp = items[leftIndex];
					items[leftIndex] = items[rightIndex];
					items[rightIndex] = temp;
				}
				leftIndex++;
		}
			if(!isSwap)
				break;
		positionOfSortedArray--;
		}
	}
}