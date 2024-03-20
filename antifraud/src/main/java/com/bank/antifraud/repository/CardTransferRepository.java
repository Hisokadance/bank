package com.bank.antifraud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bank.antifraud.entity.CardTransfer;

@Repository
public interface CardTransferRepository extends JpaRepository<CardTransfer, Integer> {
}
