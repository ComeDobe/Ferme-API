# Start with a base image containing Java runtime (OpenJDK 11)
FROM openjdk:11-jre-slim

# Copy the WAR file to the Tomcat webapps directory
COPY target/Ferme-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expose the port
EXPOSE 8080

# Use the Catalina script to run Tomcat
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]
