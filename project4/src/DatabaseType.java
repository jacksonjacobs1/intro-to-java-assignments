import java.util.Comparator;

/**
 * An interface decribing things that may be stored in a database
 * @author Jackson Jacobs*/
public interface DatabaseType<S extends DatabaseType> {
    Comparator<S> getComparatorByTrait(String trait);
}
