package com.lothuialon.clients.fraud;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class fraudDTO {

    private Integer userId;
    private boolean isFraud;
    private LocalDateTime createdAt;

}
