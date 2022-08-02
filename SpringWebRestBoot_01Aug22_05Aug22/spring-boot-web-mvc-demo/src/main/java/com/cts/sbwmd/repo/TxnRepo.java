package com.cts.sbwmd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.sbwmd.entity.Txn;

public interface TxnRepo extends JpaRepository<Txn,Long> {

}
