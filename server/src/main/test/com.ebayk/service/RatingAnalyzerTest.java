package com.ebayk.service;

import com.ebayk.data.user.User;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

public class RatingAnalyzerTest {
    @Test
    public void getRatedUsersForRatingCreatorTest() throws RatingAnalyzer.UserNotFoundException {
        RatingAnalyzer ratingAnalyzer = new RatingAnalyzer();
        List<User> users = ratingAnalyzer.getRatedUsersForRatingCreator(3);
        Assertions.assertThat(users.size()).isEqualTo(1);
    }

    @Test(expected = RatingAnalyzer.UserNotFoundException.class)
    public void shouldThrowExceptionIfIdIsInvalid() throws RatingAnalyzer.UserNotFoundException {
        RatingAnalyzer ratingAnalyzer = new RatingAnalyzer();
        ratingAnalyzer.getRatedUsersForRatingCreator(11);
    }
}