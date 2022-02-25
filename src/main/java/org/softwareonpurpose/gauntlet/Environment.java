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
package org.softwareonpurpose.gauntlet;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Environment {
    private static Environment environment;
    private final Properties properties = new Properties();

    Environment(InputStream inputStream) {
        if (inputStream != null) {
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * System Property 'env' is used to initialize Environment to resources/[env].properties
     * @return Environment
     */
    public static Environment getInstance() {
        if (environment == null) {
            String env = System.getProperty("env");
            InputStream inputStream = null;
            try {
                inputStream = Environment.class.getClassLoader().getResourceAsStream(String.format("%s.properties", env));
            } catch (Exception e) {
                LoggerFactory.getLogger(Environment.class).error("System Property 'env' NOT SET (e.g. \"dev\" for a 'dev' environment)");
            }
            environment = new Environment(inputStream);
        }
        return environment;
    }

    static void clear() {
        environment=null;
    }

    String getProperty(String key) {
        return properties.getProperty(key);
    }
}
