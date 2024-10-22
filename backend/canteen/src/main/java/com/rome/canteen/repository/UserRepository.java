package com.rome.canteen.repository;
import com.rome.canteen.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);

}
