FROM openjdk:16-alpine3.13

WORKDIR /usr/src/app

COPY . .

RUN mvn package

EXPOSE 8888

CMD ["mvn", "exec:java"]


