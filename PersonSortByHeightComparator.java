import java.util.Comparator;

//Class for Testing 
public class PersonSortByHeightComparator implements Comparator<Person>{
	/**
	* Comparator by person's height - (for test)
	* @param  'person1'- person to compare
	* @param  'person2'- person to compare
	* @return The result of the compare
	*/
	@Override
	public int compare(Person person1, Person person2) {
        return (person1.getHeight() < person2.getHeight()) ? -1: (person1.getHeight() > person2.getHeight()) ? 1:0 ;
    }
}