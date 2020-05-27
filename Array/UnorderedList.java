
public abstract class UnorderedList extends ArrayListClass {

	public UnorderedList(){
		super();
	}
	
	public UnorderedList(int size){
		super(size);
	}
	
	public void bubbleSort(){
		for (int pass = 0; pass < length -1; pass++){
			for(int i = 0; pass < length -1; i++){
				if(list[i] > list[i+1]){
					int temp = list[i];
					list[i] = list[i+1];
					list[i+1] = temp;
				}
			}
		}
	}
		
	public int search(int searchItem){
		for(int i=0; i<length; i++){
			if(list[i] == searchItem)
				return i;
			return -1;
		}
	}
	
	
	public void insertAt(int location, int insertItem){
		if(location < 0 || location >= maxSize)
			System.out.println("The position of the item to be inserted is out of range.");
		else if(length>= mazSize)
			System.out.println("Cannot insert in a full list.");
		else{
			for(int i = length; i>location; i--){
				list[i] = list[i-1];
				list[location] = insertItem;
				length++;
			}
		}
	}
	
	
	public void insertEnd(int insertItem){
		if(length >= maxSize)
			System.out.println("Cannot insert in a full list.");
		else{
			list[length] = insertItem;
			length;
		}	
	}
	
	public void replaceAt(int location, int repItem){
		if(location < 0 || location >= length)
			System.out.println("The location of the item to be replaced is out of range.");
		else 
			list[location] = repItem;
	}
	
	
	public void remove(int removeItem){
		int i;
		if(length == 0)
			System.out.println("Cannot delete from an empty list.");
		else{
			i = search(removeItem);
			if(i != -1)
				removeAt(i);
			else
				System.out.println("Cannt delete! The item to be deleted is not in the list.");
		}
	}
	
	public void merge(UnorderedList list2, UnorderedList list1){
		int num = 0;
		for(int j = 0; j<list1.length; j++){
			num = list1.retrieveAt(j);
			insertEnd(num);
		}
		for(int i=0; i<list2.length - 1; i++){
			num = list2.retrieveAt(i);
			insertEnd(num);
		}
	}
	
	public void split(UnorderedList list2, UnorderedList list1, 
			UnorderedList list, int item){
		int listItem = item;
		while(!list.isEmpty()){
			list.retrieveAt(listItem);
			if(listItem>item){
				if(!list2.ifFull()){
					list2.insertAt(listItem);
				}
			}
		}
		list.ResetList();
		while(!list.IsLastItem()){
			list.GetNextItem(listItem);
			if(listItem > item){
				if(!list2.IsFull())
					list2.InsertItem(listItem);
			}
			else{
				if(!list1.IsFull())
					list2.InsertItem(listItem);
				
			}
		}
		
			
	}	
}
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
