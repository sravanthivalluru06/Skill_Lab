public interface MinMax<T extends Comparable<T>> {
    T findMax(T[] array);
    T findMin(T[] array);
}
public class IntegerMinMax implements MinMax<Integer> {
    @Override
    public Integer findMax(Integer[] array) {
        Integer max = array[0];
        for (Integer value : array) {
            if (value.compareTo(max) > 0) {
                max = value;
            }
        }
        return max;
    }

    @Override
    public Integer findMin(Integer[] array) {
        Integer min = array[0];
        for (Integer value : array) {
            if (value.compareTo(min) < 0) {
                min = value;
            }
        }
        return min;
    }
}
public class FloatMinMax implements MinMax<Float> {
    @Override
    public Float findMax(Float[] array) {
        Float max = array[0];
        for (Float value : array) {
            if (value.compareTo(max) > 0) {
                max = value;
            }
        }
        return max;
    }

    @Override
    public Float findMin(Float[] array) {
        Float min = array[0];
        for (Float value : array) {
            if (value.compareTo(min) < 0) {
                min = value;
            }
        }
        return min;
    }
}
public class StringMinMax implements MinMax<String> {
    @Override
    public String findMax(String[] array) {
        String max = array[0];
        for (String value : array) {
            if (value.compareTo(max) > 0) {
                max = value;
            }
        }
        return max;
    }

    @Override
    public String findMin(String[] array) {
        String min = array[0];
        for (String value : array) {
            if (value.compareTo(min) < 0) {
                min = value;
            }
        }
        return min;
    }
}
public class CharacterMinMax implements MinMax<Character> {
    @Override
    public Character findMax(Character[] array) {
        Character max = array[0];
        for (Character value : array) {
            if (value.compareTo(max) > 0) {
                max = value;
            }
        }
        return max;
    }

    @Override
    public Character findMin(Character[] array) {
        Character min = array[0];
        for (Character value : array) {
            if (value.compareTo(min) < 0) {
                min = value;
            }
        }
        return min;
    }
}
public class MinMaxUtil {
    public static <T extends Comparable<T>> void printMinMax(MinMax<T> minMax, T[] array) {
        System.out.println("Array: ");
        for (T value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println("Max: " + minMax.findMax(array));
        System.out.println("Min: " + minMax.findMin(array));
    }

    public static void main(String[] args) {
        Integer[] intArray = {3, 1, 4, 1, 5, 9};
        Float[] floatArray = {3.14f, 1.59f, 2.65f, 3.58f};
        String[] stringArray = {"apple", "banana", "cherry"};
        Character[] charArray = {'a', 'z', 'b', 'x'};

        printMinMax(new IntegerMinMax(), intArray);
        printMinMax(new FloatMinMax(), floatArray);
        printMinMax(new StringMinMax(), stringArray);
        printMinMax(new CharacterMinMax(), charArray);
    }
}
