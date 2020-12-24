package task3.Fruit;

public class Main {
    public static void main (String[] args) {
        Box <Apple> box1 = new Box();
        Box <Orange> box2 = new Box<>();
        Box <Apple> box3 = new Box<>();
        Box box4 = new Box();

        box1.put(new Apple());
        box1.put(new Apple());
        box1.put(new Apple());

        box2.forceLoaderBox(new Orange(), 6);
        box3.forceLoaderBox(new Apple(), 8);
        System.out.println(box1.getWeight());
        System.out.println(box3.getWeight());
        System.out.println(box2.compareBox(box4));
        box1.TryOverloadBoxToBox(box3);
        System.out.println(box1.getWeight());
        System.out.println(box3.getWeight());

    }
}
