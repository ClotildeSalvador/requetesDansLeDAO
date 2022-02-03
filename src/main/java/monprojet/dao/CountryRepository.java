package monprojet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import monprojet.entity.Country;

// This will be AUTO IMPLEMENTED by Spring 
//

public interface CountryRepository extends JpaRepository<Country, Integer> {
//    @Query("SELECT SUM(cities.population) AS population"
//+ "FROM Country "
//+ "WHERE name = :name ")
//public double PopulationDe(String name);

@Query(value = "SELECT SUM(population)"
        + "FROM City "
        + "WHERE country_id = :id ", nativeQuery = true)
public Integer getPopulation(Integer id);

@Query(value = "SELECT country.name, SUM(city.population) as population "
        + "FROM Country "
        + "INNER JOIN City ON Country.id = City.country_id "
        + "GROUP BY country.name", nativeQuery = true)
public List<VillePopulation> countryList();


}
