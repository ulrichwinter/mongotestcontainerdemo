# mongotestcontainerdemo

demo project to reproduce problem starting mongo:6.0 as testcontainer

This can be reproduced using the
test [UseMongoTestcontainerTest](src/test/java/mongotestcontainerdemo/UseMongoTestcontainerTest.java)

Trying to start a testcontainer using the image "mongo" or "mongo:latest" succeeded until 25.08.2022.

After that date, the testcontaienr failed with the following exception at startup:

`exec failed: unable to start container process: exec: "mongo": executable file not found in $PATH: unknown`

Here is the relevant part of the stacktrace:

```
Container startup failed
org.testcontainers.containers.ContainerLaunchException: Container startup failed
	at app//org.testcontainers.containers.GenericContainer.doStart(GenericContainer.java:349)
	at app//org.testcontainers.containers.GenericContainer.start(GenericContainer.java:322)
	at app//mongotestcontainerdemo.UseMongoTestcontainerTest.startContainer(UseMongoTestcontainerTest.java:19)
..
Caused by: org.testcontainers.containers.MongoDBContainer$ReplicaSetInitializationException: An error occurred: OCI runtime exec failed: exec failed: unable to start container process: exec: "mongo": executable file not found in $PATH: unknown

	at app//org.testcontainers.containers.MongoDBContainer.checkMongoNodeExitCode(MongoDBContainer.java:97)
	at app//org.testcontainers.containers.MongoDBContainer.initReplicaSet(MongoDBContainer.java:132)
	at app//org.testcontainers.containers.MongoDBContainer.containerIsStarted(MongoDBContainer.java:86)
	at app//org.testcontainers.containers.GenericContainer.containerIsStarted(GenericContainer.java:701)
	at app//org.testcontainers.containers.GenericContainer.tryStart(GenericContainer.java:521)
	... 141 more

```

The issue has already been identified for testcontaienrs-java:
https://github.com/testcontainers/testcontainers-java/issues/5768
