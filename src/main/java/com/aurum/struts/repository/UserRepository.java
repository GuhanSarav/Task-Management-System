package com.aurum.struts.repository;

import java.util.HashMap;
import java.util.Map;

import com.aurum.struts.model.Task;

public class UserRepository {
	
	private static Map<String, Task> users = new HashMap<String, Task>();
	
	public UserRepository() {
		users.put("1", new Task("1", "Siva", "9842012345","de"));
		users.put("2" , new Task("2", "Ilango", "7842012345","de"));
		users.put("3", new Task("3", "Aurum", "8015726858","de"));
	}
	
	public Map<String, Task> save(Task task) {
		String id = String.valueOf(users.size() + 1);
		users.put(id, task);
		return users;
	}
	
	public Map<String, Task> findAll() {
		return users;
	}
	
	public Task get(String id) {
		return users.get(id);
	}
	
	public Map<String, Task> remove(String id) {
		users.remove(id);
		return users;
	}

}
