package com.capstone.dayj.post;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PostNotFoundException extends RuntimeException {
    final String message;
}
