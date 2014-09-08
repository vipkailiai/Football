package com.my.Football;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Paulius on 08/09/2014.
 */

public class Block {
    static final float SIZE = 1f;
    Vector2 position = new Vector2();
    Rectangle bounds = new Rectangle();
    public Block(Vector2 pos) {
        this.position = pos;
        this.bounds.width = SIZE;
        this.bounds.height = SIZE;
    }
}
