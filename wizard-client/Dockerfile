FROM node:lts
RUN mkdir /app && chown node:node /app
RUN mkdir /app/node_modules && chown node:node /app/node_modules
WORKDIR /app
USER node
COPY --chown=node:node package.json package-lock.json ./
RUN npm ci
COPY --chown=node:node . .
