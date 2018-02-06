package javaSe;
/*
 * @author:
 * @version:
 * @deprecated:不推荐使用的方法
 * @parameter:参数
 * @return:
 * @see:交叉参考的内容
 * @exception:抛出异常的类型
 * @throws:抛出的异常同上
 */
import java.util.Arrays;

import org.junit.Test;

public class Array_Sort {

	public static void main(String[] args) {
		/*
		 * binary bubble sort select sort quick sort shell sort merge sort insert sort
		 * heap sort
		 */
	/*	int[] arr = new int[] { 0, 4, 5, 6, 2, 1, 6, 7, 8, 0, 9, 3 };
		bubble(arr);
		System.out.println(Arrays.toString(arr));
		select(arr);
		System.out.println(Arrays.toString(arr));

		int[] copy1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		int[] copy2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		System.arraycopy(copy1, 3, copy2, 3, 3);
		System.out.println(Arrays.toString(copy2));*/
		
		//binarySearch
		int [] arrBinary= {4,5,6,7,8,9,10};
		int ret=binary(arrBinary,9);
		System.out.println(ret);  
	}
	/*
	 * binarySearch
	 */ 
	private static int binary(int [] arr, int target) {
		if(arr==null||arr.length==0) {
			return -1;
		}
		int low=0;
		int high=arr.length-1;
		while(low<high) {
			int middle=(high+low)/2;
			if(arr[middle]==target) {
				return middle+1;
			}else if(arr[middle]>target){
				high=middle-1;
			}else{
				low =middle+1; 
			}
		} 
		//Arrays.binarySearch(a, key)
		return -1;
	}
	/*
	 * 冒泡排序基本概念是： 依次比较相邻的两个数，将小数放在前面，大数放在后面。 即在第一趟：首先比较第1个和第2个数，将小数放前，大数放后。
	 * 然后比较第2个数和第3个数，将小数放前，大数放后，如此继续， 直至比较最后两个数，将小数放前，大数放后。至此第一趟结束，
	 * 将最大的数放到了最后。在第二趟：仍从第一对数开始比较 （因为可能由于第2个数和第3个数的交换，使得第1个数不再小于第2个数），
	 * 将小数放前，大数放后，一直比较到倒数第二个数（倒数第一的位置上已经是最大的）， 第二趟结束，在倒数第二的位置上得到一个新的最大数
	 * （其实在整个数列中是第二大的数）。如此下去，重复以上过程，直至最终完成排序。
	 */
	private static void bubble(int[] arr) { // 从后到前
		for (int x = 0; x < arr.length - 1; x++) {
			for (int y = 0; y < arr.length - 1 - x; y++) { // y逐渐减少
				if (arr[y] > arr[y + 1]) {
					arr[y] = arr[y] ^ arr[y + 1];           //a=a^b;
					arr[y + 1] = arr[y] ^ arr[y + 1];		//b=a^b;
					arr[y] = arr[y] ^ arr[y + 1];			//a=a^b;
				}
			}
		}
	} 
	/*
	 * 选择排序基本思路： 把第一个元素依次和后面的所有元素进行比较。 第一次结束后，就会有最小值出现在最前面。 依次类推
	 */
	private static void select(int[] arr) { // 从前到后
		for (int x = 0; x < arr.length - 1; x++) { // 只往前走,往下一元素比较
			for (int y = x + 1; y < arr.length; y++) {
				if (arr[y] > arr[x]) {
					int temp = arr[y];
					arr[y] = arr[x];
					arr[x] = temp;
				}
			}
		}
	}

	/*
	 * 交换数组中的两个元素
	 */
	public static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	/*
	 * 快速排序： 一趟快速排序的算法是： 1）设置两个变量i、j，排序开始的时候：i=0，j=N-1；
	 * 2）以第一个数组元素作为关键数据，赋值给key，即 key=A[0]； 3）从j开始向前搜索，即由后开始向前搜索（j=j-1即j--），
	 * 找到第一个小于key的值A[j]，A[i]与A[j]交换； 4）从i开始向后搜索，即由前开始向后搜索（i=i+1即i++），
	 * 找到第一个大于key的A[i]，A[i]与A[j]交换； 5）重复第3、4、5步，直到 I=J；
	 * (3,4步是在程序中没找到时候j=j-1，i=i+1，直至找到为止。 找到并交换的时候i， j指针位置不变。
	 * 另外当i=j这过程一定正好是i+或j-完成的最后令循环结束。）
	 */

	private static void quick(int[] data, int i, int j) {
		int pivotIndex = (i + j) / 2;
		// swap
		swap(data, pivotIndex, j);

		int k = partition(data, i - 1, j, data[j]);
		swap(data, k, j);
		if ((k - i) > 1)
			quick(data, i, k - 1);
		if ((j - k) > 1)
			quick(data, k + 1, j);

	}

	private static int partition(int[] data, int l, int r, int pivot) {
		do {
			while (data[++l] < pivot)
				;
			while ((r != 0) && data[--r] > pivot)
				;
			swap(data, l, r);
		} while (l < r);
		swap(data, l, r);
		return l;
	}

	/*
	 * 希尔排序：先取一个小于n的整数d1作为第一个增量， 把文件的全部记录分成（n除以d1）个组。所有距离为d1的倍数的记录放在同一个组中。
	 * 先在各组内进行直接插入排序；然后，取第二个增量d2<d1重复上述的分组和排序，
	 * 直至所取的增量dt=1(dt<dt-l<…<d2<d1)，即所有记录放在同一组中进行直接插入排序为止。
	 */
	public static void shell(int[] data) {
		for (int i = data.length / 2; i > 2; i /= 2) {
			for (int j = 0; j < i; j++) {
				insertSort(data, j, i);
			}
		}
		insertSort(data, 0, 1);
	}

	private static void insertSort(int[] data, int start, int inc) {
		for (int i = start + inc; i < data.length; i += inc) {
			for (int j = i; (j >= inc) && (data[j] < data[j - inc]); j -= inc) {
				swap(data, j, j - inc);
			}
		}
	}
	/*
	 * 属于插入类排序,是将整个无序列分割成若干小的子序列分别进行插入排序 排序过程：先取一个正整数d1<n，把所有序号相隔d1的数组元素放一组，
	 * 组内进行直接插入排序；然后取d2<d1，重复上述分组和排序操作；直至di=1， 即所有记录放进一个组中排序为止 初始：d=5 49 38 65
	 * 97 76 13 27 49 55 04 49 13 |-------------------| 38 27
	 * |-------------------| 65 49 |-------------------| 97 55
	 * |-------------------| 76 04 |-------------------| 一趟结果 13 27 49 55 04 49
	 * 38 65 97 76 d=3 13 27 49 55 04 49 38 65 97 76 13 55 38 76
	 * |------------|------------|------------| 27 04 65
	 * |------------|------------| 49 49 97 |------------|------------| 二趟结果 13
	 * 04 49* 38 27 49 55 65 97 76 d=1 13 04 49 38 27 49 55 65 97 76
	 * |----|----|----|----|----|----|----|----|----| 三趟结果 04 13 27 38 49 49 55
	 * 65 76 97
	 */

	/*
	 * 插入排序基本思想 将n个元素的数列分为已有序和无序两个部分，如插入排序过程示例下所示： {{a1}，{a2，a3，a4，…，an}}
	 * {{a1⑴，a2⑴}，{a3⑴，a4⑴ …，an⑴}} {{a1(n-1），a2(n-1) ，…},{an(n-1)}}
	 * 每次处理就是将无序数列的第一个元素与有序数列的元素从后往前逐个进行比较， 找出插入位置，将该元素插入到有序数列的合适位置中。
	 */
	public static void insert(int[] data) {
		for (int i = 1; i < data.length; i++) {
			for (int j = i; (j > 0) && (data[j] < data[j - 1]); j--) {
				swap(data, j, j - 1);
			}
		}

	}

	/*
	 * 归并操作(merge)，也叫归并算法，指的是将两个已经排序的序列合并成一个序列的操作。 如设有数列{6，202，100，301，38，8，1}
	 * 初始状态： [6] [202] [100] [301] [38] [8] [1] 比较次数 i=1 [6 202 ] [ 100 301] [ 8
	 * 38] [ 1 ] 3 i=2 [ 6 100 202 301 ] [ 1 8 38 ] 4 i=3 [ 1 6 8 38 100 202 301
	 * ] 4
	 */
	public static void merge(int[] data) {
		int[] temp = new int[data.length];
		mergeSort(data, temp, 0, data.length - 1);
	}

	private static void mergeSort(int[] data, int[] temp, int l, int r) {
		int mid = (l + r) / 2;
		if (l == r)
			return;
		mergeSort(data, temp, l, mid);
		mergeSort(data, temp, mid + 1, r);

		for (int i = l; i <= r; i++) {
			temp[i] = data[i];
		}
		int i1 = l;
		int i2 = mid + 1;
		for (int cur = l; cur <= r; cur++) {
			if (i1 == mid + 1)
				data[cur] = temp[i2++];
			else if (i2 > r)
				data[cur] = temp[i1++];
			else if (temp[i1] < temp[i2])
				data[cur] = temp[i1++];
			else

				data[cur] = temp[i2++];
		}
	}

	/*
	 * 堆排序利用了大根堆（或小根堆）堆顶记录的关键字最大（或最小）这一特征， 使得在当前无序区中选取最大（或最小）关键字的记录变得简单。
	 * （1）用大根堆排序的基本思想 ① 先将初始文件R[1..n]建成一个大根堆，此堆为初始的无序区 ②
	 * 再将关键字最大的记录R[1]（即堆顶）和无序区的最后一个 记录R[n]交换，由此得到新的无序区R[1..n-1]和有序区R[n]，
	 * 且满足R[1..n-1].keys≤R[n].key ③由于交换后新的根R[1]可能违反堆性质，故应将当前无序区R[1..n-1]调整为堆。
	 * 然后再次将R[1..n-1]中关键字最大的记录R[1]和该区间的最后一个记录R[n-1]交换，
	 * 由此得到新的无序区R[1..n-2]和有序区R[n-1..n]，
	 * 且仍满足关系R[1..n-2].keys≤R[n-1..n].keys，同样要将R[1..n-2]调整为堆。 直到无序区只有一个元素为止。
	 * （2）大根堆排序算法的基本操作： ① 初始化操作：将R[1..n]构造为初始堆； ②
	 * 每一趟排序的基本操作：将当前无序区的堆顶记录R[1]和该区间的最后一个记录交换， 然后将新的无序区调整为堆（亦称重建堆）。
	 */
	public static void heap(int[] data) {
		MaxHeap h = new MaxHeap();
		h.init(data);
		for (int i = 0; i < data.length; i++)
			h.remove();
		System.arraycopy(h.queue, 1, data, 0, data.length);
	}

	private static class MaxHeap {

		void init(int[] data) {
			this.queue = new int[data.length + 1];
			for (int i = 0; i < data.length; i++) {
				queue[++size] = data[i];
				fixUp(size);
			}
		}

		private int size = 0;

		private int[] queue;

		public int get() {
			return queue[1];
		}

		public void remove() {
			swap(queue, 1, size--);
			fixDown(1);
		}

		// fixdown
		private void fixDown(int k) {
			int j;
			while ((j = k << 1) <= size) {
				if (j < size && queue[j] < queue[j + 1])
					j++;
				if (queue[k] > queue[j]) // 不用交换

					break;
				swap(queue, j, k);
				k = j;
			}
		}

		private void fixUp(int k) {
			while (k > 1) {
				int j = k >> 1;
				if (queue[j] > queue[k])
					break;
				swap(queue, j, k);

				k = j;
			}
		}

	}

}
