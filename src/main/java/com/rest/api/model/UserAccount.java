package com.rest.api.model;

import java.util.Objects;

public class UserAccount {
    private Integer id;
    private String name;
    private String role;

    public UserAccount(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                role.equals(that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role);
    }
}
