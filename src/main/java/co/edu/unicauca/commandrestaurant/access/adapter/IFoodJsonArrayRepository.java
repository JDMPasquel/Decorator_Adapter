/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.domain.Food;
import java.util.List;

public interface IFoodJsonArrayRepository {
    
    public List<String> getAll();
    
    public String getById(int id);
    
    public boolean save(Food food);
    
    public boolean modify(Food food);
    
    public void remove(int id);
}
