package brickset;

import repository.Repository;

import java.util.Comparator;

/**
 * Represents a repository of {@code LegoSet} objects.
 */
public class LegoSetRepository extends Repository<LegoSet> {

    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }

    public void printLegoSetAlphabeticalOrder() {
        getAll().stream().
                map(LegoSet::getName).
                sorted(Comparator.nullsFirst(Comparator.naturalOrder())).
                forEach(System.out::println);
    }

    public long maximumPieces(){
        return getAll().stream().
                mapToLong(LegoSet::getPieces).
                max().
                getAsLong();
    }

    public void printNameOfThemeGame(){
        getAll().stream().
                filter(legoset -> legoset.getTheme().equals("Games")).
                map(LegoSet::getName).
                forEach(System.out::println);
    }
    public void printNamePiecesLessThanHundred(){
        getAll().stream().
                filter(legoset -> legoset.getPieces() < 100).
                forEach(System.out::println);
    }

    public long sumBricksThemeDuplo(){
        return getAll().stream().
                filter(legoset -> legoset.getTheme().equals("Duplo")).
                mapToLong(LegoSet::getPieces).
                sum();
    }
    public static void main(String[] args) {
        var legos = new LegoSetRepository();
        legos.printLegoSetAlphabeticalOrder();
        System.out.println(legos.maximumPieces());
        legos.printNameOfThemeGame();
        legos.printNamePiecesLessThanHundred();
        System.out.println(legos.sumBricksThemeDuplo());
    }
}