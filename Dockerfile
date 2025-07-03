FROM maven:latest AS maven
#Dentro del linux alpine de la img de maven me paro en usr/src/app
WORKDIR /usr/src/app
#Copio el directorio del proyecto al contenedor
COPY . /usr/src/app
#Compilar y empaquetar la aplicación a un .jar ejecutable
#Crea /target dentro de /usr/src/app
RUN mvn package


#Una vez compilado, parto de una imagen solo con openjdk
FROM eclipse-temurin:17-jdk-alpine
#Creo un argumento JAR_FILE que es el equivalente al nombre del jar de la aplicación
ARG JAR_FILE=tp-cache-interna.jar
#Me posiciono dentro del directorio /opt/app
WORKDIR /opt/app

# Copio el jar de la imagen de maven a /opt/app de la instancia actual.
COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/

EXPOSE 8080

ENV JAVA_OPTS=""

ENTRYPOINT java $JAVA_OPTS -jar tp-cache-interna.jar
