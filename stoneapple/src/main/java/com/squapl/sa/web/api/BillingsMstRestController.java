package com.squapl.sa.web.api;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.jdbc.ResultSetMetaData;
import com.squapl.sa.domain.Billingdtl;
import com.squapl.sa.domain.Billingmst;
import com.squapl.sa.service.BillingDltService;
import com.squapl.sa.service.BillingMstService;
import com.squapl.sa.util.constants.BillStatus;

@RestController
@RequestMapping("/api")
public class BillingsMstRestController {

	
@Autowired
 BillingMstService billingMstService;

@Autowired
BillingDltService billingDltService;


@RequestMapping(
        value = ("/list"),
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE )
@CrossOrigin(origins= "http://localhost:4200")
public ResponseEntity<Collection<Billingmst>> getBillings()
{
	Collection<Billingmst> billings = billingMstService.getAll();
    
       return new ResponseEntity<Collection<Billingmst>>(billings, HttpStatus.OK);
}

@RequestMapping(
        value = ("/findbystatus"),
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE )
@CrossOrigin(origins= "http://localhost:4200/saleshistory")
public ResponseEntity<Collection<Billingmst>> listbyStatus()
{
	Collection<Billingmst> billings = billingMstService.findByBillStatus(BillStatus.OPEN);
    
       return new ResponseEntity<Collection<Billingmst>>(billings, HttpStatus.OK);
}

@RequestMapping(
        value = ("/findbyid/{id}"),
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE )
@CrossOrigin(origins= "http://localhost:4200")
public ResponseEntity<List> findbyid(@PathVariable("id") String id)
{
	Integer i = Integer.parseInt(id);
	List itemDetailsById = billingDltService.findItemDetails(i);
    
       return new ResponseEntity<List>(itemDetailsById, HttpStatus.OK);
}

@RequestMapping(
        value = ("/delete/{orderid}/{itemid}"),
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE )
@CrossOrigin(origins= "http://localhost:4200")
public ResponseEntity<List> deletebyItemId(@PathVariable("orderid") String orderid,@PathVariable("itemid") String itemid)
{
	Integer oid = Integer.parseInt(orderid);
	Integer iid = Integer.parseInt(itemid);
	List itemDetailsById = billingDltService.deleteItembyId(oid,iid);
    
       return new ResponseEntity<List>(itemDetailsById, HttpStatus.OK);
}




@RequestMapping(
        value = ("/listitems"),
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE )
@CrossOrigin(origins= "http://localhost:4200")
public ResponseEntity servelist()
{
	List billings = billingDltService.serveitems();
	
   System.out.println(billings);
   
   Iterator it = billings.iterator();
   while(it.hasNext()){
	   List l = billingDltService.findByOrderId(it.next());
	   System.out.println(l);
   }
   
//    for (int i = 0; i < billings.size(); i++) {
//    	
//    	List l = billingDltService.findByOrderId(billings[i]);
//    		System.out.println(l);
//	}
//    
	return new ResponseEntity(billings, HttpStatus.OK);

}

@RequestMapping(
        value = ("/addbill/{product}"),
        method = RequestMethod.POST,
        consumes=MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE )
@CrossOrigin(origins= "http://localhost:4200/billing")
public ResponseEntity<List> addbill(@RequestParam("product") String body)
{
System.out.println(body);
return null;

}
}