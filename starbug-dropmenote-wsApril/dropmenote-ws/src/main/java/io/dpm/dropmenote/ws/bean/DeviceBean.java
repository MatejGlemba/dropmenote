package io.dpm.dropmenote.ws.bean;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

/**
 * @author Peter Diskanec
 */
@Data
@ToString(includeFieldNames = true)
public class DeviceBean extends AbstractBean {

    private long id;
    private UserBean user;
    private String deviceId;
    private Date registrationTime;

    public DeviceBean() {

    }
}
