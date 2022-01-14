# The FROM instruction initializes a new build stage and sets the Base Image for subsequent instructions.
FROM tomcat:8.0-jre8

LABEL maintainer="Sophia Gavrila"

# The ADD instruction copies new files, directories or remote file URLs from <src> and adds them to the filesystem of the image at the path <dest>.
ADD target/FrontControllerDemo.war /usr/local/tomcat/webapps/

# The EXPOSE instruction informs Docker that the container listens on the specified network ports at runtime.
EXPOSE 8080

# The CMD instruction specifies what to run when the container (not the image) is run
# In our case, TomCat server is started by running the shell script that starts the web 
# container. There can only be one CMD instruction in a Dockerfile.
# Do not confuse RUN with CMD. RUN actually runs a command at build time.
CMD ["catalina.sh", "run"]