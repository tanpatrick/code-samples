package generics;

/**
 *
 * @author Patrick Tan
 * @param <T>
 */
public class Box<T> {

    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "content=" + content.toString();
    }

    public static void main(String[] args) {
        Box<String> box = new Box();
        box.setContent("box content");
//        System.out.println(" ... " + box.ge);

    }
}
