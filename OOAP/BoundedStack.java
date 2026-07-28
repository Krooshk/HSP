import java.util.*;

public class BoundedStack<T> {
    // скрытые поля
    private List<T> stack;
    private int maxSize;
    private int peekStatus;
    private int popStatus;
    private int pushStatus;

    // интерфейс класса, реализующий АТД Stack
    public static final int PUSH_NIL = 0;
    public static final int PUSH_OK  = 1;
    public static final int PUSH_ERR = 2;
  
    public static final int POP_NIL = 0;
    public static final int POP_OK  = 1;
    public static final int POP_ERR = 2;
  
    public static final int PEEK_NIL = 0;
    public static final int PEEK_OK  = 1;
    public static final int PEEK_ERR = 2;

    private static final int DEFAULT_MAX_SIZE = 32;

    // конструктор
    public void BoundedStack() {
        this.maxSize = DEFAULT_MAX_SIZE;
        clear();
    }

    // предусловие: количество элементов в стеке меньше максимума
    // постусловие: в вершину стека добавлен новый элемент
    public void push(T value) {
        if (size() < maxSize) {
            stack.add(value);
            pushStatus = PUSH_OK;
        } else {
            pushStatus = PUSH_ERR;
        }
    }

    // предусловие: стек не пуст
    // постусловие: удалён верхний элемент стека
    public void pop() {
        if (size() > 0) {
            stack.remove(size() - 1);
            popStatus = POP_OK;
        } else {
            popStatus = POP_ERR;
        }
    }

    // постусловие: стек очищен, статусы сброшены
    public void clear() {
        stack = new ArrayList<>();
        peekStatus = PEEK_NIL;
        popStatus  = POP_NIL;
        pushStatus = PUSH_NIL;
    }

    // предусловие: стек не пуст
    public T peek() {
        if (size() > 0) {
            peekStatus = PEEK_OK;
            return stack.get(size() - 1);
        }
        peekStatus = PEEK_ERR;
        return null;
    }

    public int size() {
        return stack.size();
    }

    public int getMaxSize() {
        return maxSize;
    }

    // запросы статусов
    public int getPushStatus() {
        return pushStatus;
    }

    public int getPopStatus() {
        return popStatus;
    }

    public int getPeekStatus() {
        return peekStatus;
    }
}
