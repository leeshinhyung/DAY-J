package com.capstone.dayj.friendGroup;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FriendGroupNotFoundException extends RuntimeException {
    final String message;
}
