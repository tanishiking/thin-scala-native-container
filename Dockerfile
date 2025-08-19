FROM sbtscala/scala-sbt:eclipse-temurin-jammy-21.0.2_13_1.9.9_3.4.1 AS builder

RUN apt update -y && apt -y install clang

WORKDIR /app

COPY build.sbt .
COPY src ./src
COPY project ./project

RUN sbt nativeLink

FROM gcr.io/distroless/static-debian12:latest AS runner

COPY --from=builder /app/target/scala-3.7.2/native/thinscalanativecontainer.hello /app/main
WORKDIR /app

CMD [ "/app/main" ]
