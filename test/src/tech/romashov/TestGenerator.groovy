package src.tech.romashov

import org.junit.Ignore
import org.junit.Test

import java.nio.file.Files
import java.nio.file.Paths

class TestGenerator {
    String methodTemplate = "    @Test\n" +
            "    void testMethod%number%() {\n" +
            "        ApplicationStand stand = new ApplicationStand()\n" +
            "        stand.build()\n" +
            "    }"
    Integer MAX_COUNT = 100

    @Test @Ignore
    void itWorks() {
        for (i in 0..<MAX_COUNT) {
            writeToFile(
                    generateClass(generateFileTemplate(), i),
                    "ApplicationStandTest${i}.groovy"
            )
        }
    }

    String generateMethods(int maxCount) {
        StringBuilder methods = new StringBuilder();
        for (i in 0..< maxCount) {
            methods.append(methodTemplate.replace("%number%", i.toString()))
                    .append('\n\n')
        }
        return methods
    }

    String generateFileTemplate() {
        List<String> lines = Files.readAllLines(Paths.get('/Users/d.romashov/projects/singleton/test/src/tech/romashov/ApplicationStandTestTemplate.txt'))
        StringBuilder classTemplate = new StringBuilder()
        for (String line : lines) {
            classTemplate.append(line).append('\n')
        }
        return classTemplate
    }

    String generateClass(String template, int index) {
        String result = template.replace('%number%', index.toString())
        result = result.replace('%methods%', generateMethods(MAX_COUNT))
        return result
    }

    void writeToFile(String generatedClass, String filename) {
        String rootDir = '/Users/d.romashov/projects/singleton/test/src/tech/romashov/dummy'
        Files.write(Paths.get(rootDir, filename), generatedClass.getBytes())
    }
}
