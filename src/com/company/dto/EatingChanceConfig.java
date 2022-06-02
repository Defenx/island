package com.company.dto;

import com.company.model.enums.LiveableType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EatingChanceConfig {

    Map<LiveableType, Map<LiveableType, Integer>> config;

}
