package com.capstone.dayj.appUser;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class AppUserNotFoundException extends RuntimeException {
    final String message;
}
