FROM node:8-slim as production

RUN apt-get update && \
    apt-get install -y make python

ENV NO_UPDATE_NOTIFIER=true

ENV HOME=/home/node
WORKDIR /app
RUN adduser node root && \
    chown node:root /app $HOME && \
    chmod g=u /app $HOME
USER 1000:0

COPY --chown=node:root .npmrc package.json package-lock.json ./
RUN npm ci --only=production && \
    npm cache clean --force

COPY --chown=node:root . ./

ARG version=patch
RUN npm version "$version"

EXPOSE 8080
ENTRYPOINT ["npm"]
CMD ["start"]

###

FROM production as development

RUN npm install --only=development && \
    npm cache clean --force

ENTRYPOINT ["npm"]
CMD ["test"]
