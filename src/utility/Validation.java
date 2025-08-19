package utility;

public class Validation {
    public static boolean isBuiltAreaValid(double landArea, double builtArea) {
        return builtArea <= landArea;
    }
}
