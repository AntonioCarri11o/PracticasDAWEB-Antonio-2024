package com.example.movie.utils;

import java.util.Random;

public class Utils {
    public int getRandomNumber (int limit) {
        return new Random().nextInt(limit);
    }
}
