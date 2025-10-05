package net.vtraxio.renderEngine;

import static org.lwjgl.opengl.GL46.*;

public class Renderer {
    public void prepare() {
        glClear(GL_COLOR_BUFFER_BIT);
    }

    public void render(RawModel model) {
        glBindVertexArray(model.vaoID());
        glEnableVertexAttribArray(0);
        glDrawElements(GL_TRIANGLES, model.vertexCount(), GL_UNSIGNED_INT, 0);
        glDisableVertexAttribArray(0);
        glBindVertexArray(0);
    }
}
