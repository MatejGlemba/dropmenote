/**
 * 
 */
package io.dpm.dropmenote.ws.controller.rrbean;

import lombok.Data;
import lombok.ToString;

/**
 * @author Martin Jurek (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
@Data
@ToString(includeFieldNames = true)
public class AppInfoResponse {

    private long serverTime;
    private String appVersion;
}
