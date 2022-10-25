/**
 * Starbug, s.r.o.
 */
package io.dpm.dropmenote.ws.bean;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

/**
 * @author Peter Diskanec
 *
 */
@Data
@ToString(includeFieldNames = true)
public abstract class AbstractBean {

    private Date created;
    private Date updated;
}
