package com.steti.atf.restassured.formatter;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class UTF8OutputStreamWriter extends OutputStreamWriter {
    UTF8OutputStreamWriter(OutputStream out) {
        super(out, StandardCharsets.UTF_8);
    }
}
