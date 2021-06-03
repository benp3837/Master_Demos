FROM tomcat:jdk8-openjdk
RUN rm -rf /usr/local/tomcat/webapps/*
COPY HelloServlets-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/HelloServlet.war
CMD ["catalina.sh", "run"]

