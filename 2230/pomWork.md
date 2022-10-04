### Old pom and process documentation
Done:
- Rename som titles
- Other small framework fixes, pluginManagement, modules, package
- Work on pom core, framework renaming and remove javafx dependency.
- Work on pom fxui, copy from core, and add javafx dependency and plugin (from original root pom - see below)
- renamed open javafx reference in fxui, and add core pom dependency reference.  
- added dependencyManagemenet in parent and removed specifications in the respective dependencies in core and fxui.

Essentially followed the video from todolist on expanding the project with more modules. 

- copied over core pom to data with minor adaptations.


<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>it1901.2230</groupId>
  <artifactId>parent</artifactId>
  <version>0.0.1-SNAPSHOT</version>

  <name>2230</name>
  <!-- FIXME change it to the project's website -->
  <url>http://www.example.com</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>16</maven.compiler.source>
    <maven.compiler.target>16</maven.compiler.target>
  </properties>

  <dependencies>

    <!-- javafx -->
    <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-controls</artifactId>
            <version>17.0.2</version>
    </dependency>
    <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-fxml</artifactId>
            <version>17.0.2</version>
    </dependency>

    <!-- junit testing with jupiter -->
    <dependency>
              <groupId>org.junit.jupiter</groupId>
              <artifactId>junit-jupiter-api</artifactId>
              <version>5.7.2</version>
              <scope>test</scope>
    </dependency>
    <dependency>
              <groupId>org.junit.jupiter</groupId>
              <artifactId>junit-jupiter-engine</artifactId>
              <version>5.7.2</version>
              <scope>test</scope>
    </dependency>
    <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-params</artifactId>
            <version>5.7.2</version>
            <scope>test</scope>
    </dependency>

     <!-- junit testing with jupiter -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.7.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.7.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-params</artifactId>
            <version>5.7.2</version>
            <scope>test</scope>
        </dependency>

    <!-- test javafx with TextFX -->
		<dependency>
            <groupId>org.testfx</groupId>
            <artifactId>testfx-core</artifactId>
            <version>4.0.16-alpha</version>
            <scope>test</scope>
		</dependency>
		<dependency>
            <groupId>org.testfx</groupId>
            <artifactId>testfx-junit5</artifactId>
            <version>4.0.16-alpha</version>
            <scope>test</scope>
    </dependency>
    <dependency>
            <groupId>org.hamcrest</groupId>
            <artifactId>hamcrest</artifactId>
            <version>2.2</version>
            <scope>test</scope>
    </dependency>

    <!-- json-->
    <dependency>
            <groupId>com.googlecode.json-simple</groupId>
            <artifactId>json-simple</artifactId>
            <version>1.1.1</version>
   </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                  <release>16</release>
                </configuration>
      </plugin>
  
      <plugin>
                <groupId>org.apache.maven.plugins</groupId>
        		    <artifactId>maven-surefire-plugin</artifactId>
		            <version>3.0.0-M5</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
	    </plugin>

      <plugin>
              <artifactId>maven-clean-plugin</artifactId>
              <version>3.1.0</version>
      </plugin>
        <!-- default lifecycle, jar packaging: see https://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_jar_packaging -->
      <plugin>
              <artifactId>maven-resources-plugin</artifactId>
              <version>3.0.2</version>
      </plugin>
      <plugin>
              <artifactId>maven-compiler-plugin</artifactId>
              <version>3.8.0</version>
      </plugin>

      <!--maven plugin for running test-coverage with JaCoCo-->
      <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>0.8.7</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>prepare-agent</goal>
                        </goals>
                    </execution>
                    <!-- attached to Maven test phase -->
                    <execution>
                        <id>report</id>
                        <phase>verify</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
      <plugin>
                <groupId>org.openjfx</groupId>
                <artifactId>javafx-maven-plugin</artifactId>
                <version>0.0.6</version>
                <!-- Usage: mvn javafx:run -->
                <configuration>
                  <!--May be necessary to change the adress to mainClass later!-->
                  <mainClass>CalendarApp.core/CalendarApp.core.CalendarApp</mainClass>
                </configuration>
      </plugin>
    </plugins>
  </build>
</project>