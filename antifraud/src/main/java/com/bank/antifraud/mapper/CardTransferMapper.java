package com.bank.antifraud.mapper;

import com.bank.antifraud.dto.CardTransferDTO;
import com.bank.antifraud.entity.CardTransfer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CardTransferMapper {
    CardTransfer toEntity(CardTransferDTO cardTransfersDTO);

    CardTransferDTO toDto(CardTransfer cardTransfer);

}