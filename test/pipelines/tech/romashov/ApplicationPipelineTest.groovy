package pipelines.tech.romashov

import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.Before
import org.junit.Test

class ApplicationPipelineTest extends BasePipelineTest {
    @Override
    @Before
    void setUp() throws Exception {
        super.setUp()
    }

    @Test
    void itShouldWorks() throws Exception {
        runScript("pipelines/tech/romashov/ApplicationPipeline.groovy")
        assertJobStatusSuccess()
    }
}
