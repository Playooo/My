package week5;

interface SafetyRegulation {
    int getMaxItems();
}

abstract class Item implements SafetyRegulation { }

class Duck extends Item {
    private final int maxItems = 5;
    public int getMaxItems() {
        return maxItems;
    }
}

class Swan extends Item {
    private final int maxItems = 2;
    public int getMaxItems() {
        return maxItems;
    }
}

class Flamingo extends Item {
    private final int maxItems = 3;
    public int getMaxItems() {
        return maxItems;
    }
}

class Dog extends Item {
    private final int maxItems = 20;
    public int getMaxItems() {
        return maxItems;
    }
}

class Cat extends Item {
    private final int maxItems = 20;
    public int getMaxItems() {
        return maxItems;
    }
}

public class AnimalFactory<T extends Item & SafetyRegulation>  {
    private int unitsProduced;

    AnimalFactory() {
        this.unitsProduced = 0;
    }

    T continueProduction(T item) {
        if(item.getMaxItems() > this.unitsProduced) {
            this.unitsProduced++;
            return(item);
        }
        return(null);
    }

    int getCount() {
        return(this.unitsProduced);
    }

    public static void main(String[] args) {
        AnimalFactory<Duck> AF_D = new AnimalFactory<>();
        while(AF_D.continueProduction(new Duck()) != null);
        System.out.println("Total Ducks produced: " + AF_D.getCount());

        AnimalFactory<Swan> AF_S = new AnimalFactory<>();
        while(AF_S.continueProduction(new Swan()) != null);
        System.out.println("Total Swans produced: " + AF_S.getCount());

        AnimalFactory<Flamingo> AF_F = new AnimalFactory<>();
        while(AF_F.continueProduction(new Flamingo()) != null);
        System.out.println("Total Flamingos produced: " + AF_F.getCount());

        AnimalFactory<Dog> AF_G = new AnimalFactory<>();
        while(AF_G.continueProduction(new Dog()) != null);
        System.out.println("Total Dogs produced: " + AF_G.getCount());

        AnimalFactory<Cat> AF_C = new AnimalFactory<>();
        while(AF_C.continueProduction(new Cat()) != null);
        System.out.println("Total Cats produced: " + AF_C.getCount());

        // Output:
        // Total Ducks produced: 5
        // Total Swans produced: 2
        // Total Flamingos produced: 3
        // Total Dogs produced: 20
        // Total Cats produced: 20
    }
}
