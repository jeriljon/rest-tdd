package com.rest.api.controller;

import com.rest.api.model.UserAccount;
import com.rest.api.service.UserAccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserAccountControllerTest {

    @Mock
    private UserAccountService userAccountService;

    @InjectMocks
    private UserAccountController userAccountController;

    @Test
    void testGetAllUserAccounts() {
        UserAccount user1 = new UserAccount(1, "John Doe", "john.doe@example.com");
        UserAccount user2 = new UserAccount(2, "Jane Doe", "jane.doe@example.com");
        List<UserAccount> userAccounts = Arrays.asList(user1, user2);
        when(userAccountService.getAllUserAccounts()).thenReturn(userAccounts);

        ResponseEntity<List<UserAccount>> response = userAccountController.getAllUserAccounts();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userAccounts, response.getBody());
    }

    @Test
    void testGetUserAccount() {
        UserAccount user = new UserAccount(1, "John Doe", "john.doe@example.com");
        when(userAccountService.getUserAccount("1")).thenReturn(user);

        ResponseEntity<UserAccount> response = userAccountController.getUserAccount("1");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }
}
