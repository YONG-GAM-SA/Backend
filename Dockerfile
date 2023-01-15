FROM openjdk:11

EXPOSE 8080

WORKDIR /yonggamsa

COPY . /yonggamsa

RUN ./gradlew build

#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/clickping-api.jar"]

CMD ["java", "-jar" , "/yonggamsa/build/libs/withsuyeonjung-0.0.1-SNAPSHOT.jar"]
