import java.util.*;
public class User {
	
	static List<Database> objects;
	
	public static void main(String[] args) throws InterruptedException {
		
			// Scanner for input
			Scanner sc = new Scanner(System.in);
			
			Database obj1 = new Database(1,"Sriram",45,"Management","CEO","--");
			Database obj2 = new Database(2,"Mukund",42,"HR","HR Manager","Sriram");
			Database obj3 = new Database(3,"Sebastian",38,"Finance","Finance Manager","Sriram");
			Database obj4 = new Database(4,"Aashirtha",32,"Product Management","Dev Manager","Sriram");
			Database obj5 = new Database(5,"Mohammad Rafi",35,"HR","HR Lead","Mukund");
			Database obj6 = new Database(6,"Anjali Kumar",29,"HR","HR associate","Mohammad Rafi");
			Database obj7 = new Database(7,"Joseph",40,"Finance","Finance Associate","Sebastian");
			Database obj8 = new Database(8,"Ramachandran",27,"Product Development","tech Lead","Aashirtha");
			Database obj9 = new Database(9,"Abhinaya Shankar",23,"Product Developement","System Developer","Ramachandran");
			Database obj10 =new Database(10,"Imran Khan",28,"Product Testing","QA Lead","Ramachandran");
			
			objects = new ArrayList<>();
			objects.add(obj1);
			objects.add(obj2);
			objects.add(obj3);
			objects.add(obj4);
			objects.add(obj5);
			objects.add(obj6);
			objects.add(obj7);
			objects.add(obj8);
			objects.add(obj9);
			objects.add(obj10);
			
			Implementation imp = new Implementation(objects);
			
			boolean isRun = true;
			while(isRun) {
				
				System.out.println("---- Initial Menu----");
				System.out.println("1. Show all Records");
				System.out.println("2. Search and update Record");
				System.out.println("3. Remove Employee");
				System.out.println("4. Manager Report");
				System.out.println("5. Reporting To -Tree");
				System.out.println("6. Summary Reports");
				System.out.println("7. Exit");
				System.out.print("Enter Your Option : ");
				int opt = sc.nextInt();
				
				switch(opt) {
					case 1:
						imp.display();
						break;
					case 2:
						imp.search();
						break;
					case 3:
						imp.delete();
						break;
					case 4:
					case 5:
					case 6:
					case 7:
						System.out.println("Exiting...");
						Thread.sleep(3000);
						System.out.println("Thank you !!!");
						isRun = false;
						break;
					default:
						System.out.println("Incorrect Option Please Select Correct One..");
				}
			}
			sc.close();
	}
	
}
