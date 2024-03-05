package src;

public class BubbleSort {
  private int operacoes;
  private long tempoInicio;
  private long tempoFim;

  public int getOperacoes() {
    return operacoes;
  }

  public long getTempoExecucao() {
    long tempoExecucao = (tempoFim - tempoInicio) / 1_000;
    return tempoExecucao;
  }

  public void ordenar(int[] arrayInteiros) {
    tempoInicio = System.nanoTime();
    operacoes = 0;
    int tamanho = arrayInteiros.length;
    for (int i = 0; i < tamanho; i++) {
      for (int j = i + 1; j < tamanho; j++) {
        if (arrayInteiros[j] < arrayInteiros[i]) {
          int temp = arrayInteiros[i];
          arrayInteiros[i] = arrayInteiros[j];
          arrayInteiros[j] = temp;
          operacoes++;
        }
        operacoes++;
      }
    }
    tempoFim = System.nanoTime();
  }

}
