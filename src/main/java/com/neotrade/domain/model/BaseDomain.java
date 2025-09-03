package com.neotrade.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
public abstract class BaseDomain implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private int version;
    private Date createdDate;
    private Date modifiedDate;
}
