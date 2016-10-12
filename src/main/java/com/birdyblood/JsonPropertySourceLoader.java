package com.birdyblood;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.HashMap;

/**
 * For json.
 * Created by fp11523 on 13/10/2016.
 */
public class JsonPropertySourceLoader implements PropertySourceLoader, PriorityOrdered {

    @Override
    public String[] getFileExtensions() {
        return new String[]{"json"};
    }

    @Override
    public PropertySource<?> load(String name, Resource resource, String profile) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();

        final HashMap hashMap = mapper.readValue(resource.getInputStream(), HashMap.class);
        return new MapPropertySource(name, hashMap);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
