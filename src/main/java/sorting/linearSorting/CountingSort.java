package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		int maxValue = this.findMaxValue(array, leftIndex, rightIndex);
		int[] countingArray = new int[maxValue];

		for(int i = leftIndex; i < rightIndex; i++) {
			countingArray[array[i] - 1]++;
		}

		for(int i = leftIndex + 1; i < rightIndex; i++) {
			countingArray[i] = countingArray[i] + countingArray[i - 1];
		}

		for(int i = rightIndex; i >= leftIndex; i--) {
			array[countingArray[array[i] - 1] - 1] = array[i];
		}
	}

	private int findMaxValue(Integer[] array,  int leftIndex, int rigthIndex) {
		int maxValue = 0;
		for (int i = leftIndex; i < rigthIndex; i++) {
			if (array[i] > maxValue) {
				maxValue = array[i];
			}
		}
		return maxValue;
	}
}
