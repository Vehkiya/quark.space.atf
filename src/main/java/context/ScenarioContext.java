package context;

import org.springframework.stereotype.Service;
import webdriver.Browser;

import java.util.HashMap;
import java.util.Map;

@Service
public class ScenarioContext {

    private Browser browser;

    private Map<DataKey, Object> data = new HashMap<>();

    private String currentEvidencePath;

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

    public void resetResource() {
        data.clear();
    }

    public Browser getBrowser() {
        return browser;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    public String getCurrentEvidencePath() {
        return currentEvidencePath;
    }

    public void setCurrentEvidencePath(final String currentEvidencePath) {
        this.currentEvidencePath = currentEvidencePath;
    }
}
