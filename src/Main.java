public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();


        toyStore.addToy(1,"Toy1", 3);
        toyStore.addToy(2,"Toy2", 5);
        toyStore.addToy(3,"Toy3", 2);

        toyStore.setWeight(2,10);

        toyStore.generateOutPut();
    }
}
