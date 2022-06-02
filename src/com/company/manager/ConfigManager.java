package com.company.manager;

import com.company.dto.AnimalsConfig;
import com.company.dto.EatingChanceConfig;
import com.company.dto.MapConfig;
import com.company.service.util.ConfigReader;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import static com.company.constants.Constants.*;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConfigManager {

    static volatile ConfigManager configManager;

    AnimalsConfig animalsConfig;
    EatingChanceConfig eatingChanceConfig;
    MapConfig mapConfig;

    public ConfigManager(AnimalsConfig animalsConfig, EatingChanceConfig eatingChanceConfig, MapConfig mapConfig) {
        this.animalsConfig = animalsConfig;
        this.eatingChanceConfig = eatingChanceConfig;
        this.mapConfig = mapConfig;
    }

    public static ConfigManager getConfigManager() {
        if (configManager == null) {
            synchronized (ConfigManager.class) {
                if (configManager == null) {
                    configManager = new ConfigManager(
                            ConfigReader.readConfig(ANIMAL_PROPERTIES_FILE_PATH, AnimalsConfig.class),
                            ConfigReader.readConfig(EATING_CHANCE_PROPERTIES_FILE_PATH, EatingChanceConfig.class),
                            ConfigReader.readConfig(MAP_PROPERTIES_FILE_PATH, MapConfig.class)
                    );
                }
            }
        }
        return configManager;
    }

}
