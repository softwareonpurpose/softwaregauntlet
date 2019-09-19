/*Copyright 2017 Craig A. Stockton

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.*/
package com.softwareonpurpose.gauntlet.environment;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SuppressWarnings("unused")
public class Environment {
    private static Environment environment;
    @SuppressWarnings({"FieldCanBeLocal", "MismatchedQueryAndUpdateOfCollection"})
    private final Properties properties = new Properties();

    private Environment(InputStream inputStream) {
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Environment getInstance() {
        if (environment == null) {
            String env = System.getProperty("env");
            LoggerFactory.getLogger(Environment.class).error("System Property 'env' NOT SET (e.g. 'dev')");
            InputStream inputStream = Environment.class.getClassLoader().getResourceAsStream(String.format("%s.properties", env));
            environment = new Environment(inputStream);
        }
        return environment;
    }
}
