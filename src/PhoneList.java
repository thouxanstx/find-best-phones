import java.util.*;

public class PhoneList {
	private final List<Phone> allPhones = new ArrayList<>();
	private final Set<Phone> bestPhones = new HashSet<>();
	
	/*
	 * Adds a phone to the list.
	 */
	public void addPhone(Phone phone) {
		allPhones.add(phone);
		
		// remove from bestPhones if dominated by the new phone
		Iterator<Phone> iter = bestPhones.iterator();
		while(iter.hasNext()) {
			Phone other = iter.next();
			if(phone.dominates(other)) {
				iter.remove();
			}
		}
		
		// only add the new phone to bestPhones if it's not dominated
		if(!phoneIsDominated(phone)) {
			bestPhones.add(phone);
		}
	}
	
	/*
	 * Determines whether a phone is dominated by any other phone.
	 */
	public boolean phoneIsDominated(Phone phone) {
		// only need to compare with the undominated phones
		for(Phone other : bestPhones) {
			if(other.dominates(phone)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Gets all phones. The list returned is unmodifiable.  
	 */
	public List<Phone> getAllPhones() {
		return Collections.unmodifiableList(allPhones);
	}
	
	/*
	 * Gets all phones which are not dominated by another phone. The
	 * collection returned is unmodifiable.  
	 */
	public Collection<Phone> getBestPhones() {
		return Collections.unmodifiableCollection(bestPhones);
	}
}