import java.util.*;

class aBST
{
    public Integer Tree []; // массив ключей

    public aBST(int depth)
    {
        // правильно рассчитайте размер массива для дерева глубины depth:
        int tree_size = countSize(depth);
        Tree = new Integer[ tree_size ];
        for(int i=0; i<tree_size; i++) Tree[i] = null;
    }

    private int countSize(int depth){
        if (depth == 0) return 1;

        return  powBaseTwo(depth) + countSize(depth - 1);
    }

    private int powBaseTwo(int degree) {
        if (degree == 0) return 1;

        return 2 * powBaseTwo(degree - 1);
    }

    // Задание 1 FindKeyIndex, Time(O(logN)), Space(O(1))
    public Integer FindKeyIndex(int key)
    {
        int index = 0;

        while (index < Tree.length && Tree[index] != null) {
            if (key == Tree[index]) {
                return index;
            }

            if (key < Tree[index]) {
                index = index * 2 + 1;
                continue;
            }

            if (key > Tree[index]) {
                index = index * 2 + 2;
            }
        }

        if (index >= Tree.length)  return null;

        return index * -1;
    }

    // Задание 1 AddKey, Time(O(logN)), Space(O(1))
    public int AddKey(int key)
    {
        Integer index = FindKeyIndex(key);
        if (index == null) return -1;
        if (index == 0 && Tree[index] == null || index < 0) {
            Integer positiveIndex = index * -1;
            Tree[positiveIndex] = key;
            return positiveIndex;
        }

        return index;
    }

    // Задание 3 WideAllNodes, Time(O(N)), Space(O(1))
    ArrayList<Integer> WideAllNodes() {
        ArrayList<Integer> list = new ArrayList<>();

        for (Integer node : Tree) {
            if (node != null) {
                list.add(node);
            }
        }

        return list;
    }

}

