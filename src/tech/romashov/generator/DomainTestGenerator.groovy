package tech.romashov.generator

class DomainTestGenerator extends AbstractTestGenerator {
    @Override
    String getPathToClassTemplate() {
        return '/Users/d.romashov/projects/singleton/test/src/tech/romashov/ApplicationStandTestTemplate.txt'
    }

    @Override
    String getPrefixOfFilename() {
        return 'ApplicationStandTest'
    }

    @Override
    String getMethodTemplate() {
        return "    @Test\n" +
                "    void testMethod%number%() {\n" +
                "        ApplicationStand stand = new ApplicationStand()\n" +
                "        stand.build()\n" +
                "    }"
    }

    @Override
    String getRootDirectoryOfGeneratedClasses() {
        return '/Users/d.romashov/projects/singleton/test/src/tech/romashov/dummy'
    }
}
