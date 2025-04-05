# Notification Service with Kafka in Spring Boot

#### 1. Add Kafka Dependencies
#### 2. Configure Kafka Properties
#### 3. Create Kafka Producer for Notifications
#### 4. Create Kafka Consumer for Notifications
#### 5. Create a REST Controller to Trigger Notifications
#### 6. Run Kafka Locally (Download and extract Apache Kafka latest version) or Use Docker
   #### *Manually start Kafka (cmd)*
      1. Start Zookeeper `bin\windows\zookeeper-server-start.bat ..\..\config\zookeeper.properties`
      2. Start Kafka Server `bin\windows\kafka-server-start.bat ..\..\config\server.properties`
      3. Create the topic manually (if not auto-created) `bin\windows\kafka-topics.bat --create --topic notification --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
#### 7. Connect a WebSocket Client
#### 8. Send a Notification Request using postman or your browser
    http://localhost:8000/notifications/send?message=hi