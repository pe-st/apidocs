package ch.schlau.pesche.apidocs.openapi.designfirst.generated;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ch.schlau.pesche.apidocs.openapi.designfirst.generated.model.EmvTags;
import ch.schlau.pesche.apidocs.openapi.designfirst.generated.model.PinCheckRequest;
import ch.schlau.pesche.apidocs.openapi.designfirst.generated.model.PinCheckResponse;
import ch.schlau.pesche.apidocs.openapi.designfirst.generated.model.PurchaseAuthRequest;
import ch.schlau.pesche.apidocs.openapi.designfirst.generated.model.PurchaseAuthResponse;

class GenerationTest {

    private static final String FILE_SEPARATOR = System.getProperty("file.separator");

    @ParameterizedTest
    @ValueSource(classes = {
            EmvTags.class,
            PinCheckRequest.class,
            PinCheckResponse.class,
            PurchaseAuthRequest.class,
            PurchaseAuthResponse.class
    })
    void compare_generated_classes(Class clazz) throws IOException {

        String generated = loadGeneratedSourceFile(clazz);
        String expected = loadExpectedSourceFile(clazz);

        assertThat(generated, is(expected));
    }

    private String loadGeneratedSourceFile(Class clazz) throws IOException {

        // set in maven pom.xml or the run configuration
        String directoryGenerated = System.getProperty("generated.path");
        String generatedSourcePath = clazz.getName().replace(".", FILE_SEPARATOR) + ".java";
        Path path = Paths.get(directoryGenerated, generatedSourcePath);

        return IOUtils.toString(path.toUri(), StandardCharsets.UTF_8);
    }

    private String loadExpectedSourceFile(Class clazz) throws IOException {

        String fileName = clazz.getSimpleName() + ".java.txt";
        return IOUtils.toString(getClass().getClassLoader().getResourceAsStream(fileName), StandardCharsets.UTF_8)
                // needed on Windows depending on the Git configuration (core.autocrlf)
                .replace("\r\n", "\n");
    }
}
