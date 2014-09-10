package com.my.Football;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Paulius on 08/09/2014.
 */
public class Stadium {
    Array<Block> blocks = new Array<Block>();

    Player player;

    public Array<Block> getBlocks() {

        return blocks;
    }

    public Player getPlayer() {
        return player ;
    }

    public Stadium() {

        createMockStadium();

    }


    private void createMockStadium() {
      player = new Player(new Vector2(7, 2));

//        for (int i = 0; i < 10; i++) {
//
//            blocks.add(new Block(new Vector2(i, 0)));
//            blocks.add(new Block(new Vector2(i, 7)));
//            if (i > 2)
//                blocks.add(new Block(new Vector2(i, 1)));
//        }
//        blocks.add(new Block(new Vector2(9, 2)));
//        blocks.add(new Block(new Vector2(9, 3)));
//        blocks.add(new Block(new Vector2(9, 4)));
//        blocks.add(new Block(new Vector2(9, 5)));
//        blocks.add(new Block(new Vector2(6, 3)));
//        blocks.add(new Block(new Vector2(6, 4)));
//        blocks.add(new Block(new Vector2(6, 5)));
    }
}

