#FROM openjdk:11-slim as runtime
#FROM openjdk:11-jdk-slim as runtime

# (1) use Alpine Linux for build stage
#FROM alpine:latest as runtime
# (2) install build dependencies
#RUN apk --no-cache add openjdk11
#RUN echo $PATH $JAVA_HOME
# build JDK with less modules
#RUN /usr/lib/jvm/default-jvm/bin/jlink \
#    --compress=2 \
#    --module-path /usr/lib/jvm/default-jvm/jmods \
#    --add-modules java.base,java.logging,java.xml,jdk.unsupported,java.sql,java.naming,java.desktop,java.management,java.security.jgss,java.instrument \
#    --output /jdk-minimal
#-Djava.security.egd=file:/dev/./urandom 
#

##From spring-boot-runtime:openjdk-slim  this docker file is created with
## Dockerfile_spring_boot_runtime_openjdk

From spring-boot-runtime:openjdk-slim as openjdk-slim
ARG OPEN_JDK_BASE_IMAGE=openjdk-slim



ARG PORT=8585
ARG HEALTHCHECK_URL=/actuator/health
ARG DEPENDENCY=target/dependency
ARG API_NAME=transcribeapi
ARG ARTIFACT_NAME=transcribeapi
ARG API_VERSION=0.0.1-SNAPSHOT
ARG STORE_PASS=admin111
ARG KEY_STORE_PASS=admin111
ARG APP_HOME=/apps
ARG image_tag=$AP_NAME:$API_VERSION
ARG APP_PROPERTIES_FILE="application-dev.properties"


ENV APP_PROPERTIES_FILE $APP_PROPERTIES_FILE
ENV MAIN_CLASS=Application.java
ENV SPRING_PROFILE=dev
ENV JAVA_OPTS="-Xmx 1000mb -Xms 500mb -Dspring.profiles.active=${SPRING_PROFILE}"
ENV HEALTHCHECK_URL=actuator/health


# to check for open ports in the container: docker run <container id> netstat -tan
#ARG SSH_KEY
#RUN echo "$SSH_KEY" > ~/.ssh/id_rsa

#find /usr/share/ca-certificates/mozilla/ -name "*.crt" -type f -exec  $JAVA_HOME/bin/keytool -importcert  -cacerts  -storepass $STORE_PASS -noprompt  -file '{}' -alias '{}' \; && \
#  $JAVA_HOME/bin/keytool -list -keystore $JAVA_HOME/lib/security/cacerts --storepass $STORE_PASS


RUN  echo $PATH $JAVA_HOME && \
     mkdir -p /apps/$API_NAME && \
	 mkdir -p $APP_HOME/configs && \
     mkdir -p $APP_HOME/logs && \
     mkdir -p $APP_HOME/temp && \
     echo $HOME && \
     mkdir -p $HOME/temp/logs/

WORKDIR $APP_HOME
USER $USERNAME
#RUN echo "$SSH_KEY" > ~/.ssh/id_rsa
#JMX
#EXPOSE 9010

# JVM debugging port
EXPOSE $PORT

COPY ./BOOT-INF/lib $APP_HOME/$API_NAME/lib
COPY ./META-INF $APP_HOME/$API_NAME/META-INF
COPY ./BOOT-INF/classes $APP_HOME/$API_NAME
COPY ./org $APP_HOME/$API_NAME/org

#RUN cp $APP_HOME/apps/$API_NAME/classes/sample.jks $APP_HOME/apps/$API_NAME/classes/sample.cert
#ENTRYPOINT ["sh", "-c", "$JAVA_OPTS -Djava.security.egd=file:/dev/urandom -jar app.jar "]

RUN if [ -e $APP_HOME/configs/$APP_PROPERTIES_FILE ]; then  \
        JAVA_OPTS=$JAVA_OPTS" -DSPRING_CONFIG_FILE=$APP_HOME/configs/$APP_PROPERTIES_FILE --DSPRING_PROFILES_ACTIVE=$APP_PROFILE  -D" \
    fi \
RUN if [ ! -z $APP_PROFILE ]; then  \
        JAVA_OPTS=$JAVA_OPTS" --DSPRING_PROFILES_ACTIVE=$APP_PROFILE " \
    fi

HEALTHCHECK --interval=20s --timeout=5s  retries: 5  start_period: 60s  CMD curl -k --fail https://localhost:$PORT/$HEALTHCHECK_URL | grep UP || exit 1
#test: ["CMD-SHELL", "pg_isready -U postgres"]
ENTRYPOINT ["sh", "-c",  "java  -cp  $APP_HOME/$API_NAME:$APP_HOME/$API_NAME/lib/*:$APP_HOME/$API_NAME/classes:$APP_HOME/$API_NAME/org    $JAVA_OPTS   -Djava.security.egd=file:/dev/urandom   $MAIN_CLASS " ]

#image_tag
#docker build -t <image_tag> . && docker run -p 8585:8585 <image_tag>
#docker build -t <image_tag> . && docker run -p 8585:8585 -p 5005:5005 --env JAVA_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 --env MAIN_CLASS=com.htsvsystems.config.Application \
 # --env JAVA_OPTS=-Dlogging.level.org.springframework=DEBUG <image_tag>
#docker build -t <image_tag> . && docker run -p 8080:8080 -v /opt/spring-boot/test/config:$APP_HOME/configs:ro <image_tag>
