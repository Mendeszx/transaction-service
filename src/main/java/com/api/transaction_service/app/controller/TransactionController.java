package com.api.transaction_service.app.controller;

import com.api.transaction_service.app.dto.request.TransactionRequest;
import com.api.transaction_service.app.dto.response.TransactionResponse;
import com.api.transaction_service.app.service.TransactionService;
import com.api.transaction_service.enuns.TransactionTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
public class TransactionController implements CommandLineRunner {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public void run(String... args) throws Exception {

        TransactionResponse transactionResponse;

        TransactionRequest transactionTED = TransactionRequest.builder()
                .account("438999").amount(BigDecimal.TEN).currency("BRL").transactionTypeEnum(TransactionTypeEnum.TED)
                .build();

        transactionResponse = transactionService.transfer(transactionTED);

        log.info("Successfully in transaction TED");
        log.info("Transaction ID: {}", transactionResponse.getTransactionId());

        TransactionRequest transactionPIX = TransactionRequest.builder()
                .account("438999").amount(BigDecimal.TEN).currency("BRL").transactionTypeEnum(TransactionTypeEnum.PIX)
                .build();

        transactionResponse = transactionService.transfer(transactionPIX);

        log.info("Successfully in transaction PIX");
        log.info("Transaction ID: {}", transactionResponse.getTransactionId());

        TransactionRequest transactionDOC = TransactionRequest.builder()
                .account("438999").amount(BigDecimal.TEN).currency("BRL").transactionTypeEnum(TransactionTypeEnum.DOC)
                .build();

        transactionResponse = transactionService.transfer(transactionDOC);

        log.info("Successfully in transaction DOC");
        log.info("Transaction ID: {}", transactionResponse.getTransactionId());
    }
}
