package com.rest.api.controller;

import com.rest.api.model.UserAccount;
import com.rest.api.service.UserAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @GetMapping(value = "/userAccounts")
    public ResponseEntity<List<UserAccount>> getAllUserAccounts() {
        System.out.println("In UserAccountController.getUserAccount()");
        List<UserAccount> userAccounts = userAccountService.getAllUserAccounts();
        System.out.println("In UserAccountController, userAccount: " + userAccounts);
        return ResponseEntity.status(HttpStatus.OK).body(userAccounts);
    }

    @GetMapping(value = "/userAccount/{id}")
    public ResponseEntity<UserAccount> getUserAccount(@PathVariable("id") String id) {
        System.out.println("In UserAccountController.getUserAccount()");
        UserAccount userAccount = userAccountService.getUserAccount(id);
        System.out.println("In UserAccountController, userAccount: " + userAccount);
        return ResponseEntity.status(HttpStatus.OK).body(userAccount);
    }
}
