public class OrderedArrayList extends ArrayListClass{ 
   
    public OrderedArrayList() { 
        super(); 
    }

    public OrderedArrayList(int size) { 
        super(size); 
    } 
 

    //implementation for abstract methods defined in ArrayListClass

    //ordered list --> binary search 
    public int search(int item) { 
        int first = 0; 
        int last = length - 1; 
        int middle = -1;

        while (first <= last)  { 
            middle = (first + last) / 2; 
            if (list[middle] == item) 
                return middle; 
            else 
                if (list[middle] > item) 
                    last = middle - 1; 
                else 
                    first = middle + 1; 
        } 
        return -1; 
    }

    public void insert(int item) { 
        int loc; 
        boolean found = false; 
        if (length == 0)            //list is empty 
            list[length++] = item;  //insert item and increment length 
        else if (length == maxSize) //list is full 
            System.err.println("Cannot insert in a full list."); 
        else { 
            for (loc = 0; loc < length; loc++) { 
                if (list[loc] >= item) { 
                    found = true; 
                    break; 
                } 
            } 
            //starting at the end, shift right 
            for (int i = length; i > loc; i--) 
                list[i] = list[i - 1]; 
            list[loc] = item; //insert in place
            length++; 
        } 
    }


    public void insertAt(int location, int item)  { 
        if (location < 0 || location >= maxSize) 
            System.err.println("The position of the item to be inserted is out of range."); 
        else if (length == maxSize)  //the list is full 
            System.err.println("Cannot insert in a full list."); 
        else { 
            System.out.println("Cannot do it, this is a sorted list. Doing insert in place (call to insert)."); 
            insert(item); 
        } 
    }

    public void insertEnd(int item) { 
        if (length == maxSize)  //the list is full 
            System.err.println("Cannot insert in a full list."); 
        else { 
            System.out.println("Cannot do it, this is a sorted list. Doing insert in place (call to insert)."); 
            insert(item); 
        } 
    }

    public void replaceAt(int location, int item) { 
        //the list is sorted! 
        //is actually removing the element at location and inserting item in place 
        if (location < 0 || location >= length) 
             System.err.println("The position of the item to be replaced is out of range."); 
        else { 
            removeAt(location);//method in ArrayListClass 
            insert(item); 
        } 
    }

     public void remove(int item) { 
        int loc; 
        if (length == 0) 
            System.err.println("Cannot delete from an empty list."); 
        else  { 
            loc = search(item); 
            if (loc != -1) 
                removeAt(loc);//method in ArrayListClass 
            else 
                System.out.println("The item to be deleted is not in the list."); 
        } 
    }


     
     public void merge(OrderedArrayList list1, OrderedArrayList list2){

    	    int size = list1.listSize() + list2.listSize();
    	    int i1 = 0;
    	    int i2 = 0;

    	    int temp = list1.retrieveAt(0);
    	    
    	    for(int i = 0; i < size; i++) {
    	      
    	      if(i1 > list1.listSize() -1) { 
    	        temp = list2.retrieveAt(i2);
    	        list[i] = temp;
    	        length++;
    	        i2++;
    	      }
    	      
    	      if(i2 > list2.listSize() -1) { 
    	        temp = list1.retrieveAt(i1);
    	        list[i] = temp;
    	        length++;
    	        i1++;
    	      }
    	      
    	      else if(list1.retrieveAt(i1) <= list2.retrieveAt(i2)) { 
    	        temp = list1.retrieveAt(i1);
    	        list[i] = temp;
    	        length++;
    	        i1++;
    	      }
    	      
    	      else if(list2.retrieveAt(i2) < list1.retrieveAt(i1)) { 
    	        temp = list2.retrieveAt(i2);
    	        list[i] = temp;
    	        length++;
    	        i2++;
    	      }  
    	      
    	    }
    	    
     }
     
     
     public void split(OrderedArrayList list2, OrderedArrayList list3, int key){
       int i1 = 0;
       int i2 = 0;
       
       list2.clearList();
       list3.clearList();
       
       for(int i = 0; i < this.listSize() ; i++) {
         if(list[i] <= key){
           list2.insert(list[i]);
           i1++;
         }
         else{
           list3.insert(list[i]);
           i2++;
         }
       }
     }
     
}

