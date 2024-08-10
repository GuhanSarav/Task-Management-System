package com.aurum.struts.rest;

import java.util.Map;

import com.aurum.struts.model.Task;
import com.aurum.struts.repository.TaskRepository;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.aurum.struts.repository.UserRepository;
import com.opensymphony.xwork2.ModelDriven;

public class TaskController implements ModelDriven<Object> {

	public static TaskRepository taskRepository = new TaskRepository();

	public Task task = new Task();
	
	private String id;

	private Object tasks;
	private Object users;

	
	private UserRepository repository = new UserRepository();
	
	// GET	/api/users
	public HttpHeaders index() {
		System.out.println("index");
		tasks = taskRepository.listTask();
		//users = repository.findAll();
		System.out.println("GET \t /user");
		return new DefaultHttpHeaders(tasks.toString());
	}
	
	// GET	/api/users/1
	public HttpHeaders show() {
		tasks = taskRepository.getTask(Integer.parseInt(getId()));
		System.out.println("GET \t /user/{id}");
		return new DefaultHttpHeaders(tasks.toString());
	}
	
	// POST	/api/users
	public HttpHeaders create() {
		tasks = taskRepository.addTask(task);
		return new DefaultHttpHeaders(task.toString());
	}
	
	// PUT	/api/users
	public HttpHeaders update() {
		tasks = taskRepository.updateTask(Integer.parseInt(getId()),task);
		System.out.println("update");
		System.out.println("PUT \t /user");
		return new DefaultHttpHeaders(tasks.toString());
	}
	
	// DELETE	/api/users/1
	public HttpHeaders destroy() {
		tasks = taskRepository.removeTask(Integer.parseInt(getId()));
		System.out.println("DELETE \t /user/{id}");
		return new DefaultHttpHeaders("destroy");
	}
	
	// GET	/api/users/1/edit
	public HttpHeaders edit() {
		System.out.println("edit");
		System.out.println("GET \t /user/{id}");
		return new DefaultHttpHeaders("edit");
	}

	public UserRepository getRepository() {
		return repository;
	}

	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Task getUser() {
		return task;
	}

	public void setUser(Task task) {
		this.task = task;
	}

	public void setUsers(Map<String, Task> users) {
		this.users = users;
	}
	
	public Object getModel() {
		return tasks != null ? tasks : task;
	}

}
