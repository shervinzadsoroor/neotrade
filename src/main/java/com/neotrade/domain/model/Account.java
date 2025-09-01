package com.neotrade.domain.model;

import com.neotrade.domain.model.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "ACCOUNT", schema = "NEOTRADE")
public class Account extends BaseEntity {

    private static final String TABLE_NAME = "ACCOUNT";

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID",
            foreignKey = @ForeignKey(name = "FK_" + TABLE_NAME + "_USER"))
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ASSET_ID",
            foreignKey = @ForeignKey(name = "FK_" + TABLE_NAME + "_ASSET"))
    private Asset asset;

}
