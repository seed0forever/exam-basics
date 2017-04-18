import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Copy {

  public static void main(String[] args) {
    // This should be the basic replica of the 'cp' command
    // If ran from the command line without arguments
    // It should print out the usage:
    // copy [source] [destination]
    // When just one argument is provided print out
    // No destination provided
    // When both arguments provided and the source is a file
    // Read all contents from it and write it to the destination

    ArgumentContainer inputArgs = new ArgumentContainer(args);

    handleArgs(inputArgs);
  }

  private static void handleArgs(ArgumentContainer inputArgs) {
    switch (inputArgs.getNumOfElements()) {
      case 0:
        printUsage();
        break;
      case 1:
        System.out.println("No destination provided");
        break;
      case 2:
        handleCopying(inputArgs);
        break;
      default:
        printUsage();
        break;
    }
  }

  private static void printUsage() {
    System.out.println("Usage: Copy [source] [destination]");
  }

  private static void handleCopying(ArgumentContainer inputArgs) {
    Path sourcePath = Paths.get(inputArgs.getArg(0));
    Path destinationPath = Paths.get(inputArgs.getArg(1));

    if (!isFileExist(sourcePath)) {
      System.out.println("Source file does not exist");
      return;
    } else if (!isFileReadable(sourcePath)) {
      System.out.println("Cannot read source file");
      return;
    }
    copyFile(sourcePath, destinationPath);
  }

  private static boolean isFileReadable(Path filePath) {
    return Files.isReadable(filePath);
  }

  private static boolean isFileExist(Path filePath) {
    return Files.exists(filePath);
  }

  private static void copyFile(Path source, Path destination) {
    System.out.println("Want to copy '" + source
            + "' to '" + destination + "'");
  }
}