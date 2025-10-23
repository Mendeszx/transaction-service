package com.api.transaction_service.domain.orchestrator;

import com.api.transaction_service.domain.usecase.TransactionUseCase;
import com.api.transaction_service.enuns.TransactionTypeEnum;

public interface TransactionOrchestrator extends TransactionUseCase {

    TransactionTypeEnum transactionType();
}
