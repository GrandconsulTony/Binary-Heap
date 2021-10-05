// Anthony Neidhardt 
// CSC 130 Section 3
//class for BinaryHeap
class BinaryHeap{
   int[] heap;
   int itemsInArray = 0;
   int maxSize; 
   
   //constructor to create a heap of a specific size
   public BinaryHeap(int maxSize){
      this.maxSize = maxSize;
      heap = new int[maxSize];
   }
   
   //nonstatic function to insert element into the heap
   public void insert(int index, int x){
      heap[index] = x;
      itemsInArray++;
   }
   
   //nonstatic function to delete min in heap, but then must heap itself
   public int deleteMin(){
      if (itemsInArray != 0){
         int root = heap[0];
         heap[0] = heap[--itemsInArray];
         heapTheArray(0);
         return root;
      }
      return 0;
   }
   //nonstatic function to sort the array and put smallest index as the first element
   public void heapTheArray(int index){
      int littleChild = 0;
      int root = heap[index];
      while(index < (itemsInArray)/2){
         int leftChild = 2 * index + 1;
         int rightChild = leftChild + 1;
         if(rightChild < itemsInArray && heap[leftChild] < heap[rightChild]){
            littleChild = leftChild;
         }
         else if (rightChild < itemsInArray && heap[leftChild] > heap[rightChild]) {
            littleChild = rightChild;
         }
         else if (rightChild > itemsInArray && leftChild < itemsInArray) {
            littleChild = leftChild;
         }
         if(root <= heap[littleChild])
            break;
         heap[index] = heap[littleChild];
         index = littleChild;
         heap[index] = root;
      } 
   }
}
