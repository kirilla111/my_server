package templates;


public class FileInfoRequest {
    public enum TYPES {
        File,
        Directory
    }

    private boolean fail = false;
    private FileInfo[] filesInfo;

    private int head = 0;

    public void add(FileInfo fileInfo) {
        filesInfo[head] = fileInfo;
        head++;
    }

    public void setFail(boolean fail) {
        this.fail = fail;
    }

    public void setArrayLength(int length) {
        filesInfo = new FileInfo[length];
    }

    public boolean isFail() {
        return fail;
    }

    public FileInfo[] getFilesInfo() {
        return filesInfo;
    }
}
