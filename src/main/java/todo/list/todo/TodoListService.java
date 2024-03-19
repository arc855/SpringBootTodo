package todo.list.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoListService {
    @Autowired
    private TodoListRepo repo;

    public TodoList SaveTask(TodoList todolist){
        return repo.save(todolist);
    }

    public ResponseEntity<TodoList> updateTask(String todoId, TodoList todolist){
        return repo.findById(todoId).map(todoData -> {
            todoData.setTodoTitle(todolist.getTodoTitle());
            TodoList updatedTodo = repo.save(todoData);
            return ResponseEntity.ok().body(updatedTodo);
        }).orElse(ResponseEntity.notFound().build());
    }

    public void  deleteTask(String id){
        repo.deleteById(id);
    }

    public List<TodoList> getAllTodoList(){
        return repo.findAll();
    }

}
