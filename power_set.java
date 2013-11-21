/**
 *  This program manipulates sets of numbers. 
 *
 *  Robin Cohen, Moshe Berman
 *
 *  Nov 20, 2013
 *
 */
import java.util.*;

/**
 * {1, 2} -> {{ø}, {1, 2}, {1,2}}
 */

class power_set{
    
    /**
     *    Returns a set of all combinations of the numbers
     *    in the set that we pass in.
     *  
     *    Because we are using Sets, all subsets are distinct.
     *    In other words, there are no duplicates.
     *
     */
    public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
    
        Set<Set<T>> sets = new HashSet<Set<T>>();
    
        if (originalSet.isEmpty()) {
    	   sets.add(new HashSet<T>());
    	   return sets;
        }
    
        List<T> list = new ArrayList<T>(originalSet);
        T head = list.get(0);
    
        Set<T> rest = new HashSet<T>(list.subList(1, list.size())); 
        
        for (Set<T> set : powerSet(rest)) 
        {
    	   Set<T> newSet = new HashSet<T>();
            newSet.add(head);
        	newSet.addAll(set);
        	sets.add(newSet);
        	sets.add(set);
        }		
        return sets;
    }

    /** 
     *  This method returns all sets in the original
     *  set that are of length N.
     */

    public static <T> Set<Set<T>> subsets(Set<T> originalSet, int n)
    {
        //  Gives us an empty set for our sets.
        Set<Set<T>> sets = powerSet(originalSet);
        Set<Set<T>> setsOfLengthN = new HashSet<Set<T>>();     

        //  Iterate the set, looking 
        //  for sets of length N.  
        for (Set<T> set : sets) {
            if (set.size() == n) {
                setsOfLengthN.add(set);
            }
        }

        return setsOfLengthN;
    }

    /** Main, to test. */
    public static void main(String [] params)
    {
        Set<Integer> mySet = new HashSet<Integer>();
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);

        //  Calculate powerSet
        Set<Set<Integer>> resultantSets = power_set.powerSet(mySet);

        //  Calculate subsets
        Set<Set<Integer>> resultantSubsets = power_set.subsets(mySet, 2);

        // Print mySet
        System.out.println("mySet: " + Arrays.toString(mySet.toArray()));

        // Print powerSet
        System.out.println("powerSet all at once: " + Arrays.toString(resultantSets.toArray()));

        //  Print powerSet
        for (Set<Integer> set : resultantSets) {
            System.out.println("powerSet: " + Arrays.toString(set.toArray()));
        }

        // Print subsets
        System.out.println("Result of subsets: " + Arrays.toString(resultantSubsets.toArray()));
    }
}
