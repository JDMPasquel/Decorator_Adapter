/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.domain.Food;
import co.unicauca.commandRestaurant.infra.Utilities;
import java.util.ArrayList;
import java.util.List;

public class FoodRepositoryJsonArrayAdapter implements IFoodRepository{

    FoodJsonArrayRepository adaptedRepository;
    
    public FoodRepositoryJsonArrayAdapter() throws Exception{
        adaptedRepository = new FoodJsonArrayRepository();
    }
    
    @Override
    public Food findById(int id) {
        return Utilities.gsonToFood(adaptedRepository.getById(id));
    }

    @Override
    public List<Food> findAll() {
        List<String> all = adaptedRepository.getAll();
        if(all != null){
            List<Food> gsonFood = new ArrayList<>();
            
            for(String cmp : all){
                gsonFood.add(Utilities.gsonToFood(cmp));
            }
            
            return gsonFood;
        }
        return null;
    }

    @Override
    public boolean create(Food food) {
        return adaptedRepository.save(food);
    }

    @Override
    public boolean update(Food food) {
        return adaptedRepository.modify(food);
    }

    @Override
    public void delete(int id) {
        adaptedRepository.remove(id);
    }
    
}
