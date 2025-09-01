package com.neotrade.domain.model.user;

import com.neotrade.shared.enumeration.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "USER_ROLE", schema = "NEOTRADE")
@IdClass(UserRoleId.class)
public class UserRole {

    private static final String TABLE_NAME = "USER_ROLE";

    @Id
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID",
            foreignKey = @ForeignKey(name = "FK_" + TABLE_NAME + "_USER"))
    private User user;

    @Id
    @Column(name = "ROLE", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
}
