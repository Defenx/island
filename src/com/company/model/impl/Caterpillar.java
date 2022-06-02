package com.company.model.impl;

import com.company.dto.LiveableConfig;
import com.company.model.Fauna;
import com.company.model.enums.LiveableType;

import static com.company.model.enums.LiveableType.CATERPILLAR;

public class Caterpillar extends Fauna {

    public Caterpillar(LiveableConfig liveableConfig) {
        super(liveableConfig);
    }

    @Override
    public LiveableType getLiveableType() {
        return CATERPILLAR;
    }
}
