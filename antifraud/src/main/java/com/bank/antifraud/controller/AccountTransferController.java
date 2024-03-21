package com.bank.antifraud.controller;

import com.bank.antifraud.dto.AccountTransferDTO;
import com.bank.antifraud.entity.AccountTransfer;
import com.bank.antifraud.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для управления операциями счета.
 * Обрабатывает запросы, связанные с переводами средств между счетами.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account-transfers")
public class AccountTransferController {

    private final AccountService accountService;

    /**
     * Метод для получения информации о переводе по идентификатору счета.
     *
     * @param id идентификатор перевода
     * @return ResponseEntity с объектом AccountTransferDTO и статусом OK
     */
    @Operation(description = "Получить информацию о переводе по идентификатору счета",summary = "получить информацию по id")
    @ApiResponse(responseCode = "200", description = "Успешное получение информации о переводе",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = AccountTransferDTO.class)))
    @GetMapping("/{id}")
    public ResponseEntity<AccountTransferDTO> getAccountController(
            @Parameter(description = "Идентификатор перевода", required = true)
            @PathVariable int id) {
        AccountTransferDTO accountTransferDTO = accountService.getAccountTransferById(id);
        return ResponseEntity.ok(accountTransferDTO);
    }

    /**
     * Метод для сохранения информации о переводе.
     *
     * @param accountTransfer объект AccountTransfer с информацией о переводе
     * @return ResponseEntity с объектом AccountTransferDTO и статусом OK
     */
    @Operation(description = "Сохранить информацию о переводе",summary = "сохранить Подозрительный перевод на аккаунте")
    @ApiResponse(responseCode = "200", description = "Успешное сохранение информации о переводе",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = AccountTransferDTO.class)))
    @PostMapping("/save")
    public ResponseEntity<AccountTransferDTO> saveAccountController(
            @Parameter(description = "Информация о переводе", required = true)
            @RequestBody AccountTransfer accountTransfer) {
        AccountTransferDTO savedAccountTransfers = accountService.saveOrUpdateAccountTransfer(accountTransfer);
        return ResponseEntity.ok(savedAccountTransfers);
    }

    /**
     * Метод для обновления информации о переводе.
     *
     * @param accountTransfer объект AccountTransfer с информацией о переводе
     * @return ResponseEntity с объектом AccountTransferDTO и статусом OK
     */
    @Operation(description = "Обновить информацию о переводе",summary = "обновить подозрительный перевод на аккаунте")
    @ApiResponse(responseCode = "200", description = "Успешное обновление информации о переводе",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = AccountTransferDTO.class)))
    @PutMapping("/edit")
    public ResponseEntity<AccountTransferDTO> updateAccountController(
            @Parameter(description = "Информация о переводе", required = true)
            @RequestBody AccountTransfer accountTransfer) {
        AccountTransferDTO savedAccountTransfers = accountService.saveOrUpdateAccountTransfer(accountTransfer);
        return ResponseEntity.ok(savedAccountTransfers);
    }

    /**
     * Метод для удаления информации о переводе по идентификатору.
     *
     * @param id идентификатор перевода
     * @return ResponseEntity с пустым телом и статусом OK
     */
    @Operation(description = "Удалить информацию о переводе по идентификатору",summary = "обновить подозрительный перевод на аккаунте")
    @ApiResponse(responseCode = "200", description = "Успешное удаление информации о переводе")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AccountTransferDTO> deleteAccountById(
            @Parameter(description = "Идентификатор перевода", required = true)
            @PathVariable Integer id) {
        accountService.deleteByIdAccountTransfer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


