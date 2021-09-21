/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.commandrestaurant.domain.decorator;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.unicauca.commandRestaurant.infra.Utilities;

/**
 *
 * @author ASUS
 */
public class CryptFood extends Food{
    /**
     * Comida decorada
     */
    private Food myDecoratedFood;

    /**
     * Costructor
     * @param id es el identificador
     * @param name es el nombre del plato
     * @param type es el tipo de plato
     */
    public CryptFood(int id, String name, FoodTypeEnum type) throws Exception{
        try{
            String secretName = Utilities.encript(name);
            myDecoratedFood = new Food(id, secretName, type);
        }catch(Exception e){
            e.getMessage();
        }
    }

    @Override
    public void setName(String name) {
        myDecoratedFood.setName(name);
    }

    @Override
    public String getName() {
        return myDecoratedFood.getName();
    }

    /**
     *
     * @return Id del plato
     */
    @Override
    public int getId() {
        return myDecoratedFood.getId();
    }

    @Override
    public void setId(int id) {
        myDecoratedFood.setId(id);
    }

    @Override
    public FoodTypeEnum getType() {
        return myDecoratedFood.getType();
    }

    @Override
    public void setType(FoodTypeEnum type) {
        myDecoratedFood.setType(type);
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + myDecoratedFood.getId() + ", name=" + myDecoratedFood.getName() + ", type=" + myDecoratedFood.getType() + '}';
    }
}
