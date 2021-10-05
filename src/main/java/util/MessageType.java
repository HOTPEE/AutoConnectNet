package util;

public enum MessageType {
    SUCCESS("成功连接"), FAILED("连接失败"), ERROR("出现了未知错误");

    private String name;
    private MessageType(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
