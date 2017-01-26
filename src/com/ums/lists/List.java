package com.ums.lists;

public interface List extends Cloneable {

    public Object clone() throws CloneNotSupportedException;

    public void deleteFromList(String id);

    public int find(String criteria);

    public int find(int criteria);

    public int find(double criteria);

    public void sort();
}
