package com.company.model.impl;

import com.company.dto.LiveableConfig;
import com.company.model.Flora;
import com.company.model.enums.LiveableType;

import static com.company.model.enums.LiveableType.PLANT;

public class Plant extends Flora {

    public Plant(LiveableConfig liveableConfig) {
        super(liveableConfig);
    }

    @Override
    public LiveableType getLiveableType() {
        return PLANT;
    }
}
