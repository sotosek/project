import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Initialization {

    private String hostname = "";
    private String port = "";
    private String database_name = "";
    private String username = "";
    private String password = "";

    public Initialization( String config_file_relative_path){
        try(InputStream input = new FileInputStream(config_file_relative_path)){
            Properties ini = new Properties();
            ini.load(input);
            hostname = ini.getProperty("hostname");
            port = ini.getProperty("port");
            database_name = ini.getProperty("database_name");
            username = ini.getProperty("username");
            password = ini.getProperty("password");
        }catch (IOException initializeException){
            initializeException.printStackTrace();
        }
    }

    public String getUrl(){
        String url_prefix = "jdbc:mysql://";
        return url_prefix + hostname + ":" + port + "/"+database_name;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }
}
