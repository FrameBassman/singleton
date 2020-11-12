package tech.romashov.generator

import java.nio.file.Files
import java.nio.file.Paths

abstract class AbstractTestGenerator {
    Integer MAX_COUNT = 100

    void run() {
        for (i in 0..<MAX_COUNT) {
            writeToFile(
                    generateClass(generateFileTemplate(), i),
                    "${getPrefixOfFilename()}${i}.groovy"
            )
        }
    }

    abstract String getPathToClassTemplate()

    abstract String getPrefixOfFilename()

    abstract String getMethodTemplate()

    abstract String getRootDirectoryOfGeneratedClasses()

    protected String generateFileTemplate() {
        List<String> lines = Files.readAllLines(Paths.get(getPathToClassTemplate()))
        StringBuilder classTemplate = new StringBuilder()
        for (String line : lines) {
            classTemplate.append(line).append('\n')
        }
        return classTemplate
    }

    protected String generateClass(String template, int index) {
        String result = template.replace('%number%', index.toString())
        result = result.replace('%methods%', generateMethods(MAX_COUNT))
        return result
    }

    protected String generateMethods(int maxCount) {
        StringBuilder methods = new StringBuilder();
        for (i in 0..< maxCount) {
            methods.append(getMethodTemplate().replace("%number%", i.toString()))
                    .append('\n\n')
        }
        return methods
    }

    protected void writeToFile(String generatedClass, String filename) {
        Files.write(Paths.get(getRootDirectoryOfGeneratedClasses(), filename), generatedClass.getBytes())
    }
}
