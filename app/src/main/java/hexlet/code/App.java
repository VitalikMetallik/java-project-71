package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable {
    @Parameters(description = "path to first file")
    private String filepath1;
    @Parameters(description = "path to second file")
    private String filepath2;
    @Option(names = {"-f", "--format"},
            description = "output format [default: stylish]",
            defaultValue = "stylish")
    private String format = "stylish";

    @Override
    public String call() {
        String resultDiff = null;
        try {
            resultDiff = Differ.generate(filepath1, filepath2);
            System.out.println(resultDiff);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultDiff;
    }

    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine(new App());
        System.exit(commandLine.execute(args));
    }
}
