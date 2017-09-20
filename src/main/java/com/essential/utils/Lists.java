package com.essential.utils;

import java.util.ArrayList;
import java.util.LinkedList;

public class Lists {

  public static <E> ArrayList<E> newArrayList() {

    return new ArrayList<E>();
  }

  public static <E> ArrayList<E> newArrayList(int initialCapacity) {

    return new ArrayList<E>(initialCapacity);
  }

  public static <E> LinkedList<E> newLinkedList() {

    return new LinkedList<E>();
  }
}
