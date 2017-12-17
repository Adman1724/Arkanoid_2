//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.adamm.arkanoid.camera;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.example.adamm.arkanoid.Arkanoid;


public class OrthoCamera extends OrthographicCamera {
    Vector3 tmp;
    Vector2 origin;
    VirtualViewport virtualViewport;
    Vector2 pos;

    public OrthoCamera() {
        this(new VirtualViewport((float) Arkanoid.WIDTH, (float) Arkanoid.HEIGHT));
    }

    public OrthoCamera(VirtualViewport virtualViewport) {
        this(virtualViewport, 0.0F, 0.0F);
    }

    public OrthoCamera(VirtualViewport virtualViewport, float cx, float cy) {
        this.tmp = new Vector3();
        this.origin = new Vector2();
        this.pos = new Vector2();
        this.virtualViewport = virtualViewport;
        this.origin.set(cx, cy);
    }

    public void setVirtualViewport(VirtualViewport virtualViewport) {
        this.virtualViewport = virtualViewport;
    }

    public void setPosition(float x, float y) {
        this.position.set(x - this.viewportWidth * this.origin.x, y - this.viewportHeight * this.origin.y, 0.0F);
        this.pos.set(x, y);
    }

    public Vector2 getPos() {
        return this.pos;
    }

    public void update() {
        float left = this.zoom * -this.viewportWidth / 2.0F + this.virtualViewport.getVirtualWidth() * this.origin.x;
        float right = this.zoom * this.viewportWidth / 2.0F + this.virtualViewport.getVirtualWidth() * this.origin.x;
        float top = this.zoom * this.viewportHeight / 2.0F + this.virtualViewport.getVirtualHeight() * this.origin.y;
        float bottom = this.zoom * -this.viewportHeight / 2.0F + this.virtualViewport.getVirtualHeight() * this.origin.y;
        this.projection.setToOrtho(left, right, bottom, top, Math.abs(this.near), Math.abs(this.far));
        this.view.setToLookAt(this.position, this.tmp.set(this.position).add(this.direction), this.up);
        this.combined.set(this.projection);
        Matrix4.mul(this.combined.val, this.view.val);
        this.invProjectionView.set(this.combined);
        Matrix4.inv(this.invProjectionView.val);
        this.frustum.update(this.invProjectionView);
    }

    public void updateViewport() {
        this.setToOrtho(false, this.virtualViewport.getWidth(), this.virtualViewport.getHeight());
    }

    public Vector2 unprojectCoordinates(float x, float y) {
        Vector3 rawtouch = new Vector3(x, y, 0.0F);
        this.unproject(rawtouch);
        return new Vector2(rawtouch.x, rawtouch.y);
    }

    public void resize() {
        VirtualViewport virtualViewport = new VirtualViewport((float) Arkanoid.WIDTH, (float) Arkanoid.HEIGHT);
        this.setVirtualViewport(virtualViewport);
        this.updateViewport();
    }
}
