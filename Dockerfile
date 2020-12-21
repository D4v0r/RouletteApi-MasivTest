FROM openjdk:8
WORKDIR /usrapp/bin
ENV REDIS_HOST $REDIS_HOST
COPY /target/classes /usrapp/bin/classes
COPY /target/dependency /usrapp/bin/dependency
CMD ["java","-cp","./classes:./dependency/*","org.masiv.rouletteApi.RouletteApiApplication"]