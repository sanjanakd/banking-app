package com.bank.dao;
import com.bank.model.Transaction;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by XKT676 on 4/18/2016.
 */
public interface TransactionRepository extends CrudRepository<Transaction, String> {
  Iterable<Transaction> findAll();
}
