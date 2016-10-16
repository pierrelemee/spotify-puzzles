package fr.pierrelemee.puzzles.services;

import org.springframework.stereotype.Service;

import java.util.BitSet;

@Service
public class BinaryReverser {

    public Long reverseBinary(Long number) {
        return longValue(reverse(fromLong(number)));
    }

    protected BitSet fromLong(Long number) {
        BitSet result = new BitSet();
        int power = 0;
        while (number != 0) {
            result.set(power++, (number & 1) != 0);
            number >>>= 1;
        }
        return result;
    }

    protected BitSet reverse(BitSet bitset) {
        BitSet result = new BitSet(bitset.length());
        for (int index = 0; index < bitset.length(); index++) {
            result.set(bitset.length() - 1 - index, bitset.get(index));
        }
        return result;
    }

    protected Long longValue(BitSet bitset) {
        Long result = 0L;
        long value = 1;
        for (int index = 0; index < bitset.length(); index++) {
            result += bitset.get(index) ? value : 0;
            value *= 2;
        }
        return result;
    }
}
