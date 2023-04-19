package net.dmytro.homework18.factory;

public class FurnitureFactory {

    public Furniture getFurniture(FurnitureTypes types){
        Furniture toReturn = null;

        switch (types){
            case BED:
                toReturn = new Bed();
                break;
            case SOFA:
                toReturn = new Sofa();
                break;
            case CHAIR:
                toReturn = new Chair();
                break;
            default:
                throw new IllegalArgumentException("Wrong furniture type " + types);
        }
        return toReturn;

    }

}
