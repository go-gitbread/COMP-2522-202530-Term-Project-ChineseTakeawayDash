/**
 * Interactable is an object that the waiter can interact with.
 *
 * @author Jossie Yan
 * @version 2025
 */
public interface Interactable {

    /**
     * Waiter will interact with the object.
     *
     * @param waiter that will interact with the object
     */
    void interact(Waiter waiter);

    /**
     * Returns true if the object is set as interactable.
     *
     * @return true if the object is interactable
     */
    boolean isInteractable();
}
