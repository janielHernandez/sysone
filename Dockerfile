FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD /target/sysone-0.0.1-SNAPSHOT.jar sysone-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","sysone-0.0.1-SNAPSHOT.jar"]