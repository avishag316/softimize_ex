import java.util.Date;

//Class for Testing 
public class MainClass {
	public static void main(String[] args){
		
		PersonCollection pCollection = new PersonCollection();
		pCollection.setPersonsComparator(new PersonSortByHeightComparator());
		
		//You may use the custom constructor
		//PersonCollection pCollection = new PersonCollection(new PersonSortByHeightComparator());
		
		OnePerson per1 = new OnePerson(12345678, "Abraham", "Cohen",new Date(), 160);
		OnePerson per2 = new OnePerson(23456781, "Benjamin", "Yafe",new Date(), 165);
		OnePerson per3 = new OnePerson(34567812, "David", "Taba",new Date(), 170);
		OnePerson per4 = new OnePerson(45678123, "Yosef", "Baner",new Date(),175);
		
		OneSubscriber sub5 = new OneSubscriber(56781234);
		OneSubscriber sub6 = new OneSubscriber(67812345);
		
		//Add a subscriber as a 'notification listener'
		pCollection.addNotificationListener(sub5, null, null);
		pCollection.addNotificationListener(sub6, null, null);
		
		//Add persons
		pCollection.Add(per2);
		pCollection.Add(per3);
		pCollection.Add(per1);
		pCollection.Add(per4);
		
		//Print
		pCollection.printAll();
		
		//Remove person
		pCollection.Remove();
		
		//Print
		pCollection.printAll();
	}
}
