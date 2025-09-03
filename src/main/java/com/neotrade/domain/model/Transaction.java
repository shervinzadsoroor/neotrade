package com.neotrade.domain.model;

import com.neotrade.shared.enumeration.TransactionType;
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
@Table(name = "TRANSACTION", schema = "NEOTRADE")
public class Transaction extends BaseDomain {

    private static final String TABLE_NAME = "TRANSACTION";

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ACCOUNT_ID",
            foreignKey = @ForeignKey(name = "FK_" + TABLE_NAME + "_ACCOUNT"))
    private Account account;

    @NotNull
    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @NotNull
    @Column(name = "AMOUNT", columnDefinition = "NUMBER(19,8)", nullable = false)
    private BigDecimal amount;

}
