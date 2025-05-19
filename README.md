# Projet Microservices - Système Scolaire


## Structure du projet

Ce projet contient les microservices suivants :
- `student-service` : gestion des étudiants
- `cours-service` : gestion des cours
- `inscription-service` : gestion des inscriptions
- `school-service` : agrégation des données + interface web
- `eureka-server` : découverte des services
- `rabbitmq` : messagerie asynchrone

  
## Technologies utilisées

- Spring Boot 3.x
- Spring Cloud Netflix Eureka Server
- Spring Cloud OpenFeign
- RabbitMQ AMQP
- Spring Boot + Thymeleaf (pour l’interface web)
- H2 Database (persistant en mode fichier)



## Dépendances principales

- spring-boot-starter-web
- spring-boot-starter-data-jpa
- spring-cloud-starter-netflix-eureka-client
- spring-cloud-starter-openfeign
- spring-boot-starter-amqp
- spring-boot-starter-thymeleaf


## Routes API

| Service             | Route             | Méthode    | Rôle                            |
|---------------------|-------------------|------------|---------------------------------|
| student-service     | `/students`       | POST / GET | Créer et lister les étudiants   |
| cours-service       | `/cours`          | POST / GET | Créer et lister les cours       |
| inscription-service | `/inscriptions`   | POST / GET | Inscrire un étudiant à un cours |
| school-service      | `/school/summary` | GET        | Résumé global via Feign         |
| school-service      | `/add/student`    | GET / POST | Formulaire d’ajout d’étudiant   |






## Instructions de démarrage

--Démarrer Eureka Server
--Démarrer les microservices :
   **  student-service
   **  cours-service
   **  inscription-service
   **  school-service


## Accéder aux interfaces :
Eureka : http://localhost:8761
RabbitMQ UI : http://localhost:15672
School Summary : http://localhost:8070/school/summary
