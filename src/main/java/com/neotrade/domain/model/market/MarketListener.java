package com.neotrade.domain.model.market;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class MarketListener {

    @PrePersist
    @PreUpdate
    public void setSymbol(Market market) {
        if (market.getBaseAsset() != null && market.getQuoteAsset() != null) {
            market.setSymbol(market.getBaseAsset().getSymbol()
                    + "/"
                    + market.getQuoteAsset().getSymbol());
        }
    }
}
