/**
 * 
 */
package io.dpm.dropmenote.ws.dto;

/**
 * @author Martin Jurek (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
public class QRCodeTypeEnumDto {

    /**
     * 
     * @param source
     * @return
     */
    public static io.dpm.dropmenote.ws.enums.QRCodeTypeEnum convertToBean(io.dpm.dropmenote.db.enums.QRCodeTypeEnum source) {
        if (source == null) {
            return null;
        }
        return io.dpm.dropmenote.ws.enums.QRCodeTypeEnum.valueOf(source.name());
    }

    /**
     * !! it doesnt support DB update. Missing ID!
     * 
     * @param source
     * @return
     */
    public static io.dpm.dropmenote.db.enums.QRCodeTypeEnum convertToEntity(io.dpm.dropmenote.ws.enums.QRCodeTypeEnum source) {
        if (source == null) {
            return null;
        }
        return io.dpm.dropmenote.db.enums.QRCodeTypeEnum.valueOf(source.name());
    }

}
