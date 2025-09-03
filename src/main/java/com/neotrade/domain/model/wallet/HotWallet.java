package com.neotrade.domain.model.wallet;

import com.neotrade.domain.model.BaseDomain;
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
@Table(name = "HOT_WALLET", schema = "NEOTRADE")
public class HotWallet extends BaseDomain {

    private static final String TABLE_NAME = "HOT_WALLET";

    @NotNull
    @Column(name = "API_KEY", nullable = false)
    private String apiKey;

    @NotNull
    @Column(name = "PROVIDER", nullable = false)
    private String provider;

}
