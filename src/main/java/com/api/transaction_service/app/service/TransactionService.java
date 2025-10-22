package com.api.transaction_service.app.service;

import com.api.transaction_service.app.dto.request.TransactionRequest;
import com.api.transaction_service.app.dto.response.TransactionResponse;

public interface TransactionService {

    TransactionResponse transfer(TransactionRequest transactionRequest);
}
