package com.bank.antifraud.repository;

import com.bank.antifraud.entity.AccountTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransferRepository extends JpaRepository<AccountTransfer, Integer> {

}
