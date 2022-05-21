package Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var db = new DataBackendTest();
		
		Customer c1 = new Customer("Madalin", "0721", "asd@gmail.com");
		Customer c2 = new Customer("Ion", "123", "dec@gmail.com");
		
		db.addNewItem(new Item(c1, c2, "Timisoara", "Bucuresti", "Fragil", 12));
		db.addNewItem(new Item(c1, c2, "Deva", "Cluj", "Normal", 1));
	}

}

class DataBackendTest {
	HashMap<Integer, Item> inventory;
	
	File storage;
	ObjectMapper objectMapper;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public DataBackendTest() {
		objectMapper = new ObjectMapper();
		this.initInventory();
	}
	
	public int addNewItem(Item item) {
		int awb = randInt(1000, 9999);
		
		inventory.put(awb, item);
		updateDB();
		
		return awb;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void updateDB() {
		try {
			objectMapper.writerWithDefaultPrettyPrinter().writeValue(storage, inventory);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private int randInt(int min, int max) {
	    Random rand = new Random();
	    
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	private void initStorage() {
		storage = new File("db.json");
		try {
			storage.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initInventory() {
		this.initStorage();
		try {
			inventory = objectMapper.readValue(storage, new TypeReference<HashMap<Integer,Item>>(){});
		} catch (MismatchedInputException e) {
			//e.printStackTrace();
			System.out.println("File is empty");
			inventory = new HashMap<Integer, Item>();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
