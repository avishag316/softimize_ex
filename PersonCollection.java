import java.util.*;
import javax.management.*;

public class PersonCollection extends NotificationBroadcasterSupport{
	//SequenceNumber of notifications
	private int sequenceNumberAdd;
	private int sequenceNumberRemove;
	
	//The collection-list of persons 
	private ArrayList<Person> personsLst = null;
	
	//Person's comparator
	private Comparator<Person> personsComparator = null;
	
	//'lockPersonsLst' lock the 'PersonsLst'
	private Object lockPersonsLst = null;
	//'lockSequenceNumberAdd' lock the 'sequenceNumberAdd'
	private Object lockSequenceNumberAdd = null;
	//'lockSequenceNumberRemove' lock the 'sequenceNumberRemove'
	private Object lockSequenceNumberRemove = null;
	
	/**
	* Constructor
	* @param  Nothing
	* @return Nothing
	*/
	public PersonCollection(){
		//Initialization
		this.sequenceNumberAdd = 0;
		this.sequenceNumberRemove = 0;
		this.personsLst = new ArrayList<Person>();
		lockPersonsLst = new Object();
		lockSequenceNumberAdd = new Object();
		lockSequenceNumberRemove = new Object();
	}
	
	/**
	* Constructor with Comparator assignment
	* @param  'personsComparator' this is parameter of comparator
	* @return Nothing
	*/
	public PersonCollection(Comparator<Person> personsComparator){
		this.sequenceNumberAdd = 0;
		this.sequenceNumberRemove = 0;
		this.personsLst = new ArrayList<Person>();
		lockPersonsLst = new Object();
		lockSequenceNumberAdd = new Object();
		lockSequenceNumberRemove = new Object();
		
		//Sets a comparator
		this.personsComparator = personsComparator;
	}
	
	/**
	* Get
	* @param  Nothing
	* @return 'personsComparator' this is parameter of comparator
	*/
	public Comparator<Person> getPersonsComparator() {
		return personsComparator;
	}

	/**
	* Enables support for all potential comparison algorithms, changes the comparator
	* @param  'personsComparator' this is parameter of comparator
	* @return Nothing
	*/
	public void setPersonsComparator(Comparator<Person> personsComparator) {
		this.personsComparator = personsComparator;
	}
	
	/**
	* Add 'newPerson' to 'personsLst' by sorting in descending order
	* @param  'newPerson' this is the parameter to add (to collection)
	* @return Nothing
	*/
	public void Add(Person newPerson){
		int index = 0;
		Notification notificationAdd;
		
		if(null == personsComparator){
			return;
		}
		
		if(null == personsLst){
			personsLst = new ArrayList<Person>();
		}
		
		synchronized (lockPersonsLst) {
			//Passing personsLst collection
		    for (index = 0; index < this.personsLst.size(); index++) {
		        // If the 'newPerson' is smaller than the index element, go to the next element
		        if(0 >= personsComparator.compare(newPerson, personsLst.get(index))){ 
		        	continue;
		        }
		        break;
		    }
		    //'index' is the location to add 'newPerson'
		    this.personsLst.add(index,newPerson);
		}
		
		synchronized (lockSequenceNumberAdd){
			//Publishes a notification to subscriber objects upon any Add
			notificationAdd = new Notification("add", this, ++sequenceNumberAdd);
		    sendNotification(notificationAdd);
		}
	}

	/**
	* Removes\Pops the person object with the 'maximum' value and returns it
	* @param  Nothing
	* @return Person this returns removed from the collection
	*/
	public Person Remove(){
		Person person;
		
		synchronized (lockPersonsLst) {
			if( null == personsLst || 0 == personsLst.size()){
				return null;
			}
		
			// The 'maximum object' is at the beginning of the list
			person = personsLst.remove(0);
		}
		
		synchronized (lockSequenceNumberRemove) {
			//Publishes a notification to subscriber objects upon any Remove
			Notification notificationRemove = new Notification("remove", this, ++sequenceNumberRemove);
			sendNotification(notificationRemove);
		}
		return person;
	}
	
	/**
	* Prints the 'personsLst', person's height for test
	* @param  Nothing
	* @return Nothing
	*/
	public void printAll(){
		System.out.println("The collection:");
		for(Person person : personsLst){
			System.out.println("person id: '" + person.getId() + "', height:" + person.getHeight());
		}
	}
}