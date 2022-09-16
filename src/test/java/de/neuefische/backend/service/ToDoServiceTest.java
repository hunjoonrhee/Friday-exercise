package de.neuefische.backend.service;

import de.neuefische.backend.model.ToDo;
import de.neuefische.backend.repo.ToDoRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ToDoServiceTest {

    ToDoRepo toDoRepo = mock(ToDoRepo.class);

    ToDoService toDoService = new ToDoService(toDoRepo);

    @Test
    void getAllToDos_Returns_AllToDos(){
        // GIVEN
        List<ToDo> toDos = new ArrayList<>();
        toDos.add(new ToDo("Friday-Exercise","OPEN" , "1"));
        when(toDoRepo.getAllToDos()).thenReturn(toDos);
        // WHEN

        List<ToDo> actual = toDoService.getAllToDos();
        // THEN

        assertEquals(toDos, actual);

    }

    @Test
    void getToDoById_Returns_ToDoForGivenId(){
        // GIVEN
        ToDo toDo = new ToDo("Friday-Exercise","OPEN" , "1");
        when(toDoRepo.getToDoById("1")).thenReturn(toDo);
        // WHEN

        ToDo actual = toDoService.getToDoById("1");
        // THEN

        assertEquals(toDo, actual);

    }

    @Test
    void postNewToDo_Returns_AddedToDo(){
        // GIVEN
        ToDo toDo = new ToDo("Friday-Exercise","OPEN" , "1");
        when(toDoRepo.addNewToDo(toDo)).thenReturn(toDo);
        // WHEN

        ToDo actual = toDoService.postNewToDo(toDo);
        // THEN

        assertEquals(toDo, actual);

    }

}