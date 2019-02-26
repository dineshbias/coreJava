/**
 * 
 */
package ocp.collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * testQueueMethods
 * 
 * @author edinjos
 *
 */
public class TestCollections {

  /**
   * @param args
   */
  public static void main(String[] args) {

    int[] i = new int[6];
    String[] array = { "A", "B", "C" };
    List<String> list = Arrays.asList(array);

    // testArrays();
    testCollectionMethods();

    // testListMethods();
    // testSetMethods();
    // testQueueMethods();

    // testMapMethods();
    // testConcurrentModification();

  }

  public static void testArrays() {

    String[] fruits = { "Apple", "Banana" };
    List<String> fruitsList = Arrays.asList(fruits);
    System.out.println("Array: " + fruits[0] + " " + fruits[1]);
    System.out.print("List: ");
    fruitsList.forEach((String s) -> System.out.print(" " + s));

    // Changing List
    System.out.println("");
    fruitsList.set(1, "papaya");
    System.out.println("Array: " + fruits[0] + " " + fruits[1]);
    System.out.print("List: ");
    fruitsList.forEach((String s) -> System.out.print(" " + s));

    System.out.println("");
    fruits[0] = "oranges";
    System.out.println("Array: " + fruits[0] + " " + fruits[1]);
    System.out.print("List: ");
    fruitsList.forEach((String s) -> System.out.print(" " + s));
  }

  public static void testCollectionMethods() {
    Collection<String> l = new ArrayList<String>();

    l.add("Test String");
    l.add("Test String");

    Collection<String> l2 = new ArrayList<>();

    l2.add("Collection");
    l2.add("Collection");

    Collection<String> l3 = new ArrayList<String>();
    l3.add("Collection");
    l3.add("Test String");

    Collection<String> l4 = new ArrayList<String>();
    l4.add("Test String");
    l4.add("ABC");

    l2.addAll(l);
    for (Object s : l2) {
      System.out.println(s);
    }

    System.out.println("After   contains on collection Object " + l2.contains(l3));
    System.out.println("After   containsAll on collection Object " + l2.containsAll(l3));

    System.out.println("After   contains on Object " + l2.contains("Collection"));

    System.out.println("After   removeAll on collection Object " + l2.removeAll(l3));

    for (Object s : l2) {
      System.out.println(s);
    }

    System.out.println("After   remove with Object   " + l.remove("Test String"));
    for (Object s : l) {
      System.out.println(s);
    }

    System.out.println("After   remove  with collection object " + l.remove(l4));
    for (Object s : l) {
      System.out.println(s);
    }

    java.lang.String[] strArray = new String[l4.size()];
    l4.toArray(strArray);
    for (int i = 0; i < strArray.length; i++) {
      System.out.print(strArray[i]);
    }

    System.out.println("Size before clear " + l4.size());
    l4.clear();
    System.out.println("Size after clear " + l4.size());

    l2.add("Mumbai");
    l2.add("Delhi");
    for (Object s : l2) {
      System.out.println(s);
    }

    System.out.println("After Retain " + l2.retainAll(l));
    for (Object s : l2) {
      System.out.println(s);
    }

    Collection<Room> setObj = new HashSet<>();
    System.out.println("---setObj created--");
    System.out.println(setObj);

    Chair chair1 = new Chair(2, "plastic");
    System.out.println("---chair1 created--");
    Room room1 = new Room(1, chair1);
    System.out.println("---room1 created--");
    System.out.println(room1);

    Chair chair2 = new Chair(5, "plastic");
    System.out.println("---chair2 created--");
    Room room2 = new Room(1, chair2);
    System.out.println("---room2 created--");
    System.out.println(room2);

    Chair chair3 = new Chair(9, "wooden");
    System.out.println("---chair3 created--");
    Room room3 = new Room(1, chair3);
    System.out.println("---room3 created--");
    System.out.println(room3);

    Chair chair4 = new Chair(13, "alloy");
    System.out.println("---chair4 created--");
    Room room4 = new Room(1, chair4);
    System.out.println("---room4 created--");
    System.out.println(room4);

    System.out.println("---room1 added to setObj -- " + setObj.add(room1));
    System.out.println("Contains : " + setObj.contains(room2));
    System.out.println("---room2 added to setObj -- " + setObj.add(room2));
    System.out.println("Contains : " + setObj.contains(room3));
    System.out.println("---room3 added to setObj -- " + setObj.add(room3));
    System.out.println("Contains : " + setObj.contains(room4));
    System.out.println("---room4 added to setObj -- " + setObj.add(room4));

    Collection<Room> listObj = new ArrayList<>();
    System.out.println("---room1 added to setObj -- " + listObj.add(room1));
    System.out.println("Contains : " + setObj.contains(room2));
    System.out.println("---room2 added to setObj -- " + listObj.add(room2));
    System.out.println("Contains : " + setObj.contains(room3));
    System.out.println("---room3 added to setObj -- " + listObj.add(room3));
    System.out.println("Contains : " + setObj.contains(room4));
    System.out.println("---room4 added to setObj -- " + listObj.add(room4));

    Collection<Room> treeSetObj = new TreeSet<>();
    System.out.println("---treeSetObj created--");
    System.out.println(treeSetObj);

    Chair chair11 = new Chair(2, "plastic");
    System.out.println("---chair11 created--");
    Room room11 = new Room(1, chair11);
    System.out.println("---room11 created--");
    System.out.println(room11);

    Chair chair22 = new Chair(5, "plastic");
    System.out.println("---chair22 created--");
    Room room22 = new Room(1, chair22);
    System.out.println("---room22 created--");
    System.out.println(room22);

    Chair chair33 = new Chair(9, "wooden");
    System.out.println("---chair33 created--");
    Room room33 = new Room(1, chair33);
    System.out.println("---room33 created--");
    System.out.println(room33);

    System.out.println("---room11 added to treeSetObj -- " + treeSetObj.add(room11));
    System.out.println("Contains : " + treeSetObj.contains(room22));
    System.out.println("---room22 added to treeSetObj -- " + treeSetObj.add(room22));
    System.out.println("Contains : " + treeSetObj.contains(room33));
    System.out.println("---room33 added to treeSetObj -- " + treeSetObj.add(room33));

  }

  public static void testListMethods() {
    ArrayList<B> arrayList = new ArrayList<B>(30);
    arrayList.add(new B(new C(), "100"));
    arrayList.add(new B(new C(), "100"));

    System.out.println(arrayList);

    Iterator<B> it = arrayList.iterator();
    while (it.hasNext()) {
      B b = it.next();
      System.out.print(b.getName() + ",");
    }
    System.out.println("");
    for (B b : arrayList) {
      System.out.print(b.getName() + ",");
    }
    arrayList.add(1, new B(new C(), "1"));

    System.out.println();
    for (int i = 0; i < arrayList.size(); i++)
      System.out.print(arrayList.get(i).getName() + ",");

    System.out.println();
    System.out.println("Contains:" + arrayList.contains(new B(new C(), "1")));
    for (int i = 0; i < 100; i++)
      arrayList.add(new B(new C(), String.valueOf(i)));
    System.out.println();

    ArrayList<B> arrayList2 = new ArrayList<B>(12);
    arrayList2.add(new B(new C(), "17"));

    System.out.println(arrayList.size() + " containsAll:" + arrayList.containsAll(arrayList2));

    System.out.println("Index Of :" + arrayList.indexOf(new B(new C(), "21")));
    System.out.println("Index Of :" + arrayList.indexOf(new B(new C(), "1")));
    System.out.println("lastIndexOf Of :" + arrayList.lastIndexOf(new B(new C(), "1")));

    arrayList2.add(null);
    System.out.println("Before removal:" + arrayList2.size());
    for (B b : arrayList2) {
      if (null != b)
        System.out.println(b.getName());
    }
    arrayList2.remove(0);
    System.out.println("After removal:" + arrayList2.size());
    for (B b : arrayList2) {
      if (null != b)
        System.out.println(b.getName());
    }

    arrayList2.clear();
    System.out.println("After clear:" + arrayList2.size());
    try {
      arrayList2.add(10000000, new B(new C(), "17"));
    } catch (Exception e) {
      System.out.println(e);
    }
    Vector<B> vector = new Vector<B>(17);

    vector.add(new B(new C(), "FirstName"));
    vector.add(new B(new C(), "LastName"));
    vector.add(new B(new C(), "FirstName"));
    vector.add(new B(new C(), "LastName"));

    System.out.println(vector.lastElement());
    System.out.println(vector.firstElement());
    System.out.println(vector.lastIndexOf(vector.firstElement()));

    LinkedList<String> linkedList = new LinkedList<String>();

    linkedList.add("First");
    linkedList.addLast("Last");
    linkedList.add(2, "445");
    linkedList.offer("7");
    linkedList.offerFirst("1");
    linkedList.offerLast("100");
    System.out.println(linkedList);
    System.out.println("linkedList.peekFirst()" + " ---- " + linkedList.peekFirst());
    System.out.println("linkedList.peekLast()" + " ---- " + linkedList.peekLast());
    linkedList.poll();
    System.out.println("linkedList.peekLast()" + " ---- " + linkedList.peekLast());
    linkedList.poll();
    System.out.println("linkedList.peekFirst()" + " ---- " + linkedList.peekFirst());
    linkedList.pollLast();
    System.out.println(linkedList.peekLast() + " ---- " + linkedList.peekLast());
  }

  public static void testSetMethods() {
    HashSet<String> set = new HashSet<String>();
    set.add("Dinesh");
    set.add("Ramesh");
    set.add("Dinesh");
    set.add(null);
    set.add(null);

    System.out.println(set);

    HashSet hashSet = new HashSet<B>();
    for (int i = 0; i < 10; i++)
      hashSet.add(new B(new C(), String.valueOf(i)));
    System.out.println("*************");
    hashSet.add(new B(new C(), String.valueOf(9)));

    System.out.println("*************");
    System.out.println(hashSet);

    B b = new B(new C(), "First");
    hashSet.add(b);
    hashSet.add(new B(new C(), "Test"));
    hashSet.add(new B(new C(), "Last"));
    hashSet.add(b);
    System.out.println(hashSet);
    for (int i = 0; i < 5; i++)
      hashSet.add(new B(new C(), String.valueOf(i)));

    System.out.println();

    TreeSet<String> treeSet = new TreeSet();
    treeSet.add("Dinesh");
    treeSet.add("Joshi");
    treeSet.add("Chander");
    treeSet.add("d");
    treeSet.add("j");
    treeSet.add("100");
    treeSet.add("0");
    treeSet.add("");

    System.out.println("treeSet: " + treeSet);

    TreeSet<Integer> treeSetInt = new TreeSet<Integer>();
    treeSetInt.add(100);
    treeSetInt.add(0);
    treeSetInt.add(1);
    System.out.println(treeSetInt);
    System.out.println(treeSetInt.lower(100));

    HashSet<Integer> hashSetInt = new HashSet<Integer>();
    hashSetInt.add(new Integer("100"));
    hashSetInt.add(0000000);
    hashSetInt.add(55);
    hashSetInt.add(1);

    System.out.println(hashSetInt);

    TreeSet<Room> treeSetObj = new TreeSet<>();
    System.out.println("---treeSetObj created--");
    System.out.println(treeSetObj);

    Chair chair1 = new Chair(2, "plastic");
    System.out.println("---chair1 created--");
    Room room1 = new Room(1, chair1);
    System.out.println("---room1 created--");
    System.out.println(room1);

    Chair chair2 = new Chair(5, "plastic");
    System.out.println("---chair2 created--");
    Room room2 = new Room(1, chair2);
    System.out.println("---room2 created--");
    System.out.println(room2);

    Chair chair3 = new Chair(9, "wooden");
    System.out.println("---chair3 created--");
    Room room3 = new Room(1, chair3);
    System.out.println("---room3 created--");
    System.out.println(room3);

    Chair chair4 = new Chair(13, "alloy");
    System.out.println("---chair4 created--");
    Room room4 = new Room(1, chair4);
    System.out.println("---room4 created--");
    System.out.println(room4);

    System.out.println("---room1 added to treeSetObj -- " + treeSetObj.add(room1));
    System.out.println("---room2 added to treeSetObj -- " + treeSetObj.add(room2));
    System.out.println("---room3 added to treeSetObj -- " + treeSetObj.add(room3));
    System.out.println("---room4 added to treeSetObj -- " + treeSetObj.add(room4));

    System.out.println(treeSetObj);
    System.out.println("---**************************************************--");

    HashSet<Room> hashSetRoom = new HashSet<Room>();
    System.out.println("---room1 added to hashSetRoom -- " + hashSetRoom.add(room1));
    System.out.println("---room1 added to hashSetRoom -- " + hashSetRoom.add(room2));
    System.out.println("---room1 added to hashSetRoom -- " + hashSetRoom.add(room3));

  }

  public static void testQueueMethods() {
    ArrayDeque<String> q1 = new ArrayDeque<String>();
    q1.add("Z");
    q1.offer("A");
    q1.add("B");
    try {
      q1.add(null);
    } catch (Exception e) {
      System.out.println(e);
    }

    System.out.println("Size : " + q1.size());
    for (; q1.size() > 0;)
      System.out.print(q1.poll() + " ");
    System.out.println();
    ArrayDeque<String> arrayDeque = new ArrayDeque<String>();
    arrayDeque.add("ChiefMinister");
    arrayDeque.offer("StateMinister");

    arrayDeque.add("District Magistrate");
    arrayDeque.offerFirst("Prime Minister");
    System.out.println("\narrayDeque.poll()");
    for (; arrayDeque.size() > 0;)
      System.out.print(arrayDeque.poll() + " ");

    arrayDeque = new ArrayDeque<String>();
    arrayDeque.add("ChiefMinister");
    arrayDeque.offer("StateMinister");
    arrayDeque.add("District Magistrate");
    arrayDeque.offerFirst("Prime Minister");
    System.out.println("\narrayDeque.pollLast()");
    for (; arrayDeque.size() > 0;)
      System.out.print(arrayDeque.pollLast() + " ");

    arrayDeque = new ArrayDeque<String>();
    arrayDeque.add("ChiefMinister");
    arrayDeque.offer("StateMinister");
    arrayDeque.push("District Magistrate");
    arrayDeque.offerFirst("Prime Minister");
    System.out.println("\narrayDeque.pop");
    for (; arrayDeque.size() > 0;)
      System.out.print(arrayDeque.pop() + " ");

    arrayDeque = new ArrayDeque<String>();
    arrayDeque.add("ChiefMinister");
    arrayDeque.add("StateMinister");
    arrayDeque.add("District Magistrate");
    arrayDeque.add("Prime Minister");
    System.out.println("\narrayDeque.pop");
    for (; arrayDeque.size() > 0;)
      System.out.print(arrayDeque.pop() + " ");

    arrayDeque = new ArrayDeque<String>();
    arrayDeque.add("ChiefMinister");
    arrayDeque.add("StateMinister");
    arrayDeque.add("District Magistrate");
    arrayDeque.add("Prime Minister");
    System.out.println("\narrayDeque.poll");
    for (; arrayDeque.size() > 0;)
      System.out.print(arrayDeque.poll() + " ");

  }

  public static void testMapMethods() {

    HashMap<String, String> map = new HashMap<String, String>();
    map.put("A", "Z");
    map.put("F", "W");

    map.put("CLARK", "Z");
    map.put("BLAKE", "W");
    map.put("FORD", "Z");
    map.put("SMITH", "W");
    map.put("WARD", "Z");
    map.put("JONES", "W");
    map.put("H", "Z");
    map.put("I", "W");
    map.put("J", null);
    map.put("K", null);
    map.put("L", "W");
    map.put("M", "Z");
    map.put("N", "W");
    map.put("O", "Z");
    map.put("P", "W");
    map.put("Q", null);
    map.put("R", null);
    map.put(null, null);
    System.out.println(map);
    System.out.println("Size : " + map.size());

    LinkedHashMap<String, String> map4 = new LinkedHashMap<String, String>();
    map4.put("A", "Z");
    map4.put("F", "W");
    map4.put("C", null);
    map4.put("F", null);
    map4.put(null, null);
    System.out.println("Size : " + map4.size());
    System.out.println(map4);
    System.out.println(".................");

    Set<Map.Entry<String, String>> entrySet = map.entrySet();
    Iterator<Entry<String, String>> it9 = entrySet.iterator();
    while (it9.hasNext()) {
      Entry e = it9.next();
      System.out.println(e.getKey() + " " + e.getValue());
    }

    System.out.println("contains A : " + map.containsKey("A"));
    System.out.println("contains Value Z : " + map.containsValue("Z"));
    map.clear();
    System.out.println("");

    HashMap<String, B> map2 = new HashMap<String, B>();
    map2.put("003", new B(new C(), "A"));
    map2.put("a", new B(new C(), "C"));
    map2.put("100", new B(new C(), "Z"));
    map2.put("A", new B(new C(), "P"));
    System.out.println("----");

    System.out.println("Contains Key B : " + map2.containsValue(new B(new C(), "P")));
    System.out.println("Contains Value 006: " + map2.containsKey("006"));
    System.out.println("----");

    HashMap<B, String> map3 = new HashMap<B, String>();
    map3.put(null, null);
    map3.put(new B(new C(), "Z"), "003");
    // map3.put(new B(new C(), "A"), "009");
    map3.put(new B(new C(), "P"), "006");

    Set<B> keySet = map3.keySet();
    Iterator<B> it = keySet.iterator();
    while (it.hasNext()) {
      B b = it.next();
      System.out.println(b + " " + map3.get(b));
    }
    map3.put(new B(new C(), "P"), "000");
    it = keySet.iterator();
    while (it.hasNext()) {
      B b = it.next();
      System.out.println(b + " " + map3.get(b));
    }

    Hashtable<B, String> hashTable = new Hashtable<B, String>();
    hashTable.put(new B(new C(), "Z"), "003");
    hashTable.put(new B(new C(), "A"), "009");
    hashTable.put(new B(new C(), "P"), "");

    try {
      hashTable.put(new B(new C(), "P"), null);
    } catch (Exception e) {
      System.out.println(e);
    }

    try {
      hashTable.put(null, null);
    } catch (Exception e) {
      System.out.println(e);
    }

    System.out.println("HashTable\n" + hashTable);

    System.out.println("HashMap \n" + map3);
    System.out.println(map4);
    System.out.println("Contains Key B : " + map3.containsKey(new B(new C(), "P")));
    System.out.println("Contains Value 006: " + map3.containsValue("006"));
    TreeMap<Duck, String> map5 = new TreeMap<Duck, String>();

    // map5.put(new Duck("Test1"), null);
    // map5.put(new Duck("Test2"), null);
    // map5.put(new Duck("Test3"), null);

    // map5.putIfAbsent(arg0, arg1);
    // map5.merge(arg0, arg1, arg2);

    // map5.computeIfPresent(arg0, arg1);
    // map5.computeIfAbsent(arg0, arg1);

    Chair chair1 = new Chair(2, "plastic");
    System.out.println("---chair1 created--");
    Room room1 = new Room(1, chair1);
    System.out.println("---room1 created--");
    System.out.println(room1);

    Chair chair2 = new Chair(5, "plastic");
    System.out.println("---chair2 created--");
    Room room2 = new Room(1, chair2);
    System.out.println("---room2 created--");
    System.out.println(room2);

    Chair chair3 = new Chair(9, "wooden");
    System.out.println("---chair3 created--");
    Room room3 = new Room(1, chair3);
    System.out.println("---room3 created--");
    System.out.println(room3);

    LinkedHashMap<Room, Integer> mapRooms = new LinkedHashMap<Room, Integer>();
    mapRooms.put(room1, 1);
    mapRooms.put(room2, 2);
    mapRooms.put(room3, 3);
    Set<Map.Entry<Room, Integer>> mapRoomsEntrySet = mapRooms.entrySet();
    Iterator<Entry<Room, Integer>> it100 = mapRoomsEntrySet.iterator();
    while (it100.hasNext()) {
      Entry e = it100.next();
      System.out.println(e.getKey() + " " + e.getValue());
    }
    System.out.println("------------------------");
    System.out.println(mapRooms.containsValue(new Integer(3)));
    System.out.println("------------------------");
    System.out.println(mapRooms.containsKey(room1));
    chair1.setmaterial("Dummy");
    System.out.println("Update room1");
    room1.setC(chair1);
    System.out.println("------------------------");
    System.out.println(mapRooms.containsKey(room1));
  }

  public static void testConcurrentModification() {
    ArrayList<String> arrayList = new ArrayList<String>();
    arrayList.add("Dinesh");
    arrayList.add("Chander");
    arrayList.add("Joshi");
    Iterator<String> it = arrayList.iterator();
    try {
      while (it.hasNext()) {
        String s = it.next();
        arrayList.add("Testing");
        System.out.print(s + " ");

      }
    } catch (Exception e) {
      System.out.println(e);
    }
    System.out.println();
    HashMap<String, String> hashMap = new HashMap<String, String>();
    hashMap.put("1", "Dinesh");
    hashMap.put("2", "Chander");
    hashMap.put("3", "Joshi");

    try {
      for (Map.Entry mapEntry : hashMap.entrySet()) {
        System.out.println(mapEntry.getKey() + " " + mapEntry.getValue());
        hashMap.put("", "fgfg");

      }
    } catch (Exception e) {
      System.out.println(e);
    }

    Iterator<Entry<String, String>> localIterator = hashMap.entrySet().iterator();
    try {
      while (localIterator.hasNext()) {
        Entry<String, String> entry = localIterator.next();
        System.out.println(entry.getKey() + " " + entry.getValue());
        hashMap.put("", "");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    System.out.println();
    ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();
    concurrentHashMap.put("1", "Dinesh");
    concurrentHashMap.put("2", "Chander");
    concurrentHashMap.put("3", "Joshi");

    for (Map.Entry mapEntry : hashMap.entrySet()) {
      System.out.println(mapEntry.getKey() + " " + mapEntry.getValue());
      concurrentHashMap.put("", "");
      System.out.print(" ");
    }
  }

}

class A {

}

class B extends A implements Comparable {
  private C c;
  private String name;

  public B(C c, String name) {
    this.c = c;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object paramObject) {
    boolean flag = false;
    System.out.println("B Inside equals");
    if (null == paramObject)
      flag = false;
    if (this == paramObject)
      flag = true;
    if (paramObject instanceof B) {
      flag = name.equals(((B) paramObject).getName());
    }
    System.out.println(flag);
    return flag;
  }

  @Override
  public int hashCode() {
    System.out.println("B Inside hashcode");
    return name.hashCode();
  }

  @Override
  public String toString() {
    return name + " " + super.toString();
  }

  @Override
  public int compareTo(Object arg0) {
    System.out.println("B Compare");
    return 0;
  }
}

class C {

}

class Chair implements Comparable<Chair> {

  public int count;
  public String material;

  public Chair(int count, String material) {
    this.count = count;
    this.material = material;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public String getmaterial() {
    return material;
  }

  public void setmaterial(String material) {
    this.material = material;
  }

  @Override
  public String toString() {
    return "Chair [count=" + count + ", material=" + material + "]";
  }

  @Override
  public int hashCode() {
    System.out.println("Chair hashCode ..");
    final int prime = 31;
    int result = 1;
    result = prime * result + ((material == null) ? 0 : material.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    System.out.println("Chair equals..");
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Chair other = (Chair) obj;
    if (material == null) {
      if (other.material != null)
        return false;
    } else if (!material.equals(other.material))
      return false;
    return true;
  }

  @Override
  public int compareTo(Chair c) {
    System.out.println("Chair compareTo.. " + c);
    return c.material.compareTo(material);
  }

}

class Room implements Comparable<Room> {

  private Chair c;
  private int roomNumber;

  public Room(int roomNumber, Chair c) {
    this.roomNumber = roomNumber;
    this.c = c;
  }

  public Chair getC() {
    return c;
  }

  public void setC(Chair c) {
    this.c = c;
  }

  public int getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(int roomNumber) {
    this.roomNumber = roomNumber;
  }

  @Override
  public int hashCode() {
    System.out.println("Room hashCode.. " + this);
    final int prime = 31;
    int result = 1;
    result = prime * result + ((c == null) ? 0 : c.hashCode());
    result = prime * result + roomNumber;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    System.out.println("Room equals.." + this);
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Room other = (Room) obj;
    if (c == null) {
      if (other.c != null)
        return false;
    } else if (!c.equals(other.c))
      return false;
    if (roomNumber != other.roomNumber)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Room [c=" + c + ", roomNumber=" + roomNumber + "]";
  }

  @Override
  public int compareTo(Room room) {
    System.out.println("Room compareTo.. " + room + "[" + this + "]");
    return c.compareTo(room.c);
  }

}