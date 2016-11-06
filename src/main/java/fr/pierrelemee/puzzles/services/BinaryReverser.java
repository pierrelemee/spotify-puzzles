package fr.pierrelemee.puzzles.services;

import org.springframework.stereotype.Service;

import java.util.BitSet;

/**
 * Service allowing user to generate the binary reverse of an number.
 *
 * Ex: 6 having a binary representation 110, it's reverse is 011, e.g 3 in decimal form
 */
@Service
public class BinaryReverser {

    public Long reverseBinary(Long number) {
        return longValue(reverse(fromLong(number)));
    }

    /**
     * Translates a number to its bit set version
     *
     * @param number the long value to expresses in bit
     * @return
     */
    protected BitSet fromLong(Long number) {
        BitSet result = new BitSet();
        int power = 0;
        while (number != 0) {
            result.set(power++, (number & 1) != 0);
            number >>>= 1;
        }
        return result;
    }

    /**
     * Generates the reversed bit set of the incoming set
     *
     * @param bitset the bit set to reverse
     * @return
     */
    protected BitSet reverse(BitSet bitset) {
        BitSet result = new BitSet(bitset.length());
        for (int index = 0; index < bitset.length(); index++) {
            result.set(bitset.length() - 1 - index, bitset.get(index));
        }
        return result;
    }

    /**
     * Translates a bit set to its number version
     *
     * @param bitset the bit set to translates
     * @return
     */
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
