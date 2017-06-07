package com.squapl.sa.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.squapl.sa.domain.User;
import com.squapl.sa.domain.security.UserRole;
import com.squapl.sa.jparepository.RoleDao;
import com.squapl.sa.jparepository.UserDao;
//import com.squapl.sa.service.AccountService;
import com.squapl.sa.service.UserService;
import com.squapl.sa.util.constants.UserStatus;

@Service
@Transactional
public class UserRepositoryImpl implements UserService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserRepositoryImpl.class);
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
//    @Autowired
//    private AccountService accountService;
	
	public void save(User user) {
        userDao.save(user);
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
    
    
    public User createUser(User user, Set<UserRole> userRoles) {
        User localUser = userDao.findByUsername(user.getUsername());

        if (localUser != null) {
            LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
        } else {
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);

            for (UserRole ur : userRoles) {
                roleDao.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);

//            user.setPrimaryAccount(accountService.createPrimaryAccount());
//            user.setSavingsAccount(accountService.createSavingsAccount());

            localUser = userDao.save(user);
        }

        return localUser;
    }
    
    public boolean checkUserExists(String username, String email){
        if (checkUsernameExists(username) || checkEmailExists(email)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUsernameExists(String username) {
        if (null != findByUsername(username)) {
            return true;
        }

        return false;
    }
    
    public boolean checkEmailExists(String email) {
        if (null != findByEmail(email)) {
            return true;
        }

        return false;
    }

    public User saveUser (User user) {
        return userDao.save(user);
    }
    
    public List<User> findUserList() {
        return userDao.findAll();
    }

    public void enableUser (String username) {
        User user = findByUsername(username);
        user.setEnabled(true);
        userDao.save(user);
    }

    public void disableUser (String username) {
        User user = findByUsername(username);
        user.setEnabled(false);
        System.out.println(user.isEnabled());
        userDao.save(user);
        System.out.println(username + " is disabled.");
    }
    

    
    public void deleteUserById(Long userId) {
    	userDao.deleteByUserId(userId);
    }

	@Override
	public User findUserById(Long userId) {
		
		return userDao.findByUserId(userId);
	}

	@Override
	public List<User> findByEnabledUser(UserStatus enable) {
		
		return userDao.findByEnabled(true);
	}

	@Override
	public List<User> findByDisabledUser(UserStatus disable) {
	
		return userDao.findByEnabled(false);
	}
	
	
	
    static StringBuilder dataCache;
    static String [] data;
//    static{
//    
//    dataCache = new StringBuilder();
//    dataCache.append("Aaron Hank,Abagnale Frank,Abbey Edward,Abel Reuben,Abelson Hal,"
//        + "Abourezk James,Abrams Creighton,Ace Jane,Ba Jin,Baba Meher,Baba Tupeni,"
//        + "Babbage Charles,Babbitt Milton,Bacevich Andrew,Bach Richard,Bachelard Gaston,"
//        + "Bachelot Roselyne,Bacon Francis,Baddiel David,Baden-Powell Sir Robert (B-P),"
//        + "Badiou, Alain,Badnarik, Michael,Cabell James Branch,Caesar Irving,Caesar Julius,"
//        + "Cage John,Cain Peter,Callaghan James,Calvin John,Cameron Julia,Cameron Kirk,"
//        + "Java Honk,Java Honk Test,Java Honk Test Successful,Java Honk Spring MVC,"
//        + "Java Honk autocomplete,Java Honk Spring MVC autocomplete List");
//    
//    data =dataCache.toString().split(",");
//    }
    
    public  List<String> getName(String name) {

    List<String> returnMatchName = new ArrayList<String>();
    
//    String[] stockArr = new String[stockList.size()];
//    stockArr = stockList.toArray(stockArr);
    
    String [] data =dataCache.toString().split(",");
    
    
    for (String string : data) {
        if (string.toUpperCase().indexOf(name.toUpperCase())!= -1) {
        returnMatchName.add(string);
        }
    }
    
    return returnMatchName;
    }

}
