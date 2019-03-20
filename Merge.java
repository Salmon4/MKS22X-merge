import java.util.*;
import java.util.Arrays;
public class Merge{
	public static void mergesort(int[]data){
	//	int[] temp = new int[data.length];

	int[] temp = new int[data.length];
	for (int i = 0; i < data.length; i++){
		temp[i] = data[i];

	}
		mergesortHelper(data,temp,0,data.length-1);
	}
	public static void insertionsort(int[] data, int lo, int hi){
		for (int i = lo; i <= hi;i++){
			int orig = data[i];
			int c = i;
			while (c > lo && data[c-1] > orig){//left number is bigger
				data[c] = data[c-1];
				//data[c] = orig;
				c--;
			}
			data[c] = orig;
		}
	}
	private static void mergesortHelper(int[] data, int[] temp, int lo, int hi){
		if (lo == hi){
    			return;
		}

		if ((lo+hi)/2 - lo <= 43){
			insertionsort(temp,lo,(lo+hi)/2);
			insertionsort(temp,(lo+hi)/2+1,hi);
		}
		else{
		//int left = lo;
		//int right = (lo+hi)/2 + 1;
		mergesortHelper(temp,data,lo,(lo+hi)/2);
		mergesortHelper(temp,data,(lo+hi)/2+1,hi);
	}
	int left = lo;
	int right = (lo+hi)/2 + 1;
		int index = lo;
		while (index <= hi){
			if (left > (lo+hi)/2){
				data[index] = temp[right];
				right++;
			}
			else{
				if (right > hi){
					data[index] = temp[left];
					left++;
				}
				else{
					int leftValue = temp[left];
					int rightValue = temp[right];
					if (leftValue < rightValue){
						data[index] = leftValue;
						left++;
					}
					else{
						data[index] = rightValue;
						right++;
					}
				}
			}
			index++;
		}

	}

	private static void mergesortHelper(int[] data, int lo, int hi){
 		if (lo >= hi){
    			return;
		}

		//int middle = (lo+hi)/2;

		int[] left = new int[(lo+hi)/2 - lo + 1];
		int[] right = new int[hi - (lo+hi)/2];
		for (int l = 0; l < left.length; l++){
			left[l] = data[l];
		}

		for (int r = 0; r < right.length; r++){
			right[r] = data[(lo+hi)/2 + 1 + r];
		}
		mergesortHelper(left,0,left.length - 1);
		mergesortHelper(right,0, right.length - 1);

		int leftIndex = 0;
		int rightIndex = 0;
		int index = 0;
		while (index < data.length){
			if (rightIndex >= right.length){
				data[index] = left[leftIndex];
				leftIndex++;
				//index++;
			}
			else{
				if (leftIndex >= left.length){
					data[index] = right[rightIndex];
					rightIndex++;
				}
				else{
					int l = left[leftIndex];
					int r = right[rightIndex];
					if (l > r){
						data[index] = r;
						rightIndex++;
					}
					else{
						data[index] = l;
						leftIndex++;
					}
				}
			//	index++;
			}
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
