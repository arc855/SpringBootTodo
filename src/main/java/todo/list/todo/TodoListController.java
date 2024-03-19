package todo.list.todo;

import org.springframework.http.ResponseEntity;
import todo.list.todo.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todo.list.todo.TodoListService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class TodoListController {
    @Autowired
    private TodoListService todoListService;
    @GetMapping("/getAllTasks")
    public List<TodoList> getAllTask(){
        return todoListService.getAllTodoList();
    }

    @PostMapping("/saveTask")
    public TodoList saveTask(@RequestBody TodoList todoList){
        return todoListService.SaveTask(todoList);
    }
    @DeleteMapping("/deleteTask/{todoId}")
    public void deleteTask(@PathVariable("todoId") String todoId){
        todoListService.deleteTask(todoId);
    }
    @PutMapping(value="/updateTask/{todoId}")
    public ResponseEntity<TodoList> updateTask(@PathVariable("todoId") String todoId , @RequestBody TodoList todoList){
        return  todoListService.updateTask(todoId , todoList);
    }






}
