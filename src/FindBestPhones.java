import java.io.*;
import java.util.*;

public class FindBestPhones {
	public static String PHONES_FILE = "phone-data.txt";
	public static String PHONES_FILE2 = "phone-data-short.txt";
	
	public static void main(String[] args) throws IOException {
			
		try {
			PhoneList phList = PhoneParser.parseFile(PHONES_FILE2);
			Collection<Phone> bestPh = phList.getBestPhones();
			for(Phone phone : bestPh) {
				System.out.println(phone.getModel());
			}
		}catch(IOException ex) {
			System.out.println("Error while reading the file " + PHONES_FILE2);
			
			
		}
		try {
			PhoneList phList = PhoneParser.parseFile(PHONES_FILE);
			Collection<Phone> bestPh = phList.getBestPhones();
			for(Phone phone : bestPh) {
				System.out.println(phone.getModel());
			}
		}catch(IOException ex) {
			System.out.println("Error while reading the file " + PHONES_FILE);
			
			
		}
	}
	}

