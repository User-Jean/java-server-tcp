# Example Java Server TCP

In the pom.xml file, two profiles have been defined, 
by default the profile is dev, so it will read the **application-dev.yaml** 
file with the common properties of **application.yml**.

## Running dev

To run spring development mode execute:
> mvn spring:boot-run

> mvn spring:boot-run -Pdev

## Running Production

Generate file app.jar in folder target
> mvn clean package

Run the jar file
> java jar -D"spring.profiles.active=prod" app.jar