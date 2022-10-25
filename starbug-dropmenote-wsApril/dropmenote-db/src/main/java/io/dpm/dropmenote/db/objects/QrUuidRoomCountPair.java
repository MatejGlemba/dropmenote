package io.dpm.dropmenote.db.objects;

public class QrUuidRoomCountPair {
	
	private String qrUuid;
	private Long roomsCount;
	
	public String getQrUuid() {
		return qrUuid;
	}
	public void setQrUuid(String qrUuid) {
		this.qrUuid = qrUuid;
	}
	public Long getRoomsCount() {
		return roomsCount;
	}
	public void setRoomsCount(Long roomsCount) {
		this.roomsCount = roomsCount;
	}
	
	public QrUuidRoomCountPair(String qrUuid, Long roomsCount) {
		super();
		this.qrUuid = qrUuid;
		this.roomsCount = roomsCount;
	}
	
	
}
