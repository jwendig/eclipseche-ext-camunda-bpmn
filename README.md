# Camunda-BPMN extension for [eclipseChe] (http://www.eclipse.org/che/)

Extension for eclipse-che to design and configure BPMN 2.0 diagrams for the Camunda BPMN Suite.
It allows you to create a BPMN-Process with the [bpmn.io] (http://bpmn.io) BPMN-Editor  and configure it for the [Camunda-BPM-Engine] (http://camunda.org).
But at the current version, the configuration for BPMN-Elements isn't implemented for all BPMN-Element-Types.

## HowTo run this extension

### Install eclipseChe

* [installation tutorial] (https://eclipse-che.readme.io/docs/install-from-source) 
* [eclipseChe Sources] (https://github.com/codenvy/che.git)

* Extension is works with the tag-version 3.12.0 from the master branch. For now it doesn´t works with tag-versions upper 3.12.0, there are some problems at loading the bpmn.io library. 

### Add this extension to a local eclipseChe installation:

Take a look at the [eclipseChe documentation] (https://eclipse-che.readme.io/docs/extension-development-workflow#author-extensions-using-the-eclipse-ide)

#### how to do this with this extension
* **Add extension dependency**
    * assembly-sdk-war/pom.xml
    * 
    	<dependency>
			<groupId>de.fhrt</groupId>
		    <artifactId>codenvy.bpmn</artifactId>
		    <version>1.0.0</version>
		</dependency>
      
    * run 'mvn sortpom:sort' to sort the pom after adding the dependency
* **Add the gwt-module**
	* src/main/resources/org/eclipse/che/ide/IDE.gwt.xml
    * '<inherits name="de.fhrt.codenvy.bpmn.BpmnExtension" />'    	
* **Enable gwt-superdevmode at the gwt-module**
	* [eclipseChe documentation to run the superdevmode] (https://eclipse-che.readme.io/docs/extension-development-workflow#setup-superdev-mode-for-eclipse)
	* src/main/resources/org/eclipse/che/ide/IDE.gwt.xml
    * 
    	<add-linker name="xsiframe"/>
		<set-configuration-property name="devModeRedirectEnabled" value="true"/>
      

## Sub-Projects

A custom bpmn.io-Project, which extends the bpmn.io meta-model with camunda-specific definitions is available [here] (https://github.com/jwendig/bpmnIo-with-camunda-for-eclipseChe)

## Test your custom Camunda-BPM-Application

If you want to test the a application create with this extension, e.g. the Camunda-Get-Started application [loan approval] (http://docs.camunda.org/get-started/), you have to import the created project into eclipseChe hosted at [codenvy.com] (https://codenvy.com/).
To import the project there, you only have to zip your project.
Imported into codenvy you can run the application with the following Docker-Image. 

### Camunda 7.3 Wildfly Docker Image

For now 'quick and dirty'

	# Base Docker-Image
	# ===
	FROM codenvy/jdk7
	
	# Verzeichnis für Camunda-Installation erstellen
	# Camunda-Wildfly-Dist herunterladen und entpacken
	# ===
	RUN mkdir /home/user/camunda && \
	wget \
	-qO- \
	"http://camunda.org/release/camunda-bpm/wildfly/7.3/camunda-bpm-wildfly-7.3.0.tar.gz" | tar -zx -C /home/user/camunda/
	
	# Wildfly-Config anpassen
	# ===
	RUN cd /home/user/camunda/server/wildfly-8.2.0.Final/standalone/configuration/ && \
	sed -i 's/enable-welcome-root="true"/enable-welcome-root="false"/g' standalone.xml && \
	sed -i 's/127.0.0.1/0.0.0.0/g' standalone.xml && \
	sed -i 's/<deployment-scanner/<deployment-scanner auto-deploy-exploded="true"/g' standalone.xml
	
	# Wildfly-Port bei Codenvy registrieren 
	# ===
	
	# DEFAULT MODE
	# ---
	EXPOSE 8080
	ENV CODENVY_APP_PORT_8080_HTTP 8080
	
	# DEBUG MODE
	# ---
	# EXPOSE 8000
	# ENV CODENVY_APP_PORT_8000_DEBUG 8000
	# ENV JAVA_OPTS "-Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n"
	
	# Anwendung auf Server Kopieren
	ADD $build$ /home/user/camunda/server/wildfly-8.2.0.Final/standalone/deployments/
	
	# Server starten
	WORKDIR /home/user/camunda/server/wildfly-8.2.0.Final/bin/
	CMD ./standalone.sh


        
			        

			        