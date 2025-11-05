## 7.1.
> everywhere - isContainsInEverySet // Содержится в каждом множестве  
detonated - isDetonated // Мина сработала    
write - hasTransferCategory // Есть ли разряд переноса  
notInitial - isInitial // Начальное значение  
successExecution - successWriteFile // Успешная запись файла  

## 7.2.
```java
//...
Character ch = village.charAt(i);
boolean isNumber = digitsList.contains(ch);
boolean isWalker = village.charAt(i) == '=';
//...
```
```java
//...
boolean isRightDirection = true;
//...
```

## 7.3. 
```java
//...
for (int column = 0; column < col.length(); i++){
//...
```

## 7.4.
```java
//...
this.last = dimension == 1;
//...
```
```java
//...
public static boolean helperIsPalindrome(String str, int offset) {
    int end = str.length() - 1;
//...
```

## 7.5. 
```java
//...
int temp = max; // temp заменить на copyMax
max = arr[index];
exMax = temp;
//... можно переставить в две строки и избаваиться от переменной, работает только для чисел
```
```java
//...
Node temp = left.prev; //tempNode, в случае с узлами нельзя убрать временную переменную для перестановки
left.next = right.next;
left.prev = right;
right.prev = temp;
right.next = left;
//...
```
