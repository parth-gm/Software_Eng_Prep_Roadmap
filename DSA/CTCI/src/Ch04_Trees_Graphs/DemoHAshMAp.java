package Ch04_Trees_Graphs;

import java.util.HashMap;

public class DemoHAshMAp {

    public static void main(String args[]) {

        // create two hash maps
        HashMap newmap1 = new HashMap();
        HashMap newmap2 = new HashMap();

        // populate 1st map
        newmap1.put(1, "tutorials");
        newmap1.put(2, "point");
        newmap1.put(3, "is best");

        // clone 1st map
        newmap2 = (HashMap)newmap1.clone();

        newmap2.remove(3);

        System.out.println("1st Map: " + newmap1);
        System.out.println("Cloned 2nd Map: " + newmap2);

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }



}

