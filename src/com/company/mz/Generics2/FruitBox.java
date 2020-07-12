package com.company.mz.Generics2;

import java.util.ArrayList;
import java.util.List;

public class FruitBox <T extends Fruit>  implements Box {

    private int fruitQty;
    private List<T> fruitBox;

    public List<T> getFruitBox() {
        return fruitBox;
    }

    public int getFruitQty() {
        return fruitQty;
    }

    public FruitBox(List<T> fruit) {
        fruitBox = new ArrayList<T>();
        this.addFruitToTheBox(fruit);
    }

    public FruitBox() {
        fruitBox = new ArrayList<T>();
    }

    public <T extends Fruit> float getWeight(){
        Fruit f = this.fruitBox.get(0);
        if(f==null || fruitBox.size() == 0) return 0.0f;
        else return fruitQty*T.getWeight();
    }

    public void addFruitToTheBox(T fr){
        this.fruitBox.add(fr);
        fruitQty++;
    }
    public void addFruitToTheBox(List<T> fr){
        for (T t : fr){
            this.addFruitToTheBox(t);
        }
    }
    public boolean compare(FruitBox<?> another){
        if(this.getWeight()-another.getWeight()==0)
            return true;
        else return false;
    }
    //not
    public boolean shiftFruit(FruitBox<T> box){
        Fruit fAnother= box.fruitBox.get(0);
        Fruit fThis= this.fruitBox.get(0);
        if(box.fruitQty == 0 || fAnother ==null){
            box.addFruitToTheBox(this.getFruitBox());
            this.clearBox();
            return true;
        }else if(fAnother instanceof Apple && fThis instanceof Apple){
            box.addFruitToTheBox(this.getFruitBox());
            this.clearBox();
            return true;
        }else if(fAnother instanceof Orange && fThis instanceof Orange){
            box.addFruitToTheBox(this.getFruitBox());
            this.clearBox();
            return true;
        }else return false;
    }
    public void clearBox(){
        this.fruitBox.clear();
        this.fruitQty = this.fruitBox.size();
    }

}
