package com.neotrade.infrastructure.persistence.entity.user;

import com.neotrade.shared.enumeration.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
    private UserEntity user;

    @Id
    @Column(name = "ROLE", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
}
