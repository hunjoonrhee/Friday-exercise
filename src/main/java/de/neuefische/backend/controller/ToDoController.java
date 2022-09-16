package de.neuefische.backend.controller;

import de.neuefische.backend.model.ToDo;
import de.neuefische.backend.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {

    private ToDoService service;

    @Autowired
    public ToDoController(ToDoService service) {
        this.service = service;
    }

    public List<ToDo> getAllToDos(){
        return service.getAllToDos();
    }
}
