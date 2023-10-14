#docker image is based on official tomcat 8.5 image from dockerhub
FROM tomcat:8.5-alpine

#Clean the base directory of tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

#copy war file of project created to the root for tomcat deployement
COPY ./target/Calculator.war /usr/local/tomcat/webapps/ROOT.war

#running the  bn command to start tomcat
CMD ["catalina.sh", "run"] 
