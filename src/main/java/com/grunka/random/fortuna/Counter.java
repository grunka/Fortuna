package com.grunka.random.fortuna;

class Counter {
    private final byte[] state;

    Counter(int bits) {
        if (bits < 8) {
            throw new IllegalArgumentException("Too few bits");
        }
        if (bits % 8 != 0) {
            throw new IllegalArgumentException("Only even bytes allowed");
        }
        state = new byte[bits / 8];
    }

    void increment() {
        int position = 0;
        byte newValue;
        do {
            newValue = ++state[position++];
        }
        while (newValue == 0 && position < state.length);
    }

    byte[] getState() {
        return state;
    }

    boolean isZero() {
        for (byte b : state) {
            if (b != 0) {
                return false;
            }
        }
        return true;
    }
}
