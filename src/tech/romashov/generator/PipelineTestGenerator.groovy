package tech.romashov.generator

class PipelineTestGenerator extends AbstractTestGenerator {
    @Override
    String getPathToClassTemplate() {
        return '/Users/d.romashov/projects/singleton/test/pipelines/tech/romashov/ApplicationPipelineTestTemplate.txt'
    }

    @Override
    String getPrefixOfFilename() {
        return 'ApplicationPipelineTest'
    }

    @Override
    String getMethodTemplate() {
        return "    @Test\n" +
                "    void testMethod%number%() throws Exception {\n" +
                "        runScript(\"pipelines/tech/romashov/ApplicationPipeline.groovy\")\n" +
                "        assertJobStatusSuccess()\n" +
                "    }"
    }

    @Override
    String getRootDirectoryOfGeneratedClasses() {
        return '/Users/d.romashov/projects/singleton/test/pipelines/tech/romashov/dummy'
    }
}
