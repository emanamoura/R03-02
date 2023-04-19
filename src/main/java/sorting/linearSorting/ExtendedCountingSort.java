package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		int[] maxAndMinValue = this.findMaxAndMinValue(array, leftIndex, rightIndex);
		int minValue = maxAndMinValue[0];
		int maxValue = maxAndMinValue[1];

		int[] countingArray = new int[maxValue - minValue];

		for(int i = leftIndex; i < rightIndex; i++) {
			countingArray[mapIndex(array[i], minValue)]++;
		}

		for(int i = leftIndex + 1; i < rightIndex; i++) {
			countingArray[i] = countingArray[i] + countingArray[i - 1];
		}

		for(int i = rightIndex; i >= leftIndex; i--) {
			array[countingArray[mapIndex(array[i], minValue)] - 1] = array[i];
		}
	}

	private int[] findMaxAndMinValue(Integer[] array,  int leftIndex, int rigthIndex) {
		int maxValue = 0;
		int minValue= 999999999;
		for (int i = leftIndex; i < rigthIndex; i++) {
			if (array[i] > maxValue) {
				maxValue = array[i];
			}
			if(array[i] < minValue) {
				minValue = array[i];
			}
		}
		return new int[]{minValue, maxValue};
	}

	private int mapIndex(int value, int minValue) {
		return value - minValue;
	}
}
