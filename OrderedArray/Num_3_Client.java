	import java.util.*;
	import java.io.*;
	
	public class Num_3_Client {
	
		public static void main(String[] args) {
					
			boolean fileOpened = true;
			Scanner file1 = null; 
			Scanner file2 = null; 
			Scanner sc = new Scanner(System.in);
					
			System.out.println("Please input the name of the file to be opened for first list: ");
			String f1 = sc.next();
			System.out.println("Please input the name of the file to be opened for second list: ");
			String f2 = sc.next();
			
		try {
				file1 = new Scanner(new File (f1));
				file2 = new Scanner(new File (f2));
			}
		catch (FileNotFoundException e) {
				System.err.println("File not found");
				fileOpened = false;
			}
				
		OrderedArrayList list1 = new OrderedArrayList();
		OrderedArrayList list2 = new OrderedArrayList();
		OrderedArrayList list3 = new OrderedArrayList();
				
		if(fileOpened){
			while(file1.hasNext()) {
				if(file1.hasNextInt())
					list1.insert(file1.nextInt());	
				else
					file1.next();
				}
						
			while(file2.hasNext()) {
				if(file2.hasNextInt())
					list2.insert(file2.nextInt());	
				else
					file2.next();
				}
						
				System.out.println("The first list is: ");
				list1.print();
				System.out.println("The second list is: ");
				list2.print();
				System.out.println("The merged list is: ");
				list3.merge(list1,list2);
				list3.print();
				System.out.println("Enter the key for the split: ");
				int key = getInt(sc);
				list3.split(list1,list2, key);
				System.out.println("The first list after the split is: ");
				list1.print();
				System.out.println("The second list after the split is: ");
				list2.print();
				
				file1.close();
				file2.close();
			}
				
		}
			
	
		public static int getInt(Scanner sc) {
			int num;
			
			while (!sc.hasNextInt()) {
				System.out.println("Not an integer, Try again");
					sc.next();
				}
				
				num = sc.nextInt();
				return num;
			}
	
	}

	
