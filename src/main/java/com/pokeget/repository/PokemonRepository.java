package com.pokeget.repository;

import com.pokeget.entity.Pokemon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PokemonRepository extends MongoRepository<Pokemon, String> {

    /**
     * Retrieves the pokemon object by name
     *
     * @param name name of the object
     * @return list of the pokemon
     */
    @Query("{'name' :?0}")
    List<Pokemon> findPokemonByName(String name);

    /**
     * Retrieves the pokemon object by its PokeDex id
     *
     * @param pokedexID the pokedex id of the pokemon to be deleted
     * @return list of the pokemon with the pokedex id
     */
    @Query("{'pokedexID' :?0 }")
    List<Pokemon> findByPokeDexID(int pokedexID);

    /**
     * Retrieves the pokemon object by one of the types listed
     *
     * @param type the type of the client is requesting
     * @return list of the pokemon with the type
     */
    @Query(" {'$or' : [{'type1' : ?0}, {'type2' : ?0}]}")
    List<Pokemon> findByPokemonType(String type);

    /**
     * Retrieves the pokemon object by its ability
     *
     * @param ability name of the ability the user wants to retrieve
     * @return a list of the pokemon with the ability passed in
     */
    @Query("{'ability': ?0}")
    List<Pokemon> findByAbility(String ability);

    /**
     * Retrieves the pokemon object by its id
     *
     * @param id String value that represents the id of the object
     * @return all of the information of the pokemon queried
     */
    @Query("{'id': ?0}")
    Pokemon getByMongoID(String id);
}
