#Here we're calling the base image which is a tomcat server compatable with JDK 8
FROM tomcat:8.0-jre8

LABEL maintainer="Mark Martin"

#copy the .war file to the tomcat webapps directory
ADD target/FrontControllerDemo.war /usr/local/tomcat/webapps/

#Expose port 8080 - The expose instruction informs Docker that the container listens on the specified port at runtime
EXPOSE 8080

#CMD instrutction specifies what to run when the container is run. In our case, the tomcat
#server is started by running the following shell script:
CMD ["cataline.sh", "run"]