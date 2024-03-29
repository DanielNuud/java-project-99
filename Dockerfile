FROM gradle:8.6.0-jdk21

WORKDIR /

COPY / .

RUN chmod +x ./gradlew

RUN ./gradlew installDist

CMD ./build/install/app/bin/app --spring.profiles.active=stage