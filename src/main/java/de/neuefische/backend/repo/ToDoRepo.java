package de.neuefische.backend.repo;

import de.neuefische.backend.model.ToDo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ToDoRepo {

    private Map<String, ToDo> toDos = new HashMap<>(
            Map.of("1", new ToDo("Friday-Exercise","OPEN" , "1")));

    public List<ToDo> getAllToDos() {
        return new ArrayList<ToDo>(toDos.values());
    }

    public ToDo getToDoById(String id) {
        return toDos.get(id);
    }

    public ToDo addNewToDo(ToDo toDo) {
        return toDos.put(toDo.getId(), toDo);
    }

    public Map<String, ToDo> getToDos() {
        return toDos;
    }
}
