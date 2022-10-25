/**
 * 
 */
package io.dpm.dropmenote.ws.bean;

import io.dpm.dropmenote.db.entity.QRCodeEntity;
import io.dpm.dropmenote.db.entity.UserEntity;
import lombok.Data;
import lombok.ToString;

/**
 * @author Martin Jurek (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
@Data
@ToString(includeFieldNames = true)
public class QRCodeShare {
    
    private QRCodeEntity qrCode;
    private UserEntity sharedOwner;

}
