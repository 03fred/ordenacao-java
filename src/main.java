import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {

		// TODO FAZER A LEITURA DO ARQUIVO.DAT

		// BUBLE SORT INT

		int contaIf = 0;
		int contaFor = 0;
		int contaTroca = 0;

		int quantidade = 1000; // QUANTIDADE DE REGISTROS

		int[] vet = new int[quantidade];

		for (int i = 0; i < vet.length; i++) {
			vet[i] = (int) (Math.random() * quantidade);

		}

		System.out.println("Quantidade de registros : " + vet.length);

		int aux = 0;
		int i = 0;

		// TEMPO INICIAL E FINAL PARA MEDIR O TEMPO DE EXECUÇÃO
		long tempoInicial = System.currentTimeMillis();
		for (i = 0; i < vet.length; i++) {
			for (int j = 0; j < (vet.length - 1); j++) {
				contaFor++;
				if (vet[j] > vet[j + 1]) {
					contaIf++;
					aux = vet[j];
					vet[j] = vet[j + 1];
					vet[j + 1] = aux;
				}
			}
		}

		long tempoFinal = System.currentTimeMillis();
		System.out.println("Quantidade de interações: " + contaFor + " " + "Quantidade de comparacoes: " + contaIf + " "
				+ "BUBLE SORT Executado em = " + (tempoFinal - tempoInicial) + " ms");

//		INSERTIONSORT
		int j;
		int key;
		vet = new int[quantidade];
		for (i = 0; i < vet.length; i++) {
			vet[i] = (int) (Math.random() * quantidade);

		}
		// TEMPO INICIAL E FINAL PARA MEDIR O TEMPO DE EXECUÇÃO
		tempoInicial = System.currentTimeMillis();

		contaIf = 0;
		contaFor = 0;
		for (j = 1; j < vet.length; j++) {
			key = vet[j];
			contaFor++;
			for (i = j - 1; (i >= 0) && (vet[i] > key); i--) {
				vet[i + 1] = vet[i];
				contaTroca++;
			}
			vet[i + 1] = key;

		}

		tempoFinal = System.currentTimeMillis();
		System.out.println("Quantidade de interações: " + contaFor + " " + "Quantidade de comparacoes: " + contaIf + " "
				+ "Quantidade de permutas " + contaTroca + " " + "INSERTION SORT Executado em = "
				+ (tempoFinal - tempoInicial) + " ms");

		vet = new int[quantidade];
		for (i = 0; i < vet.length; i++) {
			vet[i] = (int) (Math.random() * quantidade);

		}
//		QUICKSORT
		tempoInicial = System.currentTimeMillis();

		quickSort(vet, 0, vet.length - 1);

		tempoFinal = System.currentTimeMillis();

		System.out.println("QUICKSORT Executado em = " + (tempoFinal - tempoInicial) + " ms");

//		SELECTIONSORT
		tempoInicial = System.currentTimeMillis();
		selectionSort(vet);

		tempoFinal = System.currentTimeMillis();

		System.out.println("SELECTIONSORT Executado em = " + (tempoFinal - tempoInicial) + " ms");

//		SHELLSORT
		tempoInicial = System.currentTimeMillis();
		shellSort(vet);

		tempoFinal = System.currentTimeMillis();

		System.out.println("SHELLSORT Executado em = " + (tempoFinal - tempoInicial) + " ms");

//		MERGESORT
		tempoInicial = System.currentTimeMillis();
		mergeSort(vet, 0, vet.length - 1);

		tempoFinal = System.currentTimeMillis();

		System.out.println("MERGESORT Executado em = " + (tempoFinal - tempoInicial) + " ms");
	}

	private static void quickSort(int[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = separar(vetor, inicio, fim);
			quickSort(vetor, inicio, posicaoPivo - 1);
			quickSort(vetor, posicaoPivo + 1, fim);
		}
	}

	private static int separar(int[] vetor, int inicio, int fim) {
		int pivo = vetor[inicio];
		int i = inicio + 1, f = fim;
		while (i <= f) {
			if (vetor[i] <= pivo)
				i++;
			else if (pivo < vetor[f])
				f--;
			else {
				int troca = vetor[i];
				vetor[i] = vetor[f];
				vetor[f] = troca;
				i++;
				f--;
			}
		}
		vetor[inicio] = vetor[f];
		vetor[f] = pivo;
		return f;
	}

	private static void selectionSort(int[] array) {
		for (int fixo = 0; fixo < array.length - 1; fixo++) {
			int menor = fixo;

			for (int i = menor + 1; i < array.length; i++) {
				if (array[i] < array[menor]) {
					menor = i;
				}
			}
			if (menor != fixo) {
				int t = array[fixo];
				array[fixo] = array[menor];
				array[menor] = t;
			}
		}
	}

	private static int shellSort(int arr[]) {
		int n = arr.length;

		for (int gap = n / 2; gap > 0; gap /= 2) {

			for (int i = gap; i < n; i += 1) {
				int temp = arr[i];

				int j;
				for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
					arr[j] = arr[j - gap];

				arr[j] = temp;
			}
		}
		return 0;
	}

	private static void mergeSort(int vetor[], int inicio, int fim) {
		int meio;
		if (inicio < fim) {
			meio = (inicio + fim) / 2;
			mergeSort(vetor, inicio, meio);
			mergeSort(vetor, meio + 1, fim);
			intercala(vetor, inicio, meio, fim);
		}
	}

	private static void intercala(int vetor[], int inicio, int meio, int fim) {
		int i, j, k;
		int vetorB[] = new int[vetor.length];
		for (i = inicio; i < meio; i++) {
			vetorB[i] = vetor[i];
		}
		for (j = meio + 1; j < fim; j++) {
			vetorB[fim + meio + 1 - j] = vetor[j];
		}
		i = inicio;
		j = fim;
		for (k = inicio; k < fim; k++) {
			if (vetorB[i] <= vetorB[j]) {
				vetor[k] = vetorB[i];
				i = i + 1;
			} else {
				vetor[k] = vetorB[j];
				j = j - 1;
			}
		}
	}

}
