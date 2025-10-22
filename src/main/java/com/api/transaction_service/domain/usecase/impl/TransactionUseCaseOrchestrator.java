package com.api.transaction_service.domain.usecase.impl;

import com.api.transaction_service.app.dto.request.TransactionRequest;
import com.api.transaction_service.app.dto.response.TransactionResponse;
import com.api.transaction_service.domain.usecase.TransactionUseCase;
import com.api.transaction_service.enuns.TransactionTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Primary
@Component
public class TransactionUseCaseOrchestrator implements TransactionUseCase {

    private static final Logger log = LoggerFactory.getLogger(TransactionUseCaseOrchestrator.class);

    private final Map<TransactionTypeEnum, TransactionUseCase> strategies;

    public TransactionUseCaseOrchestrator(List<TransactionUseCase> useCases) {
        this.strategies = useCases.stream().collect(Collectors.toMap(
                TransactionUseCase::transactionType,
                Function.identity()
        ));
    }

    @Override
    public TransactionResponse transfer(TransactionRequest transactionRequest) {

        log.info("Transfer request to : {}", transactionRequest.getTransactionTypeEnum());

        TransactionUseCase useCase = strategies.get(transactionRequest.getTransactionTypeEnum());

        if (useCase == null){
            log.error("Transaction type {} is not supported", transactionRequest.getTransactionTypeEnum());
            throw new IllegalArgumentException("Unsupported transfer type: " + transactionRequest.getTransactionTypeEnum());
        }

        return useCase.transfer(transactionRequest);
    }

    @Override
    public TransactionTypeEnum transactionType() {
        return null;
    }
}
