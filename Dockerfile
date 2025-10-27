# Java 17 JDK 환경 기반
FROM eclipse-temurin:17-jdk-alpine

# 작업 디렉토리 지정
WORKDIR /app

# 프로젝트 전체 복사
COPY . .

# 빌드 실행
RUN ./mvnw clean package -DskipTests

# 실행
CMD ["java", "-jar", "target/*.jar"]
