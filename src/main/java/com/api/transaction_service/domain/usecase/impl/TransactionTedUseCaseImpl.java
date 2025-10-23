package com.api.transaction_service.domain.usecase.impl;

import com.api.transaction_service.app.dto.request.TransactionRequest;
import com.api.transaction_service.app.dto.response.TransactionResponse;
import com.api.transaction_service.domain.orchestrator.TransactionOrchestrator;
import com.api.transaction_service.domain.usecase.TransactionUseCase;
import com.api.transaction_service.enuns.TransactionStatusEnum;
import com.api.transaction_service.enuns.TransactionTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TransactionTedUseCaseImpl implements TransactionOrchestrator {

    private static final Logger log = LoggerFactory.getLogger(TransactionTedUseCaseImpl.class);

    @Override
    public TransactionResponse transfer(TransactionRequest transactionRequest) {

        TransactionResponse transactionResponse = TransactionResponse.builder()
                .transactionId(UUID.randomUUID().toString())
                .transactionStatusEnum(TransactionStatusEnum.EXECUTED)
                .build();

        log.info("transaction id: {} with status {} of type {}", transactionResponse.getTransactionId(),
                transactionResponse.getTransactionStatusEnum(), transactionRequest.getTransactionTypeEnum());

        return transactionResponse;
    }

    @Override
    public TransactionTypeEnum transactionType() {
        return TransactionTypeEnum.TED;
    }
}
