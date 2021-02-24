FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/spring_boot

COPY /target/*.jar cursozetta.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 8080
EXPOSE 7005

CMD java ${ADDITIONAL_OPTS} -jar cursozetta.jar --spring.profiles.active=${PROFILE}