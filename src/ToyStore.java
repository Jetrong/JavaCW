import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class ToyStore {
    private PriorityQueue<Toy> queue;

    public ToyStore(){
        queue = new PriorityQueue<>((t1, t2) -> t2.getWeight() - t1.getWeight());
    }

    public void addToy(int id, String name, int weight){
        Toy toy = new Toy(id,name,weight);
        queue.offer(toy);
    }

    public void setWeight(int id, int weight){
        Toy toy = findToById(id);
        if (toy != null) {
            toy.setWeight(weight);
        }
    }

    private Toy findToById(int id){
        for (Toy toy : queue){
            if (toy.getId() == id){
                return toy;
            }
        }
        return null;
    }

    public void generateOutPut(){
        try(FileWriter writer = new FileWriter("output.txt")){
            for (int i = 0; i < 10; i++) {
                Toy toy = queue.poll();
                writer.write(toy.getName() + "\n");
                toy.setWeight(toy.getWeight() - 1);
                queue.offer(toy);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
