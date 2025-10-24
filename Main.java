public class Main {
    // Tamanho fixo
    public static final int N = 20;
    // Classe para resultados
    static class Result {
        int swaps;
        int loops;
        int[] sorted; // cópia do array ordenado
      
        Result(int swaps, int loops, int[] sorted) {
            this.swaps = swaps;
            this.loops = loops;
            this.sorted = sorted;
        }
    }
    // Função utilitária: copia array
    public static int[] copyArray(int[] src) {
        int[] dest = new int[N];
        for (int i = 0; i < N; i = i + 1) {
            dest[i] = src[i];
        }
        return dest;
    }
    // Bubble sort com flag de parada
    public static Result bubbleFlag(int[] original) {
        int[] a = copyArray(original);
        int swaps = 0;
        int loops = 0;

        int sortedFlag = 0; // 0 = não garantido, 1 = sem trocas
        while (true) {
            loops = loops + 1; // conta cada iteração do while
            int swapped = 0; // 0/1
            for (int i = 0; i < N - 1; i = i + 1) {
                loops = loops + 1;
                if (a[i] > a[i + 1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    swaps = swaps + 1;
                    swapped = 1;
                }
            }
            if (swapped == 0) {
                break;
            }
        }
        return new Result(swaps, loops, a);
    }
  
    // Selection sort
    public static Result selectionSort(int[] original) {
        int[] a = copyArray(original);
        int swaps = 0;
        int loops = 0;

        for (int i = 0; i < N - 1; i = i + 1) {
            loops = loops + 1;
            int minIdx = i;
            for (int j = i + 1; j < N; j = j + 1) {
                loops = loops + 1;
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int tmp = a[i];
                a[i] = a[minIdx];
                a[minIdx] = tmp;
                swaps = swaps + 1;
            }
        }
        return new Result(swaps, loops, a);
    }
  
    // Cocktail sort
    public static Result cocktailSort(int[] original) {
        int[] a = copyArray(original);
        int swaps = 0;
        int loops = 0;

        int start = 0;
        int end = N - 1;
        int swapped = 1;
        while (swapped == 1) {
            loops = loops + 1;
            swapped = 0;
            for (int i = start; i < end; i = i + 1) {
                loops = loops + 1;
                if (a[i] > a[i + 1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    swaps = swaps + 1;
                    swapped = 1;
                }
            }
            if (swapped == 0) {
                break;
            }
            swapped = 0;
            end = end - 1;
            for (int i = end - 1; i >= start; i = i - 1) {
                loops = loops + 1;
                if (a[i] > a[i + 1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    swaps = swaps + 1;
                    swapped = 1;
                }
            }
            start = start + 1;
        }
        return new Result(swaps, loops, a);
    }
  
    // Gnome sort
    public static Result gnomeSort(int[] original) {
        int[] a = copyArray(original);
        int swaps = 0;
        int loops = 0;

        int index = 0;
        while (index < N) {
            loops = loops + 1;
            if (index == 0) {
                index = index + 1;
                continue;
            }
            loops = loops + 1;
            if (a[index] >= a[index - 1]) {
                index = index + 1;
            } else {
                int tmp = a[index];
                a[index] = a[index - 1];
                a[index - 1] = tmp;
                swaps = swaps + 1;
                index = index - 1;
            }
        }
        return new Result(swaps, loops, a);
    }
  
    // Comb sort
    public static Result combSort(int[] original) {
        int[] a = copyArray(original);
        int swaps = 0;
        int loops = 0;
      
        float shrink = 1.3f;
        int gap = N;
        int sortedFlag = 0;
        while (gap > 1 || sortedFlag == 0) {
            loops = loops + 1;
            gap = (int)(gap / shrink);
            if (gap < 1) {
                gap = 1;
            }
            sortedFlag = 1;
            for (int i = 0; i < N - gap; i = i + 1) {
                loops = loops + 1;
                if (a[i] > a[i + gap]) {
                    int tmp = a[i];
                    a[i] = a[i + gap];
                    a[i + gap] = tmp;
                    swaps = swaps + 1;
                    sortedFlag = 0;
                }
            }
        }
        return new Result(swaps, loops, a);
    }
  
    // Bucket sort
    public static Result bucketSort(int[] original) {
        int[] a = copyArray(original);
        int swaps = 0;
        int loops = 0;
      
        if (N == 0) return new Result(0, 0, a);
      
        // encontra min e max
        loops = loops + 1;
        int minv = a[0];
        int maxv = a[0];
        for (int i = 1; i < N; i = i + 1) {
            loops = loops + 1;
            if (a[i] < minv) minv = a[i];
            if (a[i] > maxv) maxv = a[i];
        }
      
        int k = 5; // número de buckets
        int[][] buckets = new int[k][N]; // cada bucket tem capacidade N
        int[] sizes = new int[k];
        for (int i = 0; i < k; i = i + 1) {
            sizes[i] = 0;
        }
      
        int range = maxv - minv + 1;
        for (int i = 0; i < N; i = i + 1) {
            loops = loops + 1;
            int x = a[i];
            int idx = ( (x - minv) * k ) / range;
            if (idx >= k) idx = k - 1;
            buckets[idx][ sizes[idx] ] = x;
            sizes[idx] = sizes[idx] + 1;
        }
      
        int[] result = new int[N];
        int pos = 0;
        for (int b = 0; b < k; b = b + 1) {
            for (int i = 1; i < sizes[b]; i = i + 1) {
                loops = loops + 1;
                int key = buckets[b][i];
                int j = i - 1;
                while (j >= 0 && buckets[b][j] > key) {
                    loops = loops + 1;
                    buckets[b][j + 1] = buckets[b][j];
                    swaps = swaps + 1;
                    j = j - 1;
                }
                buckets[b][j + 1] = key;
            }
            for (int i = 0; i < sizes[b]; i = i + 1) {
                loops = loops + 1;
                result[pos] = buckets[b][i];
                pos = pos + 1;
            }
        }
        return new Result(swaps, loops, result);
    }
  
    // Função utilitária para imprimir um array
    public static String arrayToString(int[] a) {
        String s = "[";
        for (int i = 0; i < N; i = i + 1) {
            s = s + ("" + a[i]);
            if (i < N - 1) s = s + ", ";
        }
        s = s + "]";
        return s;
    }
  
    // Função para imprimir tabela dos resultados para um vetor
    public static void printResultsForVector(String name, int[] vec, String label) {
        System.out.println("=== " + label + " ===");
        System.out.println("Vetor: " + arrayToString(vec));
        Result rBubble = bubbleFlag(vec);
        Result rSelection = selectionSort(vec);
        Result rCocktail = cocktailSort(vec);
        Result rGnome = gnomeSort(vec);
        Result rComb = combSort(vec);
        Result rBucket = bucketSort(vec);
      
        System.out.println("Algoritmo\tSwaps\tLoops");
        System.out.println("BubbleFlag\t" + rBubble.swaps + "\t" + rBubble.loops);
        System.out.println("Selection\t" + rSelection.swaps + "\t" + rSelection.loops);
        System.out.println("Cocktail\t" + rCocktail.swaps + "\t" + rCocktail.loops);
        System.out.println("Gnome\t\t" + rGnome.swaps + "\t" + rGnome.loops);
        System.out.println("Comb\t\t" + rComb.swaps + "\t" + rComb.loops);
        System.out.println("Bucket\t\t" + rBucket.swaps + "\t" + rBucket.loops);
        System.out.println();
    }
  
    // Programa principal
    public static void main(String[] args) {
        try {
            int[] vetor1 = {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
            int[] vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
            int[] vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};
          
            printResultsForVector("vetor1", vetor1, "Vetor 1 (misturado)");
            printResultsForVector("vetor2", vetor2, "Vetor 2 (ordenado)");
            printResultsForVector("vetor3", vetor3, "Vetor 3 (decrescente)");
          
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
