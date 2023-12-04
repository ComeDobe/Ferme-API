# Utilisez l'image OpenJDK 11 comme base
FROM openjdk:11-jdk
# Définissez le répertoire de travail
WORKDIR /app
# Copiez le fichier JAR de votre application Spring Boot dans le répertoire de travail
COPY target/Ferme-0.0.1-SNAPSHOT.jar app.jar
# Exposez le port utilisé par votre application Spring Boot
EXPOSE 8080
# Commande pour exécuter l'application Spring Boot lorsque le conteneur démarre
CMD ["java", "-jar", "app.jar"]
