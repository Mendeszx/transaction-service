package com.api.transaction_service.app.dto.request;

import com.api.transaction_service.enuns.TransactionTypeEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TransactionRequest {

    private BigDecimal amount;
    private String currency;
    private String account;
    private TransactionTypeEnum transactionTypeEnum;
}
