package com.company.mz.Generics;

public class Box {
    private Object object;

    public Box(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Box{" +
                "type = " +this.object.getClass().getSimpleName()+
                " object=" + object +
                '}';
    }
}
