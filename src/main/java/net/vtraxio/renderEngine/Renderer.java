package net.vtraxio.renderEngine;

import static org.lwjgl.opengl.GL46.*;

public class Renderer {
    public void prepare() {
        glClearColor(1, 0, 0, 1);
        glClear(GL_COLOR_BUFFER_BIT);
    }

    public void render(RawModel model) {
        glBindVertexArray(model.vaoID());
        glEnableVertexAttribArray(0);
        glDrawArrays(GL_TRIANGLES, 0, model.vertexCount());
        glDisableVertexAttribArray(0);
        glBindVertexArray(0);
    }
}
