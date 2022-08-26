/*
 * Try current mongo docker images if they can be started as testcontainer.
 */
package mongotestcontainerdemo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

class UseMongoTestcontainerTest {
    private static final DockerImageName DEFAULT_IMAGE_NAME = DockerImageName.parse("mongo");
    private static final String DEFAULT_TAG = "4.0.10";

    @ParameterizedTest
    @ValueSource(strings = {DEFAULT_TAG, "latest", "6.0.1", "4.2", "4.4", "5.0", "6.0"})
    void startContainer(String tag) {
        MongoDBContainer mongoDBContainer = new MongoDBContainer(DEFAULT_IMAGE_NAME.withTag(tag));
        mongoDBContainer.start();
        System.out.println(mongoDBContainer.getConnectionString());
        mongoDBContainer.stop();
    }
}
