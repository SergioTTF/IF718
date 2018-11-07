FROM node:10-slim

ADD package.json npm-shrinkwrap.json /var/app/

WORKDIR /var/app/

RUN npm install \
    && npm install supervisor -g