
import java.util.*;

public class Implementation {
	
	List<Database> objects;
	Scanner sc = new Scanner(System.in);
	
	public Implementation(List<Database> objects) {
		this.objects = objects;
	}

	// 1.Display the elements....
	
	public void display() {
		
		System.out.println("ID  Name   Age   Deparment   Designation   ReportingTo");
		for(Database d : objects) {
			System.out.println("-----------------------------------------");
			System.out.println(d.ID+" | "+d.Name+" | "+d.Age+" | "+d.Department+" | "+d.Designation+"  | "+d.ReportingTo);
		}
		
		System.out.println("--------*----------*------------*-----------*-----------");
		System.out.println();
	}
	
	// 2.Searching the elements......
	
	public void search()  {
		
		while(true) {
			
			System.out.print("Do you want Continue the Searching ? (yes/no) : ");
			String result = sc.next().toLowerCase();
			if(result.equals("no")) break;
			
			addAnotherCriteria(objects);
		}
		while(true) {
			System.out.print("Do you want Continue Updating ? (yes/no) : ");
			String result = sc.next().toLowerCase();
			if(result.equals("no")) break;
			
			try {
				update();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("--------Search & Update Finished---------");
		System.out.println();
	}
	
	// 2.5 Update the data..
	public void update() throws InterruptedException{
		
		List<Database> searchedObject = addAnotherCriteria(objects); // Selecting the Rows to be update..
		System.out.println("Select the Column name to Update");
		int opt = provideOption();
		sc.nextLine();
		
		System.out.print("Enter the new Data : ");
		String newData = sc.nextLine();
		
		switch(opt) {
			case 1:
				for(Database obj : searchedObject) {
					obj.ID = Integer.parseInt(newData); 
					Thread.sleep(2000);
					print(obj);
				}
				break;
			case 2:
				for(Database obj : searchedObject) {
					obj.Name = newData;
					Thread.sleep(2000);
					print(obj);
				}
				break;
			case 3:
				for(Database obj : searchedObject) {
					obj.Age = Integer.parseInt(newData);
					Thread.sleep(2000);
					print(obj);
				}
				break;
			case 4:
				for(Database obj : searchedObject) {
					obj.Department = newData;
					Thread.sleep(2000);
					print(obj);
				}
				break;
			case 5:
				for(Database obj : searchedObject) {
					obj.Designation = newData;
					Thread.sleep(2000);
					print(obj);
				}
				break;
			case 6:
				for(Database obj : searchedObject) {
					obj.ReportingTo = newData;
					Thread.sleep(2000);
					print(obj);
				}
				break;
			default:
				System.out.println("Please Enter the correct Option & Data to be Update..");
		}
		
	}
	
	// 3. Delete the rows in DB....
	public void delete() {
		
		while(true) {
			System.out.print("Do you want to Continue the Deleting Process ? (yes/no) ");
			if(sc.next().toLowerCase().equals("no")) break;
			
			System.out.print("Enter the ID for Deleting the row : ");
			int id = sc.nextInt();
			
//			for(Database obj : objects) {
//				if(obj.ID == id) {
//					objects.remove(obj);
//					break;
//				}
//			}
			objects.remove(id-1);
		}
	}
	
	// Another Criteria for recursive operation.....
	private List<Database> addAnotherCriteria(List<Database> lst) {
				
		System.out.println("-------Select the Search Field----------");
		
		int opt = provideOption();
		System.out.print("Enter Data : ");
		String data = sc.next();
		
		List<Database> tempLst = new ArrayList<>();
		
		System.out.println("Provide the Criteria");
		String specify = specifySearch(opt);
		if(specify.equals("wrong")) return tempLst;
		
		switch(opt) {
		// Id column Search.....
		case 1:
			int data1 = Integer.parseInt(data);
			if(specify.equals("="))
			for(Database d : lst) {
				if(d.ID==data1) {
					tempLst.add(d);
					print(d);
					break;
				}
			}
			else if(specify.equals("!=")) {
				for(Database d : lst) {
					if(d.ID!=data1) {
						tempLst.add(d);
						print(d);
					}
				}
			}
			else if(specify.equals(">"))
				for(Database d : lst) {
					if(d.ID>data1) {
						tempLst.add(d);
						print(d);
					}
				}
			else if(specify.equals("<"))
				for(Database d : lst) {
					if(d.ID<data1) {
						tempLst.add(d);
						print(d);
					}
				}
			break;
			
			// Name Column Search....
			case 2:
				if(specify.equals("equals"))
				for(Database d : lst) {
					if(d.Name.equals(data)) {
						tempLst.add(d);
						print(d);
					}
				}
				else if(specify.equals("not equals"))
					for(Database d : lst) {
						if(!d.Name.equals(data)) {
							tempLst.add(d);
							print(d);
						}
					}
				else if(specify.equals("contains")) 
					for(Database d : lst) {
						if(d.Name.contains(data)) {
							tempLst.add(d);
							print(d);
						}
					}
				else if(specify.equals("not contains")) 
					for(Database d : objects) {
						if(!d.Name.contains(data)) {
							tempLst.add(d);
							print(d);
						}
					}
				break;
				
			// Age Search...
			case 3:
				int data11 = Integer.parseInt(data);
				if(specify.equals("="))
				for(Database d : lst) {
					if(d.Age==data11) {
						tempLst.add(d);
						print(d);
					}
				}
				else if(specify.equals("!="))
					for(Database d : lst) {
						if(d.Age!=data11) {
							tempLst.add(d);
							print(d);
						}
					}
				else if(specify.equals("<"))
					for(Database d : lst) {
						if(d.Age<data11) {
							tempLst.add(d);
							print(d);
						}
					}
				else if(specify.equals(">"))
					for(Database d : lst) {
						if(d.Age>data11) {
							tempLst.add(d);
							print(d);
						}
					}
				break;
				
			// Department Search...
			case 4:
				if(specify.equals("equals"))
				for(Database d : lst) {
					if(d.Department.equals(data)) {
						tempLst.add(d);
						print(d);
					}
				}
				else if(specify.equals("not equals"))
					for(Database d : lst) {
						if(!d.Department.equals(data)) {
							tempLst.add(d);
							print(d);
						}
					}
				else if(specify.equals("contains"))
					for(Database d : lst) {
						if(d.Department.contains(data)) {
							tempLst.add(d);
							print(d);
						}
					}
				else if(specify.equals("not contains"))
					for(Database d : lst) {
						if(!d.Department.contains(data)) {
							tempLst.add(d);
							print(d);
						}
					}
				break;
				
			// Designation Search.....
			case 5:
				if(specify.equals("equals"))
				for(Database d : lst) {
					if(d.Designation.equals(data)) {
						tempLst.add(d);
						print(d);
					}
				}
				else if(specify.equals("not equals"))
					for(Database d : lst) {
						if(!d.Designation.equals(data)) {
							tempLst.add(d);
							print(d);
						}
					}
				else if(specify.equals("contains"))
					for(Database d : lst) {
						if(d.Designation.contains(data)) {
							tempLst.add(d);
							print(d);
						}
					}
				else if(specify.equals("not contains"))
					for(Database d : lst) {
						if(!d.Designation.contains(data)) {
							tempLst.add(d);
							print(d);
						}
					}
				break;
				
			// Reporting To Search.....
			case 6:
				if(specify.equals("equals"))
				for(Database d : lst) {
					if(d.ReportingTo.equals(data)) {
						tempLst.add(d);
						print(d);
					}
				}
				else if(specify.equals("not equals"))
					for(Database d : lst) {
						if(!d.ReportingTo.equals(data)) {
							tempLst.add(d);
							print(d);
						}
					}	
				else if(specify.equals("contains"))
					for(Database d : lst) {
						if(d.ReportingTo.contains(data)) {
							tempLst.add(d);
							print(d);
						}
					}
				else if(specify.equals("not contains"))
					for(Database d : lst) {
						if(!d.ReportingTo.contains(data)) {
							tempLst.add(d);
							print(d);
						}
					}	
				break;
				
			// If there is incorrect Option....
			default:
				System.out.println("Please Enter the correct option");
				return tempLst;
		}
		System.out.print("Do you Want Add Another Criteria ? ");
		String temp = sc.next().toLowerCase();
		
		if(temp.equals("yes")) return addAnotherCriteria(tempLst);
		else return tempLst;
		
	}
	
	// Specify the Search....
	private String specifySearch(int option) {
		
		if(option==1 || option==3) {
			System.out.println("1. Equals(==)");
			System.out.println("2. Not Equals(!=)");
			System.out.println("3. Grater than (>)");
			System.out.println("4. Less than (<)");
			System.out.print("Provide the option : ");
			int opt = sc.nextInt();
			
			switch(opt) {
				case 1:
					return "=";
				case 2:
					return "!=";
				case 3:
					return ">";
				case 4:
					return "<";
				default:
					System.out.println("Please provide the correct option...");
			}
		}
		else {
			System.out.println("1. Equals");
			System.out.println("2. Not Equals");
			System.out.println("3. Contains");
			System.out.println("4. Not Contains");
			System.out.print("Provide the option : ");
			int opt = sc.nextInt();
			
			switch(opt) {
			case 1:
				return "equals";
			case 2:
				return "not equals";
			case 3:
				return "contains";
			case 4:
				return "not contains";
			default:
				System.out.println("Please provide the correct option...");
			}
		}
		return "wrongOption";
	}
	
	// Print the Searched Value...
	private void print(Database obj) {
		System.out.println(obj.ID+" | "+obj.Name+" | "+obj.Age+" | "+obj.Department+" | "+obj.Designation+" | "+obj.ReportingTo);	
	}
	
	private int provideOption() {
		
		System.out.println("1. ID");
		System.out.println("2. Name");
		System.out.println("3. Age");
		System.out.println("4. Department");
		System.out.println("5. Designation");
		System.out.println("6. Report To");
		
		System.out.print("Enter Your Option : ");
		int  opt = sc.nextInt();
		
		return opt;
	}
}
