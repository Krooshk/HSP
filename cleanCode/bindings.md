```java
//...1
    final static String DIVIDER = "|";
// ...
    String coord = x + DIVIDER + y;
// ... Связывание выполняю позже, так код становится гибче. И я могу поменять только в одном месте значение для разделителя.
```

```java
//...2
    final static String FORMAT_PATTERN = "%.5f";
// ...
    return removeZero(String.format(FORMAT_PATTERN, res));
// ... Связывание выполняю позже, так код становится гибче. В данном случае форматирование(округление) происходит до 5 знака после запятой,
// потом могут поменяться требования и надо будет изменить только в одном месте.
```

```java
//...3
public int hash1(String str1)
{
    int magicNumber = 17;
    int result = 0;
    for(int i=0; i < str1.length(); i++)
    {
        int code = (int)str1.charAt(i);
        result = (code + magicNumber * result) % filter_len;
    }

    return result;
}
public int hash2(String str1)
{
    int magicNumber = 223;
    int result = 0;
    for(int i=0; i < str1.length(); i++)
    {
        int code = (int)str1.charAt(i);
        result = (code + magicNumber * result) % filter_len;
    }

    return result;
}
// ... Связывание выполняю рано в отношении магических чисел. Не выносил в константу, 
// так как хотел связать число с областью видимости метода и не перемещать наружу. В данном случае это число будет использоваться только в одном месте.
```