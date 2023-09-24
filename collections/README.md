## Comparison of Collections

### ArrayList vs LinkedList

Size of variable is 8000000 elements.

| Type       | Insert   | Find     | Remove   |
|------------|----------|----------|----------|
| ArrayList  | 458.47ms | 1.19ms   | 305.03ms |
| LinkedList | 961.75ms | 354.99ms | 14.49ms  |

1) LinkedList is better in removing elements. But if we delete last elements of LinkedList, ArrayList will be faster.
LinkedList is better in removing of first elements. 
2) ArrayList is always faster in finding elements 
3) Inserting of ArrayList is faster in cases, when we had many values. If we make test of inserting
on variable size 80000, we will find, that operations of inserting in LinkedList are faster than ArrayList.

#### Sources: 
1. https://stackoverflow.com/questions/5346039/java-linkedlist-slower-than-arraylist-when-adding-elements
2. https://habr.com/ru/articles/233797/

### TreeSet vs HashSet

Size of variable is 8000000 elements.

| Type    | Insert    | Find   | Remove |
|---------|-----------|--------|--------|
| TreeSet | 2921.96ms | 0.62ms | 0.10ms |
| HashSet | 911.51ms  | 0.08ms | 0.02ms |

#### HashSet is faster in inserting, finding and removing than TreeSet. 

HashSet difficult of operations is O(1) in the best case. 
But HashSet difficult of operations is O(n) in the worst case.

TreeSet difficult of operations is O(log n) in all cases.

#### Conclusion (From fastest to slowest)

**Insert**: ArrayList (in big variables cases) < LinkedList < HashSet < TreeSet

**Find**: HashSet (in best cases) < TreeSet <  ArrayList < LinkedList

**Remove**:  HashSet (in best cases) < TreeSet < LinkedList (remove first part of list) < ArrayList
