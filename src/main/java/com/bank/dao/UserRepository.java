package com.bank.dao;

import com.bank.model.Account;
import com.bank.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by XKT676 on 5/8/2016.
 */
public interface UserRepository extends CrudRepository<User, String > {

    Iterable<User> findAll();
}
