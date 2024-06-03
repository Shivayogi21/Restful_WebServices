package com.restapi.REST_API.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users=new ArrayList<>();
	private static int usercount=0;
	static {
		users.add(new User(++usercount,"Alex",LocalDate.now().minusYears(23)));
		users.add(new User(++usercount,"Shivayogi",LocalDate.now().minusYears(22)));
		users.add(new User(++usercount,"Vinnu",LocalDate.now().minusYears(21)));		
	}
	
	public List<User> findAllUsers(){
		return users;
	}
	
	public User findOne(int id) {
	    for (User user : users) {
	        if (user.getId() == id) {
	            return user;
	        }
	    }
	    return null; }
	
	
	public User createUser(User user) {
		user.setId(++usercount);
		users.add(user);
		return user;
	}
	
	public Optional<User> deleteOne(int id) {
	    for (User user : users) {
	        if (user.getId() == id) {
	            users.remove(user);
	            return Optional.of(user);
	        }
	    }
	    return Optional.empty();
	}
	
}
