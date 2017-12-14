/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupgame;

import java.util.Random;

/**
 *
 * @author ryanlingxiao
 */
public class Dice {
        public int roll(int times, int face) {
        int output = 0;
        Random random = new Random();
        for (int index = 0; index < times; index++) {
            output += random.nextInt(face)+1;
        }
        return output;
    }
}
