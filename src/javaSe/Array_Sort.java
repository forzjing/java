package javaSe;
/*
 * @author:
 * @version:
 * @deprecated:���Ƽ�ʹ�õķ���
 * @parameter:����
 * @return:
 * @see:����ο�������
 * @exception:�׳��쳣������
 * @throws:�׳����쳣ͬ��
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
	 * ð��������������ǣ� ���αȽ����ڵ�����������С������ǰ�棬�������ں��档 ���ڵ�һ�ˣ����ȱȽϵ�1���͵�2��������С����ǰ�������ź�
	 * Ȼ��Ƚϵ�2�����͵�3��������С����ǰ�������ź���˼����� ֱ���Ƚ��������������С����ǰ�������ź����˵�һ�˽�����
	 * ���������ŵ�������ڵڶ��ˣ��Դӵ�һ������ʼ�Ƚ� ����Ϊ�������ڵ�2�����͵�3�����Ľ�����ʹ�õ�1��������С�ڵ�2��������
	 * ��С����ǰ�������ź�һֱ�Ƚϵ������ڶ�������������һ��λ�����Ѿ������ģ��� �ڶ��˽������ڵ����ڶ���λ���ϵõ�һ���µ������
	 * ����ʵ�������������ǵڶ���������������ȥ���ظ����Ϲ��̣�ֱ�������������
	 */
	private static void bubble(int[] arr) { // �Ӻ�ǰ
		for (int x = 0; x < arr.length - 1; x++) {
			for (int y = 0; y < arr.length - 1 - x; y++) { // y�𽥼���
				if (arr[y] > arr[y + 1]) {
					arr[y] = arr[y] ^ arr[y + 1];           //a=a^b;
					arr[y + 1] = arr[y] ^ arr[y + 1];		//b=a^b;
					arr[y] = arr[y] ^ arr[y + 1];			//a=a^b;
				}
			}
		}
	} 
	/*
	 * ѡ���������˼·�� �ѵ�һ��Ԫ�����κͺ��������Ԫ�ؽ��бȽϡ� ��һ�ν����󣬾ͻ�����Сֵ��������ǰ�档 ��������
	 */
	private static void select(int[] arr) { // ��ǰ����
		for (int x = 0; x < arr.length - 1; x++) { // ֻ��ǰ��,����һԪ�رȽ�
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
	 * ���������е�����Ԫ��
	 */
	public static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	/*
	 * �������� һ�˿���������㷨�ǣ� 1��������������i��j������ʼ��ʱ��i=0��j=N-1��
	 * 2���Ե�һ������Ԫ����Ϊ�ؼ����ݣ���ֵ��key���� key=A[0]�� 3����j��ʼ��ǰ���������ɺ�ʼ��ǰ������j=j-1��j--����
	 * �ҵ���һ��С��key��ֵA[j]��A[i]��A[j]������ 4����i��ʼ�������������ǰ��ʼ���������i=i+1��i++����
	 * �ҵ���һ������key��A[i]��A[i]��A[j]������ 5���ظ���3��4��5����ֱ�� I=J��
	 * (3,4�����ڳ�����û�ҵ�ʱ��j=j-1��i=i+1��ֱ���ҵ�Ϊֹ�� �ҵ���������ʱ��i�� jָ��λ�ò��䡣
	 * ���⵱i=j�����һ��������i+��j-��ɵ������ѭ����������
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
	 * ϣ��������ȡһ��С��n������d1��Ϊ��һ�������� ���ļ���ȫ����¼�ֳɣ�n����d1�����顣���о���Ϊd1�ı����ļ�¼����ͬһ�����С�
	 * ���ڸ����ڽ���ֱ�Ӳ�������Ȼ��ȡ�ڶ�������d2<d1�ظ������ķ��������
	 * ֱ����ȡ������dt=1(dt<dt-l<��<d2<d1)�������м�¼����ͬһ���н���ֱ�Ӳ�������Ϊֹ��
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
	 * ���ڲ���������,�ǽ����������зָ������С�������зֱ���в������� ������̣���ȡһ��������d1<n��������������d1������Ԫ�ط�һ�飬
	 * ���ڽ���ֱ�Ӳ�������Ȼ��ȡd2<d1���ظ�������������������ֱ��di=1�� �����м�¼�Ž�һ����������Ϊֹ ��ʼ��d=5 49 38 65
	 * 97 76 13 27 49 55 04 49 13 |-------------------| 38 27
	 * |-------------------| 65 49 |-------------------| 97 55
	 * |-------------------| 76 04 |-------------------| һ�˽�� 13 27 49 55 04 49
	 * 38 65 97 76 d=3 13 27 49 55 04 49 38 65 97 76 13 55 38 76
	 * |------------|------------|------------| 27 04 65
	 * |------------|------------| 49 49 97 |------------|------------| ���˽�� 13
	 * 04 49* 38 27 49 55 65 97 76 d=1 13 04 49 38 27 49 55 65 97 76
	 * |----|----|----|----|----|----|----|----|----| ���˽�� 04 13 27 38 49 49 55
	 * 65 76 97
	 */

	/*
	 * �����������˼�� ��n��Ԫ�ص����з�Ϊ������������������֣�������������ʾ������ʾ�� {{a1}��{a2��a3��a4������an}}
	 * {{a1�ţ�a2��}��{a3�ţ�a4�� ����an��}} {{a1(n-1����a2(n-1) ����},{an(n-1)}}
	 * ÿ�δ�����ǽ��������еĵ�һ��Ԫ�����������е�Ԫ�شӺ���ǰ������бȽϣ� �ҳ�����λ�ã�����Ԫ�ز��뵽�������еĺ���λ���С�
	 */
	public static void insert(int[] data) {
		for (int i = 1; i < data.length; i++) {
			for (int j = i; (j > 0) && (data[j] < data[j - 1]); j--) {
				swap(data, j, j - 1);
			}
		}

	}

	/*
	 * �鲢����(merge)��Ҳ�й鲢�㷨��ָ���ǽ������Ѿ���������кϲ���һ�����еĲ����� ����������{6��202��100��301��38��8��1}
	 * ��ʼ״̬�� [6] [202] [100] [301] [38] [8] [1] �Ƚϴ��� i=1 [6 202 ] [ 100 301] [ 8
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
	 * �����������˴���ѣ���С���ѣ��Ѷ���¼�Ĺؼ�����󣨻���С����һ������ ʹ���ڵ�ǰ��������ѡȡ��󣨻���С���ؼ��ֵļ�¼��ü򵥡�
	 * ��1���ô��������Ļ���˼�� �� �Ƚ���ʼ�ļ�R[1..n]����һ������ѣ��˶�Ϊ��ʼ�������� ��
	 * �ٽ��ؼ������ļ�¼R[1]�����Ѷ����������������һ�� ��¼R[n]�������ɴ˵õ��µ�������R[1..n-1]��������R[n]��
	 * ������R[1..n-1].keys��R[n].key �����ڽ������µĸ�R[1]����Υ�������ʣ���Ӧ����ǰ������R[1..n-1]����Ϊ�ѡ�
	 * Ȼ���ٴν�R[1..n-1]�йؼ������ļ�¼R[1]�͸���������һ����¼R[n-1]������
	 * �ɴ˵õ��µ�������R[1..n-2]��������R[n-1..n]��
	 * ���������ϵR[1..n-2].keys��R[n-1..n].keys��ͬ��Ҫ��R[1..n-2]����Ϊ�ѡ� ֱ��������ֻ��һ��Ԫ��Ϊֹ��
	 * ��2������������㷨�Ļ��������� �� ��ʼ����������R[1..n]����Ϊ��ʼ�ѣ� ��
	 * ÿһ������Ļ�������������ǰ�������ĶѶ���¼R[1]�͸���������һ����¼������ Ȼ���µ�����������Ϊ�ѣ�����ؽ��ѣ���
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
				if (queue[k] > queue[j]) // ���ý���

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
