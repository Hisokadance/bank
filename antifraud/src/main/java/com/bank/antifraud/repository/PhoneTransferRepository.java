package com.bank.antifraud.repository;

import com.bank.antifraud.entity.PhoneTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneTransferRepository extends JpaRepository<PhoneTransfer, Integer> {
}
