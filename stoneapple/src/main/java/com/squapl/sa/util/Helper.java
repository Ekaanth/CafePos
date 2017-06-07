package com.squapl.sa.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.squapl.sa.config.SystemConfiguration;
@Component
public class Helper {
	private static final Logger logger = LoggerFactory.getLogger(Helper.class);
	
	@Autowired
	private  SystemConfiguration systemconfiguration;
	
	
	  public  List<String> getName(String name, List<String> list) {
		  //List<String> usersList = clientService.findActiveUsers();

		  String[] usersArr = new String[list.size()];
		  usersArr = list.toArray(usersArr);
		  
		    List<String> returnMatchName = new ArrayList<String>();
		    String [] data =usersArr;    
		    for (String string : data) {
		        if (string.toUpperCase().indexOf(name.toUpperCase())!= -1) {
		        returnMatchName.add(string);
		        }
		    }
		    
	    return returnMatchName;
	  }
	  
	  
		public boolean validatePhonenumber(String phonenumber) {
			String patternstring ="(?:\\s+|)((0|(?:(\\+|)91))(?:\\s|-)*(?:(?:\\d(?:\\s|-)*\\d{9})|(?:\\d{2}(?:\\s|-)*\\d{8})|(?:\\d{3}(?:\\s|-)*\\d{7}))|\\d{10})(?:\\s+|)";
			
			Pattern pattern = Pattern.compile(patternstring);				
					
			Matcher matcher = pattern.matcher(phonenumber); 
			 if (matcher.matches()) {
			      System.out.println("Phone Number Valid");
			      return true;
			 } else {
		    	  System.out.println("Phone Number must be in the form XXXX-XXX-XXX");
		    	  return false;
			 }
			
		}

}
