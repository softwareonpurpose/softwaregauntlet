package com.softwareonpurpose.gauntlet.environment;

import com.sun.javafx.runtime.SystemProperties;

public class Environment {

    private static EnvironmentDefinition environment;

    private Environment() {
    }

    public static EnvironmentDefinition getInstance() {
        if (environment == null) {
            String environment = SystemProperties.getProperty("environment");
            switch (environment) {
                default:
                    Environment.environment = ProductionEnvironment.getInstance();
            }
        }
        return environment;
    }
}
