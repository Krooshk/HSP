// 2.1

abstract class LinkedList<T> {

	public static final int HEAD_NIL = 0; // head() ни разу не вызывался
	public static final int HEAD_OK = 1; // курсор успешно переставлен на первый узел
	public static final int HEAD_ERR = 2; // список оказался пуст, переставлять некуда
	
	public static final int TAIL_NIL = 0; // tail() ни разу не вызывался
	public static final int TAIL_OK = 1; // курсор успешно переставлен на последний узел
	public static final int TAIL_ERR = 2; // список оказался пуст, переставлять некуда
	
	public static final int RIGHT_NIL = 0; // right() ни разу не вызывался
	public static final int RIGHT_OK = 1; // курсор успешно сдвинут на соседний узел справа
	public static final int RIGHT_ERR = 2; // сдвигаться некуда: список пуст либо курсор уже на последнем узле
	
	public static final int PUT_RIGHT_NIL = 0; // put_right() ни разу не вызывался
	public static final int PUT_RIGHT_OK = 1; // новый узел успешно добавлен справа от текущего
	public static final int PUT_RIGHT_ERR = 2; // вставка невозможна: курсор не установлен ни на какой узел
	
	public static final int PUT_LEFT_NIL = 0; // put_left() ни разу не вызывался
	public static final int PUT_LEFT_OK = 1; // новый узел успешно добавлен слева от текущего
	public static final int PUT_LEFT_ERR = 2; // вставка невозможна: курсор не установлен ни на какой узел
	
	public static final int REMOVE_NIL = 0; // remove() ни разу не вызывался
	public static final int REMOVE_OK = 1; // текущий узел успешно удалён
	public static final int REMOVE_ERR = 2; // удалять нечего: курсор ни на что не указывает
	
	public static final int ADD_TO_EMPTY_OK = 1; // единственный узел успешно добавлен в пустой список
	public static final int ADD_TO_EMPTY_ERR = 2; // список оказался непустым, операция неприменима
	
	public static final int REPLACE_NIL = 0; // replace() ни разу не вызывался
	public static final int REPLACE_OK = 1; // значение текущего узла успешно заменено
	public static final int REPLACE_ERR = 2; // заменять нечего: курсор не установлен
	
	public static final int FIND_NIL = 0; // find() ни разу не вызывался
	public static final int FIND_OK = 1; // подходящий узел найден, курсор перемещён на него
	public static final int FIND_ERR = 2; // подходящего узла справа от курсора нет 
	
	public static final int GET_NIL = 0; // get() ни разу не вызывался
	public static final int GET_OK = 1; // значение текущего узла успешно возвращено
	public static final int GET_ERR = 2; // получать нечего: курсор ни на что не указывает
	
	// конструктор
	// постусловие: создан новый список, в котором пока нет ни одного узла
	public LinkedList() {	}
		
	// команды
	
	// предусловие: в списке есть хотя бы один узел
	// постусловие: курсор переставлен на самый первый узел списка
	public abstract void head();
	
	// предусловие: в списке есть хотя бы один узел
	// постусловие: курсор переставлен на самый последний узел списка
	public abstract void tail();
	
	// предусловие: список непуст, и текущий узел — не последний
	// постусловие: курсор перемещён к соседнему узлу справа
	public abstract void right();
	
	// предусловие: курсор указывает на некоторый узел 
	// постусловие: справа от текущего узла появился новый узел с заданным значением
	public abstract void put_right(T value);
	
	// предусловие: курсор указывает на некоторый узел 
	// постусловие: слева от текущего узла появился новый узел с заданным значением
	public abstract void put_left(T value);
	
	// предусловие: курсор указывает на некоторый узел 
	// постусловие: текущий узел исключён из списка;
	// курсор переходит на правого соседа, а если справа никого нет — на левого соседа
	public abstract void remove();
	
	// постусловие: список полностью очищен, узлов не осталось
	public abstract void clear();
	
	// предусловие: список пока пуст
	// постусловие: в список добавлен единственный узел с заданным значением
	public abstract void add_to_empty(T value);
	
	// постусловие: в конец списка добавлен новый узел с заданным значением
	public abstract void add_tail(T value);
	
	// предусловие: курсор указывает на некоторый узел 
	// постусловие: старое значение текущего узла заменено на переданное
	public abstract void replace(T value);
	
	// предусловие: курсор указывает на некоторый узел 
	// постусловие: если справа от текущей позиции существует узел с искомым значением —
	// курсор переставлен на него; иначе позиция курсора не меняется
	public abstract void find(T value);
	
	// постусловие: из списка исключены все узлы, значение которых совпадает с value
	public abstract void remove_all(T value);
	
	// запросы
	
	// предусловие: курсор указывает на некоторый узел 
	public abstract T get();
	
	public abstract int size();
	
	public abstract boolean is_head();
	
	public abstract boolean is_tail();
	
	public abstract boolean is_value();
	
	// дополнительные запросы:
	public abstract int get_head_status(); // возвращает одно из значений HEAD_*
	public abstract int get_tail_status(); // возвращает одно из значений TAIL_*
	public abstract int get_right_status(); // возвращает одно из значений RIGHT_*
	public abstract int get_put_right_status(); // возвращает одно из значений PUT_RIGHT_*
	public abstract int get_put_left_status(); // возвращает одно из значений PUT_LEFT_*
	public abstract int get_remove_status(); // возвращает одно из значений REMOVE_*
	public abstract int get_add_to_empty_status(); // возвращает одно из значений ADD_TO_EMPTY_*
	public abstract int get_replace_status(); // возвращает одно из значений REPLACE_*
	public abstract int get_find_status(); // возвращает одно из значений FIND_*
	public abstract int get_get_status(); // возвращает одно из значений GET_*	
}

/* 

2.2 Почему операция tail не сводима к другим операциям (если исходить из эффективной реализации)?

В данной реализации операция будет выполнена за O(1). 
При использовании операции right() для достижения установки курсора на последний элемент надо пройтись по всем элементам => сложность O(N).

2.3 Операция поиска всех узлов с заданным значением, выдающая список таких узлов, уже не нужна. Почему?

Операция поиска всех узлов с заданным значением, выдающая список таких узлов, 
сводится к циклу по всем элементам с использованием операций find() и get().

*/
