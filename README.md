## Zadanie

Zaimplementuj 1-warstwową sieć neuronową rozpoznającą język zadanego tekstu.

### Sieć neuronowa

Sieć neuronowa ma tyle neuronów, ile jest unikalnych języków w zbiorze danych. Sieć neuronowa powinna je rozpoznać na podstawie danych treningowych.

### Representacja wejścia

Wektor wejściowy reprezentuje proporcję każdej litery ASCII w danym tekście.

#### Przykład:

- Tekst wejściowy: „tools of ai”
- Wektor: 1/9, 0, 0, 0, 0, 1/9, 0, 0, 1/9, 0, 0, 1/9, 0, 0, 1/3, 0, 0, 0, 1/9, 1/9, 0, 0, 0, 0, 0, 0

### Wyjście

Każdy neuron oblicza swoje wyjście liniowe (net). Użyj selektora maksimum, aby znaleźć, który neuron jest aktywowany (1) i załóż, że inne neurony nie są aktywowane (0).

### Trenowanie

Należy zastosować regułę delta. Po każdym kroku uczenia wektory wag można znormalizować, aby poprawić klasyfikację.

### Dane

Utwórz samodzielnie zbiór danych treningowych. Utwórz 3-4 osobne foldery i nadaj im nazwy odpowiadające językom (pl, en, de ...). Każdy folder zawiera pliki tekstowe (10+) w określonym języku - jeden plik zawiera kilka akapitów tekstu. Upewnij się, że wybrany język może być reprezentowany przez znaki ascii.

### Testowanie

Zapewnij interfejs umożliwiający wprowadzenie krótkiego tekstu, który zostanie sklasyfikowany przez Twój program.

### Porównywanie Wartości "Net" Bez Softmax:

1. **Trenowanie:**
    - Sieć z jedną warstwą o liniowych neuronach przetwarza dane wejściowe.
    - Wyniki "net" z neuronów wyjściowych są otrzymywane bezpośrednio jako sumy ważone danych wejściowych:
      \[
      net_i = \sum_{j=1}^{N} w_{ij} \cdot x_j
      \]
    - \( net_i \) to wynik "net" dla neuronu \( i \),
    - \( w_{ij} \) to waga między neuronem \( i \) a wejściem \( j \),
    - \( x_j \) to wartość wejścia dla neuronu \( j \).

2. **Testowanie:**
    - Podczas testowania, możesz porównywać te wartości "net" dla różnych neuronów wyjściowych.
    - Wybierz neuron z największą wartością "net" jako przewidywaną klasę/język.








=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=