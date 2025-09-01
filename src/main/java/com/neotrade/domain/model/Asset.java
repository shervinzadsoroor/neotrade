package com.neotrade.domain.model;

import com.neotrade.shared.enumeration.AssetType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "ASSET", schema = "NEOTRADE",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"symbol"})
        })
public class Asset extends BaseEntity {

    private static final String TABLE_NAME = "ASSET";

    @Column(nullable = false, unique = true, length = 20)
    private String symbol; // e.g., "BTC", "USDT", "EUR"

    @NotNull
    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @NotNull
    @Column(name = "TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private AssetType type;

    @Column(nullable = false)
    private int precision; // decimals (BTC = 8, USDT = 6, EUR = 2)

    @OneToMany(mappedBy = "asset")
    private Set<Account> accounts;

    @OneToMany(mappedBy = "asset")
    private Set<Transaction> transactions;
//
//    @OneToMany(mappedBy = "asset")
//    private Set<Wallet> wallets;
}
