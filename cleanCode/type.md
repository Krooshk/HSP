```java
//...1
boolean isReachRightKontur = curr_x + size == n;
    if (isRightDirection && isReachRightKontur){
// ...isReachRightKontur вынес в булеву переменную
```
```java
//...2
final static String DIVIDER = "|";
// ... Вынес магическую строку в константу
```

```java
//...3
if (sumVotes) {
    throw new ArithmeticException();
}

double percent = Votes[indexMax] * 1.0 / sumVotes;
// ... Добавил выбрасывание ошибки, если знаменатель равен нулю 
```

```java
//...4
boolean isCrossed = arr2[i].charAt(j) == arr1[startH + i].charAt(startW + j);
        if (!isCrossed) {
            return false;
        }
// ... Вынес выражение в логическую переменную
```

```java
//...5
boolean isNotEqualElems = arr[i] != copy[i];
    if (isNotEqualElems) {
        return false;
    }
// ... Вынес выражение в логическую переменную
```

```java
//...6
boolean isUndoStackEmpty = stackUndo.size() == 0;
        if (!isUndoStackEmpty) {
// ... Вынес выражение в логическую переменную
```

```java
//...7
static final Character SYMBOL_PLUS = '+';
static final Character SYMBOL_DOT = '.';
// ... Вынес символы в константы
```

```java
//...8
final static String ERROR_MESSAGE = "Not such command";
// ... Строка с сообщением об ошибке
```

```java
//...9
boolean isOvercomeMiddleOfStr = offset >= str.length() / 2;
        if (isOvercomeMiddleOfStr) {
        return true;
        }

// ... Вынес выражение в логическую переменную
```

```java
//...10
final static String DIVIDER = " ";
// ... Вынес разделитель для строк
```

```java
//...11
final static String EQUAL_STR = "=";
// ... Вынес cтроку со знаком "равно"
```

```java
//...12
boolean isEven = currentNum % 2 == 0;
if (isEven) {
// ... Вынес выражение в логическую переменную
```