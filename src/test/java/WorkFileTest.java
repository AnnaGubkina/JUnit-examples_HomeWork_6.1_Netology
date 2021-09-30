import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WorkFileTest {


    WorkFile file;

    @BeforeEach
    void setUp() {
        file = new WorkFile();
        System.out.println("Test started");

    }

    @ParameterizedTest
    @MethodSource("factory")
    void createFolder(String obj, StringBuilder bd, String str, File expected) {

        final File result = new File(obj);
        boolean created = result.mkdir();
        if (created)
            bd.append(str);

        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> factory() {
        return Stream.of(
                Arguments.of("/Users/SIREN-A/folder1", new StringBuilder(), "Folder folder1 has been created ", "/Users/SIREN-A/folder1"),
                Arguments.of("/Users/SIREN-A/folder2", new StringBuilder(), "Folder folder2 has been created ", "/Users/SIREN-A/folder2"),
                Arguments.of("/Users/SIREN-A/folder3", new StringBuilder(), "Folder folder3 has been created ", "/Users/SIREN-A/folder3")

        );
    }


    @ParameterizedTest
    @MethodSource("params")
    void createFile(String obj, StringBuilder bd, String str, File expected) throws IOException {
        final File result = new File(obj);
        boolean created = result.createNewFile();
        if (created)
            bd.append(str);

        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of("/Users/SIREN-A/file1", new StringBuilder(), "File file1 has been created ", "/Users/SIREN-A/file1"),
                Arguments.of("/Users/SIREN-A/file2", new StringBuilder(), "File file2 has been created ", "/Users/SIREN-A/file2"),
                Arguments.of("/Users/SIREN-A/file3", new StringBuilder(), "File file has been created ", "/Users/SIREN-A/file3")

        );
    }

}
