package com.example.TaskGenerator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
@RestController
@CrossOrigin
@RequestMapping(("/api/tasks"))
public class taskcontroller {
   @Autowired
   private taskrepository taskrepo;

    @GetMapping("/hello")
    public String helloworld() {
        return "hello world";
    }
    @PostMapping
    public Task createTask(@RequestBody Task t) {
        //System.out.println(t.getDescription() + " - " + t.isStatus());
         taskrepo.save(t);
         return t; 
    }
    @GetMapping
    public List<Task> getallTasks()
    {
        return taskrepo.findAll();
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable("id") long id, @RequestBody Task task) {
    task.setId(id);
    return taskrepo.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") long id) {
    taskrepo.deleteById(id);
    }
}
