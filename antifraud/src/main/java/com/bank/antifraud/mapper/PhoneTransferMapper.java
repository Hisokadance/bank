package com.bank.antifraud.mapper;

import com.bank.antifraud.dto.PhoneTransferDTO;
import com.bank.antifraud.entity.PhoneTransfer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PhoneTransferMapper {
    PhoneTransfer toEntity(PhoneTransferDTO phoneTransfersDTO);

    PhoneTransferDTO toDto(PhoneTransfer phoneTransfer);

}