FROM openjdk:8-jre-alpine

COPY build/distributions/Consumer-Api-Project-1.0-SNAPSHOT.tar /opt/app/

WORKDIR /opt/app

RUN tar -xvf Consumer-Api-Project-1.0-SNAPSHOT.tar

ENTRYPOINT "/opt/app/Consumer-Api-Project-1.0-SNAPSHOT/bin/Consumer-Api-Project"