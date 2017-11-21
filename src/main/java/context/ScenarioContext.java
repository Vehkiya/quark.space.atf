package context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Service
public class ScenarioContext {

    @Autowired
    @Qualifier("webProperties")
    Properties webProperties;

    private Map<DataKey, Object> data = new HashMap<>();

    public Map<DataKey, Object> getData() {
        return data;
    }

    public Object getDataByKey(DataKey dataKey) {
        return data.getOrDefault(dataKey, null);
    }

    public void saveIfNotPresent(DataKey dataKey, Object object) {
        data.putIfAbsent(dataKey, object);
    }

    public void save(DataKey dataKey, Object object) {
        data.put(dataKey, object);
    }
}
