public class Phone {
	private final String model;
	private final double screenSize;
	private final int batteryCapacity;
	
	public Phone(String model, double screenSize, int batteryCapacity) {
		if(screenSize <= 0 || batteryCapacity <= 0) { 
			throw new IllegalArgumentException(
					"Screen size and/or battery capacity can't be negative"
					);
		}
		
		this.model = model;
		this.screenSize = screenSize;
		this.batteryCapacity = batteryCapacity;
	}
	
	/*
	 * Gets the phone's model name.
	 */
	public String getModel() {
		return model;
	}
	
	/*
	 * Gets the phone's diagonal screen size (in inches).
	 */
	public double getScreenSize() {
		return screenSize;
	}
	
	/*
	 * Gets the phone's battery capacity (in mAh).
	 */
	public int getBatteryCapacity() {
		return batteryCapacity;
	}
	
	/*
	 * Determines whether this phone "dominates" another phone, meaning
	 * this phone is better in one criterion, and at least as good in the
	 * other criterion.
	 */
	public boolean dominates(Phone other) {
		if(this.batteryCapacity > other.getBatteryCapacity() && this.screenSize >= other.getScreenSize() || 
				this.batteryCapacity >= other.getBatteryCapacity() && this.screenSize > other.getScreenSize()) {
			return true;
		}else {
			return false;
		}
		
	}
}