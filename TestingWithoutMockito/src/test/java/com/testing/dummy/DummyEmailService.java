package com.testing.dummy;

public class DummyEmailService implements EmailServices{
    @Override
    public void sendEmail() {
        throw new AssertionError("Email is not send");
    }
}
