package task1_2;

import task3.Fruit.Box;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        Box box1 = new Box();
        Box box2 = new Box<>();
        Box box3 = new Box<>();
        Box box4 = new Box();

        String[] strings = new String[]{"asd", "asdad","a","sdadas"};
        Box[] boxes = new Box[]{ box1,box2,box3,box4};
        Integer[] integers = new Integer[]{2,32,31,312,3123,21};
        System.out.println(Arrays.deepToString(integers));
        replaceElementArray(integers, 1, 2);
        System.out.println(Arrays.deepToString(integers));
        System.out.println(arrayToArrayList(boxes).get(0).getClass());
    }
    //замена элементов массива
    public static <T> void replaceElementArray(T []array, int first, int second) {
        if (first >= array.length || first < 0 || second >= array.length || second < 0) {
            System.out.println("Enter correct number elements of array for change");
        } else if (first >= array.length || first < 0 || second >= array.length || second < 0) {
            System.out.println("Enter not null array");
        } else {
            T a = array[second];
            array[second] = array[first];
            array[first] = a;
        }
    }
    // преобразует массив в ArrayList;
    public static <T> ArrayList arrayToArrayList (T[] array) {
        if (array == null){
            System.out.println("Enter not null array");
            return null;
        }
        else {
            ArrayList <T> list = new ArrayList<T>(Arrays.asList(array));
            return list;
        }
    }
}
