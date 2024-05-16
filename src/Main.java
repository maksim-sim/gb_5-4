public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        toyStore.addToy(new Toy(1, "Плюшевый мишка", 10, 20));
        toyStore.addToy(new Toy(2, "Кукла", 15, 30));
        toyStore.addToy(new Toy(3, "Игрушечная машина", 20, 50));

        Toy selectedToy = toyStore.drawToy();
        if (selectedToy != null) {
            System.out.println("Поздравляем! Вы выиграли " + selectedToy.getName());
            toyStore.saveToyToFile(selectedToy);
        } else {
            System.out.println("Извините, попробуйте позже..");
        }
    }
}