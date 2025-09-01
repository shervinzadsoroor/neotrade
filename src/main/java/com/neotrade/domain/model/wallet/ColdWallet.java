package com.neotrade.domain.model.wallet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "COLD_WALLET", schema = "NEOTRADE")
public class ColdWallet extends Wallet {

    private static final String TABLE_NAME = "COLD_WALLET";

    @NotNull
    @Column(name = "CUSTODY_PROVIDER", nullable = false)
    private String custodyProvider;

    @NotNull
    @Column(name = "STORAGE_LOCATION", nullable = false)
    private String storageLocation;

}
