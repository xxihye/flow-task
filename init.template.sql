-- 파일 확장자 테이블 생성
CREATE TABLE IF NOT EXISTS file_extension(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    extension  VARCHAR(20) NOT NULL UNIQUE,
    type       VARCHAR(10) NOT NULL,
    is_used    BOOLEAN     NOT NULL DEFAULT TRUE,
    created_at DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 고정 확장자 데이터 추가
INSERT INTO file_extension (extension, type, is_used)
VALUES ('bat', 'FIXED', false),
       ('cmd', 'FIXED', false),
       ('com', 'FIXED', false),
       ('cpl', 'FIXED', false),
       ('exe', 'FIXED', false),
       ('scr', 'FIXED', false),
       ('js', 'FIXED', false);

-- 새로운 사용자 생성 및 권한 부여
CREATE USER '${DB_USERNAME}'@'%' IDENTIFIED BY '${DB_PASSWORD}';
GRANT ALL PRIVILEGES ON ${DB_NAME}.* TO '${DB_USERNAME}'@'%';
FLUSH PRIVILEGES;






