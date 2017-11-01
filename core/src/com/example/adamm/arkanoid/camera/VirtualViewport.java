//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.adamm.arkanoid.camera;

import com.badlogic.gdx.Gdx;

public class VirtualViewport {
    float virtualWidth;
    float virtualHeight;

    public float getVirtualWidth() {
        return this.virtualWidth;
    }

    public float getVirtualHeight() {
        return this.virtualHeight;
    }

    public VirtualViewport(float virtualWidth, float virtualHeight) {
        this(virtualWidth, virtualHeight, false);
    }

    public VirtualViewport(float virtualWidth, float virtualHeight, boolean shrink) {
        this.virtualWidth = virtualWidth;
        this.virtualHeight = virtualHeight;
    }

    public float getWidth() {
        return this.getWidth((float)Gdx.graphics.getWidth(), (float)Gdx.graphics.getHeight());
    }

    public float getHeight() {
        return this.getHeight((float)Gdx.graphics.getWidth(), (float)Gdx.graphics.getHeight());
    }

    public float getWidth(float screenWidth, float screenHeight) {
        float virtualAspect = this.virtualWidth / this.virtualHeight;
        float aspect = screenWidth / screenHeight;
        return aspect <= virtualAspect && Math.abs(aspect - virtualAspect) >= 0.01F?this.virtualWidth:this.virtualHeight * aspect;
    }

    public float getHeight(float screenWidth, float screenHeight) {
        float virtualAspect = this.virtualWidth / this.virtualHeight;
        float aspect = screenWidth / screenHeight;
        return aspect <= virtualAspect && Math.abs(aspect - virtualAspect) >= 0.01F?this.virtualWidth / aspect:this.virtualHeight;
    }
}
