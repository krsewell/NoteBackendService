package com.ksdev.notesvc.utils;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import org.jetbrains.annotations.NotNull;


public class DocumentIdService {

    public static @NotNull String getNewId() {
        return NanoIdUtils.randomNanoId();
    }
}
