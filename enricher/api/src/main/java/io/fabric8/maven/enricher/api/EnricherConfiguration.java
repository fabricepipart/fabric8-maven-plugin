/*
 * Copyright 2016 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */

package io.fabric8.maven.enricher.api;

import java.util.Collections;
import java.util.Map;

/**
 * @author roland
 * @since 24/05/16
 */
public class EnricherConfiguration {

    private final String prefix;
    private final Map<String,String> config;

    EnricherConfiguration(String prefix, Map<String, String> config) {
        this.config = Collections.unmodifiableMap(config != null ? config : Collections.<String, String>emptyMap());
        this.prefix = prefix + ".";
    }

    public String get(String key) {
        return get(key, null);
    }

    public String get(String key, String defaultVal) {
        String val = config.get(prefix + key);
        return val != null ? val : defaultVal;
    }

    public int getAsInt(String key) {
        return getAsInt(key, 0);
    }

    public int getAsInt(String key, int defaultVal) {
        String val = get(key);
        return val != null ? Integer.parseInt(val) : defaultVal;
    }

    public boolean getAsBoolean(String key) {
        return getAsBoolean(key, false);
    }

    public boolean getAsBoolean(String key, boolean defaultVal) {
        String val = get(key);
        return val != null ? Boolean.parseBoolean(val) : defaultVal;
    }
}