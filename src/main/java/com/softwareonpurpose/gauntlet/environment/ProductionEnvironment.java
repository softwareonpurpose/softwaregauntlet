package com.softwareonpurpose.gauntlet.environment;

public class ProductionEnvironment extends EnvironmentDefinition {

    public static ProductionEnvironment getInstance() {
        return new ProductionEnvironment();
    }
}
