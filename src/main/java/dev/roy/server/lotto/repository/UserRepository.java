package dev.roy.server.lotto.repository;

import dev.roy.server.lotto.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    public User findByName(String name);

}
