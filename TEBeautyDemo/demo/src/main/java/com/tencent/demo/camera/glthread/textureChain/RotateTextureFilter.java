package com.tencent.demo.camera.glthread.textureChain;

import com.tencent.demo.camera.glrender.TextureConverter;

public class RotateTextureFilter implements TextureFilter {


    private TextureConverter textureConverter = null;
    private boolean isFrontCamera = true;


    public void setFrontCamera(boolean frontCamera) {
        isFrontCamera = frontCamera;
    }

    @Override
    public void init() {
        this.textureConverter = new TextureConverter();
    }

    @Override
    public CameraXTexture processTexture(CameraXTexture cameraXTexture) {
        int resultId = -1;
        if (this.isFrontCamera) {
            resultId = this.textureConverter.convert(cameraXTexture.textureId, cameraXTexture.width, cameraXTexture.height, 270, false, true);
        } else {
            resultId = this.textureConverter.convert(cameraXTexture.textureId, cameraXTexture.width, cameraXTexture.height, 90, false, false);
        }
        return new CameraXTexture(resultId, cameraXTexture.height, cameraXTexture.width);
    }

    @Override
    public void release() {
        this.textureConverter.release();
    }

}
