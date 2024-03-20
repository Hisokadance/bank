package com.bank.antifraud.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "suspicious_phone_transfers")
public class PhoneTransfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "phone_transfer_id" , nullable = false, unique = true)
    private int phoneTransferId;

    @Column(name = "is_blocked")
    private boolean isBlocked;

    @Column(name = "is_suspicious")
    private boolean isSuspicious;

    @Column(name = "blocked_reason")
    private String blockedReason;

    @Column(name = "suspicious_reason")
    private String suspiciousReason;
}