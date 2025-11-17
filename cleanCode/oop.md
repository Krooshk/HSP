## 3.1.
```java
//...
private NativeCache() { }

public static NativeCache setSize(int sz, Class clazz){
    size = sz;
    slots = new String[size];
    hits = new int[size];
    values = (T[]) Array.newInstance(clazz, this.size);
    return this;
}
//...
```

```java
//...
private BloomFilter() { }

public static BloomFilter initFilterSize(int f_len){
    filter_len = f_len;
    bitArray = 0;
    return this;
}
//...
```

```java
//...
private HashTable() { }

public static void setStep(int stp){
    step = stp;
}

public static initSize(int sz){
    size = sz;
    slots = new String[size];
    for(int i=0; i<size; i++) slots[i] = null;
    return this;
}
//...
```

## 3.2.
FactoryEntity, FactoryAction, FactoryCreature 

