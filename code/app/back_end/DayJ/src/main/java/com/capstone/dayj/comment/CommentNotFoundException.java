package com.capstone.dayj.comment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CommentNotFoundException extends RuntimeException {
    final String message;
}
