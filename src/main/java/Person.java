public abstract class Person {
    private final String name;
    private int xCoordinate;
    private int yCoordinate;

    protected Person(String name, int xCoordinate, int yCoordinate) {
        this.name = name;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /**
     * Returns the person's name as a String.
     *
     * @return the person's name
     */
    public String getName() {
        return name;
    }


    /**
     * Returns the person's current x coordinate.
     *
     * @return the person's current x coordinate
     */
    public int getxCoordinate() {
        return xCoordinate;
    }

    /**
     * Returns the person's current y coordinate.
     *
     * @return the person's current y coordinate
     */
    public int getyCoordinate() {
        return yCoordinate;
    }

    /**
     * Sets the xCoordinate to the new x coordinate.
     *
     * @param xCoordinate represents the new x coordinate
     */
    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * Sets the yCoordinate to the new y coordinate.
     *
     * @param yCoordinate represents the new y coordinate
     */
    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
