package src;

import utils.ArrayUtils;

public class Main {

  public static void main(String[] args) {
    int[] array;
    int[] bubbleArray;
    int[] mergeArray;
    int[] quickArray;
    int[] insertionArray;

    for (int n = 100; n < 50000; n += 350) {
      array = new int[n];
      ArrayUtils.preencherArrayComValoresInteirosAleatorios(array, 10_000, true);

      if (n == 100) {
        System.out.println("BubbleSort;" + "MergeSort;" + "QuickSort;" + "InsertionSort");
      }

      BubbleSort bs = new BubbleSort();
      bubbleArray = array.clone();
      bs.ordenar(bubbleArray.clone());
      System.out.print(n + ";" + bs.getOperacoes() + ";");

      MergeSort ms = new MergeSort();
      mergeArray = array.clone();
      ms.ordenar(mergeArray);
      System.out.print(n + ";" + ms.getOperacoes() + ";");

      QuickSort qs = new QuickSort();
      quickArray = array.clone();
      qs.ordenar(quickArray);
      System.out.print(n + ";" + qs.getOperacoes() + ";");

      InsertionSort is = new InsertionSort();
      insertionArray = array.clone();
      is.ordenar(insertionArray);
      System.out.print(n + ";" + is.getOperacoes() + ";");

      System.out.println();
    }
  }
}
