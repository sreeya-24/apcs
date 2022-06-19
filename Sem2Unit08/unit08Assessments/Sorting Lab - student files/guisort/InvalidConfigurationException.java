package guisort;

public class InvalidConfigurationException extends RuntimeException {
    public InvalidConfigurationException() {
        super("The chart you created does not support buffering. Specify " +
              "includeBuffer=true.");
    }
}
