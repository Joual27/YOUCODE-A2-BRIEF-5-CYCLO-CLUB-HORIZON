package org.youcode.generalResult.embeddables;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class GeneralResultKey implements Serializable {

    @Column(name="CYCLIST_ID")
    private Long cyclistId;

    @Column(name="COMPETITION_ID")
    private Long competitionId;

}