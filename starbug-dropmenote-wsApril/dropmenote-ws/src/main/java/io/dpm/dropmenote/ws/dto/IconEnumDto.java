/**
 * 
 */
package io.dpm.dropmenote.ws.dto;

/**
 * @author Martin Jurek (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
public class IconEnumDto {

    /**
     * 
     * @param source
     * @return
     */
    public static io.dpm.dropmenote.ws.enums.IconEnum convertToBean(io.dpm.dropmenote.db.enums.IconEnum source) {
        if (source == null) {
            return null;
        }
        return io.dpm.dropmenote.ws.enums.IconEnum.valueOf(source.name());
    }

    /**
     * !! it doesnt support DB update. Missing ID!
     * 
     * @param source
     * @return
     */
    public static io.dpm.dropmenote.db.enums.IconEnum convertToEntity(io.dpm.dropmenote.ws.enums.IconEnum source) {
        if (source == null) {
            return null;
        }
        return io.dpm.dropmenote.db.enums.IconEnum.valueOf(source.name());
    }

}
