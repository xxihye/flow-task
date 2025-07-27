#!/bin/bash

# .env 주입 및 파일 생성
export $(cat .env | xargs)
envsubst < ./src/main/resources/application.template.yml > ./src/main/resources/application.yml
envsubst < ./init.template.sql > ./init.sql

# 컨테이너 정리 및 새로 빌드
docker-compose down -v
docker-compose up --build -d

# mysql 떠서 초기화 작업 끝날 때까지 대기
dockerize -wait tcp://localhost:3306 -timeout 30s
sleep 5
echo "✅ MySQL is up and running!"

# 애플리케이션 빌드 및 실행
./gradlew clean bootJar
java -jar build/libs/file-ext-admin-1.0.0.jar
