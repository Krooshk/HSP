```java
//...1
final static int SIZE_FIBERS = 8192;
public static int artificial_muscle_fibers(int[] arr){
    byte[] store = new byte[SIZE_FIBERS];
}
// ...По заданию было ограничение в 8 мб, лучше размер вынести в константу
```
```java
//...2
final static int ARRAY_LENGTH = 3;
public static int[] TRC_sort(int[] trc) {
    int[] countDigits = new int[ARRAY_LENGTH];
// ... Размер массива можно вынести в константу
```

```java
//...3
final String DIRECTION_UP = "up";
final String DIRECTION_DOWN = "down";
final String DIRECTION_LEFT = "left";
final String DIRECTION_RIGHT = "right";
public static String army_communication_matrix(int n, int [][] matrix) {
// ... Строковые значение лучше вынести, тем более каждое из них повторялось по три раза  
```

```java
//...4
final Character EMPTY_BIT = '0';
final Character FULL_BIT = '1';
public static String digital_rain(String col){
// ... Символы пустого и заполненого бита тоже лучше вынести  
```

```java
//...5
final static Character[] DIGITS = new Character[]{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
// ... Cимволы цифр следует вынести, так как в коде они не изменяются, а определяются заранее 
```

```java
//...6
final static String FORMAT_PATTERN = "%.5f";
//---//----
        return removeZero(String.format(FORMAT_PATTERN, res));

// ... Строку, определяющую форматирование лучше вынести, определяется единожды 
```

```java
//...7
final static String MAJOR_WINNER = "majority winner";
final static String MINOR_WINNER = "minority winner";
final static String NO_WINNER = "no winner";
// ... Строки с определенной информацией, которая не будет часто изменяться
```

```java
//...8
final static String ERROR_MESSAGE = "Not such command";
// ... Строка с сообщением об ошибке
```

```java
//...9
final static Character OPEN_BRACKET = '(';
final static Character CLOSE_BRACKET = ')';
// ... Скобки для валидации выражения
```

```java
//...10
final static String DIVIDER = " ";
// ... Разделитель для строк
```

```java
//...11
final static String EQUAL_STR = "=";
// ... Строка с равно, вдруг будет пример с приближенным равно
```

```java
//...12
final statc int SALT_NUMBER_ONE = 42;
// ... Случайное число для соли
```