import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class ToyStore {
    private List<Toy> toys = new ArrayList<>();

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateToyFrequency(int toyId, int frequency) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setFrequency(frequency);
                break;
            }
        }
    }

    public Toy drawToy() {
        Random random = new Random();
        int totalFrequency = toys.stream().mapToInt(Toy::getFrequency).sum();
        int randomNumber = random.nextInt(totalFrequency);
        int cumulativeFrequency = 0;
        Toy selectedToy = null;

        for (Toy toy : toys) {
            cumulativeFrequency += toy.getFrequency();
            if (randomNumber < cumulativeFrequency) {
                selectedToy = toy;
                break;
            }
        }

        if (selectedToy != null) {
            selectedToy.reduceQuantity();
            toys.remove(selectedToy);
        }

        return selectedToy;
    }

    public void saveToyToFile(Toy toy) {
        try (FileWriter writer = new FileWriter("prize.txt", true)) {
            writer.write(toy.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}