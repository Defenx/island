package com.company.model.impl;

import com.company.dto.LiveableConfig;
import com.company.model.Fauna;
import com.company.model.enums.LiveableType;

import static com.company.model.enums.LiveableType.SNAKE;

public class Snake extends Fauna {

    public Snake(LiveableConfig liveableConfig) {
        super(liveableConfig);
    }

    @Override
    public LiveableType getLiveableType() {
        return SNAKE;
    }
}
