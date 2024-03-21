package com.bank.antifraud.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@NotBlank
@Data
public class PhoneTransferDTO {
    private int id;
    private int phoneTransferId;
    private boolean isBlocked;
    private boolean isSuspicious;
    private String blockedReason;
    private String suspiciousReason;
}
