package com.neotrade.domain.model;

import com.neotrade.domain.model.market.Market;
import com.neotrade.shared.enumeration.OrderSide;
import com.neotrade.shared.enumeration.OrderStatus;
import com.neotrade.shared.enumeration.OrderType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "ORDER", schema = "NEOTRADE")
public class Order extends BaseEntity {

    private static final String TABLE_NAME = "ORDER";

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ACCOUNT_ID",
            foreignKey = @ForeignKey(name = "FK_" + TABLE_NAME + "_ACCOUNT"))
    private Account account;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MARKET_ID",
            foreignKey = @ForeignKey(name = "FK_" + TABLE_NAME + "_MARKET"))
    private Market market;

    @NotNull
    @Column(name = "PRICE", columnDefinition = "NUMBER(19,8)", nullable = false)
    private BigDecimal price;

    @NotNull
    @Column(name = "QTY", columnDefinition = "NUMBER(10,8)", nullable = false)
    private double quantity;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderSide side;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderType type;

}
