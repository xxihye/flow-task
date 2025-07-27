# file-ext-admin

파일 확장자 관리 기능을 제공하는 Spring Boot 기반의 관리자 웹 애플리케이션입니다.  
관리자가 시스템에서 사용 가능한 확장자 유형을 등록 및 제어할 수 있으며, 확장자 사용 여부를 실시간으로 관리합니다.

## 기술 스택

### Backend
- Java 17
- Spring Boot 3.4
- Spring Web
- JDBC + MyBatis (`@Mapper` 기반 SQL 작성)
- MySQL (Docker 컨테이너)
- Lombok
- Gradle

### Frontend
- Thymeleaf
- Bootstrap
- jquery
- Axios

### DevOps & Infra
- AWS EC2 (Amazon Linux 2023)
- Docker & Docker Compose
- dockerize 
- shell script 기반 배포 자동화

## 배포 환경
- Amazon EC2에 MySQL을 Docker로 띄우고, Spring Boot 애플리케이션을 `.jar` 파일로 실행
- `dockerize` 도구를 활용하여 DB가 준비될 때까지 애플리케이션 실행을 지연

## 관리자 기능
- 커스텀 확장자 등록 및 수정
- 고정 확장자 사용 여부 On/Off 전환