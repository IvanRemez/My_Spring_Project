package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Task;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    TaskRepository taskRepository;

    @Mock
    TaskMapper taskMapper;

    @InjectMocks
    TaskServiceImpl taskService;

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L})  // <- these 3 IDs will be tested 1 by 1
    void findById_Test(long id) {

    // GIVEN: (Preparation)
        Task task = new Task();
        // ^^ can create Object here and pass it in the methods instead of passing
        // any(Task.class)

        when(taskRepository.findById(id)).thenReturn(Optional.of(task)); // Optional<Task>
        when(taskMapper.convertToDto(task)).thenReturn(new TaskDTO());

    // WHEN: (Action - method being tested)
        taskService.findById(id);

    // THEN: (Assertion and Verification checks)
        verify(taskRepository).findById(id);
        verify(taskMapper).convertToDto(task);
    }

    @Test
    void findById_BDD_Test() {

// OLDER STRUCTURE:

    // GIVEN:
        Task task = new Task();

        given(taskRepository.findById(anyLong())).willReturn(Optional.of(task));
        given(taskMapper.convertToDto(task)).willReturn(new TaskDTO());

    // WHEN:
        taskService.findById(anyLong());

    // THEN:
        then(taskRepository).should().findById(anyLong());
        then(taskMapper).should(atLeastOnce()).convertToDto(task);

    }

}