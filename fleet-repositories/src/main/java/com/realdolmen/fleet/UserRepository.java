package com.realdolmen.fleet;

public interface UserRepository extends SoftDeleteRepository<User, Long> {
    User findByEmail(String email);
}
