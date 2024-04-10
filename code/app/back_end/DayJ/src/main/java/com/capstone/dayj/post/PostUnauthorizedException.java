package com.capstone.dayj.post;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PostUnauthorizedException extends RuntimeException {
    final String message;
}
