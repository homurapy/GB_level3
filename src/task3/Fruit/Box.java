package task3.Fruit;

import java.util.ArrayList;

public class Box <T extends Fruit>  {
    private ArrayList <T> boxC = new ArrayList<T>();
    public <T extends Fruit> Box(){}

    public void put(T fruit){
    this.boxC.add(fruit);
    }
    public <T>float getWeight(){
        Float weightBox;
        if(boxC.size() == 0){
        weightBox =0.0f;
        }
        else {
            weightBox = this.boxC.get(0).getWeight() * this.boxC.size();
        }
        return weightBox;
    }
    public boolean compareBox(Box box){
        if (this.getWeight() == box.getWeight()) {
        return true;
    }
    else{
        return false;
        }
    }
    public boolean TryOverloadBoxToBox (Box <T> box) {
        if (this.boxC.size() == 0) {
            System.out.println(box + " - is free");
            return false;
        }
        else if (box.boxC.size() == 0){
            this.boxC.addAll(box.boxC);
            box.boxC.clear();
            return true;
        }
        else
            {
            box.boxC.addAll(this.boxC);
            this.boxC.clear();
            return true;
        }
    }
    public void forceLoaderBox(T fruit, int quantity){
        for (int i = 0; i < quantity; i++) {
            boxC.add(fruit);
        }
    }

}


