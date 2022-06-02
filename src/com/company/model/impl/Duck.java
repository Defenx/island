package com.company.model.impl;

import com.company.dto.LiveableConfig;
import com.company.model.Fauna;
import com.company.model.enums.LiveableType;

import static com.company.model.enums.LiveableType.DUCK;

public class Duck extends Fauna {

    public Duck(LiveableConfig liveableConfig) {
        super(liveableConfig);
    }

    @Override
    public LiveableType getLiveableType() {
        return DUCK;
    }
}
