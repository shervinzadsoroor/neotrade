package com.neotrade.domain.model.wallet;

import com.neotrade.domain.model.Account;
import com.neotrade.domain.model.Asset;
import com.neotrade.domain.model.BaseEntity;
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
@Inheritance(strategy = InheritanceType.JOINED)
//@Table(name = "WALLET", schema = "NEOTRADE")
public abstract class Wallet extends BaseEntity {

    private static final String TABLE_NAME = "WALLET";

//    @NotNull
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "ACCOUNT_ID",
//            foreignKey = @ForeignKey(name = "FK_" + TABLE_NAME + "_ACCOUNT"))
//    private Account account;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "BALANCE")
    private BigDecimal balance;

    @ManyToOne(fetch =  FetchType.LAZY, optional = false)
    @JoinColumn(name = "ASSET_ID",
            foreignKey = @ForeignKey(name = "FK_" + TABLE_NAME + "_ASSET"))
    private Asset asset;

}
