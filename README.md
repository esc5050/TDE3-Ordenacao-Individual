# TDE 3 - Ordenação Individual

Implementações **Java** de:
- Comb Sort
- Gnome Sort
- Bucket Sort

E comparação com:
- Bubble Sort (flag de parada)
- Selection Sort
- Cocktail Sort

**Restrições respeitadas**: O projeto usa apenas tipos primitivos, `String`, `try-catch` e operações básicas.

## Resultado & tabelas
As tabelas produzidas pelo programa mostram, para cada algoritmo e para cada vetor de teste:
- `swaps` — quantidade de trocas / movimentos de elementos
- `loopIters` — quantas vezes corpos de laços foram executados
- `comparisons` — comparações entre elementos

## Resultados de desempenho (tabelas)

### Vetor 1 — aleatório
| Algoritmo        | Trocas (swaps) | Iterações (loops) | Comparações |
|------------------|----------------:|-------------------:|-------------:|
| Selection Sort   | 18  | 209 | 190 |
| Comb Sort        | 22  | 138 | 129 |
| Bucket Sort      | 60  | 81  | 60  |
| Cocktail Sort    | 78  | 160 | 154 |
| Gnome Sort       | 78  | 174 | 174 |
| Bubble (flag)    | 78  | 300 | 285 |

**Ranking (menos trocas):** Selection → Comb → Bucket → Gnome/Bubble/Cocktail  
**Ranking (menos iterações):** Bucket → Comb → Cocktail → Gnome → Selection → Bubble

---

### Vetor 2 — já ordenado
| Algoritmo        | Trocas (swaps) | Iterações (loops) | Comparações |
|------------------|----------------:|-------------------:|-------------:|
| Comb Sort        | 0   | 118 | 110 |
| Gnome Sort       | 0   | 19  | 19  |
| Bubble (flag)    | 0   | 20  | 19  |
| Cocktail Sort    | 0   | 20  | 19  |
| Selection Sort   | 0   | 209 | 190 |
| Bucket Sort      | 40  | 61  | 40  |

**Ranking (menos trocas):** Comb/Gnome/Bubble/Cocktail/Selection (empate em 0)  
**Ranking (menos iterações):** Gnome → Bubble/Cocktail → Bucket → Comb → Selection

---

### Vetor 3 — decrescente (pior caso)
| Algoritmo        | Trocas (swaps) | Iterações (loops) | Comparações |
|------------------|----------------:|-------------------:|-------------:|
| Selection Sort   | 10  | 209 | 190 |
| Comb Sort        | 18  | 138 | 129 |
| Bucket Sort      | 113 | 134 | 113 |
| Cocktail Sort    | 190 | 200 | 190 |
| Gnome Sort       | 190 | 380 | 380 |
| Bubble (flag)    | 190 | 400 | 380 |

**Ranking (menos trocas):** Selection → Comb → Bucket → Gnome/Bubble/Cocktail  
**Ranking (menos iterações):** Bucket → Comb → Cocktail → Selection → Gnome → Bubble

---

- O arquivo `SortingComparison.java` tem todas as implementações e uma rotina que imprime essas tabelas no console.
