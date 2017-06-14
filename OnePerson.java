import java.util.Date;

//Class for Testing 
public class OnePerson implements Person  {

	private int id;
	private String firsnName;
	private String lastName;
	private Date date;
	private int height;
	
	/**
	* Constructor
	* @param  id - person's id
	* @param  firstName - person's firstName
	* @param  lastName - person's lastName
	* @param  date - person's date
	* @param  height - person's height
	* @return Nothing
	*/
	public OnePerson(int id,String firstName,String lastName,Date date,int height){
		//Initialization
		this.id = id;
		this.firsnName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.height = height;
	}
	
	/**
	* Get
	* @param  Nothing
	* @return 'id' of person
	*/
	public int getId() {
		return this.id;
	}

	/**
	* Get
	* @param  Nothing
	* @return 'firsnName' of person
	*/
	public String getFirstName() {
		return this.firsnName;
	}

	/**
	* Get
	* @param  Nothing
	* @return 'lastName' of person
	*/
	public String getLastName() {
		return this.lastName;
	}

	/**
	* Get
	* @param  Nothing
	* @return 'height' of person
	*/
	public int getHeight() {
		return this.height;
	}

	/**
	* Get
	* @param  Nothing
	* @return 'date' of person
	*/
	public Date getDateOfBirth() {
		return this.date;
	}
}
