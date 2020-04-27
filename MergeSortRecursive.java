public class MergeSortRecursive {

	public static void merge(int A[], int low, int mid, int high) {
		int n1=mid-low+1;
		int n2=high-mid;
		int i,j,k;
		int B[] = new int[n1];
		int C[] = new int[n2];
		for(i=0;i<n1;i++) {
			B[i]=A[low+i];
		}
		for(j=0;j<n2;j++) {
			C[j]=A[mid+1+j];
		}
		i=0;
		j=0;
		k=low;
		while(i<n1 && j <n2) {
			if(B[i] <= C[j]) {
				A[k] =B[i];
				i++;
			}
			else {
				A[k] =C[j];
				j++;
			}
			k++;
		}
		while(i< n1) {
			A[k]=B[i];
			i++;
			k++;
		}
		
		while(j<n2) {
			A[k]=C[j];
			j++;
			k++;
		}
	}

	public static void mergeSort(int A[], int low, int high) {

		if (low == high)// If only one element is remained
			return;
		else {
			int mid = (low + (high-1)) / 2; //For odd and even length
			mergeSort(A, low, mid);
			mergeSort(A, mid + 1, high);
			merge(A, low, mid, high);
		}
	}

	public static void main(String[] args) {
		int A[] = { 1, 5, 3, 8, 2, 6, 7, 9, 34, 11, 4, 33, 25 };
		mergeSort(A, 0, A.length - 1);
		System.out.println("After Sort");
		for (int a : A) {
			System.out.print(a + " ");
		}
	}
}
