package com.company.model;

import com.company.dto.LiveableConfig;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
public abstract class Flora extends NatureObject {

    public Flora(LiveableConfig liveableConfig) {
        super(liveableConfig);
    }

}
