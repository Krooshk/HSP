```java
//...1 - пункт 1
int min = getMin(m, n);
// Под кольцами подразумеваю, внутренние "контура" матрицы
// Например имеем подобную матрицу
// 1 1 1 1
// 1 2 2 1
// 1 1 1 1
// В данном случае будем иметь два кольца, обозначил внешнее 1, внутреннее 2
int quantityRings = min / 2;
// ...
```

```java
//...2 - пункт 1
boolean isS1Biggest = isFirstBiggest(s1, s2);

// Определяем наибольшую из строк, чтобы получить результат по модулю
if (isS1Biggest) {
    return BigMinusRightOrder(s1, s2);
    } else {
        return BigMinusRightOrder(s2, s1);
    }
// ...
```

```java
//...3 - пункт 2
// Достаточно сравнивать до середины, чтобы определить палиндром
        for (int i = 0; i <= len / 2; i++ ) {
// ...
```

```java
//...4 - пункт 2
// Осуществляем поворот матрицы следующим образом:
// Определаем "кольца", затем разворачиваем их в полосу, сдвигаем элементы и в обратном порядке восстанавливаем
        for (int i = 0; i < quantityRings; i++){
// ...
```

```java
//...5 - пункт 3
// Массив состояния дверей, изначально они все открыты  и имеют значение "0"
String[] doors = new String[k];
// ...
```

```java
//...6 - пункт 2
// Рассматриваем движение во все четыре стороны
handlePoint( x + 1, y, map, queue, N, M);
handlePoint(x - 1, y, map, queue, N, M);
// ...
```

```java
//...7 - пункт 4
// Работает только с 8, и 16-ным форматами, последний параметр является флагом, что число восьмеричное
@Test public void testEmpty(){
    int[] nums = new int[0];
    int[] result = new int[0];
    assertArrayEquals(Task13.UFO(nums.length, nums, false), result);
}
// ...
```

```java
//...8 - пункт 1
// Для чисел заранее вычислены соседи на клавишах
        oneHit.put(1, new Integer[]{ 2, 6, 9});
        oneHit.put(2, new Integer[]{ 1, 5, 3, 8});
// ...
```

```java
//...9 - пункт 5
boolean isPrevNull = node.prev == null;
// Важно обрабатываеть все случаи:
// Когда элемент в начале, в конце, в середине, когда элемент один
            if (isFit && isNextNull && !isPrevNull) {
// ...
```

```java
//...10 - пункт 5
public void put(String key, T value)
{
// Используется кеширование LFU(Least Frequently Used)
}
// ...
```

```java
//...11 - пункт 6
// TODO: вынести в файл с константами
String tonerValue = "!  9\n" +
                "\"  6\n" +
// ...
```

```java
//...12 - пункт 6
public HashTable(int sz, int stp)
// TODO: исправить на более оптимальный вариант решения коллизий
// ...
```

