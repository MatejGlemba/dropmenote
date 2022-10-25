DROP INDEX IF EXISTS idx_blacklist_uuid;
DROP INDEX IF EXISTS idx_configuration_key;

DROP INDEX IF EXISTS idx_device_device_id;
DROP INDEX IF EXISTS idx_device_user_id;

DROP INDEX IF EXISTS idx_matrix_user_uuid;
DROP INDEX IF EXISTS idx_matrix_qr_code_uuid;
DROP INDEX IF EXISTS idx_matrix_matrix_room_id;

DROP INDEX IF EXISTS idx_qr_code_uuid;
DROP INDEX IF EXISTS idx_qr_code_owner_id;

DROP INDEX IF EXISTS idx_qr_code_list_uuid;

DROP INDEX IF EXISTS idx_qr_code_share_qrcode_id;
DROP INDEX IF EXISTS idx_qr_code_share_shared_owner_id;

DROP INDEX IF EXISTS idx_qr_code_user_share_owner_user_id;
DROP INDEX IF EXISTS idx_qr_code_user_share_qr_code_id;
DROP INDEX IF EXISTS idx_qr_code_user_share_shared_user_id;

DROP INDEX IF EXISTS idx_user_uuid;

DROP INDEX IF EXISTS idx_user_session_device_id;
DROP INDEX IF EXISTS idx_user_session_token;
DROP INDEX IF EXISTS idx_user_session_user_id;

CREATE INDEX idx_blacklist_uuid ON blacklist(uuid);
CREATE INDEX idx_configuration_key ON configuration(key);

CREATE INDEX idx_device_device_id ON device(device_id);
CREATE INDEX idx_device_user_id ON device(user_id);

CREATE INDEX idx_matrix_user_uuid ON matrix(user_uuid);
CREATE INDEX idx_matrix_qr_code_uuid ON matrix(qr_code_uuid);
CREATE INDEX idx_matrix_matrix_room_id ON matrix(matrix_room_id);

CREATE INDEX idx_qr_code_uuid ON qr_code(uuid);
CREATE INDEX idx_qr_code_owner_id ON qr_code(owner_id);

CREATE INDEX idx_qr_code_list_uuid ON qr_code_list(uuid);

CREATE INDEX idx_qr_code_user_share_owner_user_id ON qr_code_user_share(owner_user_id);
CREATE INDEX idx_qr_code_user_share_qr_code_id ON qr_code_user_share(qr_code_id);
CREATE INDEX idx_qr_code_user_share_shared_user_id ON qr_code_user_share(shared_user_id);

CREATE INDEX idx_user_uuid ON "user"(uuid);

CREATE INDEX idx_user_session_device_id ON user_session(device_id);
CREATE INDEX idx_user_session_token ON user_session(token);
CREATE INDEX idx_user_session_user_id ON user_session(user_id);