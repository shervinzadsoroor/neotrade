package com.neotrade.shared.enumeration;

import lombok.Getter;

@Getter
public enum KYCLevel {

    SDD("Simplified Due Diligence", "low risk"),
    CDD("Customer Due Diligence", "normal"),
    EDD("Enhanced Due Diligence", "high risk");

    private final String title;
    private final String description;

    KYCLevel(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
