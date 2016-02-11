package com.bank.dao;

import com.bank.model.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by xkt676 on 2/10/16.
 */

//Just define this interface, Spring JPA will provide implementation

public interface AccountRepository extends CrudRepository<Account, String> {

    Iterable<Account> findAll();

    void delete(String var1);
}
