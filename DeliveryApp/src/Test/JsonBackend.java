package Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class ExampleSubObj {
	public int num;
	public String name;
	public ExampleSubObj(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}
}


class ExampleObj {
	public String name;
	public List<String> strs;
	public List<ExampleSubObj> objs;
	
	public ExampleObj() {
		name = new String("exx");
		
		strs = new ArrayList<String>();
		strs.add("asd");
		strs.add("lol");
		
		objs = new ArrayList<ExampleSubObj>();
		objs.add(new ExampleSubObj(10, "numele"));
	}
	
}

public class JsonBackend {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Works");
		
		ExampleObj test = new ExampleObj();

		ObjectMapper objectMapper = new ObjectMapper();
		
		String carAsString = objectMapper.writeValueAsString(test);
		
		System.out.println(carAsString);

	}

}
