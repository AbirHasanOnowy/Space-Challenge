public interface Spaceship {
    //indicates if the launch was successful or not
    public Boolean launch();

    //indicates if the landing was successful or not
    public Boolean land();

    public Boolean canCarry(Item item);
    public void carry(Item item);
}
