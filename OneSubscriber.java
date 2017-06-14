import javax.management.Notification;
import javax.management.NotificationListener;

//Class for Testing 
public class OneSubscriber implements NotificationListener{
	private int subscriberId;
	
	/**
	* Constructor
	* @param  'id'- subscriber's id
	* @return Nothing
	*/
	public OneSubscriber(int id) {
		this.subscriberId = id;
	}

	/**
	* Print the notifications
	* @param  'anotification'
	* @param  'aobject'
	* @return Nothing
	*/
	public void handleNotification(Notification anotification, Object aobject) {
		System.out.println("Notification:");
		System.out.println("subscriber id: " + String.valueOf(subscriberId) +
				": number of " +anotification.getType() + " is: " + anotification.getSequenceNumber());
	}

}
