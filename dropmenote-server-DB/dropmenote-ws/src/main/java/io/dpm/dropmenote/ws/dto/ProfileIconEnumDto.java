/**
 * 
 */
package io.dpm.dropmenote.ws.dto;

/**
 * @author Peterko
 *
 */
public class ProfileIconEnumDto {

    /**
     * 
     * @param source
     * @return
     */
    public static io.dpm.dropmenote.ws.enums.ProfileIconEnum convertToBean(io.dpm.dropmenote.db.enums.ProfileIconEnum source) {
        if (source == null) {
            return null;
        }
        return io.dpm.dropmenote.ws.enums.ProfileIconEnum.valueOf(source.name());
    }

    /**
     * !! it doesnt support DB update. Missing ID!
     * 
     * @param source
     * @return
     */
    public static io.dpm.dropmenote.db.enums.ProfileIconEnum convertToEntity(io.dpm.dropmenote.ws.enums.ProfileIconEnum source) {
        if (source == null) {
            return null;
        }
        return io.dpm.dropmenote.db.enums.ProfileIconEnum.valueOf(source.name());
    }

}
