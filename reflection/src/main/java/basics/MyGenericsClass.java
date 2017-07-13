package basics;

import java.util.List;

/**
 * Created by fjiang on 4/25/17.
 */
public class MyGenericsClass<T extends String> {
    private T t;
    private List<T> list;

    public MyGenericsClass(final List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return this.list;
    }

    public void setList(final List<T> list) {
        this.list = list;
    }

    public Class getType() {
       return t.getClass();
    }
}
