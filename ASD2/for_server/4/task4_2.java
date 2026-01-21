import java.util.*;

class aBSTAdditional
{
    public Integer Tree []; // массив ключей

    public aBSTAdditional(int depth)
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

    // Задание 2* getLCA, Time(O(logN)), Space(O(1))
    // Если разные уровни, то вычисляем, какой из них больше и только дял него применяем изменение для индекса.
    // В случае, если два тестовых узла на одном уровне, то меняем их индексы на родительские.
    // Так поступаем до тех пор, пока не найдем одинаковые индексы.
    // Преимущество перед обычным способом, что можно подвязываться к степени двойки для нахождения текущего уровня дерева.
    Integer getLCA(Integer index1, Integer index2) {
        if (index1 == null || index2 == null) return null;
        return checkAncestors(index1, index2);
    }

    Integer checkAncestors(Integer index1, Integer index2) {
        if (index1 == index2) return index1;
        if (index1 == 0 || index2 == 0) return -1;
        Integer level1 = getLevelOfIndex(index1 + 1);
        Integer level2 = getLevelOfIndex(index2 + 1);
        Integer index1Anc = level1 >= level2 ? (index1 - 1) / 2 : index1;
        Integer index2Anc = level2 >= level1 ? (index2 - 1) / 2 : index2;
        return checkAncestors(index1Anc, index2Anc);
    }

    Integer getLevelOfIndex(Integer index) {
        if (index == 1) return 0;
        return 1 + getLevelOfIndex(index / 2);
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

