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



ENV JAVA_OPTS="-Xmx 256mb "
ENV MAIN_CLASS App.java
ARG PORT=8585
ARG HEALTHCHECK_URL  /api/v1/health
ARG DEPENDENCY=target/dependency
ARG API_NAME=transcribeapi
ARG STORE_PASS=admin111

USER $USERNAME

# to check for open ports in the container: docker run <container id> netstat -tan
#ARG SSH_KEY
#RUN echo "$SSH_KEY" > /root/.ssh/id_rsa

#find /usr/share/ca-certificates/mozilla/ -name "*.crt" -type f -exec  $JAVA_HOME/bin/keytool -importcert  -cacerts  -storepass changeit -noprompt  -file '{}' -alias '{}' \; && \
#  $JAVA_HOME/bin/keytool -list -keystore $JAVA_HOME/lib/security/cacerts --storepass $STORE_PASS

ENV APP_HOME /opt/apps

RUN  echo $PATH $JAVA_HOME && \
     mkdir -p /opt/apps/$API_NAME && \
	 mkdir -p $APP_HOME/configs && \
     mkdir -p $APP_HOME/logs && \
     mkdir -p $APP_HOME/temp && \
     echo $HOME && \
     mkdir -p $HOME/temp/logs/

WORKDIR $APP_HOME

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
HEALTHCHECK --interval=5s --timeout=5s   CMD curl -k --fail https://localhost:8585/$HEALTHCHECK_URL|| exit 1
ENTRYPOINT ["sh", "-c",  "java  -cp  /opt/apps/$API_NAME:/opt/apps/$API_NAME/lib/*:/opt/apps/$API_NAME/classes:/opt/apps/$API_NAME/org    $JAVA_OPTS   -Djava.security.egd=file:/dev/urandom   $MAIN_CLASS " ]

#docker build -t <image_tag> . && docker run -p 8585:8585 <image_tag>
#docker build -t <image_tag> . && docker run -p 8585:8585 -p 5005:5005 --env JAVA_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 \
 # --env JAVA_OPTS=-Dlogging.level.org.springframework=DEBUG <image_tag>
#docker build -t <image_tag> . && docker run -p 8080:8080 -v /opt/spring-boot/test/config:$APP_HOME/apps/configs:ro <image_tag>
