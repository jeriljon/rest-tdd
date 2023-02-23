package com.rest.api.service;

import com.rest.api.model.UserAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAccountService {

    public UserAccount getUserAccount(String id) {
        return getUserAccountById(id);
    }

    public List<UserAccount> getAllUserAccounts() {
        return generateSampleUserAccounts();
    }

    private List<UserAccount> generateSampleUserAccounts() {
        List<UserAccount> userAccountList = new ArrayList<>();
        userAccountList.add(new UserAccount(1, "Jake", "Admin"));
        userAccountList.add(new UserAccount(2, "Bob", "User"));
        userAccountList.add(new UserAccount(3, "Tom", "User"));
        return userAccountList;
    }

    private UserAccount getUserAccountById(String id) {
        Integer idInt = Integer.parseInt(id);
        return generateSampleUserAccounts().stream().filter(userAccount -> userAccount.getId().equals(idInt)).findFirst().orElse(null);
    }
}
