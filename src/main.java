import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {

		// TODO FAZER A LEITURA DO ARQUIVO.DAT

		// BUBLE SORT INT
      
		int quantidade = 10000; //QUANTIDADE DE REGISTROS
		int[] vet = new int[quantidade];

		for (int i = 0; i < vet.length; i++) {
			vet[i] = (int) (Math.random() * quantidade);
		}

		int aux = 0;
		int i = 0;

		// TEMPO INICIAL E FINAL PARA MEDIR O TEMPO DE EXECUÇÃO
		long tempoInicial = System.currentTimeMillis();
		for (i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				if (vet[j] > vet[j + 1]) {
					aux = vet[j];
					vet[j] = vet[j + 1];
					vet[j + 1] = aux;
				}
			}
		}

		for (i = 0; i < 5; i++) {
			System.out.println(" " + vet[i]);
		}
		long tempoFinal = System.currentTimeMillis();
		System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");

//		INSERTIONSORT
		int j;
		int key;

		// TEMPO INICIAL E FINAL PARA MEDIR O TEMPO DE EXECUÇÃO
		tempoInicial = System.currentTimeMillis();

		for (j = 1; j < vet.length; j++) {
			key = vet[j];
			for (i = j - 1; (i >= 0) && (vet[i] > key); i--) {
				vet[i + 1] = vet[i];
			}
			vet[i + 1] = key;
		}

		tempoFinal = System.currentTimeMillis();
		System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");

	}

}
