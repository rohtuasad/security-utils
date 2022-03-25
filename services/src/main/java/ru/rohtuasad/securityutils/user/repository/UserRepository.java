package ru.rohtuasad.securityutils.user.repository;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.rohtuasad.securityutils.user.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

}
