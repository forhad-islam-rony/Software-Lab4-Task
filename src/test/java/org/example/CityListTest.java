package org.example;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Test.*;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    City city1 = new City("Rajshahi","Bangladesh");
    City city2 = new City("Dhaka","Bangladesh");
    City city3 = new City("Khulna","Bangladesh");

    @Test
    public void testcount()
    {
        CityList cityList = new CityList();
        cityList.add(city1);
        cityList.add(city2);
        assertEquals(2,cityList.Count());
    }


    @Test
    public void testdelete()
    {
        CityList cityList = new CityList();
        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);

        cityList.delete(city2);
        assertEquals(2,cityList.Count());

    }

    @Test
    public void testdeleteexception()
    {
        CityList cityList = new CityList();
        cityList.add(city1);
        assertThrows(IllegalArgumentException.class,() -> {
            cityList.delete(city3);
        });

    }


    @Test
    public void testsort()
    {
        CityList cityList = new CityList();
        cityList.add(city3);
        cityList.add(city1);
        cityList.add(city2);

        List<City> sortedCities = cityList.getCities();

        for (int i = 0; i < sortedCities.size() - 1; i++) {
            assertTrue(sortedCities.get(i).compareTo(sortedCities.get(i + 1)) <= 0);
        }
    }

}