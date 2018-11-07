FROM node:10-alpine

ARG local=/var/app
ARG ENV=prod

ENV ENV ${ENV}
ENV PREPI_ENV ${ENV}

RUN mkdir -p ${local}

WORKDIR /var/app/
COPY . ${local}

CMD [ "npm", "start" ]
