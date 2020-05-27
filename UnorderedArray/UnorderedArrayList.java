import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UnorderedArrayList extends ArrayListClass { 
   
    public UnorderedArrayList() { 
        super(); 
    }

    public UnorderedArrayList(int size) { 
        super(size); 
    }

    //Bubble Sort 
    public void bubbleSort() { 
     for (int pass = 0; pass < length - 1; pass++) { 
         for (int i = 0; i < length - 1; i++) { 
             if (list[i] > list[i + 1]) { 
                 int temp = list[i]; 
                 list[i] = list[i + 1]; 
                 list[i + 1] = temp; 
             } 
         } 
     } 
    }

    //implementation for abstract methods defined in ArrayListClass 
    //unordered list --> linear search 
    public int search(int searchItem) { 
        for(int i = 0; i < length; i++) 
            if(list[i] == searchItem) 
                return i; 
        return -1; 
    }

    public void insertAt(int location, int insertItem) { 
        if (location < 0 || location >= maxSize) 
            System.err.println("The position of the item to be inserted is out of range."); 
        else if (length >= maxSize) 
            System.err.println("Cannot insert in a full list."); 
        else { 
            for (int i = length; i > location; i--) 
                list[i] = list[i - 1];  //shift right 
            list[location] = insertItem; 
            length++; 
        } 
    }

    public void insertEnd(int insertItem) { 
        if (length >= maxSize) 
            System.err.println("Cannot insert in a full list."); 
        else { 
            list[length] = insertItem; 
            length++; 
        } 
    }

    public void replaceAt(int location, int repItem)  { 
        if (location < 0 || location >= length) 
            System.err.println("The location of the item to be replaced is out of range."); 
        else 
            list[location] = repItem; 
    }

    public void remove(int removeItem) { 
        int i; 
        if (length == 0) 
            System.err.println("Cannot delete from an empty list."); 
        else { 
            i = search(removeItem); 
            if (i != -1) 
                removeAt(i); 
            else 
                System.out.println("Cannot delete! The item to be deleted is not in the list."); 
        } 
    } 
    
    
    public UnorderedArrayList merge(UnorderedArrayList list2){ 
    	UnorderedArrayList merge = new UnorderedArrayList();
    	for(int i = 0;i < this.length; i++){
    		merge.insertEnd(this.retrieveAt(i));
    	}
    	for(int i = 0;i < list2.length; i++){
    		merge.insertEnd(list2.retrieveAt(i));
    	}
    	
    	return merge;
    }
    
    public void split(UnorderedArrayList list1, UnorderedArrayList list2, int key) {
    	int i1 = 0;
    	int i2 = 0;
    	list1.clearList();
    	list2.clearList();
    	for(int i = 0; i < this.listSize(); i++){
    		if(this.list[i] <= key) {
    			list1.insertAt(i1, this.list[i]);
    			i1++;
    		}	
    		else {
    			list2.insertAt(i2, this.list[i]);
    			i2++;
    		}	
    	}
    }
    
}
