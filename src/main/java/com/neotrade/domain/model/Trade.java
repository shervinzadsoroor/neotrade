package com.neotrade.domain.model;

import com.neotrade.domain.model.market.Market;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "TRADE", schema = "NEOTRADE")
public class Trade extends BaseDomain {

    private static final String TABLE_NAME = "TRADE";

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BUY_ORDER_ID",
            foreignKey = @ForeignKey(name = "FK_" + TABLE_NAME + "_BUY_ORDER"))
    private Order buyOrder;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SELL_ORDER_ID",
            foreignKey = @ForeignKey(name = "FK_" + TABLE_NAME + "_SELL_ORDER"))
    private Order sellOrder;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MARKET_ID",
            foreignKey = @ForeignKey(name = "FK_" + TABLE_NAME + "_MARKET"))
    private Market market;

    @NotNull
    @Column(name = "PRICE", columnDefinition = "NUMBER(19,8)", nullable = false)
    private BigDecimal price;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE", nullable = false, updatable = false)
    private Date date;

}
