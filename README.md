## Multi-Service Application with Docker, MySQL, and Redis

# Overview

This project is a multi-service application using Spring Boot, MySQL, Redis, and Docker. The application is containerized using Docker and managed with Docker Compose. A CI/CD pipeline is implemented using GitHub Actions for automated builds and deployments.

## Project Structure

├── web-service/            # Spring Boot application
├── database/               # MySQL database setup
├── cache/                  # Redis cache setup
├── docker-compose.yaml     # Docker Compose configuration
├── .github/
│   ├── workflows/
│   │   └── ci-cd.yml       # GitHub Actions CI/CD workflow
└── README.md

# Prerequisites

Ensure you have the following installed:

Java 21

Spring Boot 3.4.1

Docker & Docker Compose

MySQL

Redis

Git

Setup Instructions

1. Clone the Repository

git clone https://github.com/your-username/your-repo.git
cd your-repo

2. Build the Spring Boot Application

cd web-service
./mvnw clean package
cd ..

3. Run the Application with Docker Compose

docker-compose up --build

4. Verify Services

Web Service: http://localhost:8080

MySQL: docker exec -it your_mysql_container mysql -u root -p

Redis: docker exec -it your_redis_container redis-cli

5. Stop Services

docker-compose down

CI/CD Pipeline

GitHub Actions is used for continuous integration and deployment.

Workflow (.github/workflows/ci-cd.yml)

name: CI/CD Pipeline

on:
push:
branches:
- main

jobs:
build:
runs-on: ubuntu-latest
steps:
- name: Checkout Code
uses: actions/checkout@v4
- name: Set up Docker Buildx
uses: docker/setup-buildx-action@v3
- name: Log in to Docker Hub
uses: docker/login-action@v3
with:
username: ${{ secrets.DOCKER_USERNAME }}
password: ${{ secrets.DOCKER_PASSWORD }}
- name: Build and Push Docker Images
run: |
docker-compose build
docker-compose push
deploy:
needs: build
runs-on: ubuntu-latest
steps:
- name: Checkout Code
uses: actions/checkout@v4
- name: Deploy Services
run: |
docker-compose down
docker-compose pull
docker-compose up -d

# Setup GitHub Secrets

Go to your repository on GitHub.

Navigate to Settings > Secrets and variables > Actions.

Add:

DOCKER_USERNAME: Your Docker Hub username.

DOCKER_PASSWORD: Your Docker Hub password.

# Deployment

Every push to the main branch triggers the CI/CD pipeline.

The pipeline builds, pushes, and deploys updated Docker images automatically.

# License

This project is licensed under the MIT License.

