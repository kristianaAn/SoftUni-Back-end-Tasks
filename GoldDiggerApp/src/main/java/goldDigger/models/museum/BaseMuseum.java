package goldDigger.models.museum;

import java.util.ArrayList;
import java.util.Collection;

public class BaseMuseum implements Museum{
    private Collection<String> exhibits;

    public BaseMuseum() {
        this.exhibits = new ArrayList<>();
    }

    public void setExhibits(Collection<String> exhibits) {
        this.exhibits = exhibits;
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }
}
