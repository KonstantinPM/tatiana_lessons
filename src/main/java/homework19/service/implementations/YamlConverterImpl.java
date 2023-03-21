package homework19.service.implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import homework19.service.interfaces.Converter;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.util.Map;

public class YamlConverterImpl implements Converter {
    @Override
    public String convert(String data) {
        Yaml yaml = new Yaml(new Constructor(Map[].class));
        Map[] obj = yaml.load(data);
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            System.err.println("Yaml convertation fault!");
            throw new RuntimeException(e);
        }
    }
}
