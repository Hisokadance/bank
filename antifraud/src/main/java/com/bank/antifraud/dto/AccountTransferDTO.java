package com.bank.antifraud.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@NotBlank
@Data
public class AccountTransferDTO {
    private int id;
    private int accountTransferId;
    private boolean isBlocked;
    private boolean isSuspicious;
    private String blockedReason;
    private String suspiciousReason;
}
