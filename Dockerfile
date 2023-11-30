# Start with a base image containing Java runtime (OpenJDK 11)
FROM openjdk:11-jre-slim

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/Ferme-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
COPY ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]
# Use Tomcat version 8.5 as the base
FROM tomcat:8.5

# Copy the WAR file to the Tomcat webapps directory
COPY target/Ferme-0.0.1-SNAPSHOT.jar /usr/local/tomcat/webapps/ROOT.war

# Use the Catalina script to run Tomcat
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]

