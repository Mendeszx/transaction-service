package com.api.transaction_service.app.service.impl;

import com.api.transaction_service.app.dto.request.TransactionRequest;
import com.api.transaction_service.app.dto.response.TransactionResponse;
import com.api.transaction_service.app.service.TransactionService;
import com.api.transaction_service.domain.usecase.TransactionUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionUseCase transactionUseCase;

    public TransactionServiceImpl(TransactionUseCase transactionUseCase) {
        this.transactionUseCase = transactionUseCase;
    }

    @Override
    public TransactionResponse transfer(TransactionRequest transactionRequest) {

        log.info("Sending transaction to UseCase");

        return transactionUseCase.transfer(transactionRequest);
    }
}
