FROM openjdk:8

RUN git clone https://github.com/codeforberlin/opacapi
RUN git clone https://github.com/opacapp/opacapp-config-files

RUN cd opacapi
RUN /opacapi/gradlew build

COPY entrypoint.sh /entrypoint.sh

ENTRYPOINT ["sh", "/entrypoint.sh"]
CMD ["sh", "gradlew", "run"]
