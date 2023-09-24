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

