package com.lothuialon.fraud.service;

import com.lothuialon.clients.fraud.fraudDTO;

public interface fraudCheckHistoryService {
    fraudDTO userIsFraud(Integer userId);
}
