package com.cts.sbwrd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.sbwrd.entity.Txn;

public interface TxnRepo extends JpaRepository<Txn,Long> {

}
