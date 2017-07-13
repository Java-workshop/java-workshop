package basics;

import java.util.List;

/**
 * Created by fjiang on 4/25/17.
 */
public class MySubGenericsClass<T extends String> extends MyGenericsClass<T> {

    public MySubGenericsClass(final List<T> list) {
        super(list);
    }
}
