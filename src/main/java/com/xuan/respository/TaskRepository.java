package com.xuan.respository;

import org.springframework.data.repository.CrudRepository;

import com.xuan.bean.Task;
public interface TaskRepository extends CrudRepository<Task, Long> {

}
