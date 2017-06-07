package com.squapl.sa.web.api;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.squapl.sa.domain.Items;
import com.squapl.sa.domain.Vendor;
import com.squapl.sa.service.VendorService;
import com.squapl.sa.util.Helper;
import com.squapl.sa.util.constants.Active;

@Controller
public class VendorController {
	
	@Autowired
	VendorService vendorService;
	
	@Autowired
	Helper helper;
	
	@RequestMapping(value = "/vendor", method = RequestMethod.GET)
    public String vendor(Model model, Principal principal) {
		
        Vendor vendor = new Vendor();
        model.addAttribute("vendor", vendor);
        return "vendor/vendor";
     }
	
	@RequestMapping(value = "/vendor/save", method = RequestMethod.POST)
	public String vendorSave(Model model,@Valid @ModelAttribute("vendor") Vendor vendor,@RequestParam("contactno1") String contactno1, BindingResult bindingResult,
			 @RequestParam("mode") String mode, @RequestParam("contactno2") String contactno2,Principal principal){
		
		if (bindingResult.hasErrors()) {
			
 			 return  "vendor/vendor";
			}
		
		Boolean Contact1=helper.validatePhonenumber(contactno1);
		Boolean Contact2=helper.validatePhonenumber(contactno2);
			
		if(Contact1==false)
		{ 
		model.addAttribute("contactno1", true);
		}
		else if (Contact2!=null && Contact2==false && contactno2!="" )
		{
			model.addAttribute("contactno2", true);
		}

		else{
			vendor.setIsactive(Active.Y);
			vendorService.saveVendor(vendor);
			
			if(mode!= null && mode.equalsIgnoreCase("add")) {
				model.addAttribute("q", "add");
				model.addAttribute("key", vendor.getVendorname());
				model.addAttribute("id", vendor.getId());
				model.addAttribute("vendor", new Vendor());

				return "vendor/vendor";
			} else 
			{
				List<Vendor> vendorList = vendorService.findByVendorList(principal);
				model.addAttribute("vendorList", vendorList);
				model.addAttribute("q", "edit");
				model.addAttribute("key", vendor.getVendorname());
				return "vendor/vendorshow";	        	
			}
		}
			return "vendor/vendor";
		
	
		}
	
	
	@RequestMapping(value = "/vendor/show", method = RequestMethod.GET)
	public String vendorShow(Model model, Items items,Principal principal){
		List<Vendor> vendorList=vendorService.findByActiveList(Active.Y);
		model.addAttribute("vendorList", vendorList);
		return "vendor/vendorshow";
	}
	
	
	 @RequestMapping(value = "/vendor/edit", method = RequestMethod.GET)
	    public String vendorEdit(@RequestParam(value = "id") String vendorId, Model model, Principal principal){

	        Vendor vendor = vendorService.findVendorById(Long.parseLong(vendorId));
	        model.addAttribute("vendor", vendor);
	       
	        return "vendor/vendoredit";
	    }
	 
	 @RequestMapping(value = "/vendor/delete", method = RequestMethod.GET)
	    public String vendorDelete(@RequestParam(value = "id") String vendorId, Model model, Principal principal){
		 	
		    Vendor vendor = vendorService.findVendorById(Long.parseLong(vendorId));
	        //vendorService.deleteVendorById(Long.parseLong(vendorId));
	        vendor.setIsactive(Active.N);
      
	        List<Vendor> vendorList=vendorService.findByActiveList(Active.Y);
			model.addAttribute("vendorList", vendorList);
			
			model.addAttribute("q", "del");
			model.addAttribute("key",vendor.getVendorname());
	        return "vendor/vendorshow";
	    }

}
