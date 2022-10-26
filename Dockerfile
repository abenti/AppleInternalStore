FROM openjdk:17-alpine
VOLUME /main-app
COPY target/AppleInternalStore-0.0.1-SNAPSHOT.jar AppleInternalStore.jar
EXPOSE 8088
ENTRYPOINT ["java","-jar","/AppleInternalStore.jar"]