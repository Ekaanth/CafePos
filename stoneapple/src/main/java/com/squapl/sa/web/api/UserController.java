package com.squapl.sa.web.api;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.squapl.sa.domain.User;
import com.squapl.sa.service.UserService;
import com.squapl.sa.util.Helper;
import com.squapl.sa.util.constants.UserStatus;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
	@Autowired
	private Helper helper;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Principal principal, Model model) {
        User user = userService.findByUsername(principal.getName());

        model.addAttribute("user", user);

        return "profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String profilePost(@Valid @ModelAttribute("user") User newUser, BindingResult bindingResult, 
    		Model model, Principal principal) {

    	if (bindingResult.hasErrors()) {
			 return "profile";
	        }
    	
        User user = userService.findByUsername(newUser.getUsername());
        user.setUsername(newUser.getUsername());
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        user.setPhone(newUser.getPhone());

        model.addAttribute("user", user);

        userService.saveUser(user);
		
	     
   
		 return "profile";
    }
    
    @RequestMapping(value = "/profile/list", method = RequestMethod.GET)
    public String userList(Model model, Principal principal) {
	

		List<User> userlist = userService.findUserList();
	
        model.addAttribute("userlist", userlist);

        return "profileuserlist";
    }
    
	@RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
	public String userEdit(@RequestParam(value = "id") String userId, Model model, Principal principal,HttpServletRequest request){

		User user= userService.findUserById(Long.parseLong(userId));

		model.addAttribute("user", user);

		return "profile";
	}
    
    @RequestMapping(value = "/profile/deactivate", method = RequestMethod.GET)
    public String profiledeactivate(Principal principal, Model model,@ModelAttribute("user") User newUser,@RequestParam(value = "id") String userId) {
    
    	User user= userService.findUserById(Long.parseLong(userId));
  
    	user.setEnabled(false);
    	System.out.println("deactivated" +user);
    	userService.saveUser(user);
        model.addAttribute("deactivate", true);
        
        model.addAttribute("user", user);
             
        return "profile";
        
    }
    @RequestMapping(value = "/profile/active", method = RequestMethod.GET) 
    public String profileActiveUsers(Principal principal, Model model,@ModelAttribute("user") User newUser){
    	
    	List<User> userEnable=userService.findByEnabledUser(UserStatus.Enable);
    	
    	List<User> userDisable =userService.findByDisabledUser(UserStatus.Disable);
    	model.addAttribute("userEnable", userEnable);
    	model.addAttribute("userDisable", userDisable);
    	return "listuser";
    	
   	
    	
    }
   
}