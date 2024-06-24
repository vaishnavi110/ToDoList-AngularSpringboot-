package com.todo.taskgenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class taskcontroller {
   @Autowired
   private taskrepository taskrepo;

    @GetMapping("/hello")
    public String helloworld() {
        return "hello world";
    }

    @PostMapping("/api/tasks")
    public Task createTask(@RequestBody Task t) {
        //System.out.println(t.getDescription() + " - " + t.isStatus());
         taskrepo.save(t);
         return t; 
    }
}
