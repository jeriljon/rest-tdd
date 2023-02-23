package com.rest.api.service;

import com.rest.api.model.UserAccount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserAccountServiceTest {

    @InjectMocks
    private UserAccountService userAccountService;

    @Test
    void testGetAllUserAccounts() {
        UserAccount user1 = new UserAccount(1, "Jake", "Admin");
        UserAccount user2 = new UserAccount(2, "Bob", "User");
        UserAccount user3 = new UserAccount(3, "Tom", "User");
        List<UserAccount> expectedUserAccounts = Arrays.asList(user1, user2, user3);
        List<UserAccount> actualUserAccounts = userAccountService.getAllUserAccounts();

        assertEquals(expectedUserAccounts, actualUserAccounts);
    }

    @Test
    void testGetUserAccount() {
        UserAccount expectedUser = new UserAccount(1, "Jake", "Admin");
        UserAccount actualUser = userAccountService.getUserAccount("1");

        assertEquals(expectedUser, actualUser);
    }
}
