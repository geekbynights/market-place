package com.ebayk.service;

import com.ebayk.data.user.User;
import com.ebayk.data.user.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RatingAnalyzer {

    public List<User> getRatedUsersForRatingCreator(final Integer userId)
            throws UserNotFoundException {
        validateUserExists(userId);
        UserRepository userRepository = new UserRepository();
        return userRepository.getUsers().stream()
                .filter(user -> user.getRatings().stream().anyMatch(rating -> rating.getRatingCreatorUserId().equals(userId)))
                .collect(Collectors.toList());
    }

    private void validateUserExists(final Integer userId) throws UserNotFoundException {
        UserRepository userRepository = new UserRepository();
        if (userRepository.getUser(userId) == null) {
            throw new UserNotFoundException(userId);
        }
    }

    public static class UserNotFoundException extends Exception {
        UserNotFoundException(Integer userId) {
            super("User with id '" + userId + "' does not exist");
        }
    }
}