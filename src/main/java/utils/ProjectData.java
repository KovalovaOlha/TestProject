package utils;

public class ProjectData {
    public static String env = "env1";
    public static String appUrl = Utils.getFrameworkProperty(env, "appUrl");
    public static String suitName = Utils.getFrameworkProperty(env,"suitName");

    public static String defaultUser = Utils.getFrameworkProperty(env,"defaultUser");
    public static String defaultPassword = Utils.getFrameworkProperty(env, "defaultPassword");
}
