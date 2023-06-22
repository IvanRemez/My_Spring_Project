package com.cydeo.service.impl;

import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    UserMapper userMapper;

    @InjectMocks    // creates UserServiceImpl Object and injects the above (mock dependencies)
    UserServiceImpl userService;
// ^^ must use Impl Class NOT the Interface - @InjectMocks doesn't work with Interfaces

    @Test
    void findByUserName_Test() {
    // calling the REAL method which we want to test
        userService.findByUserName("harold@manager.com");

    // checking if this MOCK method ran or not:
        verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com", false);

        verify(userRepository, times(1))
                .findByUserNameAndIsDeleted("harold@manager.com", false);
    // ^^ checks how many times this method is run in the original findByUserName() method
        // runs 1 time so .times(1) will pass the test ^^

        verify(userRepository, atLeastOnce())
                .findByUserNameAndIsDeleted("harold@manager.com", false);
        // making sure this ^^ mock method runs at least once
        verify(userRepository, atLeast(1))
                .findByUserNameAndIsDeleted("harold@manager.com", false);

        verify(userRepository, atMostOnce())
                .findByUserNameAndIsDeleted("harold@manager.com", false);
        verify(userRepository, atMost(1))
                .findByUserNameAndIsDeleted("harold@manager.com", false);

        InOrder inOrder = inOrder(userRepository, userMapper);

        inOrder.verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com", false);
        inOrder.verify(userMapper).convertToDto(null);
    // ^^ checks if these mock methods are running in this order


    }

}