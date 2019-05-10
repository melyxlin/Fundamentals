public class SelectionSort
{
    public static void selectionSortA(int[] items) {
		int bestPositionIndex = 0;
		while (bestPositionIndex < items.length) {
			int startIndex = bestPositionIndex + 1;
			while (startIndex < items.length) {
				if (items[bestPositionIndex] > items[startIndex]) {
					int temp = items[bestPositionIndex];
					items[bestPositionIndex] = items[startIndex];
					items[startIndex] = temp;
				}
				startIndex = startSearchIndex + 1;
			}
			bestPositionIndex++;
		}
	}
}