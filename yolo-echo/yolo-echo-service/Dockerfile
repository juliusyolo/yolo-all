FROM openjdk:17-jdk-alpine
RUN addgroup -S yolo && adduser -S yolo -G yolo
USER yolo:yolo
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.juliusyolo.yolo.echo.YoloEchoServiceApplication"]