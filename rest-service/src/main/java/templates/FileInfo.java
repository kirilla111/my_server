package templates;

public class FileInfo {
    private final String name;
    private final String path;
    private FileInfoRequest.TYPES type;

    public FileInfo(String name, String path, FileInfoRequest.TYPES type) {
        this.name = name;
        this.path = path;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public void setType(FileInfoRequest.TYPES type) {
        this.type = type;
    }

    public FileInfoRequest.TYPES getType() {
        return type;
    }
}
