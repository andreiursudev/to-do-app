package org.todoapp.todo;

import org.springframework.stereotype.Service;
import org.todoapp.todo.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {

	private TodoRepository todoRepository;

	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public List<Todo> findByUsername(String username) {
		return todoRepository.findByUsername(username);
	}

	public Todo findById(int id) {
		return todoRepository.findById(id).get();
	}

	public void deleteById(int id) {
		todoRepository.deleteById(id);
	}

	public Todo updateTodo(int id, Todo todo) {
		todoRepository.updateTodo(todo.getDescription(),todo.getUsername(),todo.getTargetDate(), todo.isDone(), id);
		return findById(id);
	}

	public Todo save(Todo todo) {
		return todoRepository.save(todo);
	}
}