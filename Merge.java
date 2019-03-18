public class Merge{
	public static void mergesort(int[]data){
	//	int[] temp = new int[data.length];
		mergesortHelper(data,0,data.length-1);
	}

	private static void mergesortHelper(int[] data, int lo, int hi){
 		if (lo >= hi){
    			return;
		}
		int[] left = new int[(lo+hi)/2];
		int[] right = new int[data.length - (lo+hi)/2];

		for (int l = 0; l < (lo+hi)/2; l++){
			left[l] = data[lo + l];
		}

		for (int r = 0; r < data.length - (lo+hi)/2; r++){
			right[r] = data[(lo+hi)/2 + r];
		}
		/**
		temp = new int[data.length - (data.length/2)];
		int tempIndex = 0;
		for (int i = data.length - (data.length/2); i < data.length; i++{
			temp[tempIndex] = data[i];
			tempIndex++;
		}
		**/
  	mergesortHelper(left,0,(lo + hi) / 2);
		mergesortHelper(right,(lo + hi) / 2 + 1, data.length - 1);

		int leftIndex = 0;
		int rightIndex = 0;
		int index = lo;
		while (leftIndex =< (lo+hi)/2 && rightIndex < data.length - ((lo+hi)/2)){
			if (left[leftIndex] < right[rightIndex]){
				data[index] = left[leftIndex];
				leftIndex++;
				index++;
			}
			else{
				data[index] = right[rightIndex];
				rightIndex++;
				index++;
			}
		}

		while (leftIndex < (lo+hi)/2){
			data[index] = left[leftIndex];
			leftIndex++;
			index++;
		}
		while (rightIndex < data.length - ((lo+hi)/2)){
			data[index] = right[rightIndex];
			rightIndex++;
			index++;
		}
}
