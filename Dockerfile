FROM gradle:8.4.0-jdk20

WORKDIR /

COPY / .

RUN chmod +x ./gradlew

RUN ./gradlew installDist

CMD ./build/install/app/bin/app --spring.profiles.active=stage