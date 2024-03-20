package com.bank.antifraud.mapper;

import com.bank.antifraud.dto.AccountTransferDTO;
import com.bank.antifraud.entity.AccountTransfer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccountTransferMapper {
    AccountTransfer toEntity(AccountTransferDTO accountTransferDTO);

    AccountTransferDTO toDto(AccountTransfer accountTransfer);


}