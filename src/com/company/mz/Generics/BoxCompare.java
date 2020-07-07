package com.company.mz.Generics;

public class BoxCompare implements Comparable<BoxCompare>{
    private int size;

    public BoxCompare(int size) {
        this.size = size;
    }

    @Override
    public int compareTo(BoxCompare o) {
        if( o == null){
            throw  new RuntimeException("Object is null!");
        }
        return this.size - o.size;
    }

//    @Override
//    public int compareTo(Object o) {
//        if(!(o instanceof BoxCompare)){
//            throw  new RuntimeException("Invalid box type:" + o.getClass().getSimpleName());
//        }
//        BoxCompare another = (BoxCompare) o;
//        return this.size - another.size;
//    }
}
