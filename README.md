# TDE 3 - Ordenação Individual

> Aluno: Gustavo Lona Grespan

## Algoritmos implementados

* Comb Sort
* Gnome Sort
* Bucket Sort (com buckets estáticos)
* Bubble Sort com flag de parada
* Selection Sort
* Cocktail Sort

---

O arquivo `Main.java` contém todas as implementações e imprime os resultados.

IDE utilizada: IntelliJ

---

## Vetores usados

* `vetor1 = {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28}`
* `vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32}`
* `vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6}`

---

## Resultado

> As tabelas abaixo são os valores impressos pelo `Main.java` executado no IntelliJ.

### Vetor 1 (misturado)

Vetor: `[12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28]`

| Algoritmo  | Swaps | Loops |
| ---------- | ----: | ----: |
| BubbleFlag |    78 |   300 |
| Selection  |    18 |   209 |
| Cocktail   |    78 |   160 |
| Gnome      |    78 |   350 |
| Comb       |    22 |   138 |
| Bucket     |    22 |    97 |

**Rank (menos swaps)**: 1) Selection (18) — 2) Comb / Bucket (22) — 3) Bubble / Cocktail / Gnome (78).

**Rank (menos loops)**: 1) Bucket (97) — 2) Comb (138) — 3) Cocktail (160) — 4) Selection (209) — 5) Bubble (300) — 6) Gnome (350).

---

### Vetor 2 (ordenado)

Vetor: `[5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32]`

| Algoritmo  | Swaps | Loops |
| ---------- | ----: | ----: |
| BubbleFlag |     0 |    20 |
| Selection  |     0 |   209 |
| Cocktail   |     0 |    20 |
| Gnome      |     0 |    39 |
| Comb       |     0 |   118 |
| Bucket     |     0 |    75 |

**Rank (menos swaps)**: todos 0 (empate).

**Rank (menos loops)**: 1) Bubble / Cocktail (20) — 2) Gnome (39) — 3) Bucket (75) — 4) Comb (118) — 5) Selection (209).

---

### Vetor 3 (decrescente)

Vetor: `[99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6]`

| Algoritmo  | Swaps | Loops |
| ---------- | ----: | ----: |
| BubbleFlag |   190 |   400 |
| Selection  |    10 |   209 |
| Cocktail   |   190 |   200 |
| Gnome      |   190 |   780 |
| Comb       |    18 |   138 |
| Bucket     |    63 |   138 |

**Rank (menos swaps)**: 1) Selection (10) — 2) Comb (18) — 3) Bucket (63) — 4) Bubble/Cocktail/Gnome (190).

**Rank (menos loops)**: 1) Comb & Bucket (138 emp.) — 2) Cocktail (200) — 3) Selection (209) — 4) Bubble (400) — 5) Gnome (780).

---

## Implementação e métricas

* `swaps`: conta apenas as trocas explícitas entre elementos do array (cada atribuição que troca duas posições conta como 1 swap).
* `loops`: conta as iterações executadas por laços `for` e `while`. Cada vez que um laço executa uma volta incrementa +1 no contador.
* `Bucket Sort` foi implementado com `k = 5` buckets fixos, cada bucket com capacidade `N` e ordenação por insertion sort para cada bucket.
* `Comb Sort` usa fator de redução `shrink = 1.3`.
* `Selection Sort` e demais implementações seguem as versões padrão, adaptadas para contar `swaps` e `loops` e obedecer às restrições do enunciado.
