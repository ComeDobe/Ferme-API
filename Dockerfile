# Utilisez l'image Tomcat 8.5 comme base
FROM tomcat:8.5

# Copiez le fichier WAR de votre application Spring Boot dans le répertoire webapps de Tomcat
COPY target/Ferme-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Exposez le port
EXPOSE 8080

# Utilisez le script Catalina pour exécuter Tomcat
CMD ["catalina.sh", "run"]
