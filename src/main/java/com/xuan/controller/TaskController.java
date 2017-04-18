package com.xuan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuan.bean.Task;
import com.xuan.respository.TaskRepository;

public class TaskController {
	@Autowired
	private TaskRepository taskRepository;

	@PostMapping(path = "/tasks")
	public @ResponseBody ResponseInfo addTask(@RequestBody Task task) {
		task.setStatus(0);
		taskRepository.save(task);
		return new ResponseInfo(200, "add success", taskRepository.findOne(task.getId()));
	}

	@PutMapping(path = "/tasks")
	public @ResponseBody ResponseInfo UpdateTask(@RequestBody Task task) {

		taskRepository.save(task);

		return new ResponseInfo(200, "update success", taskRepository.findOne(task.getId()));
	}

	@GetMapping(path = "/tasks")
	public @ResponseBody Task viewTask(@RequestBody Task task) {
		return taskRepository.findOne(task.getId());
	}
	
	@DeleteMapping(path = "/tasks")
	public @ResponseBody ResponseInfo deleteTask(@RequestBody Task task){
		taskRepository.delete(task);
		return new ResponseInfo(200, "delete success");
	}
}
