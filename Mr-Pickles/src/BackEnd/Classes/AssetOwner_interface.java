package BackEnd.Classes;

import java.util.ArrayList;

public interface AssetOwner_interface {


    abstract int getBalance();


    abstract ArrayList<Card> getCards();

    abstract ArrayList<Card_PotLuck>getPotLuckCards();

    abstract ArrayList<Card_Property>getProperties();




}
