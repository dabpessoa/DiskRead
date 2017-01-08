package br.unifor.util;

public class HeapSort {

	public static void sort(Integer a[]) throws Exception {
		int N = a.length;
		for (int k = N/2; k > 0; k--) {
			downheap(a, k, N);
		}
		do {
			int T = a[0];
			a[0] = a[N - 1];
			a[N - 1] = T;
			N = N - 1;
			downheap(a, 1, N);
		} while (N > 1);
	}

	private static void downheap(Integer a[], int k, int N) throws Exception {
		int T = a[k - 1];
		while (k <= N/2) {
			int j = k + k;
			if ((j < N) && (a[j - 1] < a[j])) {
				j++;
			}
			if (T >= a[j - 1]) {
				break;
			} else {
				a[k - 1] = a[j - 1];
				k = j;
			}
		}
		a[k - 1] = T;
	}
	
	public static void main (String args[]) {
	
		Integer vet[] = {8,5,9,4,6,2,3,1,7};
		
		try {
			HeapSort.sort(vet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int i = 0 ; i < vet.length ; i++) {
			System.out.println("vet["+i+"]: "+vet[i]);
		}
		
	
	}
		
}
