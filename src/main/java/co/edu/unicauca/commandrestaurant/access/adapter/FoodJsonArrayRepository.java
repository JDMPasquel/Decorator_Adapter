/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.domain.decorator.CapitalFood;
import co.edu.unicauca.commandrestaurant.domain.decorator.CryptFood;
import co.unicauca.commandRestaurant.infra.Utilities;
import java.util.ArrayList;
import java.util.List;

public class FoodJsonArrayRepository implements IFoodJsonArrayRepository{
    
    private static List<String> foods;

    public FoodJsonArrayRepository() throws Exception {
        if (foods == null) {
            foods = new ArrayList<>();
            initData();
        }
    }
    
    private void initData() throws Exception {
        foods.add(Utilities.foodToGson(new CryptFood(1, "Sopa de verduras", FoodTypeEnum.ENTRADA)));
        foods.add(Utilities.foodToGson(new CryptFood(2, "Frijoles", FoodTypeEnum.PRINCIPIO)));
        foods.add(Utilities.foodToGson(new CryptFood(3, "Chuleta de pollo", FoodTypeEnum.CARNE)));
        foods.add(Utilities.foodToGson(new CryptFood(4, "Jugo de Lulo", FoodTypeEnum.JUGO)));
        foods.add(Utilities.foodToGson(new CryptFood(5, "Pollo en salsa de champiñones", FoodTypeEnum.CARNE)));
        foods.add(Utilities.foodToGson(new CryptFood(6, "Sopa de pastas", FoodTypeEnum.ENTRADA)));
    }
    
    @Override
    public List<String> getAll(){
        return foods;
    }
    
    @Override
    public String getById(int id){
        int i;
        String aux = " ", tempFood;
        for(i = 0; i < foods.size(); i++){
            tempFood = foods.get(i);
            if(tempFood.contains("\"id\":"+id+",")){
                aux = foods.get(i);
            }
        }
        return aux;
    }
    
    @Override
    public boolean save(Food food){
        if(" ".equals(this.getById(food.getId()))){
            foods.add(Utilities.foodToGson(food));
            return true;
        }
        return false;
    }
    
    @Override
    public boolean modify(Food food){
        String jsonFood = this.getById(food.getId());
        Food aux = Utilities.gsonToFood(jsonFood);
        if(aux != null){
            this.remove(aux.getId());
            this.save(food);
            return true;
        }
        return false;
    }
    
    @Override
    public void remove(int id){
        int i;
        String tempFood;
        for(i = 0; i < foods.size(); i++){
            tempFood = foods.get(i);
            if(tempFood.contains("\"id\":"+id+",")){
                foods.remove(i);
            }
        }
    }
}
