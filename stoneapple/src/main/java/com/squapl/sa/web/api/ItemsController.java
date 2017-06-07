package com.squapl.sa.web.api;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
import com.squapl.sa.service.ItemsService;
import com.squapl.sa.service.VendorService;
import com.squapl.sa.util.Helper;
import com.squapl.sa.util.constants.Active;
import com.squapl.sa.util.constants.ItemsCat;
import com.squapl.sa.util.constants.ItemsUom;

@Controller
public class ItemsController {
	
	@Autowired
	ItemsService itemsService;
	
	@Autowired
	Helper helper;

	@Autowired
	VendorService vendorService;
	
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
	
	@RequestMapping(value = "/items", method = RequestMethod.GET)
    public String items(Model model, Principal principal) {
		
        Items items = new Items();
        model.addAttribute("items", items);
        
        List<ItemsUom> ItemsUomlist = Arrays.asList(ItemsUom.values());
	    model.addAttribute("ItemsUomlist", ItemsUomlist);
	    
	    List<ItemsCat> ItemsCatlist = Arrays.asList(ItemsCat.values());
	    model.addAttribute("ItemsCatlist", ItemsCatlist);
	    
	  	    
        return "items/items";
     }
	
		@RequestMapping(value = "/items/save", method = RequestMethod.POST)
		public String itemsSave( @Valid @ModelAttribute("items") Items items,Model model, BindingResult bindingResult, @RequestParam("mode") String mode,Principal principal,
				@ModelAttribute("effDate") String effdate) throws ParseException{
			
			if (bindingResult.hasErrors()) {
   			 return "items/items";
			}
			
			Date effdt = dateformat.parse( effdate );
			items.setEffdate(effdt);
			items.setIsvalid(Active.Y);
			   	      
			//Vendor vendor=vendorService.findByVendorName(principal.getName());
			//items.setVendor(vendor);
			
			itemsService.saveItems(items);
			
			
			if(mode!= null && mode.equalsIgnoreCase("add")) {
				model.addAttribute("q", "add");
				model.addAttribute("key", items.getItemname());
				model.addAttribute("effDate", "");
				model.addAttribute("id", items.getId());
				model.addAttribute("items", new Items());
				
				 return "items/items";
			} 
			else 
			{
				List<Items> itemsList = itemsService.findItemsList(principal);
				model.addAttribute("itemsList", itemsList);
				model.addAttribute("q", "edit");
				model.addAttribute("key", items.getItemname());
				return "items/itemsshow";	        	
			}

			
		}
	
		@RequestMapping(value = "/items/show", method = RequestMethod.GET)
		public String itemsShow(Model model, Items items,Principal principal){
			List<Items> itemsList=itemsService.findByIsValid(Active.Y);
		    model.addAttribute("itemsList", itemsList);
			
			return "items/itemsshow";
		}
	
	  @RequestMapping(value = "/items/edit", method = RequestMethod.GET)
	    public String itemsEdit(@RequestParam(value = "id") String itemsId, Model model, Principal principal){

	        Items items = itemsService.findItemsById(Long.parseLong(itemsId));
	        model.addAttribute("items", items);
	        
	        List<Items> itemsList=itemsService.findItemsList(principal);
			model.addAttribute("itemsList", itemsList);
			
			List<ItemsUom> ItemsUomlist = Arrays.asList(ItemsUom.values());
			model.addAttribute("ItemsUomlist", ItemsUomlist);

			List<Active> Validlist = Arrays.asList(Active.values());
			model.addAttribute("Validlist", Validlist);
			    
			List<ItemsCat> ItemsCatlist = Arrays.asList(ItemsCat.values());
			model.addAttribute("ItemsCatlist", ItemsCatlist);
			
			model.addAttribute("effDate", dateformat.format(items.getEffdate()));
	        
	        model.addAttribute("selecteduom", items.getUom());
	        model.addAttribute("selectedvalidlist", items.getIsvalid());
	        model.addAttribute("selecteditemcat", items.getItemcat());
	       
	        return "items/itemsedit";
	    }
	  
	  @RequestMapping(value = "/items/delete", method = RequestMethod.GET)
	    public String itemDelete(@RequestParam(value = "id") String itemsId, Model model, Principal principal){
		  	
		    Items items = itemsService.findItemsById(Long.parseLong(itemsId));
	       // itemsService.deleteItemsById(Long.parseLong(itemsId));
		    items.setIsvalid(Active.N);
		    items.setDeldate(new Date());
		    List<Items> itemsList=itemsService.findByIsValid(Active.Y);
		    model.addAttribute("itemsList", itemsList);
	        model.addAttribute("q", "del");
	     
			model.addAttribute("key",items.getItemname());
	     	       
	        return "items/itemsshow";
	    }

}
