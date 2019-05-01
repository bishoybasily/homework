package com.gmail.bishoybasily.issr.proj.model.service;

import com.gmail.bishoybasily.issr.proj.model.entity.User;
import com.gmail.bishoybasily.issr.proj.model.repository.RepositoryUsers;

import javax.inject.Inject;
import java.util.List;

public class ServiceUsers {

    private RepositoryUsers repositoryUsers;

    @Inject
    public ServiceUsers(RepositoryUsers repositoryUsers) {
        this.repositoryUsers = repositoryUsers;
    }

    public User getOne(Long id) throws Exception {
        try {
            return repositoryUsers.getOne(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAll() {
        try {
            return repositoryUsers.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
