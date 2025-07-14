# Football Standings Service

This project provides a Spring Boot-based REST API to fetch and display football standings based on Country, League, and Team names. It also supports offline mode and can be integrated with a UI (such as React) for a full-stack solution.

---

## ✅ Features

- REST API with `/api/standings` endpoint
- Fetch standings from [API-Football](https://apifootball.com/documentation/)
- Offline mode with mock data support
- Error handling and fallback logic
- Designed without 3rd party JSON libraries or databases
- Swagger UI for interactive testing
- Designed for UI integration (React suggested)

---

## 🔧 Technologies Used

- Java 17+
- Spring Boot 3.x
- Swagger / OpenAPI (Springdoc)
- Maven

---

## 📐 Design & Implementation Approach

### 1. **Layered Architecture**
- **Controller Layer**: Exposes REST endpoint to receive request parameters.
- **Service Layer**: Business logic and API call.
- **Model Layer**: Represents Country, League, Team, and TeamStandingResponse.
- **Fallback Mode**: Logic toggled by `OFFLINE_MODE` environment variable.

### 2. **Configuration**
- API key is read from environment variable `FOOTBALL_API_KEY`.
- Offline toggle is controlled via `OFFLINE_MODE` environment variable (default `false`).

---

## 🧩 Design Patterns Used

| Pattern             | Usage                                                                 |
|---------------------|------------------------------------------------------------------------|
| **Factory Pattern** | Used in creating mock `TeamStandingResponse` data                      |
| **Strategy Pattern**| Enabled API/Offline mode toggle to switch logic dynamically            |
| **Singleton**       | `RestTemplate` used as a singleton instance via Spring DI              |
| **Controller-Service** Separation | Ensures modularity and separation of concerns            |

---

## 📦 API Usage

**Endpoint**:  
`GET /api/standings?country=England&league=Premier League&team=Chelsea`

## Sample Response
{
  "country": "England",
  "countryId": "41",
  "league": "Premier League",
  "leagueId": "149",
  "team": "Chelsea",
  "teamId": "2612",
  "overallLeaguePosition": "12"
}


## CI/CD Pipeline

## Jenkins Setup

The Jenkinsfile defines a pipeline for:

Code checkout

Maven build/test

Docker image build and run

Ensure jdk24 and Maven 3.9.10 are configured in Jenkins Global Tool Configuration.

## Docker Setup

Dockerfile provided at root.

Run with:
     docker build -t football-standings-service .
     docker run -d -p 8080:8080 football-standings-service

