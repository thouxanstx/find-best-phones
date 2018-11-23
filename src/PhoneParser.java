import java.io.*;

public class PhoneParser {
	/*
	 * Parses a phone data string, in the following format:
	 * 
	 *     model screenSize batteryCapacity
	 * 
	 * The model name is encoded with underscores instead of spaces.
	 */
	public static Phone parse(String data) {
		String[] phone = data.split(" ");
		String model = phone[0];
		model = model.replaceAll("_", " ");
		double size = Double.parseDouble(phone[1]);
		int capacity = Integer.parseInt(phone[2]);
		return new Phone(model, size, capacity);
	}
	
	/*
	 * Returns a PhoneList by parsing a text file containing the phone data.
	 */
	public static PhoneList parseFile(String filename) throws IOException {
		PhoneList phList = new PhoneList();
		try {
			BufferedReader file = new BufferedReader(new FileReader(filename));
					while(true) {
						String line = file.readLine();
						if(line == null) {
							file.close();
							break;
						}
						phList.addPhone(parse(line));
					}
		}catch(FileNotFoundException ex) {
			System.out.println("File not found " + filename);
		}catch(IOException ex) {
			System.out.println("Error while reading the file " + filename);
		}
		
		return phList;
	}
}