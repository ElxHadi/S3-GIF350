#!/bin/bash

# Define the project name
PROJECT_NAME="MenuFact"

# Create the project directory
mkdir -p $PROJECT_NAME/src/main/java/com/restaurant/model

# Create the pom.xml file
cat <<EOL > $PROJECT_NAME/pom.xml
<project xmlns="http://maven.apache.org/POM/4.0.0" 
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.restaurant</groupId>
    <artifactId>$PROJECT_NAME</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>

    <dependencies>
        <!-- Add any dependencies here -->
    </dependencies>
</project>
EOL

# Create the empty Java files with the correct package declaration
echo "package com.restaurant.model;" > $PROJECT_NAME/src/main/java/com/restaurant/model/IPlat.java
echo "package com.restaurant.model;" > $PROJECT_NAME/src/main/java/com/restaurant/model/Plat.java
echo "package com.restaurant.model;" > $PROJECT_NAME/src/main/java/com/restaurant/model/PlatEnfant.java
echo "package com.restaurant.model;" > $PROJECT_NAME/src/main/java/com/restaurant/model/PlatSante.java
echo "package com.restaurant.model;" > $PROJECT_NAME/src/main/java/com/restaurant/model/Menu.java
echo "package com.restaurant.model;" > $PROJECT_NAME/src/main/java/com/restaurant/model/Client.java
echo "package com.restaurant.model;" > $PROJECT_NAME/src/main/java/com/restaurant/model/Facture.java
echo "package com.restaurant.model;" > $PROJECT_NAME/src/main/java/com/restaurant/model/EtatPlat.java
echo "package com.restaurant.model;" > $PROJECT_NAME/src/main/java/com/restaurant/model/EtatFacture.java

# Create the main class
cat <<EOL > $PROJECT_NAME/src/main/java/com/restaurant/Main.java
package com.restaurant;

public class Main {
    public static void main(String[] args) {
        // Entry point of the application
        System.out.println("Welcome to the MenuFact application!");
    }
}
EOL

# Notify user of successful creation
echo "Project structure for '$PROJECT_NAME' has been created successfully!"
