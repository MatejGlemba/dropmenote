package io.dpm.dropmenote.ws.bean;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

/**
 * @author Peterko
 *
 */
@Data
@ToString(includeFieldNames = true)
public class ConfigurationBean {

    private long id;
    private String key;
    private String value;
    private String note;
    private Date created;

    public ConfigurationBean() {

    }
}
