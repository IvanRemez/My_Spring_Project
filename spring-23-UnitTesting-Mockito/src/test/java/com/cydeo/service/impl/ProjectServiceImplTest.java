package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;

    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void getByProjectCode_Test() {
// Gherkin Language:
    // GIVEN:

        // Stubbing ex.
        when(projectRepository.findByProjectCode(anyString())).thenReturn(new Project());
        // anyString() -> instead of passing real project code, when any type of String
        // is passed -> return us a new Project Entity

        when(projectMapper.convertToDto(any(Project.class))).thenReturn(new ProjectDTO());
        // ^^ when any Project Entity is passed, return ProjectDTO

    // WHEN:
        ProjectDTO projectDTO = projectService.getByProjectCode(anyString());
        // ^^ Real Method being tested

    // THEN:
        InOrder inOrder = inOrder(projectRepository, projectMapper);
        // check order of these 2 Mocks

        inOrder.verify(projectRepository).findByProjectCode(anyString());
        inOrder.verify(projectMapper).convertToDto(any(Project.class));
        // ^^ provided order

        assertNotNull(projectDTO);
    }

    @Test
    void getByProjectCode_ExceptionTest() {
    // WHEN:
        when(projectRepository.findByProjectCode(""))   // <- empty String passed as code
                .thenThrow(new NoSuchElementException("Project Not Found"));
        // ^^ Real Method being Tested

        Throwable throwable = assertThrows(NoSuchElementException.class, () -> projectService.getByProjectCode(""));
                                        // ^^ Expected Exception

        verify(projectRepository).findByProjectCode("");
        // ^^ verify the method is running

        verify(projectMapper, never()).convertToDto(any(Project.class));
        // ^^ verify the above method is NEVER run

        assertEquals("Project Not Found", throwable.getMessage());
        // make sure Throwable throws the message we predefined above

    }

}