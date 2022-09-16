package de.neuefische.backend.service;

import de.neuefische.backend.model.ToDo;
import de.neuefische.backend.repo.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class ToDoService {

    private ToDoRepo toDoRepo;
    @Autowired
    public ToDoService(ToDoRepo toDoRepo) {
        this.toDoRepo = toDoRepo;
    }

    public List<ToDo> getAllToDos(){
        return toDoRepo.getAllToDos();
    }

    public ToDo postNewToDo(ToDo toDo) {
        Map<String, ToDo> presentToDos = toDoRepo.getToDos();
        int newId1 = presentToDos.size()+1;
        String newId = String.valueOf(newId1);
        toDo.setId(newId);
        return toDoRepo.addNewToDo(toDo);
    }

    public ToDo getToDoById(String id) {
        ToDo foundToDo = toDoRepo.getToDoById(id);
        if(foundToDo == null){
            throw new NoSuchElementException("No ToDo was found with id: " + id);
        }
        return toDoRepo.getToDoById(id);
    }
}
