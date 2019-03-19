import java.util.*;
import java.util.Arrays;
public class Merge{
	public static void mergesort(int[]data){
	//	int[] temp = new int[data.length];
		mergesortHelper(data,0,data.length-1);
	}

	private static void mergesortHelper(int[] data, int lo, int hi){
 		if (lo >= hi){
    			return;
		}

		int middle = (lo+hi)/2;
		mergesortHelper(data,lo,middle);
		mergesortHelper(data,middle + 1, hi);
		int length1 = middle - lo;
		int length2 = hi - middle;
		int[] left = new int[(lo+hi)/2];
		int[] right = new int[hi - (lo+hi)/2];

		for (int l = 0; l < length1; l++){
			left[l] = data[lo + l];
		}

		for (int r = 0; r < length2; r++){
			right[r] = data[middle + 1 + r];
		}
		/**
		temp = new int[data.length - (data.length/2)];
		int tempIndex = 0;
		for (int i = data.length - (data.length/2); i < data.length; i++{
			temp[tempIndex] = data[i];
			tempIndex++;
		}
		**/
  	//mergesortHelper(left,lo,(lo + hi) / 2);
		//mergesortHelper(right,(lo + hi) / 2 + 1, hi);

		int leftIndex = 0;
		int rightIndex = 0;
		int index = lo;
		while (leftIndex < length1 && rightIndex < length2){
			if (left[leftIndex] < right[rightIndex]){
				data[index] = left[leftIndex];
				leftIndex++;
				//index++;
			}
			else{
				data[index] = right[rightIndex];
				rightIndex++;
			//	index++;
			}
			index++;
		}

		while (leftIndex < length1){
			data[index] = left[leftIndex];
			leftIndex++;
			index++;
		}
		while (rightIndex < length2){
			data[index] = right[rightIndex];
			rightIndex++;
			index++;
		}
}
public static void main(String[]args){
System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
int[]MAX_LIST = {1000000000,500,10};
for(int MAX : MAX_LIST){
	for(int size = 31250; size < 2000001; size*=2){
		long qtime=0;
		long btime=0;
		//average of 5 sorts.
		for(int trial = 0 ; trial <=5; trial++){
			int []data1 = new int[size];
			int []data2 = new int[size];
			for(int i = 0; i < data1.length; i++){
				data1[i] = (int)(Math.random()*MAX);
				data2[i] = data1[i];
			}
			long t1,t2;
			t1 = System.currentTimeMillis();
			Merge.mergesort(data2);
			t2 = System.currentTimeMillis();
			qtime += t2 - t1;
			t1 = System.currentTimeMillis();
			Arrays.sort(data1);
			t2 = System.currentTimeMillis();
			btime+= t2 - t1;
			if(!Arrays.equals(data1,data2)){
				System.out.println("FAIL TO SORT!");
				System.exit(0);
			}
		}
		System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
	}
	System.out.println();
}
}
}
