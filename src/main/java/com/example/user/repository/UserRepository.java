package com.example.user.repository;


import com.example.user.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,String> {
    @Query
    public UserEntity findByUserId(String userId);
    @Query
    public UserEntity findByEmail(String email);
    @Query
    public UserEntity findByFirstName(String firstName);


}
