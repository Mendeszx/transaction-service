package com.api.transaction_service.domain.usecase;

import com.api.transaction_service.app.dto.request.TransactionRequest;
import com.api.transaction_service.app.dto.response.TransactionResponse;
import com.api.transaction_service.enuns.TransactionTypeEnum;

public interface TransactionUseCase {

    TransactionResponse transfer(TransactionRequest transactionRequest);
}
