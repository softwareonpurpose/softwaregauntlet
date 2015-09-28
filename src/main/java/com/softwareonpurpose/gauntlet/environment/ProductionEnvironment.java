package com.softwareonpurpose.gauntlet.environment;

public class ProductionEnvironment extends EnvironmentDefinition {

    private ProductionEnvironment() {
    }

    public static ProductionEnvironment getInstance() {
        return new ProductionEnvironment();
    }
}
