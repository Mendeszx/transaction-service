package com.api.transaction_service.app.dto.response;

import com.api.transaction_service.enuns.TransactionStatusEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionResponse {

    private String transactionId;
    private TransactionStatusEnum transactionStatusEnum;
}
