package com.neotrade.domain.model.market;

import com.neotrade.domain.model.Asset;
import com.neotrade.domain.model.BaseEntity;
import com.neotrade.domain.model.Order;
import com.neotrade.domain.model.Trade;
import com.neotrade.shared.enumeration.MarketStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@EntityListeners(MarketListener.class)
@Table(name = "MARKET", schema = "NEOTRADE")
public class Market extends BaseEntity {

    private static final String TABLE_NAME = "MARKET";

    @Column(name = "SYMBOL", nullable = false, unique = true)
    private String symbol;//sample: BTC/USDT

    @NotNull
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private MarketStatus status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BASE_ASSET_ID",
            foreignKey = @ForeignKey(name = "FK_" + TABLE_NAME + "_BASE_ASSET"))
    private Asset baseAsset;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "QUOTE_ASSET_ID",
            foreignKey = @ForeignKey(name = "FK_" + TABLE_NAME + "_QUOTE_ASST"))
    private Asset quoteAsset;

    @OneToMany(mappedBy = "market", fetch = FetchType.LAZY)
    private Set<Order> orders;

    @OneToMany(mappedBy = "market", fetch = FetchType.LAZY)
    private Set<Trade> trades;

    @Column(name = "MAKER_FEE_RATE")
    private Float makerFeeRate;

    @Column(name = "TAKER_FEE_RATE")
    private Float takerFeeRate;

    @Column(name = "MIN_ORDER_SIZE")
    private BigDecimal minOrderSize;

    @Column(name = "MAX_ORDER_SIZE")
    private BigDecimal maxOrderSize;

    @Column(name = "TICK_SIZE")
    private BigDecimal tickSize;

    @Column(name = "PRICE_PRECISION")
    private int pricePrecision;//todo study about it

    @Column(name = "QUANTITY_PRECISION")
    private int quantityPrecision;//todo study about it

}
